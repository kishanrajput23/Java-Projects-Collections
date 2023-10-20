import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import java.util.*;

public class UserInterface_GUI extends JFrame implements ActionListener
{
    private Container       con;
    private Controller_GUI  rcController;
    private String          currentUserName;
    
    // components for menu
    private JMenuBar   menuBar;
    private JMenu      mnFile;
    private JMenuItem  mntm1, mntm2;
    
    
    //-------- Master panel -------------- 
    //Main content panel(CENTER)
    private JPanel         mainPanel;
    
    //Head panel (North)
    private JPanel         headPanel;
    private JLabel         headTitle;
    private JButton        headBtnLogin;
    private JButton        headBtnLogout;
    
    //Main button panel(WEST)
    private JPanel         mainBtnsPanel;
    // Main buttons

    private JButton        mainBtnShowMenu;
    private JButton        mainBtnManageOrder;
    // Main buttons for management
    private JButton        mainBtnManageEmployee;
    private JButton        mainBtnManageMenuItem;
    private JButton        mainBtnShowTotalSales;
    private JButton        mainBtnShowPayment;
    
    //Information panel(SOUTH)
    private JPanel         infoPanel;
    private JLabel         labelLoginUserName;
    private JButton         btnClockOut;
    private JTextArea      taMessage;
    
    //-------- Contents panel --------------
    // components for home panel
    private JPanel         homePanel;
    private JLabel         homeImage;
    
    private LoginPanel          cLoginPanel;
    private MenuListPanel       cMenuListPanel;
    private OrderListPanel      cOrderListPanel;
    private OrderDetailPanel    cOrderDetailPanel;
    private EmployeeListPanel   cEmployeeListPanel;
    private EditEmployeePanel   cEditEmployeePanel;
    private MenuManagementPanel       cMenuManagementPanel;
    private EditMenuItemPanel       cEditMenuItemPanel;
    private TotalSalesPanel       cTotalSalesPanel;
    private PaymentPanel        cPaymentPanel;


    private final static int WINDOW_X = 100;
    private final static int WINDOW_Y = 100;
    private final static int WINDOW_WIDTH = 900;
    private final static int WINDOW_HEIGHT = 600;
    /**
     * Constructor for objects of class UserInterface_GUI
     */
    public UserInterface_GUI(Controller_GUI rController)
    {
        this.rcController = rController;
        this.con = getContentPane();
        
        // Set frame
        setTitle("Valentino Restaurant Management System");
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        createMasterPanelConpornents();
        currentUserName = "";
        setLoginUserName(currentUserName);
        
        //------- Create main content panels
        //Home panel
        homePanel = new JPanel();
        homeImage = new JLabel();
        
        //Random generator = new Random();
        int i = new Random().nextInt(4)+1;
        homeImage.setHorizontalAlignment(SwingConstants.CENTER);
        homeImage.setVerticalAlignment(SwingConstants.CENTER);
        homeImage.setIcon(new ImageIcon("images/home" + i + ".jpg"));
        homePanel.add(homeImage);
        homePanel.setBackground(Color.WHITE);
        mainPanel.add("Home", homePanel);

        cLoginPanel = new LoginPanel();
        mainPanel.add("Login", cLoginPanel);
        cMenuListPanel = new MenuListPanel();
        mainPanel.add("MenuList", cMenuListPanel);
        cOrderListPanel = new OrderListPanel();
        mainPanel.add("OrderList", cOrderListPanel);
        cOrderDetailPanel = new OrderDetailPanel();
        mainPanel.add("OrderDetail", cOrderDetailPanel);
        cEmployeeListPanel = new EmployeeListPanel();
        mainPanel.add("EmployeeList", cEmployeeListPanel);
        cEditEmployeePanel = new EditEmployeePanel();
        mainPanel.add("EditEmployee", cEditEmployeePanel);
        cMenuManagementPanel = new MenuManagementPanel();
        mainPanel.add("MenuManagement", cMenuManagementPanel);
        cEditMenuItemPanel = new EditMenuItemPanel();
        mainPanel.add("EditMenuItem", cEditMenuItemPanel);
        cTotalSalesPanel = new TotalSalesPanel();
        mainPanel.add("TotalSalesPanel", cTotalSalesPanel);
        cPaymentPanel = new PaymentPanel();
        mainPanel.add("PaymentPanel", cPaymentPanel);
        
        changeMode(MODE_ANONYMOUS);
    }
    
    private void createMasterPanelConpornents()
    {
                // Add menu to frame
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        mnFile = new JMenu("File");
        menuBar.add(mnFile);

        mntm1 = new JMenuItem("[1] Login");
        mnFile.add(mntm1);
        mntm1.addActionListener(this);
        
        mntm2 = new JMenuItem("[2] Exit");
        mnFile.add(mntm2);
        mntm2.addActionListener(this);
        
        //----------- Create main panels ------------
        con.setLayout(new BorderLayout());
        
        //head panel
        headPanel = new JPanel();
        headPanel.setBackground(Color.BLACK);
        headPanel.setLayout(new FlowLayout());
        headTitle = new JLabel("Valentino Restaurant Management System");
        headTitle.setForeground(Color.WHITE);
        headTitle.setPreferredSize(new Dimension(500, 30));
        headTitle.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
        headBtnLogin = new JButton("Login");
        headBtnLogin.addActionListener(this);
        headBtnLogout = new JButton("Logout");
        headBtnLogout.addActionListener(this);
        headPanel.add(headTitle);
        headPanel.add(headBtnLogin);
        headPanel.add(headBtnLogout);
        con.add(headPanel, BorderLayout.NORTH);
        
        //main content panel
        mainPanel = new JPanel();
        mainPanel.setOpaque(true);
        mainPanel.setLayout(new CardLayout());
        con.add(mainPanel, BorderLayout.CENTER);
        
        //main operate buttons panel
        mainBtnsPanel = new JPanel();
        mainBtnsPanel.setLayout(new GridLayout(0,1));
        
        mainBtnShowMenu = new JButton("Show menu");
        mainBtnShowMenu.addActionListener(this);
        mainBtnsPanel.add(mainBtnShowMenu);
        
        mainBtnManageOrder = new JButton("Order management");
        mainBtnManageOrder.addActionListener(this);
        mainBtnsPanel.add(mainBtnManageOrder);
        
        mainBtnManageEmployee = new JButton("Manage employees");
        mainBtnManageEmployee.addActionListener(this);
        mainBtnsPanel.add(mainBtnManageEmployee);
        
        mainBtnManageMenuItem = new JButton("Manage menu items");
        mainBtnManageMenuItem.addActionListener(this);
        mainBtnsPanel.add(mainBtnManageMenuItem);
        
        mainBtnShowTotalSales = new JButton("Show total sales");
        mainBtnShowTotalSales.addActionListener(this);
        mainBtnsPanel.add(mainBtnShowTotalSales);
        
        mainBtnShowPayment = new JButton("Show payments");
        mainBtnShowPayment.addActionListener(this);
        mainBtnsPanel.add(mainBtnShowPayment);
        
        con.add(mainBtnsPanel, BorderLayout.WEST);
        
        //Information panel
        infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout());
        labelLoginUserName = new JLabel();
        labelLoginUserName.setPreferredSize(new Dimension(150, 50));
        taMessage = new JTextArea(3,50);
        taMessage.setEditable(false);
        taMessage.setText("Wellcome!!");
        taMessage.setOpaque(true);
        btnClockOut = new JButton("Clock out");
        btnClockOut.setEnabled(false);
        btnClockOut.addActionListener(this);
        LineBorder border = new LineBorder(Color.BLACK, 3, true);
        taMessage.setBorder(border);
        taMessage.setBackground(Color.WHITE);
        infoPanel.add(labelLoginUserName);
        infoPanel.add(btnClockOut);
        infoPanel.add(taMessage);
        con.add(infoPanel, BorderLayout.SOUTH);
    }
    

    public void setLoginUserName(String newName)
    {
        currentUserName = newName;
         if(newName == "")
         {
             labelLoginUserName.setText("Please login first.");
         }
         else
         {
            labelLoginUserName.setText("<html>Login user<br>" + newName + "</html>");
        }
    }

    public final static byte MODE_ANONYMOUS = 0;
    public final static byte MODE_EMPLOYEE = 1;
    public final static byte MODE_MANAGER = 2;
    
    public void changeMode(byte state)
    {
        switch(state)
        {
            case MODE_ANONYMOUS:
                headBtnLogout.setEnabled(false);
                mainBtnShowMenu.setEnabled(false);
                mainBtnManageOrder.setEnabled(false);
                mainBtnManageEmployee.setEnabled(false);
                mainBtnManageMenuItem.setEnabled(false);
                mainBtnShowTotalSales.setEnabled(false);
                mainBtnShowPayment.setEnabled(false);
                break;
            case MODE_EMPLOYEE:
                headBtnLogout.setEnabled(true);
                mainBtnShowMenu.setEnabled(true);
                mainBtnManageOrder.setEnabled(true);
                mainBtnManageEmployee.setEnabled(false);
                mainBtnManageMenuItem.setEnabled(false);
                mainBtnShowTotalSales.setEnabled(false);
                mainBtnShowPayment.setEnabled(false);
                break;
           case MODE_MANAGER:
                headBtnLogout.setEnabled(true);
                mainBtnShowMenu.setEnabled(true);
                mainBtnManageOrder.setEnabled(true);
                mainBtnManageEmployee.setEnabled(true);
                mainBtnManageMenuItem.setEnabled(true);
                mainBtnShowTotalSales.setEnabled(true);
                mainBtnShowPayment.setEnabled(true);
                break;
        }
    }
    
    public void setTodaysDate(String today)
    {
        ////
    }
    
    void setClockOutButton()
    {
        if(rcController.checkIfUserClockedOut())
            btnClockOut.setEnabled(true);
        else
            btnClockOut.setEnabled(false);
    }
    //--------------------------------------------------------
    // Display message on an information panel
    //--------------------------------------------------------
    public void displayMessage(String message)
    {
        taMessage.setForeground(Color.BLACK);
        taMessage.setText(message);
    }
    
    public void displayErrorMessage(String message)
    {
        taMessage.setForeground(Color.RED);
        taMessage.setText(message);
    }
    
    //========================================================
    // Show dialog message
    //========================================================
    final static int DIALOG_YES = JOptionPane.YES_OPTION;
    final static int DIALOG_NO = JOptionPane.NO_OPTION;
    final static int DIALOG_CANCEL = JOptionPane.CANCEL_OPTION;
    
    public int showYesNoDialog(String title, String message)
    {
        int option = JOptionPane.showConfirmDialog(this, message, title, JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE);
        return option;
    }
    
    public int showYesNoCancelDiaglog(String title, String message)
    {
        int option = JOptionPane.showConfirmDialog(this, message, title, JOptionPane.YES_NO_CANCEL_OPTION, 
        JOptionPane.QUESTION_MESSAGE);
        return option;
    }
    
    public void showErrorDialog(String title, String message)
    {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
    }
    
    public void showConfirmDialog(String title, String message)
    {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.PLAIN_MESSAGE);
    }
        

    
    
    private int getIDfromString(String stringLine, int length)
    {
        int index = stringLine.indexOf("ID:"); //Search string of "ID:"
        if(index == -1)
        {
            showErrorDialog("Error", "String 'ID:' is not found!!");
            return -1;
        }
        
        try
        {
            String strID = stringLine.substring(index + 3, index + 3 + length);
            int id = Integer.parseInt(strID.trim());
            return id;
        }
        catch(Exception e)
        {
            showErrorDialog("Error", "Parse error");
            return -1;
        }
    }
    //========================================================
    // Master panel action
    //========================================================
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == mntm2)
        {
            System.exit(0);
        }
        else if (ae.getSource() == mainBtnShowMenu)
        {
            //((CardLayout) mainPanel.getLayout()).show( mainPanel, "MenuList");
            changeMainPanel("MenuList");
            cMenuListPanel.init();
        }
        else if (ae.getSource() == mainBtnManageOrder)
        {
            //((CardLayout) mainPanel.getLayout()).show( mainPanel, "OrderList");
            changeMainPanel("OrderList");
            cOrderListPanel.init();
        }
        else if (ae.getSource() == mainBtnManageEmployee)
        {
            changeMainPanel("EmployeeList");
            cEmployeeListPanel.init();
        }
        else if (ae.getSource() == mainBtnManageMenuItem)
        {
            changeMainPanel("MenuManagement");
            cMenuManagementPanel.init();
        }
        else if (ae.getSource() == mainBtnShowTotalSales)
        {
            changeMainPanel("TotalSalesPanel");
            cTotalSalesPanel.init();
        }
        else if (ae.getSource() == mainBtnShowPayment)
        {
            changeMainPanel("PaymentPanel");
            cPaymentPanel.init();
        }
        else if (ae.getSource() == headBtnLogin || ae.getSource() == mntm1) {
            changeMainPanel("Login");
            cLoginPanel.init();
            displayMessage("Enter your login ID and password.");
        }
        else if (ae.getSource() == headBtnLogout) {
            if( showYesNoDialog("Logout","Are you sure to logout?") == DIALOG_YES)
            {
                rcController.userLogout();
                changeMainPanel("Home");
                changeMode(MODE_ANONYMOUS);
                setClockOutButton();
            }
        }
        else if (ae.getSource() == btnClockOut){
            if( showYesNoDialog("Clock out","Are you sure to clock out?") == DIALOG_YES)
            {
                rcController.clockOut();
                setClockOutButton();
            }
        }
    }
    
    /****************************************************************
     * Login panel
    *****************************************************************/
    private class LoginPanel extends JPanel implements ActionListener
    {
        // components for login panel
        //private JPanel         loginPanel;
        private JLabel          lblUserID;
        private JTextField      tfUserID;
        private JLabel          lblPassword;
        private JPasswordField  pwPassword;
        private JCheckBox       chbIsManager;
        private JButton         btnLoginOK;
        public LoginPanel()
        {
            //loginPanel = new JPanel();
            GridBagLayout gbLayout = new GridBagLayout();
            this.setLayout( gbLayout);
            GridBagConstraints gbc = new GridBagConstraints();
            lblUserID = new JLabel("UserID:");
            lblUserID.setPreferredSize(new Dimension(100, 30));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbLayout.setConstraints(lblUserID, gbc);
            this.add(lblUserID);
            
            tfUserID = new JTextField(20);
            tfUserID.setInputVerifier(new IntegerInputVerifier(0));
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbLayout.setConstraints(tfUserID, gbc);
            this.add(tfUserID);
            
            lblPassword = new JLabel("Password:");
            lblPassword.setPreferredSize(new Dimension(100, 30));
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbLayout.setConstraints(lblPassword, gbc);
            this.add(lblPassword);
            
            pwPassword = new JPasswordField(20);
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbLayout.setConstraints(pwPassword, gbc);
            this.add(pwPassword);
            
            chbIsManager = new JCheckBox("Login as manager");
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbLayout.setConstraints(chbIsManager, gbc);
            this.add(chbIsManager);
            
            btnLoginOK = new JButton("Login");
            btnLoginOK.addActionListener(this);
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            gbLayout.setConstraints(btnLoginOK, gbc);
            this.add(btnLoginOK);
        }
        
        private void setUserID(String id)
        {
            tfUserID.setText(id);
        }
        
        private void setPassword(String password)
        {
            pwPassword.setText(password);
        }
        
        public void init()
        {
            setUserID("");
            setPassword("");
            tfUserID.setBackground( UIManager.getColor( "TextField.background" ) ); 
        }
         
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnLoginOK)
            {
                //Check whether current focuced compornent have to verify their value
                if (btnLoginOK.getVerifyInputWhenFocusTarget()) {
                    //Try to get focus
                    btnLoginOK.requestFocusInWindow();
                    if (!btnLoginOK.hasFocus()) {    //Can not get focus ?Ë the compornent have not been verified
                        return;
                    }
                }  
                //if(!inputVerified)
                //    return;
                    
                char[] password;
                boolean isManager = chbIsManager.isSelected(); 
                
                byte state = -1;
                
                String inputID = tfUserID.getText();
               
                if(inputID.equals(""))
                {
                    displayErrorMessage("Enter user ID");
                    return;
                }
                
     
                password= pwPassword.getPassword();
                String inputPassword = new String(password);
                if(inputPassword.equals(""))
                {
                    displayErrorMessage("Enter password");
                    return;
                }
                
                if( rcController.loginCheck(Integer.parseInt(inputID), inputPassword, isManager))
                {
                    showConfirmDialog("Message", "Login success!!");
                    displayMessage("Wellcome, " + currentUserName);
                    tfUserID.setText("");
                    pwPassword.setText("");
                    changeMainPanel("Home");
                    setClockOutButton();
                }
                else
                {
                    displayErrorMessage(rcController.getErrorMessage());
                }
            }
        }
    }
    
    private void  changeMainPanel(String panelName)
    {
        ((CardLayout) mainPanel.getLayout()).show( mainPanel, panelName);
        displayMessage("Main paanel change :" + panelName);
    }
    
    /****************************************************************
     * Menu list panel
    *****************************************************************/       
    private class MenuListPanel extends JPanel implements ActionListener
    {
        private JScrollPane     scrollPanel;
        private JTextArea       displayArea;
        private JPanel          btnPanel;
        private JButton         btnAll;
        private JButton         btnMain;
        private JButton         btnDrink;
        private JButton         btnAlcohol;
        private JButton         btnDessert;
        
        public MenuListPanel()
        {
            this.setLayout( new BorderLayout());
            displayArea = new JTextArea();
            displayArea.setFont(new Font(Font.MONOSPACED,Font.PLAIN,16));
            displayArea.setEditable(false);
            displayArea.setMargin(new Insets(5, 5, 5, 5));
            scrollPanel = new JScrollPane(displayArea);
            scrollPanel.setPreferredSize(new Dimension(200, 400));
            add(scrollPanel, BorderLayout.CENTER);
            
           btnPanel = new JPanel();
           btnPanel.setLayout( new FlowLayout());
           btnAll = new JButton("All");
           btnAll.addActionListener(this);
           btnMain = new JButton("Main");
           btnMain.addActionListener(this);
           btnDrink = new JButton("Drink");
           btnDrink.addActionListener(this);
           btnAlcohol = new JButton("Alcohol");
           btnAlcohol.addActionListener(this);
           btnDessert = new JButton("Dessert");
           btnDessert.addActionListener(this);
           
           btnPanel.add(btnAll);
           btnPanel.add(btnMain);
           btnPanel.add(btnDrink);
           btnPanel.add(btnAlcohol);
           btnPanel.add(btnDessert);
           
           add(btnPanel, BorderLayout.SOUTH);
        }
    
        public void init()
        {
            showMenuList(0);
            //displayArea.setText(str);
            //showAllMenuList(displayArea);
        }
        
        private void showMenuList(int menuType)
        {
            displayArea.setText("");
            ArrayList<String> menuList = rcController.createMenuList(menuType);
            for(int i = 0; i < menuList.size(); i++)
                displayArea.append(menuList.get(i) + "\n");
        }
        
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnAll)
            {
                showMenuList(0);
                //showAllMenuList(displayArea);
            }
            else if (ae.getSource() == btnMain)
            {
                showMenuList(MenuItem.MAIN);
                //showParticularMenuList(MenuItem.MAIN, displayArea);
            }
            else if (ae.getSource() == btnDrink)
            {
                showMenuList(MenuItem.DRINK);
                //showParticularMenuList(MenuItem.DRINK, displayArea);
            }
            else if (ae.getSource() == btnAlcohol)
            {
                showMenuList(MenuItem.ALCOHOL);
                //showParticularMenuList(MenuItem.ALCOHOL, displayArea);
            }
            else if (ae.getSource() == btnDessert)
            {
                showMenuList(MenuItem.DESSERT);
                //showParticularMenuList(MenuItem.DESSERT, displayArea);
            }
        }
    }
    
    /****************************************************************
     * MenuManagementPanel
    *****************************************************************/    
    private class MenuManagementPanel extends JPanel implements ActionListener
    {
        private JScrollPane     scrollPanel;
        private JList           displayList;
        private JButton         btnAddNewMenuItem;
        private JButton         btnEditMenuItem;
        private JButton         btnDeleteMenuItem;
        
        public MenuManagementPanel()
        {
            GridBagLayout gbLayout = new GridBagLayout();
            this.setLayout( gbLayout);
            GridBagConstraints gbc = new GridBagConstraints();

            scrollPanel = new JScrollPane();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.gridwidth = 3;
            gbLayout.setConstraints(scrollPanel, gbc);
            this.add(scrollPanel);
            
            btnAddNewMenuItem     = new JButton("Add new menu item");
            btnAddNewMenuItem.addActionListener(this);
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.weighty = 0;
            gbc.weightx = 0.5;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbLayout.setConstraints(btnAddNewMenuItem, gbc);
            this.add(btnAddNewMenuItem);
            
            btnEditMenuItem    = new JButton("Edit menu item");
            btnEditMenuItem.addActionListener(this);
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbLayout.setConstraints(btnEditMenuItem, gbc);
            this.add(btnEditMenuItem);
            
            btnDeleteMenuItem   = new JButton("Delete menu item");
            btnDeleteMenuItem.addActionListener(this);
            gbc.gridx = 2;
            gbc.gridy = 1;
            gbLayout.setConstraints(btnDeleteMenuItem, gbc);
            this.add(btnDeleteMenuItem);
            
            displayList = new JList();
            displayList.setFont(new Font(Font.MONOSPACED,Font.PLAIN,16));
            displayList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
        
        public void init()
        {
            showMenuList();
        }
        
        private void showMenuList()
        {
            displayList.setListData(rcController.createMenuList(0).toArray());
            scrollPanel.getViewport().setView(displayList);
        }
        
        private int getSelectedMenuID()
        {
            String orderLine = (String)displayList.getSelectedValue();
            if (orderLine == null)
                return -1;
                
            return getIDfromString( orderLine, 4);
        }
        
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnAddNewMenuItem)
            {
                cEditMenuItemPanel.init(0);
                changeMainPanel("EditMenuItem");
            }
            else if (ae.getSource() == btnEditMenuItem)
            {
                int menuID = getSelectedMenuID();
                if( menuID == -1)    return;
                cEditMenuItemPanel.init(menuID);
                changeMainPanel("EditMenuItem");
            }
            else if (ae.getSource() == btnDeleteMenuItem)
            {
                int deleteMenuID = getSelectedMenuID();
                if( deleteMenuID == -1)    return;
                
                if( showYesNoDialog("", "Are you sure to delete the menu item?") == DIALOG_YES)
                {
                    if(!rcController.deleteMenuItem(deleteMenuID))
                    {
                        showErrorDialog("Error", rcController.getErrorMessage());
                    }
                    else
                    {
                        displayMessage("Deleted.");
                        init();
                    }
                }
            }
        }
    }
    
    /****************************************************************
     * Edit menu item panel
    *****************************************************************/       
    private class EditMenuItemPanel extends JPanel implements ActionListener
    {
        private JLabel          lblMenuItemID;
        private JTextField      tbMenuItemID;
        private JLabel          lblName;
        private JTextField      tbName;
        private JLabel          lblPrice;
        private JTextField      tbPrice;
        private JLabel          lblType;
        private JComboBox       cbType;
        private JButton         btnOK;
        
        private boolean         isUpdate;
        
        public EditMenuItemPanel()
        {
            GridBagLayout gbLayout = new GridBagLayout();
            this.setLayout( gbLayout);
            GridBagConstraints gbc = new GridBagConstraints();
            
            lblMenuItemID = new JLabel("Menu item ID:");
            lblMenuItemID.setPreferredSize(new Dimension(100, 30));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            gbLayout.setConstraints(lblMenuItemID, gbc);
            this.add(lblMenuItemID);
            
            tbMenuItemID = new JTextField(4);
            tbMenuItemID.setInputVerifier(new IntegerInputVerifier(1,10000));
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbLayout.setConstraints(tbMenuItemID, gbc);
            this.add(tbMenuItemID);
            
            lblName = new JLabel("Menu item name:");
            lblName.setPreferredSize(new Dimension(100, 30));
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbLayout.setConstraints(lblName, gbc);
            this.add(lblName);
            
            tbName = new JTextField(20);
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbLayout.setConstraints(tbName, gbc);
            this.add(tbName);
            
            lblPrice = new JLabel("Menu item price:");
            lblPrice.setPreferredSize(new Dimension(100, 30));
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbLayout.setConstraints(lblPrice, gbc);
            this.add(lblPrice);
            
            tbPrice = new JTextField(10);
            tbPrice.setInputVerifier(new DoubleInputVerifier(1,10000));
            gbc.gridx = 1;
            gbc.gridy = 2;
            gbLayout.setConstraints(tbPrice, gbc);
            this.add(tbPrice);
            
            lblType = new JLabel("Menu item type:");
            lblType.setPreferredSize(new Dimension(100, 30));
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbLayout.setConstraints(lblType, gbc);
            this.add(lblType);
            
            String[] combodata = {"Main", "Drink", "Alcohol", "Dessert"};
            cbType = new JComboBox(combodata);
            gbc.gridx = 1;
            gbc.gridy = 3;
            gbLayout.setConstraints(cbType, gbc);
            this.add(cbType);
            
            btnOK = new JButton("OK");
            btnOK.addActionListener(this);
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.gridwidth = 2;
            gbLayout.setConstraints(btnOK, gbc);
            this.add(btnOK);
        }
        
        private void setMenuID(String id)
        {
            tbMenuItemID.setText(id);
        }
        
        private void setItemName(String name)
        {
            tbName.setText(name);
        }
        
        private void setPrice(String price)
        {
            tbPrice.setText(price);
        }
        
        private void setType(String type)
        {
            cbType.setSelectedItem(type);
        }
        
        
        public void init(int menuItemID)
        {
            //------------- Add new menu item ------------
            if( menuItemID == 0)    
            {
                setMenuID("");
                tbMenuItemID.setEditable(true);
                setItemName("");
                setPrice("");
                setType("Main");
                isUpdate = false;
                return;
            }
            
            //------------- Update menu item ------------
            
            MenuItem   rMenuItem = rcController.getMenuItemData(menuItemID);
            isUpdate = true;
            
            if( rMenuItem == null)
            {
                showErrorDialog("Error", "Get menu item data failed.");
                setItemName("");
                setPrice("");
                setType("Main");
                return;
            }
            setMenuID(Integer.toString(rMenuItem.getID()));
            setItemName(rMenuItem.getName());
            setPrice(Double.toString(rMenuItem.getPrice()));
            tbPrice.setBackground( UIManager.getColor( "TextField.background" ) ); 
            switch( rMenuItem.getType())
            {
                case MenuItem.MAIN:
                    setType("Main");
                break;
                case MenuItem.DRINK:
                    setType("Drink");
                break;
                case MenuItem.ALCOHOL:
                    setType("Alcohol");
                break;
                case MenuItem.DESSERT:
                    setType("Dessert");
                break;
            }
            tbMenuItemID.setEditable(false);
            tbMenuItemID.setBackground( UIManager.getColor( "TextField.background" ) ); 
        }
        
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnOK)
            {
                //if( !inputVerified) return;
                //Check whether current focuced compornent have to verify their value
                if (btnOK.getVerifyInputWhenFocusTarget()) {
                    //Try to get focus
                    btnOK.requestFocusInWindow();
                    if (!btnOK.hasFocus()) {    //Can not get focus ?Ë the compornent have not been verified
                        return;
                    }
                }  
                
                if( tbMenuItemID.getText().equals("") || tbName.getText().equals("") || tbPrice.getText().equals(""))
                {
                    displayErrorMessage("Fill all form!!");
                    return;
                }

                int menuItemID = Integer.parseInt(tbMenuItemID.getText());
 
                String strMenuType = (String)cbType.getSelectedItem();
                byte    menuType;
                
                if( strMenuType.equals("Main"))
                {
                    menuType = MenuItem.MAIN;
                }
                else if( strMenuType.equals("Drink"))
                {
                    menuType = MenuItem.DRINK;
                }
                else if( strMenuType.equals("Alcohol"))
                {
                    menuType = MenuItem.ALCOHOL;
                }
                else    //Dessert
                {
                    menuType = MenuItem.DESSERT;
                }
                
                if(isUpdate)
                {
                    if(! rcController.updateMenuItem(menuItemID , tbName.getText(), Double.parseDouble(tbPrice.getText()), menuType))
                    {
                        showErrorDialog("Error", rcController.getErrorMessage());
                        return;
                    }
                    showConfirmDialog("Message", "Update successful!!");
                }
                else
                {                   
                    if(! rcController.addNewMenuItem(menuItemID , tbName.getText(), Double.parseDouble(tbPrice.getText()), menuType))
                    {
                        showErrorDialog("Error", rcController.getErrorMessage());
                        return;
                    }
                    showConfirmDialog("Message", "New menu item is added!!");
                }
                init(menuItemID);
            }
        }
    }
    
    /****************************************************************
     * Employee list panel
    *****************************************************************/       
    private class EmployeeListPanel extends JPanel implements ActionListener
    {
        private JScrollPane     scrollPanel;
        private JList           displayList;
        //private JPanel          btnPanel;
        private JButton         btnAddStaff;
        private JButton         btnEditStaff;
        private JButton         btnDeleteStaff;
        private JButton         btnClockOut;
        
        public EmployeeListPanel()
        {
            GridBagLayout gbLayout = new GridBagLayout();
            this.setLayout( gbLayout);
            GridBagConstraints gbc = new GridBagConstraints();

            scrollPanel = new JScrollPane();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.gridwidth = 4;
            gbLayout.setConstraints(scrollPanel, gbc);
            this.add(scrollPanel);
            
            btnAddStaff     = new JButton("Add new staff");
            btnAddStaff.addActionListener(this);
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.weighty = 0;
            gbc.weightx = 0.25;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbLayout.setConstraints(btnAddStaff, gbc);
            this.add(btnAddStaff);
            
            btnEditStaff    = new JButton("Edit staff");
            btnEditStaff.addActionListener(this);
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbLayout.setConstraints(btnEditStaff, gbc);
            this.add(btnEditStaff);
            
            btnDeleteStaff   = new JButton("Delete staff");
            btnDeleteStaff.addActionListener(this);
            gbc.gridx = 2;
            gbc.gridy = 1;
            gbLayout.setConstraints(btnDeleteStaff, gbc);
            this.add(btnDeleteStaff);
            
            btnClockOut  = new JButton("Clock out");
            btnClockOut.addActionListener(this);
            gbc.gridx = 3;
            gbc.gridy = 1;
            gbLayout.setConstraints(btnClockOut, gbc);
            this.add(btnClockOut);
            
            displayList = new JList();
            displayList.setFont(new Font(Font.MONOSPACED,Font.PLAIN,16));
            displayList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
        
        public void init()
        {
            showStaffList();
        }
        
        public void showStaffList()
        {
            displayList.setListData(rcController.createStaffList().toArray());
            scrollPanel.getViewport().setView(displayList);
        }
        
        private int getSelectedStaffID()
        {
            String orderLine = (String)displayList.getSelectedValue();
            if (orderLine == null)
                return -1;
                
            return getIDfromString( orderLine, 4);
        }
        
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnAddStaff)
            {
                cEditEmployeePanel.init(0);
                changeMainPanel("EditEmployee");
            }
            else if (ae.getSource() == btnEditStaff)
            {
                int staffID = getSelectedStaffID();
                if( staffID == -1)    return;
                 cEditEmployeePanel.init(staffID);
                 changeMainPanel("EditEmployee");
            }
            else if (ae.getSource() == btnDeleteStaff)
            {
                int deleteStaffID = getSelectedStaffID();
                if( deleteStaffID == -1)    return;
                
                if( showYesNoDialog("", "Are you sure to delete the staff?") == DIALOG_YES)
                {
                    if(!rcController.deleteStaff(deleteStaffID))
                    {
                        showErrorDialog("Error", rcController.getErrorMessage());
                    }
                    else
                    {
                        displayMessage("Deleted.");
                        init();
                    }
                }
            }
            else if (ae.getSource() == btnClockOut)
            {
                int staffID = getSelectedStaffID();
                if( staffID == -1)    return;
                if(showYesNoDialog("", "Are you sure to make the staff clocked out?") == DIALOG_NO)
                    return;
                if( rcController.clockOut(staffID) == false)
                    showErrorDialog("Error", rcController.getErrorMessage());
                else
                {
                    displayMessage("The staff have been clocked out.");
                    init();
                }
            }
        }
    }
    
    /****************************************************************
     * Edit employee panel
    *****************************************************************/       
    private class EditEmployeePanel extends JPanel implements ActionListener
    {
        private JLabel          lblStaffID;
        private JTextField      tbStaffID;
        private JLabel          lblFirstName;
        private JTextField      tbFirstName;
        private JLabel          lblLastName;
        private JTextField      tbLastName;
        private JLabel          lblPassword;
        private JPasswordField  tbPassword;
        private JButton         btnOK;
        
        private boolean         isUpdate;
        
        public EditEmployeePanel()
        {
            GridBagLayout gbLayout = new GridBagLayout();
            this.setLayout( gbLayout);
            GridBagConstraints gbc = new GridBagConstraints();
            
            lblStaffID = new JLabel("StaffID:");
            lblStaffID.setPreferredSize(new Dimension(100, 30));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            gbLayout.setConstraints(lblStaffID, gbc);
            this.add(lblStaffID);
            
            tbStaffID = new JTextField(4);
            tbStaffID.setInputVerifier(new IntegerInputVerifier(1,10000));
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbLayout.setConstraints(tbStaffID, gbc);
            this.add(tbStaffID);
            
            lblFirstName = new JLabel("FirstName:");
            lblFirstName.setPreferredSize(new Dimension(100, 30));
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbLayout.setConstraints(lblFirstName, gbc);
            this.add(lblFirstName);
            
            tbFirstName = new JTextField(20);
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbLayout.setConstraints(tbFirstName, gbc);
            this.add(tbFirstName);
            
            lblLastName = new JLabel("LastName:");
            lblLastName.setPreferredSize(new Dimension(100, 30));
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbLayout.setConstraints(lblLastName, gbc);
            this.add(lblLastName);
            
            tbLastName = new JTextField(20);
            gbc.gridx = 1;
            gbc.gridy = 2;
            gbLayout.setConstraints(tbLastName, gbc);
            this.add(tbLastName);
            
            lblPassword = new JLabel("Password:");
            lblPassword.setPreferredSize(new Dimension(100, 30));
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbLayout.setConstraints(lblPassword, gbc);
            this.add(lblPassword);
            
            tbPassword = new JPasswordField(20);
            gbc.gridx = 1;
            gbc.gridy = 3;
            gbLayout.setConstraints(tbPassword, gbc);
            this.add(tbPassword);
            
            btnOK = new JButton("OK");
            btnOK.addActionListener(this);
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.gridwidth = 2;
            gbLayout.setConstraints(btnOK, gbc);
            this.add(btnOK);
        }
        
        private void setUserID(int id)
        {
            tbStaffID.setText(Integer.toString(id));
        }
        
        private void setPassword(String password)
        {
            tbPassword.setText(password);
        }
        
        private void setLastName(String lastName)
        {
            tbLastName.setText(lastName);
        }
        
        private void setFirstName(String firstName)
        {
            tbFirstName.setText(firstName);
        }
        
        public void init(int employeeID)
        {
            //------------- Add new staff ------------
            if( employeeID == 0)    
            {
                setUserID(0);
                tbStaffID.setEditable(true);
                setPassword("");
                setLastName("");
                setFirstName("");
                isUpdate = false;
                return;
            }
            
            //------------- Update staff ------------
            
            Staff   rStaff = rcController.getStaffData(employeeID);
            isUpdate = true;
            
            if( rStaff == null)
            {
                showErrorDialog("Error", "Get staff data failed.");
                setLastName("");
                setFirstName("");
                return;
            }
            setUserID(rStaff.getID());
            setPassword(rStaff.getPassword());
            setLastName(rStaff.getLastName());
            setFirstName(rStaff.getFirstName());
            tbStaffID.setEditable(false);
            tbStaffID.setBackground( UIManager.getColor( "TextField.background" ) ); 
        }
        
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnOK)
            {
                //if( !inputVerified) return;
                //Check whether current focuced compornent have to verify their value
                if (btnOK.getVerifyInputWhenFocusTarget()) {
                    //Try to get focus
                    btnOK.requestFocusInWindow();
                    if (!btnOK.hasFocus()) {    //Can not get focus ?Ë the compornent have not been verified
                        return;
                    }
                }  
                
                
                int test = tbPassword.getPassword().length;
                
                if(tbPassword.getPassword().length == 0 || tbFirstName.getText().equals("") || tbLastName.getText().equals(""))
                {
                    displayErrorMessage("Fill all form!!");
                    return;
                }
                
                int staffID = Integer.parseInt(tbStaffID.getText());
                
                if(isUpdate)
                {
                    if(! rcController.updateStaff(staffID , new String(tbPassword.getPassword()), tbFirstName.getText(), tbLastName.getText())) 
                    {
                        showErrorDialog("Error", rcController.getErrorMessage());
                        return;
                    }
                    showConfirmDialog("Message", "Update successful!!");
                }
                else
                {
                    boolean isManager = false;
                    
                    if( showYesNoDialog("", "Add as Manager?") == DIALOG_YES)
                        isManager = true;
                    
                    if(!rcController.addNewStaff(staffID,
                                                new String(tbPassword.getPassword()),
                                                tbFirstName.getText(),
                                                tbLastName.getText(),
                                                isManager))
                    {
                        showErrorDialog("Error", rcController.getErrorMessage());
                        return;
                    }
                    showConfirmDialog("Message", "New staff is added!!");
                    
                }
                init(staffID);
            }
        }
    }
    
    /****************************************************************
     * Order list panel
    *****************************************************************/       
    private class OrderListPanel extends JPanel implements ActionListener
    {
        private JScrollPane     scrollPanel;
        //private JTextArea       displayArea;
        private JPanel          btnPanel;
        private JButton         btnNewOrder;
        private JButton         btnEditOrder;
        private JButton         btnCloseOrder;
        private JButton         btnCancelOrder;
        private JLabel          lblTotalSales;
        private JLabel          lblTotalCount;
        private JLabel          lblCancelTotal;
        private JLabel          lblCancelCount;
        private JList           displayList;
        
        public OrderListPanel()
        {
            GridBagLayout gbLayout = new GridBagLayout();
            this.setLayout( gbLayout);
            GridBagConstraints gbc = new GridBagConstraints();
            /*displayArea = new JTextArea();
            displayArea.setFont(new Font(Font.MONOSPACED,Font.PLAIN,16));
            displayArea.setEditable(false);
            displayArea.setMargin(new Insets(5, 5, 5, 5));*/
            scrollPanel = new JScrollPane();
            scrollPanel.setPreferredSize(new Dimension(500, 300));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 4;
            gbLayout.setConstraints(scrollPanel, gbc);
            this.add(scrollPanel);
            
            lblTotalCount = new JLabel();
            lblTotalCount.setFont(new Font(Font.MONOSPACED,Font.PLAIN,16));
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            gbc.insets = new Insets(10, 10, 10, 10);
            gbLayout.setConstraints(lblTotalCount, gbc);
            this.add(lblTotalCount);
            
            lblTotalSales = new JLabel();
            lblTotalSales.setFont(new Font(Font.MONOSPACED,Font.PLAIN,16));
            gbc.gridx = 2;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            gbLayout.setConstraints(lblTotalSales, gbc);
            this.add(lblTotalSales);
            
            lblCancelCount = new JLabel();
            lblCancelCount.setFont(new Font(Font.MONOSPACED,Font.PLAIN,16));
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbLayout.setConstraints(lblCancelCount, gbc);
            this.add(lblCancelCount);
            
            lblCancelTotal = new JLabel();
            lblCancelTotal.setFont(new Font(Font.MONOSPACED,Font.PLAIN,16));
            gbc.gridx = 2;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbLayout.setConstraints(lblCancelTotal, gbc);
            this.add(lblCancelTotal);
            
            btnNewOrder     = new JButton("New");
            btnNewOrder.addActionListener(this);
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            gbc.weightx = 0.25;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbLayout.setConstraints(btnNewOrder, gbc);
            this.add(btnNewOrder);
            
            btnEditOrder    = new JButton("Edit");
            btnEditOrder.addActionListener(this);
            gbc.gridx = 1;
            gbc.gridy = 3;
            gbLayout.setConstraints(btnEditOrder, gbc);
            this.add(btnEditOrder);
            
            btnCloseOrder   = new JButton("Close");
            btnCloseOrder.addActionListener(this);
            gbc.gridx = 2;
            gbc.gridy = 3;
            gbLayout.setConstraints(btnCloseOrder, gbc);
            this.add(btnCloseOrder);
            
            btnCancelOrder  = new JButton("Cancel");
            btnCancelOrder.addActionListener(this);
            gbc.gridx = 3;
            gbc.gridy = 3;
            gbLayout.setConstraints(btnCancelOrder, gbc);
            this.add(btnCancelOrder);
            
            displayList = new JList();
        }
        
        private void setTotalCount( int count)
        {
            lblTotalCount.setText("Today's order: " + count);
        }
        
        private void setTotalSales( double sales)
        {
            lblTotalSales.setText("Total:$ " + sales);
        }
        
        private void setCancelCount( int count)
        {
            lblCancelCount.setText("Canceled orders: " + count);
        }
        
        private void setCancelTotal( double sales)
        {
            lblCancelTotal.setText("Cancel total:$ " + sales);
        }
        
        private void showOrderList()
        {
            displayList.setListData(rcController.createOrderList().toArray());
            scrollPanel.getViewport().setView(displayList);
            
            setTotalCount(rcController.getTodaysOrderCnt());
            setTotalSales(rcController.getTotalSales());
            setCancelCount(rcController.getTodaysCancelCnt());
            setCancelTotal(rcController.getCancelTotal());
            
        }
        
        public void init()
        {
            showOrderList();
        }
        
        private int getSelectedOrderID()
        {
            String orderLine = (String)displayList.getSelectedValue();
            if (orderLine == null)
                return -1;
                
            return getIDfromString( orderLine, 4);
        }
        
        private String getSelectedOrderStaffName()
        {
            String stringLine = (String)displayList.getSelectedValue();
            if (stringLine == null)
                return null;
                
            int index = stringLine.indexOf("Name:"); //Search string of "ID:"
            if(index == -1)
            {
                showErrorDialog("Error", "String 'Name:' is not found!!");
                return null;
            }
            

            String staffName = stringLine.substring(index + 5, index + 5 + 22);
            return staffName.trim();
        }
        
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnNewOrder)
            {
                //((CardLayout) mainPanel.getLayout()).show( mainPanel, "OrderDetail");
                changeMainPanel("OrderDetail");
                int orderID = rcController.createOrder();
                String staffName = rcController.getCurrentUserName();
                cOrderDetailPanel.init(orderID, staffName);
                //cOrderListPanel.init();
            }
            else if (ae.getSource() == btnEditOrder)
            {
                int orderID = getSelectedOrderID();
                String staffName = getSelectedOrderStaffName();
                if(orderID == -1) return;
                    
                ((CardLayout) mainPanel.getLayout()).show( mainPanel, "OrderDetail");
                //int orderID = cController.createOrder();
                cOrderDetailPanel.init(orderID, staffName);
            }
            else if (ae.getSource() == btnCloseOrder)
            {
                int orderID = getSelectedOrderID();
                if(orderID == -1) return;
                
                if( showYesNoDialog("Close order","Are you sure to close the order?") == DIALOG_YES)
                {
                    if( !rcController.closeOrder(orderID))
                        displayErrorMessage(rcController.getErrorMessage());
                    showOrderList();
                }
            }
            else if (ae.getSource() == btnCancelOrder)
            {
                int orderID = getSelectedOrderID();
                if(orderID == -1) return;
                
                if( showYesNoDialog("Close order","Are you sure to close the order?") == DIALOG_YES)
                {
                    if(!rcController.cancelOrder(orderID))
                        displayErrorMessage(rcController.getErrorMessage());
                    showOrderList();
                }
            }
        }
    }
    
    /****************************************************************
     * Order detail panel
    *****************************************************************/       
    private class OrderDetailPanel extends JPanel implements ActionListener, ListSelectionListener
    {
        //Right
        private JLabel          lblRightTitle;
       
        private JScrollPane     menuScrollPanel;
        private JButton         btnAll;
        private JButton         btnMain;
        private JButton         btnDrink;
        private JButton         btnAlcohol;
        private JButton         btnDessert;
        
        //Left
        private JLabel          lblLeftTitle;
        private JLabel          lblLeftInfo;
        private JScrollPane     orderScrollPanel;
        //private JTextArea       displayArea;
        private JPanel          btnPanel;
        private JButton         btnAddItem;
        private JButton         btnDeleteItem;
        private JLabel          lblQuantity;
        private JTextField      tfQuantity;
        
        private JLabel              lblTotalSales;
        private JLabel              lblOrderState;
        private JLabel              lblStaffName;
        private JList               orderItemList;
        private JList               menuList;
        
        private int             currentOrderID;
        private int             orderItemCnt;
        private int             currentOrderState;
        
        private JPanel          orderDetailPanel;
        private JPanel          menuListPanel;
        
        public OrderDetailPanel()
        {
            this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
            //this.insets = new Insets(5, 5, 5, 5);
            
            orderDetailPanel = new JPanel();
            //orderDetailPanel.setSize(new Dimension(270, 600));
            
            GridBagLayout gbLayout = new GridBagLayout();
            orderDetailPanel.setLayout( gbLayout);
            GridBagConstraints gbc = new GridBagConstraints();
            
            lblLeftTitle = new JLabel("Order detail");
            
            //lblLeftTitle.setMaximumSize(new Dimension(350, 50));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 4;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(5, 5, 5, 5);
            gbLayout.setConstraints(lblLeftTitle, gbc);
            orderDetailPanel.add(lblLeftTitle);
            
            lblLeftInfo = new JLabel("No  Item name                 quantity    price");
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 4;
            gbLayout.setConstraints(lblLeftInfo, gbc);
            orderDetailPanel.add(lblLeftInfo);
            
            orderScrollPanel = new JScrollPane();
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.ipadx = 0;
            gbc.ipady = 0;
            gbc.weighty = 1.0;
            //gbc.fill = GridBagConstraints.VERTICAL;
            gbLayout.setConstraints(orderScrollPanel, gbc);
            orderDetailPanel.add(orderScrollPanel);
            
            lblTotalSales = new JLabel();
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.weighty = 0;
            gbc.gridwidth = 4;
            //gbc.fill = GridBagConstraints.BOTH;
            gbLayout.setConstraints(lblTotalSales, gbc);
            orderDetailPanel.add(lblTotalSales);
            
            lblOrderState = new JLabel();
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbLayout.setConstraints(lblOrderState, gbc);
            orderDetailPanel.add(lblOrderState);
            
            lblStaffName = new JLabel();
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.gridwidth = 4;
            gbLayout.setConstraints(lblStaffName, gbc);
            orderDetailPanel.add(lblStaffName);
            
            lblQuantity = new JLabel("Quantity");
            gbc.ipadx = 20;
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.gridwidth = 2;
            gbLayout.setConstraints(lblQuantity, gbc);
            orderDetailPanel.add(lblQuantity);
            
            tfQuantity = new JTextField();
            tfQuantity.setInputVerifier(new IntegerInputVerifier(1,100));
            tfQuantity.addActionListener(this);
            gbc.gridx = 0;
            gbc.gridy = 7;
            gbLayout.setConstraints(tfQuantity, gbc);
            orderDetailPanel.add(tfQuantity);
            
            btnAddItem  = new JButton("Add");
            btnAddItem.addActionListener(this);
            gbc.gridx = 2;
            gbc.gridy = 6;
            gbc.gridwidth = 1;
            gbc.gridheight = 2;
            gbLayout.setConstraints(btnAddItem, gbc);
            orderDetailPanel.add(btnAddItem);
            
            btnDeleteItem   = new JButton("Delete");
            btnDeleteItem.addActionListener(this);
            gbc.gridx = 3;
            gbc.gridy = 6;
            gbLayout.setConstraints(btnDeleteItem, gbc);
            orderDetailPanel.add(btnDeleteItem);
            
            
            //Right panel            
            menuListPanel = new JPanel();
            
            menuListPanel.setLayout( gbLayout);
            
            lblRightTitle = new JLabel("Menu list");
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.ipadx = 0;
            gbc.gridwidth = 5;
            gbc.gridheight = 1;
            gbc.fill = GridBagConstraints.BOTH;
            gbLayout.setConstraints(lblRightTitle, gbc);
            menuListPanel.add(lblRightTitle);
            
            menuScrollPanel = new JScrollPane();
            //menuScrollPanel.setPreferredSize(new Dimension(270, 300));
            //menuScrollPanel.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
            gbc.gridy = 1;
            gbc.weighty = 1.0;
            
            gbLayout.setConstraints(menuScrollPanel, gbc);
            menuListPanel.add(menuScrollPanel);
            
            btnAll  = new JButton("All");
            btnAll.addActionListener(this);
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            gbc.weighty = 0;
            gbc.fill = GridBagConstraints.BOTH;
            gbLayout.setConstraints(btnAll, gbc);
            menuListPanel.add(btnAll);
            
            btnMain  = new JButton("Main");
            btnMain.addActionListener(this);
            gbc.gridx = 1;
            gbc.gridy = 2;
            gbLayout.setConstraints(btnMain, gbc);
            menuListPanel.add(btnMain);
            
            btnDrink  = new JButton("Drink");
            btnDrink.addActionListener(this);
            gbc.gridx = 2;
            gbc.gridy = 2;
            gbLayout.setConstraints(btnDrink, gbc);
            menuListPanel.add(btnDrink);
            
             btnAlcohol  = new JButton("Alcohol");
             btnAlcohol.addActionListener(this);
            gbc.gridx = 3;
            gbc.gridy = 2;
            gbLayout.setConstraints(btnAlcohol, gbc);
            menuListPanel.add(btnAlcohol);
            
            btnDessert  = new JButton("Dessert");
            btnDessert.addActionListener(this);
            gbc.gridx = 4;
            gbc.gridy = 2;
            gbLayout.setConstraints(btnDessert, gbc);
            menuListPanel.add(btnDessert);
            
            LineBorder border = new LineBorder(Color.BLACK, 1, false);
            menuListPanel.setBorder(border);
            orderDetailPanel.setBorder(border);
            this.add(orderDetailPanel);
            this.add(menuListPanel);
            
            
            //menuListPanel.setMaximumSize(new Dimension(350, 600));
            
            orderItemList   = new JList();
            orderItemList.setFont(new Font(Font.MONOSPACED,Font.PLAIN,10));
            orderItemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            menuList = new JList();
            menuList.addListSelectionListener(this);
            menuList.setFont(new Font(Font.MONOSPACED,Font.PLAIN,10));
            menuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            
       }
        
        public void init(int orderID, String staffName)
        {
            currentOrderID = orderID;
            currentOrderState = rcController.getOrderState(orderID);
            switch(currentOrderState)
            {
                case Order.ORDER_CLOSED:
                    setOrderState("Closed");
                break;
                case Order.ORDER_CANCELED:
                    setOrderState("Canceled");
                break;
                default:
                break;
            }
            
             if(currentOrderState != 0)
            {
                btnAddItem.setEnabled(false);
                btnDeleteItem.setEnabled(false);
            }
            else
            {
                btnAddItem.setEnabled(true);
                btnDeleteItem.setEnabled(true);
            }
            
            refleshOrderDetailList();
            menuList.setListData(rcController.createMenuList(0).toArray());
            menuScrollPanel.getViewport().setView(menuList);
            tfQuantity.setText("");
            tfQuantity.setBackground( UIManager.getColor( "TextField.background" ) );
            setStaffName(staffName);
        }
        
        private void setTotal(double total)
        {
            lblTotalSales.setText("Total charge: $" + total);
        }
        
        private void setOrderState(String state)
        {
            lblOrderState.setText("Order state: " + state);
        }
        
        private void setStaffName(String name)
        {
            lblStaffName.setText("Staff name: " + name);
        }
        
        private void refleshOrderDetailList()
        {
            ArrayList<String> list = rcController.createOrderItemlList(currentOrderID);
            setTotal(rcController.getOrderTotalCharge(currentOrderID));
            orderItemCnt = list.size();
            orderItemList.setListData(list.toArray());
            //createOrderItemlList(currentOrderID, orderItemList);
            orderScrollPanel.getViewport().setView(orderItemList);
        }
        
        private int getOrderDetailIndexFromString(String orderLine)
        {
            try
            {
                String strIndex = orderLine.substring(0, 4);
                int index = Integer.parseInt(strIndex.trim());
                return index;
            }
            catch(Exception e)
            {
                //showErrorDialog("Error", "Parse error");
                return -1;
            }
        }
        
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnAddItem)
            {
                //if(!inputVerified)
                //    return;
                //Check whether current focuced compornent have to verify their value
                if (btnAddItem.getVerifyInputWhenFocusTarget()) {
                    //Try to get focus
                    btnAddItem.requestFocusInWindow();
                    if (!btnAddItem.hasFocus()) {    //Can not get focus ?Ë the compornent have not been verified
                        return;
                    }
                }  
                
                String menuLine = (String)menuList.getSelectedValue();
                if (menuLine == null)
                    return;

                int     id = getIDfromString( menuLine, 4);
                if(id == -1)
                    return;
                if( tfQuantity.getText().equals(""))
                {
                    showErrorDialog("Error", "Enter quantity!!");
                    return;
                }
                byte    quantity = Byte.parseByte(tfQuantity.getText().trim());
                /*if( quantity <= 0 || 100 <= quantity)
                {
                    displayErrorMessage("Quantity must be between 1 and 100");
                    return;
                }*/
                displayMessage("Menu ID = "+ id + " Quantity = " + quantity);
                if( rcController.addNewOrderItem(currentOrderID, id, quantity) == false)
                {
                    displayErrorMessage("addNewOrderItem Error!!\n" + rcController.getErrorMessage());
                }
                refleshOrderDetailList();
                //auto scroll
                orderItemList.ensureIndexIsVisible(orderItemCnt-1);
                
            }
            else if (ae.getSource() == btnDeleteItem)
            {
                String orderLine = (String)orderItemList.getSelectedValue();
                if(orderLine == null)
                    return;
                    
                int     index = getOrderDetailIndexFromString(orderLine);
                if(index == -1)
                    return;
                if( rcController.deleteOrderItem(currentOrderID, index) == false)
                {
                    displayErrorMessage("deleteOrderItem Error!!\n" + rcController.getErrorMessage());
                }
                refleshOrderDetailList();
            }
             else if (ae.getSource() == btnAll)
            {
                menuList.setListData(rcController.createMenuList(0).toArray());
                menuScrollPanel.getViewport().setView(menuList);
            }
             else if (ae.getSource() == btnMain)
            {
                //createParticularMenuList(MenuItem.MAIN, menuList);
                menuList.setListData(rcController.createMenuList(MenuItem.MAIN).toArray());
                menuScrollPanel.getViewport().setView(menuList);
            }
             else if (ae.getSource() == btnDrink)
            {
                //createParticularMenuList(MenuItem.DRINK, menuList);
                menuList.setListData(rcController.createMenuList(MenuItem.DRINK).toArray());
                menuScrollPanel.getViewport().setView(menuList);
            }
             else if (ae.getSource() == btnAlcohol)
            {
                //createParticularMenuList(MenuItem.ALCOHOL, menuList);
                menuList.setListData(rcController.createMenuList(MenuItem.ALCOHOL).toArray());
                menuScrollPanel.getViewport().setView(menuList);
            }
             else if (ae.getSource() == btnDessert)
            {
                //createParticularMenuList(MenuItem.DESSERT, menuList);
                menuList.setListData(rcController.createMenuList(MenuItem.DESSERT).toArray());
                menuScrollPanel.getViewport().setView(menuList);
            }
        }
        
        public void valueChanged( ListSelectionEvent e ) {
            if( e.getValueIsAdjusting() == true ){  //when mouce click happens
                if( e.getSource() == menuList ){
                     tfQuantity.setText("1");
                }
            }
        }
    }
    
    /****************************************************************
     * Total sales panel
    *****************************************************************/   
    private class TotalSalesPanel extends JPanel implements ActionListener
    {
        private JScrollPane     scrollPanel;
        private JList           displayList;
        private JButton         btnPrint;
        private JButton         btnCloseAllOrder;
        private JLabel          lblTotalSales;
        private JLabel          lblTotalCount;
        private JLabel          lblCancelTotal;
        private JLabel          lblCancelCount;
        
        
        public TotalSalesPanel()
        {
            GridBagLayout gbLayout = new GridBagLayout();
            this.setLayout( gbLayout);
            GridBagConstraints gbc = new GridBagConstraints();

            scrollPanel = new JScrollPane();
            //scrollPanel.setPreferredSize(new Dimension(500, 300));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 4;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.fill = GridBagConstraints.BOTH;
            gbLayout.setConstraints(scrollPanel, gbc);
            this.add(scrollPanel);
            
            lblTotalCount = new JLabel();
            lblTotalCount.setFont(new Font(Font.MONOSPACED,Font.PLAIN,16));
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            gbc.weighty = 0;
            gbLayout.setConstraints(lblTotalCount, gbc);
            this.add(lblTotalCount);
            
            lblTotalSales = new JLabel();
            lblTotalSales.setFont(new Font(Font.MONOSPACED,Font.PLAIN,16));
            gbc.gridx = 2;
            gbc.gridy = 1;
            gbLayout.setConstraints(lblTotalSales, gbc);
            this.add(lblTotalSales);
            
            lblCancelCount = new JLabel();
            lblCancelCount.setFont(new Font(Font.MONOSPACED,Font.PLAIN,16));
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbLayout.setConstraints(lblCancelCount, gbc);
            this.add(lblCancelCount);
            
            lblCancelTotal = new JLabel();
            lblCancelTotal.setFont(new Font(Font.MONOSPACED,Font.PLAIN,16));
            gbc.gridx = 2;
            gbc.gridy = 2;
            gbLayout.setConstraints(lblCancelTotal, gbc);
            this.add(lblCancelTotal);
            
            btnPrint    = new JButton("Generate text file");
            btnPrint.addActionListener(this);
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            gbLayout.setConstraints(btnPrint, gbc);
            this.add(btnPrint);
            
            btnCloseAllOrder    = new JButton("Close all order");
            btnCloseAllOrder.addActionListener(this);
            gbc.gridx = 2;
            gbc.gridy = 3;
            gbLayout.setConstraints(btnCloseAllOrder, gbc);
            this.add(btnCloseAllOrder);
            
            displayList = new JList();
        }
        
        private void setTotalCount( int count)
        {
            lblTotalCount.setText("Today's order: " + count);
        }
        
        private void setTotalSales( double sales)
        {
            lblTotalSales.setText("Total:$ " + sales);
        }
        
        private void setCancelCount( int count)
        {
            lblCancelCount.setText("Canceled orders: " + count);
        }
        
        private void setCancelTotal( double sales)
        {
            lblCancelTotal.setText("Cancel total:$ " + sales);
        }
        
        private void showOrderList()
        {
            displayList.setListData(rcController.createOrderList().toArray());
            scrollPanel.getViewport().setView(displayList);
            
            setTotalCount(rcController.getTodaysOrderCnt());
            setTotalSales(rcController.getTotalSales());
            setCancelCount(rcController.getTodaysCancelCnt());
            setCancelTotal(rcController.getCancelTotal());
        }
        
        public void init()
        {
            showOrderList();
        }
        
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnPrint)
            {
                String createFineName = rcController.generateSalesReport();
                if( createFineName == null)
                    displayErrorMessage(rcController.getErrorMessage());
                else
                    displayMessage(createFineName + " have been generated.");
            }
            else if (ae.getSource() == btnCloseAllOrder)
            {
                if (showYesNoDialog("", "Are you sure to close all order?") == DIALOG_YES)
                {
                    rcController.closeAllOrder();
                    init();
                    displayMessage("");
                }
            }
        }
    }
    
    /****************************************************************
     * Payment panel
    *****************************************************************/   
    private class PaymentPanel extends JPanel implements ActionListener
    {
        private JScrollPane     scrollPanel;
        private JTextArea       displayArea;
        private JButton         btnPrint;
        private JButton         btnAllClockOut;
        
        public PaymentPanel()
        {
            GridBagLayout gbLayout = new GridBagLayout();
            this.setLayout( gbLayout);
            GridBagConstraints gbc = new GridBagConstraints();

            displayArea = new JTextArea();
            displayArea.setFont(new Font(Font.MONOSPACED,Font.PLAIN,16));
            displayArea.setEditable(false);
            displayArea.setMargin(new Insets(5, 5, 5, 5));
            scrollPanel = new JScrollPane(displayArea);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.fill = GridBagConstraints.BOTH;
            gbLayout.setConstraints(scrollPanel, gbc);
            this.add(scrollPanel);
            
            btnPrint = new JButton("Create payment report file");
            btnPrint.addActionListener(this);
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.weighty = 0;
            gbLayout.setConstraints(btnPrint, gbc);
            this.add(btnPrint);
            
            btnAllClockOut = new JButton("Clock out for all staff");
            btnAllClockOut.addActionListener(this);
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.weighty = 0;
            gbLayout.setConstraints(btnAllClockOut, gbc);
            this.add(btnAllClockOut);
        }
        

        
        public void init()
        {
            displayArea.setText(rcController.createPaymentList());
        }
        
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnPrint)
            {
                String createFineName = rcController.generatePaymentReport();
                if( createFineName == null)
                    displayErrorMessage(rcController.getErrorMessage());
                else
                    displayMessage(createFineName + " have been generated.");
            }
            else if (ae.getSource() == btnAllClockOut)
            {
                if (showYesNoDialog("", "Are you sure to meke all staff clocked out?") == DIALOG_YES)
                {
                    rcController.clockOutAll();
                    init();
                }
            }
        }
    }
    /****************************************************************
     * Input validation
    *****************************************************************/
    
    private class IntegerInputVerifier extends InputVerifier{
        private int state = 0;  //0:no range check 1:min check 2:min and max check
        private int MAX = 0;
        private int MIN = 0;
        
        public IntegerInputVerifier()
        {
            super();
        }
        
        public IntegerInputVerifier(int min)
        {
            super();
            MIN = min;
            state = 1;
        }
        
        public IntegerInputVerifier(int min, int max)
        {
            super();
            MIN = min;
            MAX = max;
            state = 2;
        }
        
        @Override public boolean verify(JComponent c)
        {
            JTextField textField = (JTextField)c;
            boolean result = false;
            
            try
            {
                int number = Integer.parseInt(textField.getText());
                
                switch(state)
                {
                    case 0:
                        result = true;
                    case 1:
                        if( number < MIN)
                        {
                            //UIManager.getLookAndFeel().provideErrorFeedback(c);
                            displayErrorMessage("Minimum input is " + MIN);
                            textField.setBackground( Color.red );
                            result = false;
                        }
                        else
                        {
                            textField.setBackground( UIManager.getColor( "TextField.background" ) );  
                            result = true;
                        }
                    break;
                    case 2:
                        if( number < MIN)
                        {
                            displayErrorMessage("Minimum input is " + MIN);
                            textField.setBackground( Color.red );
                            result = false;
                        }
                        else
                        {
                            if(number > MAX)
                            {
                                displayErrorMessage("Maximum input is " + MAX);
                                textField.setBackground( Color.red );
                                result = false;
                            }
                            else
                            {
                                textField.setBackground( UIManager.getColor( "TextField.background" ) );  
                                result = true;
                            }
                        }
                    break;
                }
            }catch(NumberFormatException e) {
                  displayErrorMessage("Only number is allowed.");
                  textField.setBackground( Color.red );
                result = false;
            }
            return result;
        }
    }
    
    private class DoubleInputVerifier extends InputVerifier{
        private int state = 0;  //0:no range check 1:min check 2:min and max check
        private double MAX = 0;
        private double MIN = 0;
        
        public DoubleInputVerifier()
        {
            super();
        }
        
        public DoubleInputVerifier(double min)
        {
            super();
            MIN = min;
            state = 1;
        }
        
        public DoubleInputVerifier(double min, double max)
        {
            super();
            MIN = min;
            MAX = max;
            state = 2;
        }
        
        @Override public boolean verify(JComponent c)
        {
            JTextField textField = (JTextField)c;
            boolean result = false;
            
            try
            {
                double number = Double.parseDouble(textField.getText());
                
                switch(state)
                {
                    case 0:
                        result = true;
                    case 1:
                        if( number < MIN)
                        {
                            //UIManager.getLookAndFeel().provideErrorFeedback(c);
                            displayErrorMessage("Minimum input is " + MIN);
                            textField.setBackground( Color.red );
                            result = false;
                        }
                        else
                        {
                            textField.setBackground( UIManager.getColor( "TextField.background" ) );  
                            result = true;
                        }
                    break;
                    case 2:
                        if( number < MIN)
                        {
                            displayErrorMessage("Minimum input is " + MIN);
                            textField.setBackground( Color.red );
                            result = false;
                        }
                        else
                        {
                            if(number > MAX)
                            {
                                displayErrorMessage("Maximum input is " + MAX);
                                textField.setBackground( Color.red );
                                result = false;
                            }
                            else
                            {
                                textField.setBackground( UIManager.getColor( "TextField.background" ) );  
                                result = true;
                            }
                        }
                    break;
                }
            }catch(NumberFormatException e) {
                  displayErrorMessage("Only number is allowed.");
                  textField.setBackground( Color.red );
                result = false;
            }
            return result;
        }
    }
}
