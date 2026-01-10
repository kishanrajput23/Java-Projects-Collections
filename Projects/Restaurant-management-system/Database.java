/**
 * Kazunori Hayashi
* Version 1.0 29/7/2013
 */
import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Comparator;

public class Database
{
    private final static String STAFF_FILE = "dataFiles/staff.txt";
    private final static String MANAGER_FILE = "dataFiles/manager.txt";
    private final static String MENU_FILE = "dataFiles/menu_item.txt";
    private final static String REPORT_FILE = "dataFiles/reports/report_";
    private final static String PAYMENT_FILE = "dataFiles/reports/payment_";
    private final static String WAGE_INFO_FILE = "dataFiles/wage_info.txt";
    
    private ArrayList<Staff> staffList = new ArrayList<Staff>();
    private ArrayList<MenuItem> menuList = new ArrayList<MenuItem>();
    private ArrayList<Order> orderList = new ArrayList<Order>();
    
    private Date    date;
    int     todaysOrderCounts;
    /****************************************************************************
     * Constructor
     ***************************************************************************/   
    public Database()
    {
        date = new Date();
        todaysOrderCounts = 0;  //Load order file??
    }
    /****************************************************************************
     * Getter
     ***************************************************************************/
     public ArrayList<Staff> getStaffList()
     {
         return staffList;
     }
     
     public ArrayList<MenuItem> getMenuList()
     {
         return menuList;
     }
     
     public ArrayList<Order> getOrderList()
     {
         return orderList;
     }
     
     public int getTodaysOrderCount()
     {
         return this.todaysOrderCounts;
     }
     
    //----------------------------------------------------------
    // Find staff from ID
    //----------------------------------------------------------
    public Staff   findStaffByID(int id)
    {
        Iterator<Staff> it = staffList.iterator();
        Staff           re = null;
        boolean         found = false;
        
        if(id < 0){
            return null;
        }
        
        while (it.hasNext() && !found) {
            re = (Staff)it.next();  
            if( re.getID() == id)
            {
                found = true;
            }
        }
        
        if(found)
            return re;
        else        
            return null;
    }
    
    //----------------------------------------------------------
    // Find menu item from ID
    //----------------------------------------------------------
    public MenuItem   findMenuItemByID(int id)
    {
        Iterator<MenuItem> it = menuList.iterator();
        MenuItem           re = null;
        boolean         found = false;
        
        if(id < 0){
            return null;
        }
        
        while (it.hasNext() && !found) {
            re = (MenuItem)it.next();  
            if( re.getID() == id)
            {
                found = true;
            }
        }
        
        if(found)
            return re;
        else        
            return null;
    }
    
    //----------------------------------------------------------
    // Find order from ID
    //----------------------------------------------------------
    public Order   findOrderByID(int id)
    {
        Iterator<Order> it = orderList.iterator();
        Order           re = null;
        boolean         found = false;
        
        if(id < 0){
            return null;
        }
        
        while (it.hasNext() && !found) {
            re = it.next();  
            if( re.getOrderID() == id)
            {
                found = true;
            }
        }
        
        if(found)
            return re;
        else        
            return null;
    }
     /****************************************************************************
     * Manipurate datas
     ***************************************************************************/
     //---------------------------------------------------------------
     // Staff information
     //---------------------------------------------------------------
     //edit staff data
     // rStaff reference the staff 
     // which 1:Lastname 2:Firstname 3:passward
     public final static int EDIT_LAST_NAME = 1;
     public final static int EDIT_FIRST_NAME = 2;
     public final static int EDIT_PASSWORD = 3;
     
     public void editStaffData(int staffID, String newPassword, String newFirstName, String newLastName) throws DatabaseException
     {
        Staff  rStaff = findStaffByID(staffID);
        rStaff.setPassword(newPassword);
        rStaff.setLastName(newLastName);
        rStaff.setFirstName(newFirstName);
    
        try
        {
            if(rStaff instanceof Manager)
            //if(rStaff.getClass().getName().equalsIgnoreCase("Manager"))
            updateStaffFile(true);//update manager file
            else
            updateStaffFile(false);//update employee file
        }
        catch(DatabaseException dbe)
        {
            throw dbe;
        }
    }
     
     public void editStaffData(Staff rStaff, int which, String newData) throws DatabaseException
     {
         switch(which)
         {
             case EDIT_LAST_NAME:
                rStaff.setLastName(newData);
             break;
             case EDIT_FIRST_NAME:
                rStaff.setFirstName(newData);
             break;
             case EDIT_PASSWORD:
                rStaff.setPassword(newData);
             break;
             default:
             break;
         }
         
         try
         {
             if(rStaff instanceof Manager)
             //if(rStaff.getClass().getName().equalsIgnoreCase("Manager"))
                updateStaffFile(true);//update manager file
             else
                updateStaffFile(false);//update employee file
         }
         catch(DatabaseException dbe)
         {
             throw dbe;
         }
     }
     
     public void deleteStaff(Staff rStaff) throws DatabaseException
     {
         boolean isManager = false;
         staffList.remove(rStaff);
         //if(rStaff.getClass().getName().equalsIgnoreCase("Manager"))
        if(rStaff instanceof Manager)
         isManager = true;
        try
        {
            updateStaffFile(isManager);
        }
        catch(DatabaseException dbe)
        {
            throw dbe;
        }
     }
     
     
     public void addStaff(int newID, String newPassward, String newFirstName, String newLastName, boolean isManager) throws DatabaseException
     {
         Staff newStaff;
         if(isManager)
            newStaff = new Manager(newID, newLastName, newFirstName, newPassward);
         else
            newStaff = new Employee(newID, newLastName, newFirstName, newPassward);
         staffList.add(newStaff);
         if(newStaff instanceof Manager)
         //if(newStaff.getClass().getName().equalsIgnoreCase("Manager"))
            isManager = true;
        try
        {
            updateStaffFile(isManager);
        }
        catch(DatabaseException dbe)
        {
            throw dbe;
        }
     }

     //---------------------------------------------------------------
     // MenuItem
     //---------------------------------------------------------------
     //edit menu item data
     // rMenuItem reference the MenuItem 
     // which 1:name 2:price 3:type
     public final static int EDIT_ITEM_NAME = 1;
     public final static int EDIT_ITEM_PRICE = 2;
     public final static int EDIT_ITEM_TYPE = 3;
     
     public void editMenuItemData(int id, String newName, double newPrice, byte menuType) throws DatabaseException
     {
         MenuItem rMenuItem = findMenuItemByID(id);
         rMenuItem.setName(newName);
         rMenuItem.setPrice(newPrice);
         rMenuItem.setType(menuType);
         
        /*try
        {
            updateMenuFile();
        }
        catch(DatabaseException dbe)
        {
            throw dbe;
        }*/
     }
     
     public void editMenuItemData(MenuItem rMenuItem, int which, String newData) throws DatabaseException
     {
         try
         {
             switch(which)
             {
                 case EDIT_ITEM_NAME:
                    rMenuItem.setName(newData);
                    break;
                 case EDIT_ITEM_PRICE:
                    double newPrice = Double.parseDouble(newData);
                    if(newPrice < 0)
                        throw new DatabaseException("Price must be positive number");
                    else
                        rMenuItem.setPrice(newPrice);
                    break;
                 case EDIT_ITEM_TYPE:
                    byte newType = Byte.parseByte(newData);
                    if(newType < MenuItem.MAIN || MenuItem.DESSERT < newType)
                        throw new DatabaseException("Type must be between " + MenuItem.MAIN
                                            + " and " + MenuItem.DESSERT + ")");
                    else
                        rMenuItem.setType(Byte.parseByte(newData));
                    break;
                 default:
                    break;
             }
        }
        catch(DatabaseException e)
        {
            throw e;
        }
        catch(Exception e)
        {
            throw new DatabaseException(e.getMessage());
        }
     }
     
     public void setMenuItemAsPromotionItem(MenuItem rMenuItem, double price)
     {
         rMenuItem.setState(MenuItem.PROMOTION_ITEM, price);
     }
     
     public void resetMenuState(MenuItem rMenuItem)
     {
         rMenuItem.resetState();
     }
     
     public void deleteMenuItem(MenuItem rMenuItem) throws DatabaseException
     {
         menuList.remove(rMenuItem);
         /*try
        {
             updateMenuFile();
        }
        catch(DatabaseException dbe)
        {
            throw dbe;
        }*/
     }
     
     public void addMenuItem(int newID, String newName, double newPrice, byte newType) throws DatabaseException
     {
         MenuItem newMenuItem = new MenuItem(newID, newName,newPrice, newType);
         menuList.add(newMenuItem);
         Collections.sort(menuList, new MenuItemComparator());
         /*try
         {
             updateMenuFile();
        }
        catch(DatabaseException dbe)
        {
            throw dbe;
        }*/  
     }
     //---------------------------------------------------------------
     // Order
     //---------------------------------------------------------------
     public int addOrder(int staffID, String staffName)
     {
         int newOrderID = ++todaysOrderCounts;
         Order newOrder = new Order(staffID, staffName);
         newOrder.setOrderID( newOrderID);
         orderList.add(newOrder);
         return newOrderID;
     }
     
     public void addOrderItem(int orderID, MenuItem rItem, byte quantity)
     {
         Order rOrder = findOrderByID(orderID);
         rOrder.addItem(rItem, quantity);
     }
     
     public boolean deleteOrderItem(int orderID, int index)
     {
          Order rOrder = findOrderByID(orderID);
          if(rOrder == null)
            return false;
          return rOrder.deleteItem(index);
     }
     
     
     //Cancel order: order data is not deleted from the database(Just put cancel flag on)
     public boolean cancelOrder(int orderID)
     {
         Order rOrder = findOrderByID(orderID);
        if(rOrder == null)
            return false;
         rOrder.setState(Order.ORDER_CANCELED);
         return true;
     }
     //Delete order: order data is deleted from the database
     public boolean deleteOrder(int orderID)
     {
         Order rOrder = findOrderByID(orderID);
        if(rOrder == null)
            return false;
         orderList.remove(rOrder);
         todaysOrderCounts--;
         return true;
     }
     
     public boolean closeOrder(int orderID)
     {
         Order rOrder = findOrderByID(orderID);
        if(rOrder == null)
            return false;
         rOrder.setState(Order.ORDER_CLOSED);
         return true;
     }
     
     public void closeAllOrder()
     {
        Iterator<Order> it = orderList.iterator();
        Order           re = null;
        
        while (it.hasNext()) {
            re = it.next();  
            if( re.getState() == 0)//neither closed and canceled
            {
                re.setState(Order.ORDER_CLOSED);
            }
        }
     }
     
     public int getOrderState(int orderID)
     {
         Order  re = findOrderByID(orderID);
         if(re == null)
             return -1;
         return re.getState();
     }
     
     public double getOrderTotalCharge(int orderID)
     {
         Order  re = findOrderByID(orderID);
         if(re == null)
             return -1;
         return re.getTotal();
     }
     
     public boolean checkIfAllOrderClosed()
     {
        Iterator<Order> it = orderList.iterator();
        Order           re = null;
        
        while (it.hasNext()) {
            re = it.next();  
            if( re.getState() == 0)//neither closed and canceled
            {
                return false;
            }
        }
        return true;
     }
     
     public boolean checkIfAllStaffCheckout()
     {
        Iterator<Staff> it = staffList.iterator();
        Staff           re = null;
        
        while (it.hasNext()) {
            re = it.next();  
            if( re.getWorkState() == Staff.WORKSTATE_ACTIVE)
            {
                return false;
            }
        }
        return true;
     }
     
     public void forthClockOutAllStaff()
     {
         Iterator<Staff> it = staffList.iterator();
         Staff           re = null;
        
         while (it.hasNext()) {
            re = it.next();  
            if( re.getWorkState() == Staff.WORKSTATE_ACTIVE)
            {
                re.clockOut();
            }
         }
     }
     /****************************************************************************
    * File load
    ***************************************************************************/
    public void loadFiles() throws DatabaseException
    {
        loadStaffFile();
        loadManagerFile();
        Collections.sort(staffList, new StaffComparator());
        loadMenuFile();
        loadWageInfoFile();
    }
    
    private void loadStaffFile() throws DatabaseException
    {
            try {
            BufferedReader reader = new BufferedReader(new FileReader(STAFF_FILE));
            String line = reader.readLine();

            while (line != null) {
                String[] record = line.split(",");

                String id = record[0].trim();
                String passward = record[1].trim();
                String firstName = record[2].trim();
                String lastName = record[3].trim();

                // Add the data from file to the registerCourses array list
                Employee rEmployee = new Employee(Integer.parseInt(id),lastName, firstName, passward);
                staffList.add(rEmployee);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException ioe) {
            String message = ioe.getMessage() + ioe.getStackTrace();
            throw new DatabaseException(message);
        }
    }
 
    private void loadManagerFile() throws DatabaseException
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(MANAGER_FILE));
            String line = reader.readLine();

            while (line != null) {
                String[] record = line.split(",");

                String id = record[0].trim();
                String passward = record[1].trim();
                String firstName = record[2].trim();
                String lastName = record[3].trim();

                // Add the data from file to the registerCourses array list
                Manager rManager = new Manager(Integer.parseInt(id),lastName,firstName, passward);
                staffList.add(rManager);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException ioe) {
            String message = ioe.getMessage() + ioe.getStackTrace();
            throw new DatabaseException(message);
        }
    }
    
    private void loadMenuFile() throws DatabaseException
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(MENU_FILE));
            String line = reader.readLine();

            while (line != null) {
                String[] record = line.split(",");

                String id = record[0].trim();
                String name = record[1].trim();
                String price = record[2].trim();
                String type = record[3].trim();

                // Add the data from file to the registerCourses array list
                MenuItem rMenuItem = new MenuItem(Integer.parseInt(id), name, Double.parseDouble(price), Byte.parseByte(type));
                menuList.add(rMenuItem);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException ioe) {
            String message = ioe.getMessage() + ioe.getStackTrace();
            throw new DatabaseException(message);
        }
    }
    
    private void loadWageInfoFile() throws DatabaseException
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(WAGE_INFO_FILE));
            String line = reader.readLine();

            while (line != null) {
                String[] record = line.split(",");

                String id = record[0].trim();
                String rate = record[1].trim();
                
                double dRate = Double.parseDouble(rate);
                int iId = Integer.parseInt(id);
                
                Staff rStaff = findStaffByID(iId);
                if(rStaff == null)
                {
                    throw new DatabaseException("Load wage file error\n Staff ID:" + iId + " is not found.");
                }
                rStaff.setWageRate(dRate);

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException ioe) {
            String message = ioe.getMessage() + ioe.getStackTrace();
            throw new DatabaseException(message);
        }
        catch(Exception e)
        {
            String message = e.getMessage() + e.getStackTrace();
            throw new DatabaseException(message);
        }
    }
    
    /****************************************************************************
    * File Edit
    ***************************************************************************/
    public void updateStaffFile(boolean isManager) throws DatabaseException
    {
        Writer          writer;
        String          id;
        String          line;
        String          fileName;
        String          tempFileName = "dataFiles/temp.txt";
            
        if(isManager)
            fileName =MANAGER_FILE;
        else
            fileName = STAFF_FILE;
        
        Collections.sort(staffList, new StaffComparator());
        File tempFile = new File(tempFileName);
     
        try{
            writer = new BufferedWriter(new FileWriter(tempFile));
            Iterator it = staffList.iterator();
        
            while (it.hasNext())
            {
                Staff re = (Staff)it.next();
            
                //-------- skip writing data ----------
                if(isManager)
                {
                    //skip employee data
                    if(re instanceof Employee)
                    //if(re.getClass().getName().equalsIgnoreCase("Employee"))
                    continue;
                }
                else
                {
                    //skip managere data
                    //if(re.getClass().getName().equalsIgnoreCase("Manager"))
                    if(re instanceof Manager)
                    continue;
                }
            
                writer.write(re.getID() + "," + re.getPassword() + "," + re.getFirstName() + "," + re.getLastName()+ "\r\n");
            }
            writer.flush();
            writer.close();
        }
        catch(IOException e)
        {
            String message = e.getMessage() + e.getStackTrace();
            throw new DatabaseException(message);
        }
        
        //delete current file
        File deleteFile = new File(fileName);
        deleteFile.delete();
        
        // renames temporaly file to new file
        File newFile = new File(fileName);  
        tempFile.renameTo(newFile);
        
        updateWageFile();
    }
    
    public void updateWageFile() throws DatabaseException
    {
        Writer          writer;
        String          id;
        String          line;
        String          fileName;
        String          tempFileName = "dataFiles/temp.txt";
            
        File tempFile = new File(tempFileName);
     
        try{
            writer = new BufferedWriter(new FileWriter(tempFile));
            Iterator it = staffList.iterator();
        
            while (it.hasNext())
            {
                Staff re = (Staff)it.next();
                writer.write(re.getID() + "," + re.getWageRate() + "\r\n");
            }
            writer.flush();
            writer.close();
        }
        catch(IOException e)
        {
            String message = e.getMessage() + e.getStackTrace();
            throw new DatabaseException(message);
        }
        
        //delete current file
        File deleteFile = new File(WAGE_INFO_FILE);
        deleteFile.delete();
        
        // renames temporaly file to new file
        File newFile = new File(WAGE_INFO_FILE);  
        tempFile.renameTo(newFile);
    }
    
    public void updateMenuFile() throws DatabaseException
    {
        Writer          writer;
        String          id;
        String          line;
        String          tempFileName = "dataFiles/temp.txt";
        
        //Collections.sort(menuList, new MenuItemComparator());
        File tempFile = new File(tempFileName);
     
        try{
            writer = new BufferedWriter(new FileWriter(tempFile));
            Iterator it = menuList.iterator();
        
            while (it.hasNext())
            {
                MenuItem re = (MenuItem)it.next();

                writer.write(re.getID() + "," + re.getName() + "," + re.getPrice() + "," + re.getType()+ "\r\n");
            }
            writer.flush();
            writer.close();
        }
        catch(IOException e)
        {
            String message = e.getMessage() + e.getStackTrace();
            throw new DatabaseException(message);
        }
        
        //delete current file
        File deleteFile = new File(MENU_FILE);
        deleteFile.delete();
        
        // renames temporaly file to new file
        File newFile = new File(MENU_FILE);  
        tempFile.renameTo(newFile);
    }
    
    public String generateOrderReport( String todaysDate) throws DatabaseException
    {
        Writer          writer = null;
        String          line;
        int             state;
        double          totalAllOrder = 0;
        String          generateFileName;
        File            newFile;
        int             orderCnt = 0;
        int             cancelCnt = 0;
        double          cancelTotal = 0;
        
        String[] record = todaysDate.split("/");
        String today = record[0].trim() + "_" + record[1].trim() + "_" + record[2].trim();
        generateFileName = REPORT_FILE + today + ".txt";
        newFile = new File(generateFileName);
        
        try{
            writer = new BufferedWriter(new FileWriter(newFile));

            line = "*********** Order List (" + today + ") ***********\r\n";
            writer.write(line);
            
            Iterator<Order> it = orderList.iterator();
            while (it.hasNext())
            {
                Order re = it.next();
                state = re.getState();
                String stateString = "";
                double totalOfEachOrder = re.getTotal();
                switch(state)
                {
                    case Order.ORDER_CLOSED:
                        stateString = "";
                        totalAllOrder += totalOfEachOrder;
                        orderCnt++;
                    break;
                    case Order.ORDER_CANCELED:
                        stateString = "Canceled";
                        cancelTotal += totalOfEachOrder;
                        cancelCnt++;
                    break;
                    default:
                        stateString = "";
                        totalAllOrder += totalOfEachOrder;
                        orderCnt++;
                    break;
                }
                String output = String.format("Order ID:%4d  StaffName:%-30s  Total:$%-5.2f %s\r\n",
                                            re.getOrderID(),re.getStaffName(),totalOfEachOrder, stateString);
                writer.write(output);
                
                
            }
            writer.write("-------------------------------------------------------\r\n");
            
            writer.write("Total sales:$" + totalAllOrder + "(" + orderCnt + ")" +
                    "  Canceled:$" + cancelTotal + "(" + cancelCnt + ")\r\n");
            writer.flush();
            writer.close();
        }
        catch(IOException e)
        {
            String message = e.getMessage() + e.getStackTrace();
            newFile.delete();
            throw new DatabaseException(message);
        }
        return generateFileName;
        //System.out.println("File <" + generateFileName + "> has been generated.");
    }
    
    public String generatePaymentReport( String todaysDate) throws DatabaseException
    {
        Writer          writer = null;
        String          line;
        double          totalPayment = 0;
        String          generateFileName;
        File            newFile;
        int             staffNum = 0;
        
        String[] record = todaysDate.split("/");
        String today = record[0].trim() + "_" + record[1].trim() + "_" + record[2].trim();
        generateFileName = PAYMENT_FILE + today + ".txt";
        newFile = new File(generateFileName);
        
        try{
            writer = new BufferedWriter(new FileWriter(newFile));

            line = "*********** Payment List (" + today + ") ***********\r\n";
            writer.write(line);
            
            Iterator<Staff> it = staffList.iterator();
            while (it.hasNext())
            {
                Staff re = it.next();
 
                if(re.getWorkState() == Staff.WORKSTATE_FINISH)
                {
                    double pay = re.culculateWages();
                    String output = String.format("Order ID:%4d  StaffName:%-30s  Work time:%-5.2f Pay:%-5.2f\r\n",
                                                re.getID(),re.getFullName(),re.culculateWorkTime(), pay);
                    writer.write(output);
                    staffNum++;
                    totalPayment += pay;
                }
            }
            writer.write("-------------------------------------------------------\r\n");
            
            writer.write("Total payment:$" + totalPayment + "(" + staffNum + ")\r\n");
            writer.flush();
            writer.close();
        }
        catch(IOException e)
        {
            String message = e.getMessage() + e.getStackTrace();
            newFile.delete();
            throw new DatabaseException(message);
        }
        return generateFileName;
    }
    
    /****************************************************************************
    * Comparator
    ***************************************************************************/
    private class StaffComparator implements Comparator<Staff> {

        @Override
        public int compare(Staff s1, Staff s2) {
            return s1.getID() < s2.getID() ? -1 : 1;
        }
    }
    
    private class MenuItemComparator implements Comparator<MenuItem> {

        @Override
        public int compare(MenuItem m1, MenuItem m2) {
            return m1.getID() < m2.getID() ? -1 : 1;
        }
    }
}
