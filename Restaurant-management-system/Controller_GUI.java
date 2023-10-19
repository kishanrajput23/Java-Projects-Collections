
/**
 * Write a description of class Controller_GUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.text.*;

public class Controller_GUI
{
    private UserInterface_GUI cView;
    private Database    cDatabase;
    private int         userType;
    private int         currentUserID;
    private String      currentUserName;
    private String      todaysDate;
    
    private int         todaysOrderCnt;     //Today's order count
    private double      totalSales;         //Today's total sales
    private int         todaysCancelCnt;    //Today's cancel count
    private double      cancelTotal;        //Total cost of today's canceled orders
    
    
    private String      errorMessage;
    
    //define user type
    public final static int USER_ANONYMOUS = 0;
    public final static int USER_EMPLOYEE = 1;
    public final static int USER_MANAGER = 2; 
    
    public Controller_GUI()
    {
        this.cDatabase = new Database();
        try
        {
            cDatabase.loadFiles();
        }
        catch(DatabaseException de)
        {
            System.out.println(de.getErrMessage());
            System.exit(0);
        }
        
        cView = new UserInterface_GUI( this);
        
        Date date = new Date();
        SimpleDateFormat stf = new SimpleDateFormat("yyyy/MM/dd");
        todaysDate = stf.format(date);
        cView.setVisible(true);
        cView.setTodaysDate(todaysDate);
        this.userType = USER_ANONYMOUS;
        
        todaysOrderCnt = 0;
        totalSales = 0;
        todaysCancelCnt = 0;
        cancelTotal = 0;
    }
    
    private void  setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }
    
    public String  getErrorMessage()
    {
        String result = this.errorMessage;
        this.errorMessage = "";
        return result;
    }
    
    public int getTodaysOrderCnt()
    {
        return this.todaysOrderCnt;
    }
    
    public int getTodaysCancelCnt()
    {
        return this.todaysCancelCnt;
    }
    
    public double getTotalSales()
    {
        return this.totalSales;
    }
    
    public double getCancelTotal()
    {
        return this.cancelTotal;
    }
    
    public double getOrderTotalCharge(int orderID)
    {
        return cDatabase.getOrderTotalCharge(orderID);
    }
    
    public int getOrderState(int orderID)
    {
        return cDatabase.getOrderState(orderID);
    }
    
    public String getCurrentUserName()
    {
        return this.currentUserName;
    }
    
    public boolean checkIfUserClockedOut()
    {
        Staff   rStaff = cDatabase.findStaffByID(currentUserID);
        
        if( rStaff == null) return false;
        if( rStaff.getWorkState() == Staff.WORKSTATE_ACTIVE)
            return true;
        else 
            return false;
    }
    
     /***********************************************************
     * Login 
     **********************************************************/
    //----------------------------------------------------------
    // Find user
    //----------------------------------------------------------  
    public boolean loginCheck( int inputID, String inputPassword, boolean isManager)
    {
        String searchClassName;
            
        //---------search user----------
        Staff   rStaff = cDatabase.findStaffByID(inputID);

        if(isManager)   searchClassName = "Manager";
        else            searchClassName = "Employee";
        
        if( rStaff != null)//User data is found
        {
            //Search only particular target(Manager or Employee)
            if( rStaff.getClass().getName().equalsIgnoreCase(searchClassName))
            {
                if(rStaff.getPassword().equals(inputPassword))
                {
                    if(rStaff.getWorkState() == 0)  //Not clocked in yet
                    {
                        rStaff.clockIn();
                    }
                    if(isManager)
                    {
                        userType = USER_MANAGER;
                        cView.changeMode(cView.MODE_MANAGER);
                    }
                    else 
                    {
                        userType = USER_EMPLOYEE;
                        cView.changeMode(cView.MODE_EMPLOYEE);
                    }
                    currentUserID = inputID;
                    currentUserName = rStaff.getFullName();
                    cView.setLoginUserName(currentUserName);  //show user name on the view
                    
                    return true; //Login success
                }
                else
                {
                    setErrorMessage("Password unmatch.");
                    //printErrorMessageToView("Password unmatching.");
                    return false;
                }
            }
            else    //ID is found but type(Manager or Employee) is umnatching
            {
                setErrorMessage("Not found.");
                //printErrorMessageToView("Not found.");
                return false;
            }
        }
        else
        {
            setErrorMessage("Not found.");
            return false;
        }

    }   
    
    //----------------------------------------------------------
    // Logout (Set state as Anonymous)
    //----------------------------------------------------------
    public void userLogout()
    {
        userType = USER_ANONYMOUS;
        currentUserID = 0;
        cView.setLoginUserName("");
    }
    
     /***********************************************************
     * Staff management
     **********************************************************/
    public boolean addNewStaff(int newID, String newPassword, String newFirstName, String newLastName, boolean isManager)
    {
        Staff rStaff = cDatabase.findStaffByID(newID);
        if(rStaff != null)
        {
            setErrorMessage("ID:" + newID + " is arleady used by " + rStaff.getFullName());
            return false;
        }
        
        try
        {
            cDatabase.addStaff(newID, newPassword, newFirstName, newLastName, isManager);
            return true;
        }
        catch(DatabaseException de)
        {
            setErrorMessage(de.getErrMessage());
            return false;
        }
    }
    
    public boolean updateStaff(int id, String newPassword, String newFirstName, String newLastName)
    {
        try
        {
            cDatabase.editStaffData(id, newPassword, newFirstName, newLastName);
            return true;
        }
        catch(DatabaseException de)
        {
            setErrorMessage(de.getErrMessage());
            return false;
        }
    }
    
    public boolean deleteStaff(int id)
    {
        Staff rStaff = cDatabase.findStaffByID(id);
        if(rStaff == null)
        {
            setErrorMessage("StaffID:" + id + " is not found.");
            return false;
        }
        
        try
        {
            cDatabase.deleteStaff(rStaff);
        }
        catch(DatabaseException de)
        {
            setErrorMessage(de.getErrMessage());
            return false;
        }
        return true;
    }
    
    public Staff    getStaffData(int staffID)
    {
        return cDatabase.findStaffByID(staffID);
    }
    
    public boolean clockOut()
    {
        return clockOut(currentUserID);
    }
    
    public boolean clockOut(int staffID)
    {
        Staff rStaff = cDatabase.findStaffByID(staffID);
        
        byte state = rStaff.getWorkState();
        boolean result = false;
        switch(state)
        {
            case Staff.WORKSTATE_ACTIVE:
                rStaff.clockOut();
                result = true;
                break;
            case Staff.WORKSTATE_FINISH:
                setErrorMessage("Staff:" + rStaff.getFullName() + " already clocked out.");
                break;
           default:
                setErrorMessage("Staff:" + rStaff.getFullName() + "has not been on work today.");
                break;
        }
        
        return result;
    }
    
    public void clockOutAll()
    {
        cDatabase.forthClockOutAllStaff();
    }

     /***********************************************************
     * Menu management
     **********************************************************/
    public boolean addNewMenuItem(int newID, String newName, double newPrice, byte menuType)
    {
        MenuItem rMenuItem = cDatabase.findMenuItemByID(newID);
        if(rMenuItem != null)
        {
            setErrorMessage("ID:" + newID + " is arleady used by " + rMenuItem.getName());
            return false;
        }
        
        try
        {
            cDatabase.addMenuItem(newID, newName, newPrice, menuType);
            return true;
        }
        catch(DatabaseException de)
        {
            setErrorMessage(de.getErrMessage());
            return false;
        }
    }
    
    public boolean updateMenuItem(int id, String newName, double newPrice, byte menuType)
    {
        try
        {
            cDatabase.editMenuItemData(id, newName, newPrice, menuType);
            return true;
        }
        catch(DatabaseException de)
        {
            setErrorMessage(de.getErrMessage());
            return false;
        }
    }
    
    public boolean deleteMenuItem(int id)
    {
        MenuItem rMenuItem= cDatabase.findMenuItemByID(id);
        if(rMenuItem == null)
        {
            setErrorMessage("Menu item ID:" + id + " is not found.");
            return false;
        }
        
        try
        {
            cDatabase.deleteMenuItem(rMenuItem);
        }
        catch(DatabaseException de)
        {
            setErrorMessage(de.getErrMessage());
            return false;
        }
        return true;
    }
     
    public MenuItem    getMenuItemData(int menuItemID)
    {
        return cDatabase.findMenuItemByID(menuItemID);
    }
     /***********************************************************
     * Order management
     **********************************************************/
    public int createOrder()
    {
        return cDatabase.addOrder(currentUserID, currentUserName);
        //editOrderItem(newOrderID);
    }
    
    public boolean addNewOrderItem(int orderID, int addItemID, byte addItemQuantity)
    {
        Order rOrder = cDatabase.findOrderByID(orderID);
        if( currentUserID != rOrder.getStaffID())
        {
            setErrorMessage("You are not eligible to edit the order.\nThe order belonges to " + rOrder.getStaffName() + ")");
            //printErrorMessageToView("You are not eligible to edit the order.\nThe order belonges to " + rOrder.getStaffName() + ")");
            return false;    
        }
        
        MenuItem    rNewItem = null;
        
        rNewItem = cDatabase.findMenuItemByID(addItemID);
        if(rNewItem == null)
        {
            setErrorMessage("MenuID[" + addItemID + "]is not found.");
            //printErrorMessageToView("MenuID[" + addItemID + "]is not found.");
            addItemID = 0;
            return false;
        }
        
         //////////ADD!!!(database)/////////////
         cDatabase.addOrderItem(orderID, rNewItem, addItemQuantity);
         return true;
    }
    
    public boolean deleteOrderItem(int orderID, int deleteNo)
    {
        Order rOrder = cDatabase.findOrderByID(orderID);
        if( currentUserID != rOrder.getStaffID())
        {
            setErrorMessage("You are not eligible to delete the order.\nThe order belonges to " + rOrder.getStaffName() + ")");
            //printErrorMessageToView("You are not eligible to delete the order.\nThe order belonges to " + rOrder.getStaffName() + ")");
            return false;    
        }
        
        deleteNo -=1;  //index actually starts from zero
        if(!cDatabase.deleteOrderItem(orderID, deleteNo))
        {
            //printErrorMessageToView("Not found.");
            setErrorMessage("Not found.");
            return false;
        }
        return true;
    }
    
    public boolean closeOrder(int closeOrderID)
    {
        Order rOrder = cDatabase.findOrderByID(closeOrderID);
        if( currentUserID != rOrder.getStaffID())
        {
            setErrorMessage("You are not eligible to delete the order.\n(The order belonges to " + rOrder.getStaffName() + ")");
            return false;    
        }
        
        if(rOrder.getState() != 0)
        {
            setErrorMessage("The order is already closed or canceled.");
            return false;
        }
        cDatabase.closeOrder(closeOrderID);
        todaysOrderCnt++;
        totalSales += rOrder.getTotal();
        return true;
    }
    
    public boolean cancelOrder(int cancelOrderID)
    {
        Order rOrder = cDatabase.findOrderByID(cancelOrderID);
        if( currentUserID != rOrder.getStaffID())
        {
            setErrorMessage("You are not eligible to delete the order.\n(The order belonges to " + rOrder.getStaffName() + ")");
            return false;    
        }
        
        if( rOrder.getState() != 0)
        {
            setErrorMessage("The order is already closed or canceled.");
            return false;
        }

        cDatabase.cancelOrder(cancelOrderID);
        todaysCancelCnt++;
        cancelTotal += rOrder.getTotal();
        return true;
    }
    
    public void closeAllOrder()
    {
        cDatabase.closeAllOrder();
    }
    
    /***********************************************************
     * Reports
     * return:Report file name
     **********************************************************/
     public String generateSalesReport()
     {
        if(!cDatabase.checkIfAllOrderClosed())
        {
             setErrorMessage("All orders must be closed or canceled before generate reports.");
             return null;
        }
            
         try
        {
            return cDatabase.generateOrderReport(todaysDate);
        }
        catch(DatabaseException de)
        {
            setErrorMessage(de.getErrMessage());
            return null;
        }
    }
    
    public String generatePaymentReport()
    {
        if(!cDatabase.checkIfAllStaffCheckout())
        {
            setErrorMessage("All staff must be checked out before generate a payment report.");
            return null;
        }

        try
        {
            return cDatabase.generatePaymentReport(todaysDate);
        }
        catch(DatabaseException de)
        {
            setErrorMessage(de.getErrMessage());
            return null;
        }
    }
    
    /***********************************************************
     * Create stiring lists
     **********************************************************/
    public  ArrayList<String>  createStaffList()
    {
        Iterator<Staff> it = cDatabase.getStaffList().iterator();
        ArrayList<String> initData = new ArrayList<String>();
        
        while (it.hasNext()) {
            Staff re = (Staff)it.next();
            String fullName = re.getFullName();
            String output = String.format("Staff ID:%4d  Name:%-25s",
                                            re.getID(), fullName);
            switch(re.getWorkState())
            {
                case Staff.WORKSTATE_ACTIVE:
                    output += "[From:" + re.getStartTime() + "]";
                break;
                case Staff.WORKSTATE_FINISH:
                    output += "[From:" + re.getStartTime() + " to " + re.getFinishTime() + "]";
                break;
                default:
                    output += "[Not on work]";
                break;
            }
            
            //if(re.getClass().getName().equalsIgnoreCase("Manager"))
             if(re instanceof Manager)
            {
                output += " * Manager *";
            }
            initData.add(output);
        }
        
        return initData;
    }
    
    public ArrayList<String>  createOrderList()
    {
        Iterator<Order> it = cDatabase.getOrderList().iterator();
        String          state;
        ArrayList<String> initData = new ArrayList<String>();
        String          output;
        
        while (it.hasNext()) {
            Order re = it.next();
            switch(re.getState())
            {
                case Order.ORDER_CLOSED:
                    state = "Closed";
                break;
                case Order.ORDER_CANCELED:
                    state = "Canceled";
                break;
                default:
                    state = "-";
                break;
            }
            
            output = String.format("Order ID:%4d  StaffName:%-20s  Total:$%5.2f State:%-8s\n",
                                            re.getOrderID(),re.getStaffName(),re.getTotal(),state);
            initData.add(output);
        }
        if(initData.isEmpty())
            initData.add("No order.");
        return initData;
    }
    
    public ArrayList<String> createOrderItemlList(int orderID)
    //private void createOrderItemlList( int orderID, JList list)
    {
        Order rOrder = cDatabase.findOrderByID(orderID);
        ArrayList<String> initData = new ArrayList<String>();

        if(rOrder == null)
        {
            initData.add("No order information");
            //list.setListData(initData);
            return initData;
        }
        
        String output;

        Iterator<OrderDetail> it = rOrder.getOrderDetail().iterator();
        OrderDetail    re;
        
        int count = 0;
        
        while (it.hasNext()) {
            re = it.next();
            output = String.format("%-4d|%-24s|%5d|%5.2f",
                                    ++count, re.getItemName(), re.getQuantity(), re.getTotalPrice());
           initData.add(output);
        }
        if(initData.isEmpty())
            initData.add("No item");
        //list.setListData(initData);
        return initData;
    }   
    
    public ArrayList<String> createMenuList(int disuplayMenuType)
    {
        Iterator<MenuItem> it = cDatabase.getMenuList().iterator();
        ArrayList<String> initData = new ArrayList<String>();
        
        while (it.hasNext()) {
            MenuItem re = (MenuItem)it.next();
             byte menuType = re.getType();
             //displayMenuType != ALL && ...
             if(disuplayMenuType!= 0 && disuplayMenuType != menuType)
                continue;
             String strMenuType;
            switch( menuType)
            {
                case MenuItem.MAIN:
                strMenuType = "Main";
                break;
                case MenuItem.DRINK:
                strMenuType = "Drink";
                break;
                case MenuItem.ALCOHOL:
                strMenuType = "Alcohol";
                break;
                case MenuItem.DESSERT:
                strMenuType = "Dessert";
                break;
                default:
                strMenuType = "Undefined";
                break;
            }
            String output = String.format("Menu ID:%4d  Name:%-20s  Price:%5.2f Type:%s",
                                            re.getID(),re.getName(),re.getPrice(),strMenuType);
           if(re.getState() == MenuItem.PROMOTION_ITEM)
           {
               output += " ** Today's Special!! **";
            }
            
            initData.add(output);
        }
        if(initData.isEmpty())
            initData.add("No order.");
        return initData;
    }
    
    public String createPaymentList()
    {
        double          totalPayment = 0;
        int             staffNum = 0;
        String          output = "";
        
        Iterator<Staff> it = cDatabase.getStaffList().iterator();
        while (it.hasNext())
        {
            Staff re = it.next();

            if(re.getWorkState() == Staff.WORKSTATE_FINISH)
            {
                double pay = re.culculateWages();
                output += String.format("Staff ID:%4d  StaffName:%-20s  Work time:%5.2f Pay:%5.2f\n",
                                            re.getID(),re.getFullName(),re.culculateWorkTime(), pay);
                staffNum++;
                totalPayment += pay;
            }
            else if(re.getWorkState() == Staff.WORKSTATE_ACTIVE)
            {
                output += String.format("Staff ID:%4d  StaffName:%-20s  * On work *\n",
                                            re.getID(),re.getFullName());
                staffNum++;
            }
        }
        output += "-------------------------------------------------------\n";
        output += String.format("Total payment:$%.2f (%d)", totalPayment, staffNum);
        return output;
        //displayMessage("Total payment:$" + totalPayment + "(" + staffNum + ")");
    }
}
