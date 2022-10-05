package Reservationform;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Reservation {

	private JFrame frame;
	private JTextField textField;//To display tax
	private JTextField textField_1;//To display subtotal
	private JTextField textField_2;//To display total
	private JTextField textClass;//To display class
	private JTextField textTicket;//To display ticket
	private JTextField textAdult;//To display no. of adults
	private JTextField textChild;//To display no. of children
	private JTextField textFrom;//To display the starting station
	private JTextField textTo;//To display the destination station
	private JTextField textTime;//To display time
	private JTextField textTicketno;//To display ticket no.
	private JTextField textPrice;//To display ticket price
	private JTextField textDate;//To display date

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {//Reservation window opens
				try {
					Reservation window = new Reservation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reservation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.setBounds(0, 0, 1370, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setForeground(new Color(240, 240, 240));
		panel.setFont(null);
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(279, 47, 651, 77);
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Railway Reservation System");//Heading
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(lblNewLabel);//added as label
		
		JLabel lblNewLabel_1 = new JLabel("Ticket Class");//Ticket class Station
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(218, 190, 118, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnSleeper = new JRadioButton("Sleeper");//Ticket class type
		rdbtnSleeper.setBounds(137, 229, 111, 23);
		frame.getContentPane().add(rdbtnSleeper);
		
		JRadioButton rdbtnGeneral = new JRadioButton("General");//Ticket class type
		rdbtnGeneral.setBounds(137, 255, 111, 23);
		frame.getContentPane().add(rdbtnGeneral);
		
		JRadioButton rdbtnFirstAC = new JRadioButton("First Class AC");//Ticket class type
		rdbtnFirstAC.setBounds(137, 281, 111, 23);
		frame.getContentPane().add(rdbtnFirstAC);
		
		JRadioButton rdbtnSecondAC = new JRadioButton("Second Class AC");//Ticket class type
		rdbtnSecondAC.setBounds(137, 307, 111, 23);
		frame.getContentPane().add(rdbtnSecondAC);
		
		JRadioButton rdbtnThirdAC = new JRadioButton("Third Class AC");//Ticket class type
		rdbtnThirdAC.setBounds(137, 333, 111, 23);
		frame.getContentPane().add(rdbtnThirdAC);
		
		JRadioButton rdbtnSingle = new JRadioButton("Single");//Select if only you want to go 
		rdbtnSingle.setBounds(244, 229, 111, 23);
		frame.getContentPane().add(rdbtnSingle);
		
		JRadioButton rdbtnRound = new JRadioButton("Round Trip");//Select if only you want to go and come back
		rdbtnRound.setBounds(244, 260, 111, 23);
		frame.getContentPane().add(rdbtnRound);
		
		JRadioButton rdbtnAdult = new JRadioButton("Adult");//Adult 
		rdbtnAdult.setBounds(357, 229, 111, 23);
		frame.getContentPane().add(rdbtnAdult);
		
		JRadioButton rdbtnChild = new JRadioButton("Child");//Child
		rdbtnChild.setBounds(357, 260, 111, 23);
		frame.getContentPane().add(rdbtnChild);
		
		JComboBox Destination = new JComboBox();//Drop down to select your destination station
		Destination.setModel(new DefaultComboBoxModel(new String[] {"Destination", "Banaswadi(BAND)", "Kengeri(KGI)", "Yelahanka Jn(YNK)", "Whitefield(WFD)"}));
		Destination.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Destination.setBounds(254, 319, 161, 23);
		frame.getContentPane().add(Destination);
		
		JSeparator separator = new JSeparator();//Separators to create different sections in form
		separator.setBounds(256, 47, 692, 23);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();//Separators to create different sections in form
		separator_1.setBounds(254, 122, 692, 23);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();//Separators to create different sections in form
		separator_2.setBounds(132, 174, 116, -4);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();//Separators to create different sections in form
		separator_3.setBounds(137, 168, 1, 2);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();//Separators to create different sections in form
		separator_4.setBounds(137, 168, 73, -5);
		frame.getContentPane().add(separator_4);
		
		JSeparator separator_5 = new JSeparator();//Separators to create different sections in form
		separator_5.setBounds(314, 156, 1, 2);
		frame.getContentPane().add(separator_5);
		
		JSeparator separator_6 = new JSeparator();//Separators to create different sections in form
		separator_6.setBounds(464, 190, 1, 2);
		frame.getContentPane().add(separator_6);
		
		JSeparator separator_7 = new JSeparator();//Separators to create different sections in form
		separator_7.setBounds(103, 190, 1, 2);
		frame.getContentPane().add(separator_7);
		
		JSeparator separator_8 = new JSeparator();//Separators to create different sections in form
		separator_8.setBounds(127, 215, 298, 29);
		frame.getContentPane().add(separator_8);
		
		JSeparator separator_8_1 = new JSeparator();
		separator_8_1.setBounds(127, 363, 298, 29);//Separators to create different sections in form
		frame.getContentPane().add(separator_8_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tax");//Tax as label
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(914, 387, 49, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sub-total");//Sub-total as label
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(914, 426, 61, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Total");//TOtal as label
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(914, 475, 49, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();To display tax
		textField.setBounds(1010, 386, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(1010, 425, 96, 20);To display subtotal
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();To display total
		textField_2.setBounds(1010, 474, 96, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JSeparator separator_9 = new JSeparator();//Separators to create different sections in form
		separator_9.setBounds(860, 363, 313, 2);
		frame.getContentPane().add(separator_9);
		
		JSeparator separator_9_1 = new JSeparator();//Separators to create different sections in form
		separator_9_1.setBounds(860, 519, 313, 2);
		frame.getContentPane().add(separator_9_1);
		
		JButton btnNewButton = new JButton("Total");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//Calculating fares as per the options chosen
				
				double tax=25.50;
				double band=50.78;
				double keng=100.23;
				double ynk=150.97;
				double wfd=200.98;
				double tc=0.0, gen=15, sl= 20, ac3=40, ac2=50, ac1=60;
				String clss="";
				String tick="";
				String ad="ONE", ch="NIL";
				//Calculating cost of destination
				
					if(Destination.getSelectedItem().equals("Banaswadi(BAND)"))
					{
						tc=tc+band;
					}
					else if(Destination.getSelectedItem().equals("Kengeri(KGI)")){
						tc=tc+keng;
					}
					else if(Destination.getSelectedItem().equals("Yelahanka(YNK)")) {
						tc=tc+ynk;
					}
					else {
						tc=tc+wfd;
					}
		//Calculating cost of Class 
					
					if(rdbtnSleeper.isSelected())
					{
						tc=tc+sl;
						clss=clss+"Sleeper";
					}
					else if(rdbtnGeneral.isSelected())
					{
						tc=tc+gen;
						clss=clss+"General";
					}
					else if(rdbtnThirdAC.isSelected())
					{
						tc=tc+ac3;
						clss=clss+"Third AC";
					}
					else if(rdbtnSecondAC.isSelected())
					{
						tc=tc+ac2;
						clss=clss+"Second AC";
					}
					else 
					{
						tc=tc+ac1;
						clss=clss+"Third AC";
					}
					
          //Calculating for round trip
					if(rdbtnRound.isSelected())
					{
						tc=2*tc;
						tick=tick+"ROUND TRIP";
					}
					else {
						tick=tick+"ONE WAY";
					}
					if(rdbtnChild.isSelected())
						{
							tc=tc/2;
							ad="NIL";
							ch="ONE";
						}
					double sub=tc;
					tc=tc+tax;
					String sTax=String.format("%.2f", tax);
					textField.setText(sTax);
					String subt=String.format("%.2f", sub);
					textField_1.setText(subt);
					String stc=String.format("%.2f", tc);
					textField_2.setText(stc);
					textPrice.setText(stc);
					textClass.setText(clss);
					textTicket.setText(tick);
				    textAdult.setText(ad);
				    textChild.setText(ch);
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar timer = Calendar.getInstance();
				timer.getTime();
				SimpleDateFormat tTime = new SimpleDateFormat("hh:mm:ss");
				textTime.setText(tTime.format(timer.getTime()));//Generating time
				
				SimpleDateFormat Tdate = new SimpleDateFormat("dd-MM-yyyy");
				textDate.setText(Tdate.format(timer.getTime()));//Generating date
				
				textFrom.setText("Bangalore City Jn Station(SBC");
				textTo.setText((String) Destination.getSelectedItem()+ " *");
				
				int n;
				String q="";
				n=1325+(int)(Math.random()*4238);
				q+=n+1325;
				textTicketno.setText(q);//Generating ticket number
				
				
		
				
			}
		});
		btnNewButton.setToolTipText("Total Cost of Ticket");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(860, 546, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setToolTipText("Reset System");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//On clicking reset
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				rdbtnGeneral.setSelected(false);
				rdbtnSleeper.setSelected(false);
				rdbtnFirstAC.setSelected(false);
				rdbtnSecondAC.setSelected(false);
				rdbtnThirdAC.setSelected(false);
				rdbtnSingle.setSelected(false);
				rdbtnRound.setSelected(false);
				rdbtnAdult.setSelected(false);
				rdbtnChild.setSelected(false);
				Destination.setSelectedItem("Destination");
				textFrom.setText(null);
				textTo.setText(null);
				textTime.setText(null);
				textTicketno.setText(null);
				textPrice.setText(null);
				textClass.setText(null);
				textTicket.setText(null);
				textAdult.setText(null);
				textChild.setText(null);
				textDate.setText(null);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(970, 546, 101, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setToolTipText("Exit System");//On clicking exit
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Reservationform", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(1084, 546, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JSeparator separator_10 = new JSeparator();//Separators to create different sections in form
		separator_10.setOrientation(SwingConstants.VERTICAL);
		separator_10.setBounds(474, 457, 31, -232);
		frame.getContentPane().add(separator_10);
		
		JLabel lblNewLabel_5 = new JLabel("Class");//Labels
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(475, 190, 49, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Ticket");//Labels
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(560, 190, 49, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Adult");//Labels
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(667, 190, 49, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Child");//Labels
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(752, 190, 49, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setBounds(441, 215, 381, 2);
		frame.getContentPane().add(separator_11);
		
		textClass = new JTextField();
		textClass.setBounds(464, 223, 73, 34);
		frame.getContentPane().add(textClass);
		textClass.setColumns(10);
		
		textTicket = new JTextField();
		textTicket.setColumns(10);
		textTicket.setBounds(560, 223, 73, 34);
		frame.getContentPane().add(textTicket);
		
		textAdult = new JTextField();
		textAdult.setColumns(10);
		textAdult.setBounds(653, 223, 73, 34);
		frame.getContentPane().add(textAdult);
		
		textChild = new JTextField();
		textChild.setColumns(10);
		textChild.setBounds(736, 223, 73, 34);
		frame.getContentPane().add(textChild);
		
		JSeparator separator_12 = new JSeparator();//Separators to create different sections in form
		separator_12.setOrientation(SwingConstants.VERTICAL);
		separator_12.setBounds(432, 215, 24, 437);
		frame.getContentPane().add(separator_12);
		
		JSeparator separator_12_1 = new JSeparator();//Separators to create different sections in form
		separator_12_1.setOrientation(SwingConstants.VERTICAL);
		separator_12_1.setBounds(843, 215, 73, 437);
		frame.getContentPane().add(separator_12_1);
		
		JLabel lblNewLabel_9 = new JLabel("From");//Labels
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9.setBounds(464, 351, 49, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("To");//Labels
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_10.setBounds(464, 389, 49, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		textFrom = new JTextField();
		textFrom.setBounds(620, 350, 220, 20);
		frame.getContentPane().add(textFrom);
		textFrom.setColumns(10);
		
		textTo = new JTextField();
		textTo.setBounds(620, 386, 220, 20);
		frame.getContentPane().add(textTo);
		textTo.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Time");//Labels
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_11.setBounds(464, 431, 49, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Ticket No.");//Labels
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_12.setBounds(464, 475, 81, 14);
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Price");//Labels
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_13.setBounds(464, 519, 49, 14);
		frame.getContentPane().add(lblNewLabel_13);
		
		textTime = new JTextField();
		textTime.setColumns(10);
		textTime.setBounds(620, 425, 220, 20);
		frame.getContentPane().add(textTime);
		
		textTicketno = new JTextField();
		textTicketno.setColumns(10);
		textTicketno.setBounds(620, 474, 220, 20);
		frame.getContentPane().add(textTicketno);
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(620, 519, 220, 20);
		frame.getContentPane().add(textPrice);
		
		JLabel lblNewLabel_14 = new JLabel("Date of Journey");//Labels
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_14.setBounds(464, 311, 145, 14);
		frame.getContentPane().add(lblNewLabel_14);
		
		textDate = new JTextField();
		textDate.setColumns(10);
		textDate.setBounds(620, 308, 220, 20);
		frame.getContentPane().add(textDate);
	}
}
