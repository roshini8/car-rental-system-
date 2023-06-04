import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class DeleteCar extends JFrame {

	private JPanel contentPane;
	private JTextField CarIDTextField;
	private JTable CarInfoTable;
	private String[] choices = {"Economic Car","Premium Car","Luxury Car"};
	
	CarRentalJDBC db = new CarRentalJDBC();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCar frame = new DeleteCar();
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
	public DeleteCar() {
		setTitle("Delete A Car");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel DeleteCarPAnel = new JPanel();
		DeleteCarPAnel.setBackground(new Color(221, 160, 221));
		DeleteCarPAnel.setBounds(0, 0, 922, 663);
		contentPane.add(DeleteCarPAnel);
		DeleteCarPAnel.setLayout(null);
		
		JLabel lblDeleteACar = new JLabel("Delete A Car");
		lblDeleteACar.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 38));
		lblDeleteACar.setBounds(290, 21, 301, 44);
		DeleteCarPAnel.add(lblDeleteACar);
		
		JLabel CarTypeLabel = new JLabel("Car Type :");
		CarTypeLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		CarTypeLabel.setBounds(26, 123, 124, 20);
		DeleteCarPAnel.add(CarTypeLabel);
		
		JComboBox CarTypeCombobox = new JComboBox(choices);
		CarTypeCombobox.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 21));
		CarTypeCombobox.setBounds(150, 111, 228, 50);
		DeleteCarPAnel.add(CarTypeCombobox);
		
		JLabel CarIDLabel = new JLabel("Car ID: ");
		CarIDLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		CarIDLabel.setBounds(520, 112, 99, 43);
		DeleteCarPAnel.add(CarIDLabel);
		
		CarIDTextField = new JTextField();
		CarIDTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CarIDTextField.setColumns(10);
		CarIDTextField.setBounds(618, 118, 228, 30);
		DeleteCarPAnel.add(CarIDTextField);
		
		JLabel lblPleaseStrictlyFollow_1 = new JLabel("Please strictly follow the format of the car's ID.");
		lblPleaseStrictlyFollow_1.setFont(new Font("Constantia", Font.PLAIN, 18));
		lblPleaseStrictlyFollow_1.setBounds(26, 192, 585, 20);
		DeleteCarPAnel.add(lblPleaseStrictlyFollow_1);
		
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
		LoadCarInfoButton.setBounds(355, 489, 191, 43);
		DeleteCarPAnel.add(LoadCarInfoButton);
		
		JButton DeleteButton = new JButton("Delete");
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(CarIDTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(DeleteButton, "You did not fill in Car ID. Please key in the Car ID.");
				}
				else{
					
					  String cartype = (String)CarTypeCombobox.getSelectedItem();
				      String carid = CarIDTextField.getText();
				   
			
				        if(cartype == "Economic Car") {
				        	
					        try {
					        Connection conn = db.getConnection();
			
					        String sqlStatement = "Delete from economiccar where ECar_ID = ?";
			
					        PreparedStatement stmt = conn.prepareStatement(sqlStatement);
					        
					         stmt.setString (1, carid);
							 
					        boolean x = stmt.execute();
					        
					        if (x == true) {
					        JOptionPane.showMessageDialog(DeleteButton, "The Car ID is not found. Please check again.");
					        } 
					        else {
					        JOptionPane.showMessageDialog(DeleteButton,"A Economic Car " + carid + " is sucessfully deleted.");
					        	        	                            
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
						
								        String sqlStatement = "Delete from premiumcar where PCar_ID = ?";
						
								        PreparedStatement stmt = conn.prepareStatement(sqlStatement);
								        
								         stmt.setString (1, carid);
										 
								        boolean x = stmt.execute();
								        
								        if (x == true) {
								        JOptionPane.showMessageDialog(DeleteButton, "The Car ID is not found. Please check again.");
								        } 
								        else {
								        JOptionPane.showMessageDialog(DeleteButton,"A Premium Car " + carid + " is sucessfully deleted.");
								        	        	                            
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
						
								        String sqlStatement = "Delete from luxurycar where LCar_ID = ?";
						
								        PreparedStatement stmt = conn.prepareStatement(sqlStatement);
								        
								         stmt.setString (1, carid);
										 
								        boolean x = stmt.execute();
								        
								        if (x == true) {
								        JOptionPane.showMessageDialog(DeleteButton, "The Car ID is not found. Please check again.");
								        } 
								        else {
								        JOptionPane.showMessageDialog(DeleteButton,"A Luxury Car " + carid + " is sucessfully deleted.");
								        	        	                            
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
		DeleteButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 22));
		DeleteButton.setBounds(134, 555, 259, 74);
		DeleteCarPAnel.add(DeleteButton);
		
		JButton PreviousPageButton = new JButton("Previous Page");
		PreviousPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
        		AdminMenu adminmenu = new AdminMenu();
        		adminmenu.setVisible(true);
				
			}
		});
		PreviousPageButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 22));
		PreviousPageButton.setBounds(520, 555, 259, 74);
		DeleteCarPAnel.add(PreviousPageButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 222, 866, 255);
		DeleteCarPAnel.add(scrollPane);
		
		CarInfoTable = new JTable();
		scrollPane.setViewportView(CarInfoTable);
	}
}
