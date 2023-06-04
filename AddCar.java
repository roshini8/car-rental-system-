import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;



public class AddCar extends JFrame {

	CarRentalJDBC db = new CarRentalJDBC();
	
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    private JLabel CarTypeLabel;
    private JComboBox CarTypeCombobox;
    private JTextField PlateNoTextField;
    private JLabel CapacityLabel;

    private JTextField ModelTextField;
    private JTextField CapacityTextField;
    private JLabel PriceLabel;
    private JTextField PriceTextField;
    private JButton AddCarButton;
    private String[] choices = {"Economic Car","Premium Car","Luxury Car"};
    private JTextField CarIDTextField;
    private JTable CarInfoTable;
    private JScrollPane CarInfoScrollPane;
    private JLabel lblPleaseStrictlyFollow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCar frame = new AddCar();
					frame.getContentPane().setBackground(Color.PINK);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	  public AddCar() {

	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(450, 190, 1014, 700);

	        setResizable(true);
	        setTitle("Car Registration Form");
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	        
	        JPanel AddCarPanel = new JPanel();
	        AddCarPanel.setBackground(Color.PINK);
	        AddCarPanel.setBounds(0, 0, 1000, 663);
	        contentPane.add(AddCarPanel);
	        AddCarPanel.setLayout(null);
	        
	        	        
	        JLabel CarRegistrationLabel = new JLabel("Car Registration");
	        CarRegistrationLabel.setBounds(307, 34, 375, 44);
	        CarRegistrationLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 38));
	        	        
	        	        
	        AddCarButton = new JButton("Add Car");
	        AddCarButton.setBounds(159, 525, 259, 74);
	        AddCarButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e)
            {
	        	if(CarIDTextField.getText().isEmpty() || PlateNoTextField.getText().isEmpty() || ModelTextField.getText().isEmpty() || CapacityTextField.getText().isEmpty() || PriceTextField.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(AddCarButton, "You did not fill in all information. Please completely fill out the form.");
				 }
				else if (Integer.parseInt(CapacityTextField.getText()) < 2){
					 JOptionPane.showMessageDialog(AddCarButton, "The capacity must be at least 2.");
		        }
				else {
			
			        String cartype = (String)CarTypeCombobox.getSelectedItem();
			        String carid = CarIDTextField.getText();
			        String plateno = PlateNoTextField.getText();
			        String model = ModelTextField.getText();
			        int capacity = Integer.parseInt(CapacityTextField.getText());
			        String price = PriceTextField.getText();
		
			        if(cartype == "Economic Car") {
			        	
				        try {
				        Connection conn = db.getConnection();
		
				        String sqlStatement = "INSERT INTO economiccar (ECar_ID, PlateNo, Model, Capacity, Price) VALUES (?, ?, ?, ?, ?)";
		
				        PreparedStatement stmt = conn.prepareStatement(sqlStatement);
				        
				         stmt.setString (1, carid);
						 stmt.setString (2, plateno);
						 stmt.setString (3, model);
						 stmt.setInt (4, capacity);
						 stmt.setString (5, price);
						 
				        boolean x = stmt.execute();
				        
				        if (x == true) {
				        JOptionPane.showMessageDialog(AddCarButton, "This is already exist");
				        } 
				        else {
				        JOptionPane.showMessageDialog(AddCarButton,"A Economic Car " + carid + " is sucessfully added.");
				        	        	                            
				        }
				        conn.close();
				        } 
				        catch (Exception exception) {
				        exception.printStackTrace();
				        }
			        }
			        	if(cartype == "Premium Car") {
			        	
				        try {
				        Connection conn = db.getConnection();
		
				        String sqlStatement = "INSERT INTO premiumcar (PCar_ID, PlateNo, Model, Capacity, Price) VALUES (?, ?, ?, ?, ?)";
		
				        PreparedStatement stmt = conn.prepareStatement(sqlStatement);
				        
				         stmt.setString (1, carid);
						 stmt.setString (2, plateno);
						 stmt.setString (3, model);
						 stmt.setInt (4, capacity);
						 stmt.setString (5, price);
						 
				        boolean x = stmt.execute();
				        
				        if (x == true) {
				        JOptionPane.showMessageDialog(AddCarButton, "This is already exist");
				        } 
				        else {
				        JOptionPane.showMessageDialog(AddCarButton,"A Premium Car " + carid + " is sucessfully added.");
				        	        	                            
				        }
				        conn.close();
				        } 
				        catch (Exception exception) {
				        exception.printStackTrace();
				        }
			        }
			        	 if(cartype == "Luxury Car") {
			 	        	
			 		        try {
			 		        Connection conn = db.getConnection();
		
			 		        String sqlStatement = "INSERT INTO luxurycar (LCar_ID, PlateNo, Model, Capacity, Price) VALUES (?, ?, ?, ?, ?)";
		
			 		        PreparedStatement stmt = conn.prepareStatement(sqlStatement);
			 		        
			 		         stmt.setString (1, carid);
			 				 stmt.setString (2, plateno);
			 				 stmt.setString (3, model);
			 				 stmt.setInt (4, capacity);
			 				 stmt.setString (5, price);
			 				 
			 		        boolean x = stmt.execute();
			 		        
			 		        if (x == true) {
			 		        JOptionPane.showMessageDialog(AddCarButton, "The information is invalid.");
			 		        } 
			 		        else {
			 		        JOptionPane.showMessageDialog(AddCarButton,"A Luxury Car " + carid + " is sucessfully added.");
			 		        	        	                            
			 		        }
			 		        conn.close();
			 		        } 
			 		        catch (Exception exception) {
			 		        exception.printStackTrace();
			 		        }
			 	        }
			   
				}
            }
	        });
	        AddCarButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 22));
	        	        	        
	        JButton PreviousPageButton = new JButton("Previous Page");
	        PreviousPageButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		dispose();
	        		AdminMenu adminmenu = new AdminMenu();
	        		adminmenu.setVisible(true);
	        		
	        	}
	        });
	        PreviousPageButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 22));
	        PreviousPageButton.setBounds(574, 525, 259, 74);
	        	        	        
	        CarTypeLabel = new JLabel("Car Type :");
	        CarTypeLabel.setBounds(10, 140, 124, 20);
	        CarTypeLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
	        	        	        	        
	        CarTypeCombobox = new JComboBox(choices);
	        CarTypeCombobox.setBounds(136, 126, 228, 50);
	        CarTypeCombobox.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 21));
	        	        	        	        	        
	        JLabel PlateNoLabel = new JLabel("PlateNo : ");
	        PlateNoLabel.setBounds(10, 248, 124, 43);
	        PlateNoLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
	        	        	        	        	        	        
	        PlateNoTextField = new JTextField();
	        PlateNoTextField.setBounds(136, 253, 228, 30);
	        PlateNoTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        PlateNoTextField.setColumns(10);
	        	        	        	        	        	        	        
	        	        	        	        	        	        	        
	        JLabel ModelLabel = new JLabel("Model : ");
	        ModelLabel.setBounds(23, 301, 124, 36);
	        ModelLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
	        	        	        	        	        	        	        	        
	        ModelTextField = new JTextField();
	        ModelTextField.setBounds(136, 303, 228, 30);
	        ModelTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        ModelTextField.setColumns(10);
	        	        	        	        	        	        	        	        	        
	        	        	        	        	        	        	        	        	        
	        CapacityLabel = new JLabel("Capacity : ");
	        CapacityLabel.setBounds(10, 362, 124, 20);
	        CapacityLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
	        	        	        	        	        	        	        	        	        	        
	        CapacityTextField = new JTextField();
	        CapacityTextField.setBounds(136, 357, 228, 30);
	        CapacityTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        	        	        	        	        	        	        	        	        	        	        
	        PriceLabel = new JLabel("Price : ");
	        PriceLabel.setBounds(23, 417, 100, 20);
      	    AddCarPanel.add(PriceLabel);
        	PriceLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
	        AddCarPanel.add(CarRegistrationLabel);
	        AddCarPanel.add(AddCarButton);	        	        	        	        
	        AddCarPanel.add(PreviousPageButton);
	        AddCarPanel.add(CarTypeLabel);
	        AddCarPanel.add(CarTypeCombobox);
	        AddCarPanel.add(PlateNoLabel);
	        AddCarPanel.add(PlateNoTextField);
	        AddCarPanel.add(ModelLabel);
	        AddCarPanel.add(ModelTextField);
	        AddCarPanel.add(CapacityLabel);
	        AddCarPanel.add(CapacityTextField);
	        	        	        	        	        	        	        	        	        	        	        	        
	        PriceTextField = new JTextField();
	        PriceTextField.setBounds(136, 411, 228, 30);
	        AddCarPanel.add(PriceTextField);
	        PriceTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        
	        JLabel CarIDLabel = new JLabel("Car ID: ");
	        CarIDLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
	        CarIDLabel.setBounds(23, 195, 99, 43);
	        AddCarPanel.add(CarIDLabel);
	        
	        CarIDTextField = new JTextField();
	        CarIDTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        CarIDTextField.setColumns(10);
	        CarIDTextField.setBounds(136, 200, 228, 30);
	        AddCarPanel.add(CarIDTextField);
	        
	        CarInfoScrollPane = new JScrollPane();
	        CarInfoScrollPane.setBounds(405, 163, 574, 257);
	        AddCarPanel.add(CarInfoScrollPane);
	        
	        CarInfoTable = new JTable();
	        CarInfoScrollPane.setViewportView(CarInfoTable);
	        
	        JButton LoadCarInfoButton = new JButton("Load Car Info");
	        LoadCarInfoButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		String cartype = (String)CarTypeCombobox.getSelectedItem();
	        		
	        		if(cartype == "Economic Car") {
	        		try {
						Connection conn = db.getConnection();
						JOptionPane.showMessageDialog(LoadCarInfoButton, "Information of cars is printed!");
						
						String sqlStatement = "SELECT * FROM ECONOMICCAR";
						PreparedStatement stmt = conn.prepareStatement(sqlStatement);
						
						ResultSet result = stmt.executeQuery();
						ResultSetMetaData rsmd = result.getMetaData();
						DefaultTableModel model =(DefaultTableModel) CarInfoTable.getModel();
						
						model.setRowCount(0);
						int cols = rsmd.getColumnCount();
						String[] colName = new String[cols];
						
						for(int i=0;i<cols;i++) {
							colName[i]=rsmd.getColumnName(i+1);
						}
						
						
						model.setColumnIdentifiers(colName);
						String id,plateno,carmodel,capacity,price;
						
						while (result.next()) {
							id = result.getString(1);
							plateno = result.getString(2);
							carmodel = result.getString(3);
							capacity = result.getString(4);
							price = result.getString(5);
							String[] row = {id,plateno,carmodel,capacity,price};
							model.addRow(row);
						}
						
					} catch (Exception le) {
						le.printStackTrace();
					}
	        	}
	        		if(cartype == "Premium Car") {
		        		try {
							Connection conn = db.getConnection();
							JOptionPane.showMessageDialog(LoadCarInfoButton, "Information of cars is printed!");
							
							String sqlStatement = "SELECT * FROM PREMIUMCAR";
							PreparedStatement stmt = conn.prepareStatement(sqlStatement);
							
							ResultSet result = stmt.executeQuery();
							ResultSetMetaData rsmd = result.getMetaData();
							DefaultTableModel model =(DefaultTableModel) CarInfoTable.getModel();
							
							model.setRowCount(0);
							int cols = rsmd.getColumnCount();
							String[] colName = new String[cols];
							
							for(int i=0;i<cols;i++) {
								colName[i]=rsmd.getColumnName(i+1);
							}
							
							
							model.setColumnIdentifiers(colName);
							String id,plateno,carmodel,capacity,price;
							
							while (result.next()) {
								id = result.getString(1);
								plateno = result.getString(2);
								carmodel = result.getString(3);
								capacity = result.getString(4);
								price = result.getString(5);
								String[] row = {id,plateno,carmodel,capacity,price};
								model.addRow(row);
							}
							
						} catch (Exception le) {
							le.printStackTrace();
						}
		        	}
	        		if(cartype == "Luxury Car") {
		        		try {
							Connection conn = db.getConnection();
							JOptionPane.showMessageDialog(LoadCarInfoButton, "Information of cars is printed!");
							
							String sqlStatement = "SELECT * FROM LUXURYCAR";
							PreparedStatement stmt = conn.prepareStatement(sqlStatement);
							
							ResultSet result = stmt.executeQuery();
							ResultSetMetaData rsmd = result.getMetaData();
							DefaultTableModel model =(DefaultTableModel) CarInfoTable.getModel();
							
							model.setRowCount(0);
							int cols = rsmd.getColumnCount();
							String[] colName = new String[cols];
							
							for(int i=0;i<cols;i++) {
								colName[i]=rsmd.getColumnName(i+1);
							}
							
							
							model.setColumnIdentifiers(colName);
							String id,plateno,carmodel,capacity,price;
							
							while (result.next()) {
								id = result.getString(1);
								plateno = result.getString(2);
								carmodel = result.getString(3);
								capacity = result.getString(4);
								price = result.getString(5);
								String[] row = {id,plateno,carmodel,capacity,price};
								model.addRow(row);
							}
							
						} catch (Exception le) {
							le.printStackTrace();
						}
		        	}
	        	}
	        });
	        LoadCarInfoButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
	        LoadCarInfoButton.setBounds(597, 430, 191, 43);
	        AddCarPanel.add(LoadCarInfoButton);
	        
	        lblPleaseStrictlyFollow = new JLabel("Please strictly follow the format of the car's information.");
	        lblPleaseStrictlyFollow.setFont(new Font("Constantia", Font.PLAIN, 18));
	        lblPleaseStrictlyFollow.setBounds(405, 126, 585, 20);
	        AddCarPanel.add(lblPleaseStrictlyFollow);
	    }
	}
