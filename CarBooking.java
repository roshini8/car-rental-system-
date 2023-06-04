import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.SystemColor;

public class CarBooking extends JFrame {

	private JPanel contentPane;
	private JTextField IDTextField;
	private JTextField PlateNoTextField;
	private JTextField ModelTextField;
	private JTextField CapacityTextField;
	private JTextField PriceTextField;
	private JLabel PlateNoLabel;
	private JLabel CapacityLabel;
	private JLabel ModelLabel;
	private JLabel PriceLabel;
	private JTextField UsernameTextField;
	private JLabel UsernameLabel;
	private JTextField DurationTextField;
	private JLabel DurationLabel;
	private JTextField TotalPriceTextField;
	private JLabel TotalPriceLabel;
	private JButton ConfirmButton;
	private JButton PreviousPageButton;
	private JButton HomeButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarBooking frame = new CarBooking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void id_update(String id) {
		
		IDTextField.setText(id);
	}
	
	public void plateno_update(String plateno) {
		
		PlateNoTextField.setText(plateno);
	}

	public void model_update(String model) {
	
		ModelTextField.setText(model);
	}

	public void capacity_update(String capacity) {
	
		CapacityTextField.setText(capacity);
	}

	public void price_update(String price) {
	
		PriceTextField.setText(price);
	}
	public void username_update(String username) {
		
		UsernameTextField.setText(username);
	}
	

	/**
	 * Create the frame.
	 */
	public CarBooking() {
		setTitle("Car Booking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Booking = new JPanel();
		Booking.setBackground(SystemColor.activeCaption);
		Booking.setBounds(0, 0, 672, 391);
		contentPane.add(Booking);
		Booking.setLayout(null);
		
		JLabel IDLabel = new JLabel("Car ID:");
		IDLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		IDLabel.setBounds(27, 42, 69, 28);
		Booking.add(IDLabel);
		
		IDTextField = new JTextField();
		IDTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		IDTextField.setEditable(false);
		IDTextField.setBounds(90, 42, 96, 27);
		Booking.add(IDTextField);
		IDTextField.setColumns(10);
		
		PlateNoTextField = new JTextField();
		PlateNoTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		PlateNoTextField.setEditable(false);
		PlateNoTextField.setColumns(10);
		PlateNoTextField.setBounds(316, 40, 96, 27);
		Booking.add(PlateNoTextField);
		
		ModelTextField = new JTextField();
		ModelTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ModelTextField.setEditable(false);
		ModelTextField.setColumns(10);
		ModelTextField.setBounds(90, 97, 288, 27);
		Booking.add(ModelTextField);
		
		CapacityTextField = new JTextField();
		CapacityTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CapacityTextField.setEditable(false);
		CapacityTextField.setColumns(10);
		CapacityTextField.setBounds(530, 40, 96, 27);
		Booking.add(CapacityTextField);
		
		PriceTextField = new JTextField();
		PriceTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		PriceTextField.setEditable(false);
		PriceTextField.setColumns(10);
		PriceTextField.setBounds(458, 97, 139, 27);
		Booking.add(PriceTextField);
		
		PlateNoLabel = new JLabel("Plate No:");
		PlateNoLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		PlateNoLabel.setBounds(225, 42, 87, 28);
		Booking.add(PlateNoLabel);
		
		CapacityLabel = new JLabel("Capacity:");
		CapacityLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		CapacityLabel.setBounds(447, 42, 81, 28);
		Booking.add(CapacityLabel);
		
		ModelLabel = new JLabel("Model:");
		ModelLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		ModelLabel.setBounds(27, 97, 69, 28);
		Booking.add(ModelLabel);
		
		PriceLabel = new JLabel("Price:");
		PriceLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		PriceLabel.setBounds(407, 97, 56, 28);
		Booking.add(PriceLabel);
		
		UsernameTextField = new JTextField();
		UsernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		UsernameTextField.setEditable(false);
		UsernameTextField.setColumns(10);
		UsernameTextField.setBounds(137, 147, 288, 27);
		Booking.add(UsernameTextField);
		
		UsernameLabel = new JLabel("Username:");
		UsernameLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		UsernameLabel.setBounds(27, 147, 115, 28);
		Booking.add(UsernameLabel);
		
		DurationTextField = new JTextField();
		DurationTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		DurationTextField.setColumns(10);
		DurationTextField.setBounds(176, 199, 96, 27);
		Booking.add(DurationTextField);
		
		DurationLabel = new JLabel("Duration (Hour):");
		DurationLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		DurationLabel.setBounds(27, 198, 143, 28);
		Booking.add(DurationLabel);
		
		TotalPriceTextField = new JTextField();
		TotalPriceTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		TotalPriceTextField.setEditable(false);
		TotalPriceTextField.setColumns(10);
		TotalPriceTextField.setBounds(176, 248, 139, 27);
		Booking.add(TotalPriceTextField);
		
		TotalPriceLabel = new JLabel("Total Price (RM):");
		TotalPriceLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		TotalPriceLabel.setBounds(27, 247, 154, 28);
		Booking.add(TotalPriceLabel);
		
		JButton CalculateButton = new JButton("Calculate");
		CalculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PriceTextField.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(CalculateButton, "The price is empty.\nPlease ensure that you select a car in previous page.");
				}
				try
				{
					int x = Integer.parseInt(DurationTextField.getText());
					int total;
					if(Objects.equals(PriceTextField.getText(), "RM10PerHour") == true) {
						total = x * 10;
						String totalprice = Integer.toString(total);
						TotalPriceTextField.setText(totalprice);
					}
					else if(Objects.equals(PriceTextField.getText(), "RM20PerHour") == true) {
						total = x * 20;
						String totalprice = Integer.toString(total);
						TotalPriceTextField.setText(totalprice);
					}
					else if(Objects.equals(PriceTextField.getText(), "RM30PerHour") == true) {
						total = x * 30;
						String totalprice = Integer.toString(total);
						TotalPriceTextField.setText(totalprice);
					}
					
				}
				catch (NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(CalculateButton, "This is an invalid input. Please key in an integer.");
				}
				
			}
		});
		CalculateButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		CalculateButton.setBounds(293, 203, 132, 22);
		Booking.add(CalculateButton);
		
		ConfirmButton = new JButton("Confirm");
		ConfirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if(TotalPriceTextField.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(ConfirmButton, "You did not calculate the price. Please calculate the price.");
				 }
				else if(DurationTextField.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(ConfirmButton, "You do not have duration. Please key in the duration (hour).");
				}
				else if (Integer.parseInt(DurationTextField.getText()) <= 0){
					 JOptionPane.showMessageDialog(ConfirmButton, "The duration must be at least 1 hour.");
		        }
				else {
				int x = Integer.parseInt(TotalPriceTextField.getText());
				int y = Integer.parseInt(DurationTextField.getText());
				
				if(Objects.equals(PriceTextField.getText(), "RM10PerHour") == true) {
				
			    if(y == x/10) {
			    	CarRentalJDBC db = new CarRentalJDBC();
					 try
					 {
						 Connection conn = db.getConnection();
						 String sqlStatement = "INSERT INTO carbooking (Car_ID,PlateNo,Model,Capacity,Price,user_name,Duration,Total_Price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
						 PreparedStatement stmt = conn.prepareStatement(sqlStatement);
						
						 String carid = IDTextField.getText();
		                 String plateno = PlateNoTextField.getText();
		                 String model = ModelTextField.getText();
		                 int capacity = Integer.parseInt(CapacityTextField.getText());
		                 String price = PriceTextField.getText();
		                 String username = UsernameTextField.getText();
		                 int duration = Integer.parseInt(DurationTextField.getText());
		                 int totalprice = Integer.parseInt(TotalPriceTextField.getText());

						 stmt.setString (1, carid);
						 stmt.setString (2, plateno);
						 stmt.setString (3, model);
						 stmt.setInt (4, capacity);
						 stmt.setString (5, price);
						 stmt.setString (6, username);
						 stmt.setInt (7, duration);
						 stmt.setInt (8, totalprice);
						 
						 stmt.execute();
						 
						 conn.close();
						 
						 JOptionPane.showMessageDialog(ConfirmButton, "The booking is recorded.");
						 
						 PrintWriter outFile = null;
					        try {
					      
					            outFile = new PrintWriter(new FileOutputStream(new File("Booking_Inventory.txt"), true));
					            outFile.println(IDTextField.getText() + " " + PlateNoTextField.getText() + " " + ModelTextField.getText() + " " 
					                    + UsernameTextField.getText() + " " + DurationTextField.getText() + " " + TotalPriceTextField.getText());
					            outFile.close();
					            
					        } catch (FileNotFoundException fnfe) {
					           
					        	throw new RuntimeException(fnfe);
					        }
					        
					        String userName = UsernameTextField.getText();
							dispose();
			                UserHome userhome = new UserHome(userName);
			                userhome.username_update(userName);
			                userhome.setVisible(true);
					        
					 }
					 catch (Exception ae) {
					 
						 ae.printStackTrace();
					 }
					
				}
			    else {
			    	JOptionPane.showMessageDialog(ConfirmButton, "The duration or total price is wrong. Please check again.");
			    }
				}
				else if(Objects.equals(PriceTextField.getText(), "RM20PerHour") == true) {
			        if (y == x/20) {
			    	CarRentalJDBC db = new CarRentalJDBC();
					 try
					 {
						 Connection conn = db.getConnection();
						 String sqlStatement = "INSERT INTO carbooking (Car_ID,PlateNo,Model,Capacity,Price,user_name,Duration,Total_Price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
						 PreparedStatement stmt = conn.prepareStatement(sqlStatement);
						
						 String carid = IDTextField.getText();
		                 String plateno = PlateNoTextField.getText();
		                 String model = ModelTextField.getText();
		                 int capacity = Integer.parseInt(CapacityTextField.getText());
		                 String price = PriceTextField.getText();
		                 String username = UsernameTextField.getText();
		                 int duration = Integer.parseInt(DurationTextField.getText());
		                 int totalprice = Integer.parseInt(TotalPriceTextField.getText());

						 stmt.setString (1, carid);
						 stmt.setString (2, plateno);
						 stmt.setString (3, model);
						 stmt.setInt (4, capacity);
						 stmt.setString (5, price);
						 stmt.setString (6, username);
						 stmt.setInt (7, duration);
						 stmt.setInt (8, totalprice);
						 
						 stmt.execute();
						 
						 conn.close();
						 
						 JOptionPane.showMessageDialog(ConfirmButton, "The booking is recorded.");
						 
						 PrintWriter outFile = null;
					        try {
					      
					            outFile = new PrintWriter(new FileOutputStream(new File("Booking_Inventory.txt"), true));
					            outFile.println(IDTextField.getText() + " " + PlateNoTextField.getText() + " " + ModelTextField.getText() + " " 
					                    + UsernameTextField.getText() + " " + DurationTextField.getText() + " " + TotalPriceTextField.getText());
					            outFile.close();
					            
					        } catch (FileNotFoundException fnfe) {
					           
					        	throw new RuntimeException(fnfe);
					        }
					        
					        String userName = UsernameTextField.getText();
							dispose();
			                UserHome userhome = new UserHome(userName);
			                userhome.username_update(userName);
			                userhome.setVisible(true);
					        
					 }
					 catch (Exception ae) {
					 
						 ae.printStackTrace();
					 }
				}
			    else {
			    	JOptionPane.showMessageDialog(ConfirmButton, "The duration or total price is wrong. Please check again.");
			    }
				}
				else if(Objects.equals(PriceTextField.getText(), "RM30PerHour") == true) {
				    if(y == x/30) {
					CarRentalJDBC db = new CarRentalJDBC();
					 try
					 {
						 Connection conn = db.getConnection();
						 String sqlStatement = "INSERT INTO carbooking (Car_ID,PlateNo,Model,Capacity,Price,user_name,Duration,Total_Price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
						 PreparedStatement stmt = conn.prepareStatement(sqlStatement);
						
						 String carid = IDTextField.getText();
		                 String plateno = PlateNoTextField.getText();
		                 String model = ModelTextField.getText();
		                 int capacity = Integer.parseInt(CapacityTextField.getText());
		                 String price = PriceTextField.getText();
		                 String username = UsernameTextField.getText();
		                 int duration = Integer.parseInt(DurationTextField.getText());
		                 int totalprice = Integer.parseInt(TotalPriceTextField.getText());

						 stmt.setString (1, carid);
						 stmt.setString (2, plateno);
						 stmt.setString (3, model);
						 stmt.setInt (4, capacity);
						 stmt.setString (5, price);
						 stmt.setString (6, username);
						 stmt.setInt (7, duration);
						 stmt.setInt (8, totalprice);
						 
						 stmt.execute();
						 
						 conn.close();
						 
						 JOptionPane.showMessageDialog(ConfirmButton, "The booking is recorded.");
						 
						 PrintWriter outFile = null;
					        try {
					      
					            outFile = new PrintWriter(new FileOutputStream(new File("Booking_Inventory.txt"), true));
					            outFile.println(IDTextField.getText() + " " + PlateNoTextField.getText() + " " + ModelTextField.getText() + " " 
					                    + UsernameTextField.getText() + " " + DurationTextField.getText() + " " + TotalPriceTextField.getText());
					            outFile.close();
					            
					        } catch (FileNotFoundException fnfe) {
					           
					        	throw new RuntimeException(fnfe);
					        }
					        
					        String userName = UsernameTextField.getText();
							dispose();
			                UserHome userhome = new UserHome(userName);
			                userhome.username_update(userName);
			                userhome.setVisible(true);
					        
					 }
					 catch (Exception ae) {
					 
						 ae.printStackTrace();
					 }
				}
				else {
					JOptionPane.showMessageDialog(ConfirmButton, "The duration or total price is wrong. Please check again.");
					 
				 }
			}
			}
			}
		});
		ConfirmButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
		ConfirmButton.setBounds(90, 315, 119, 31);
		Booking.add(ConfirmButton);
		
		PreviousPageButton = new JButton("Previous Page");
		PreviousPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int confirm = JOptionPane.showConfirmDialog(PreviousPageButton, "Back to previous page?\nAll information at here will be deleted.", "Confirm Dialog", JOptionPane.YES_NO_OPTION);
				if(confirm == JOptionPane.YES_OPTION) {
					
					String userName = UsernameTextField.getText();
					SelectCarType selectcartype = new SelectCarType();
					
	        		 selectcartype.eusername_update(userName);
	        		 selectcartype.pusername_update(userName);
	        		 selectcartype.lusername_update(userName);

					dispose();
					selectcartype.setVisible(true);
				}
				
			}
		});
		PreviousPageButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
		PreviousPageButton.setBounds(258, 315, 183, 31);
		Booking.add(PreviousPageButton);
		
		HomeButton = new JButton("Home");
		HomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int confirm = JOptionPane.showConfirmDialog(PreviousPageButton, "Back to home?\nAll information at here will be deleted.", "Confirm Dialog", JOptionPane.YES_NO_OPTION);
				if(confirm == JOptionPane.YES_OPTION) {
				String userName = UsernameTextField.getText();
				dispose();
                UserHome userhome = new UserHome(userName);
                userhome.username_update(userName);
                userhome.setVisible(true);
			}
			}
		});
		HomeButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
		HomeButton.setBounds(491, 315, 115, 31);
		Booking.add(HomeButton);
	}
}
