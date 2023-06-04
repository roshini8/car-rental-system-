import java.util.Scanner;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;


public class SelectCarType extends JFrame {
	
	protected static final String NULL = null;
	protected static final String EMPTY = null;
	CarRentalJDBC db = new CarRentalJDBC();
	
	private JComboBox<String> eIDComboBox;
	private JComboBox<String> pIDComboBox;
	private JComboBox<String> lIDComboBox;
	private JTable EconomicTable;
	private JTable PremiumTable;
	private JTable LuxuryTable;
	JTextField eIDTextField;
	private JTextField ePlateNoTextField;
	private JTextField eModelTextField;
	private JTextField eCapacityTextField;
	private JTextField ePriceTextField;
	private JTextField pIDTextField;
	private JTextField lIDTextField;
	private JTextField pPlateNoTextField;
	private JTextField lPlateNoTextField;
	private JTextField pModelTextField;
	private JTextField lModelTextField;
	private JTextField pCapacityTextField;
	private JTextField lCapacityTextField;
	private JTextField pPriceTextField;
	private JTextField lPriceTextField;
	private JTextField eUsernameTextField;
	private JTextField pUsernameTextField;
	private JTextField lUsernameTextField;
	/**
	 * Launch the application.
	 */
	public static void main (String[] args) {

		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					SelectCarType frame = new SelectCarType();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void eusername_update(String username) {
				
				eUsernameTextField.setText(username);
			}
		
	public void pusername_update(String username) {
			
			pUsernameTextField.setText(username);
		}
		
	public void lusername_update(String username) {
			
			lUsernameTextField.setText(username);
		}
	
	public String getID() {
		String confirmcar = eIDTextField.getText();
		System.out.println(confirmcar);
		return eIDTextField.getText();
	}
	
	public void filleIDComboBox()
	{
		try {
			Connection conn = db.getConnection();
			
			String sqlStatement = "SELECT ECar_ID FROM ECONOMICCAR";
			PreparedStatement stmt = conn.prepareStatement(sqlStatement);
					
			ResultSet result = stmt.executeQuery();
					
			while(result.next())
			{
				eIDComboBox.addItem(result.getString("ECar_ID"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fillpIDComboBox()
	{
		try {
			Connection conn = db.getConnection();
			
			String sqlStatement = "SELECT PCar_ID FROM PREMIUMCAR";
			PreparedStatement stmt = conn.prepareStatement(sqlStatement);
					
			ResultSet result = stmt.executeQuery();
					
			while(result.next())
			{
				pIDComboBox.addItem(result.getString("PCar_ID"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void filllIDComboBox()
	{
		try {
			Connection conn = db.getConnection();
			
			String sqlStatement = "SELECT LCar_ID FROM LUXURYCAR";
			PreparedStatement stmt = conn.prepareStatement(sqlStatement);
					
			ResultSet result = stmt.executeQuery();
					
			while(result.next())
			{
				lIDComboBox.addItem(result.getString("LCar_ID"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Create the frame.
	 */
		public SelectCarType() {
		
		setFont(new Font("Dialog", Font.PLAIN, 19));
		setTitle("Select Car Type");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 400);
		getContentPane().setLayout(null);
		
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setBackground(new Color(255, 128, 128));
		ButtonPanel.setBounds(0, 0, 736, 47);
		getContentPane().add(ButtonPanel);
		
		JPanel ParentPanel = new JPanel();
		ParentPanel.setBackground(new Color(154, 205, 50));
		ParentPanel.setBounds(0, 45, 736, 318);
		getContentPane().add(ParentPanel);
		ParentPanel.setLayout(new CardLayout(0, 0));
		
		JPanel EconomicCarPanel = new JPanel();
		EconomicCarPanel.setBackground(new Color(153, 102, 51));
		ParentPanel.add(EconomicCarPanel, "name_1232548874028000");
		EconomicCarPanel.setLayout(null);
		
		JLabel eSelectLabel = new JLabel("Select a Car ID: ");
		eSelectLabel.setBounds(30, 115, 181, 26);
		eSelectLabel.setHorizontalAlignment(SwingConstants.CENTER);
		eSelectLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 18));
		EconomicCarPanel.add(eSelectLabel);
		
		JScrollPane eScrollPane = new JScrollPane();
		eScrollPane.setBounds(238, 22, 476, 173);
		EconomicCarPanel.add(eScrollPane);
		
		EconomicTable = new JTable();
		eScrollPane.setViewportView(EconomicTable);
		
		JButton eLoadButton = new JButton("Load Car Info");
		eLoadButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		eLoadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				try {
					Connection conn = db.getConnection();
					JOptionPane.showMessageDialog(eLoadButton, "Information of cars is printed!");
					
					String sqlStatement = "SELECT * FROM ECONOMICCAR";
					PreparedStatement stmt = conn.prepareStatement(sqlStatement);
					
					ResultSet result = stmt.executeQuery();
					ResultSetMetaData rsmd = result.getMetaData();
					DefaultTableModel model =(DefaultTableModel) EconomicTable.getModel();
					
					model.setRowCount(0);
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					
					for(int i=0;i<cols;i++) {
						colName[i]=rsmd.getColumnName(i+1);}
					
					
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
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		eLoadButton.setBounds(46, 61, 149, 40);
		EconomicCarPanel.add(eLoadButton);
		
		eIDTextField = new JTextField();
		eIDTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eIDTextField.getText();
			}
		});
		eIDTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		eIDTextField.setEditable(false);
		eIDTextField.setBounds(20, 245, 66, 33);
		EconomicCarPanel.add(eIDTextField);
		eIDTextField.setColumns(10);
		
		ePlateNoTextField = new JTextField();
		ePlateNoTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ePlateNoTextField.setEditable(false);
		ePlateNoTextField.setColumns(10);
		ePlateNoTextField.setBounds(107, 245, 99, 33);
		EconomicCarPanel.add(ePlateNoTextField);
		
		eModelTextField = new JTextField();
		eModelTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		eModelTextField.setEditable(false);
		eModelTextField.setColumns(10);
		eModelTextField.setBounds(227, 245, 275, 33);
		EconomicCarPanel.add(eModelTextField);
		
		eCapacityTextField = new JTextField();
		eCapacityTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		eCapacityTextField.setEditable(false);
		eCapacityTextField.setColumns(10);
		eCapacityTextField.setBounds(523, 245, 38, 33);
		EconomicCarPanel.add(eCapacityTextField);
		
		ePriceTextField = new JTextField();
		ePriceTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ePriceTextField.setEditable(false);
		ePriceTextField.setColumns(10);
		ePriceTextField.setBounds(579, 245, 135, 33);
		EconomicCarPanel.add(ePriceTextField);
		
		JLabel eIDLabel = new JLabel("ID");
		eIDLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		eIDLabel.setBounds(46, 213, 29, 33);
		EconomicCarPanel.add(eIDLabel);
		
		JLabel ePlateNoLabel = new JLabel("PlateNo");
		ePlateNoLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		ePlateNoLabel.setBounds(121, 213, 74, 33);
		EconomicCarPanel.add(ePlateNoLabel);
		
		JLabel eModelLabel = new JLabel("CarModel");
		eModelLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		eModelLabel.setBounds(321, 213, 90, 33);
		EconomicCarPanel.add(eModelLabel);
		
		JLabel eCapacityLabel = new JLabel("Capacity");
		eCapacityLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		eCapacityLabel.setBounds(499, 213, 80, 33);
		EconomicCarPanel.add(eCapacityLabel);
		
		JLabel ePriceLabel = new JLabel("Price");
		ePriceLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		ePriceLabel.setBounds(627, 213, 54, 33);
		EconomicCarPanel.add(ePriceLabel);
		
		JButton eConfirmButton = new JButton("Confirm");
		eConfirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			 if(eIDTextField.getText().isEmpty()) {
				 JOptionPane.showMessageDialog(eConfirmButton, "You did not select a car. Please select a car.");
			 }
			 else {
				 String confirmid = eIDTextField.getText();
				 String confirmplateno = ePlateNoTextField.getText();
				 String confirmmodel = eModelTextField.getText();
				 String confirmcapacity = eCapacityTextField.getText();
				 String confirmprice = ePriceTextField.getText();
				 String userName = eUsernameTextField.getText();
				 int econfirm = JOptionPane.showConfirmDialog(eConfirmButton, "Do you want to rent this " + confirmid + " car?", "Confirm Dialog", JOptionPane.YES_NO_OPTION);
				 if(econfirm == JOptionPane.YES_OPTION) {
				
				 JOptionPane.showMessageDialog(eConfirmButton, "You select " + confirmid + " car.");
				 
				 
				 CarBooking carBooking = new CarBooking();
				 carBooking.id_update(confirmid);
				 carBooking.model_update(confirmmodel);
				 carBooking.plateno_update(confirmplateno);
				 carBooking.capacity_update(confirmcapacity);
				 carBooking.price_update(confirmprice);
				 carBooking.username_update(userName);
				 dispose();
				 carBooking.setVisible(true);
				 
				 }
			}
			} 
		});
	
		eConfirmButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 17));
		eConfirmButton.setBounds(165, 288, 128, 21);
		EconomicCarPanel.add(eConfirmButton);
		
		eIDComboBox = new JComboBox();
		eIDComboBox.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
					
					String tmp = (String)eIDComboBox.getSelectedItem();
					String sqlStatement = "SELECT * FROM ECONOMICCAR WHERE ECar_ID = ?";
					
					try {
						Connection conn = db.getConnection();
						PreparedStatement stmt = conn.prepareStatement(sqlStatement);
						stmt.setString(1, tmp);
						ResultSet result = stmt.executeQuery();
						
						if(result.next()) {
						String add1 = result.getString("ECar_ID");
						eIDTextField.setText(add1);
						String add2 = result.getString("PlateNo");
						ePlateNoTextField.setText(add2);
						String add3 = result.getString("Model");
						eModelTextField.setText(add3);
						String add4 = result.getString("Capacity");
						eCapacityTextField.setText(add4);
						String add5 = result.getString("Price");
						ePriceTextField.setText(add5);
						}
						
					}catch(Exception pe) {
						JOptionPane.showMessageDialog(null,pe);
					}
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
		eIDComboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eIDComboBox.setBounds(30, 151, 181, 33);
		EconomicCarPanel.add(eIDComboBox);
		
		eUsernameTextField = new JTextField();
		eUsernameTextField.setEditable(false);
		eUsernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		eUsernameTextField.setBounds(10, 10, 218, 28);
		EconomicCarPanel.add(eUsernameTextField);
		eUsernameTextField.setColumns(10);
		
		JButton ePreviousPageButton = new JButton("Previous Page");
		ePreviousPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   
			   
				int confirm = JOptionPane.showConfirmDialog(ePreviousPageButton, "Back to previous page?\nAll information at here will be deleted.", "Confirm Dialog", JOptionPane.YES_NO_OPTION);
				if(confirm == JOptionPane.YES_OPTION) {
					
					String eusername = eUsernameTextField.getText();

					UserHome userhome = new UserHome(eusername);
					userhome.username_update(eusername);
					dispose();
					userhome.setVisible(true);
					
				}
			}
		});
		ePreviousPageButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 17));
		ePreviousPageButton.setBounds(404, 288, 175, 21);
		EconomicCarPanel.add(ePreviousPageButton);
		
		JPanel PremiumCarPanel = new JPanel();
		PremiumCarPanel.setBackground(new Color(153, 204, 204));
		ParentPanel.add(PremiumCarPanel, "name_1232884229264700");
		PremiumCarPanel.setLayout(null);
		
		JPanel LuxuryCarPanel = new JPanel();
		LuxuryCarPanel.setBackground(new Color(255, 204, 0));
		ParentPanel.add(LuxuryCarPanel, "name_1232924019892300");
		LuxuryCarPanel.setLayout(null);
		
		JLabel pSelectLabel = new JLabel("Select a Car ID: ");
		pSelectLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pSelectLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 18));
		pSelectLabel.setBounds(31, 114, 181, 26);
		PremiumCarPanel.add(pSelectLabel);
		
		pIDComboBox = new JComboBox();
		pIDComboBox.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent pe) {
				
				String tmp = (String)pIDComboBox.getSelectedItem();
				String sqlStatement = "SELECT * FROM PREMIUMCAR WHERE PCar_ID = ?";
				
				try {
					Connection conn = db.getConnection();
					PreparedStatement stmt = conn.prepareStatement(sqlStatement);
					stmt.setString(1, tmp);
					ResultSet result = stmt.executeQuery();
					
					if(result.next()) {
					String add1 = result.getString("PCar_ID");
					pIDTextField.setText(add1);
					String add2 = result.getString("PlateNo");
					pPlateNoTextField.setText(add2);
					String add3 = result.getString("Model");
					pModelTextField.setText(add3);
					String add4 = result.getString("Capacity");
					pCapacityTextField.setText(add4);
					String add5 = result.getString("Price");
					pPriceTextField.setText(add5);
					}
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,e);
				}
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
		pIDComboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pIDComboBox.setBounds(31, 150, 181, 33);
		PremiumCarPanel.setLayout(null);
		PremiumCarPanel.add(pIDComboBox);
		
		pIDTextField = new JTextField();
		pIDTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pIDTextField.setEditable(false);
		pIDTextField.setColumns(10);
		pIDTextField.setBounds(20, 246, 66, 33);
		PremiumCarPanel.add(pIDTextField);
		
		pPlateNoTextField = new JTextField();
		pPlateNoTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pPlateNoTextField.setEditable(false);
		pPlateNoTextField.setColumns(10);
		pPlateNoTextField.setBounds(107, 246, 99, 33);
		PremiumCarPanel.add(pPlateNoTextField);
		
		pModelTextField = new JTextField();
		pModelTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pModelTextField.setEditable(false);
		pModelTextField.setColumns(10);
		pModelTextField.setBounds(228, 246, 275, 33);
		PremiumCarPanel.add(pModelTextField);
		
		pCapacityTextField = new JTextField();
		pCapacityTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pCapacityTextField.setEditable(false);
		pCapacityTextField.setColumns(10);
		pCapacityTextField.setBounds(530, 246, 38, 33);
		PremiumCarPanel.add(pCapacityTextField);
		
		pPriceTextField = new JTextField();
		pPriceTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pPriceTextField.setEditable(false);
		pPriceTextField.setColumns(10);
		pPriceTextField.setBounds(591, 246, 135, 33);
		PremiumCarPanel.add(pPriceTextField);
		
		JLabel pIDLabel = new JLabel("ID");
		pIDLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		pIDLabel.setBounds(43, 214, 29, 33);
		PremiumCarPanel.add(pIDLabel);
		
		JLabel pPlateNoLabel = new JLabel("PlateNo");
		pPlateNoLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		pPlateNoLabel.setBounds(118, 214, 74, 33);
		PremiumCarPanel.add(pPlateNoLabel);
		
		JLabel pModelLabel = new JLabel("CarModel");
		pModelLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		pModelLabel.setBounds(314, 214, 90, 33);
		PremiumCarPanel.add(pModelLabel);
		
		JLabel pCapacityLabel = new JLabel("Capacity");
		pCapacityLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		pCapacityLabel.setBounds(513, 214, 75, 33);
		PremiumCarPanel.add(pCapacityLabel);
		
		JLabel pPriceLabel = new JLabel("Price");
		pPriceLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		pPriceLabel.setBounds(634, 214, 56, 33);
		PremiumCarPanel.add(pPriceLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(247, 20, 479, 176);
		PremiumCarPanel.add(scrollPane);
		
		PremiumTable = new JTable();
		scrollPane.setViewportView(PremiumTable);
		
		JButton pLoadButton = new JButton("Load Car Info");
		pLoadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			
				try {
					Connection conn = db.getConnection();
					JOptionPane.showMessageDialog(pLoadButton, "Information of cars is printed!");
					
					String sqlStatement = "SELECT * FROM PREMIUMCAR";
					PreparedStatement stmt = conn.prepareStatement(sqlStatement);
					
					ResultSet result = stmt.executeQuery();
					ResultSetMetaData rsmd = result.getMetaData();
					DefaultTableModel model =(DefaultTableModel) PremiumTable.getModel();
					
					model.setRowCount(0);
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					
					for(int i=0;i<cols;i++) {
						colName[i]=rsmd.getColumnName(i+1);}
					
					
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
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		pLoadButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		pLoadButton.setBounds(43, 59, 149, 40);
		PremiumCarPanel.add(pLoadButton);
		
		JButton pConfirmButton = new JButton("Confirm");
		pConfirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if(pIDTextField.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(pConfirmButton, "You did not select a car. Please select a car.");
				 }
				 else {
					 String confirmid = pIDTextField.getText();
					 String confirmplateno = pPlateNoTextField.getText();
					 String confirmmodel = pModelTextField.getText();
					 String confirmcapacity = pCapacityTextField.getText();
					 String confirmprice = pPriceTextField.getText();
					 String userName = pUsernameTextField.getText();
					 int pconfirm = JOptionPane.showConfirmDialog(pConfirmButton, "Do you want to rent this " + confirmid + " car?", "Confirm Dialog", JOptionPane.YES_NO_OPTION);
					 if(pconfirm == JOptionPane.YES_OPTION) {
					
					 JOptionPane.showMessageDialog(pConfirmButton, "You select " + confirmid + " car.");
					 
					 CarBooking carBooking = new CarBooking();
					 carBooking.id_update(confirmid);
					 carBooking.model_update(confirmmodel);
					 carBooking.plateno_update(confirmplateno);
					 carBooking.capacity_update(confirmcapacity);
					 carBooking.price_update(confirmprice);
					 carBooking.username_update(userName);
					 dispose();
					 carBooking.setVisible(true);
					 
					 }
				}
				} 
		});
		pConfirmButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 17));
		pConfirmButton.setBounds(201, 289, 113, 21);
		PremiumCarPanel.add(pConfirmButton);
		
		pUsernameTextField = new JTextField();
		pUsernameTextField.setEditable(false);
		pUsernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pUsernameTextField.setColumns(10);
		pUsernameTextField.setBounds(10, 10, 228, 29);
		PremiumCarPanel.add(pUsernameTextField);
		
		JButton pPreviousPageButton = new JButton("Previous Page");
		pPreviousPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(pPreviousPageButton, "Back to previous page?\nAll information at here will be deleted.", "Confirm Dialog", JOptionPane.YES_NO_OPTION);
				if(confirm == JOptionPane.YES_OPTION) {
					
					String pusername = pUsernameTextField.getText();

					UserHome userhome = new UserHome(pusername);
					userhome.username_update(pusername);
					dispose();
					userhome.setVisible(true);
					
				}
			}
		});
		pPreviousPageButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 17));
		pPreviousPageButton.setBounds(404, 289, 175, 21);
		PremiumCarPanel.add(pPreviousPageButton);
		
		JButton lLoadButton = new JButton("Load Car Info");
		lLoadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				

				try {
					Connection conn = db.getConnection();
					JOptionPane.showMessageDialog(lLoadButton, "Information of cars is printed!");
					
					String sqlStatement = "SELECT * FROM LUXURYCAR";
					PreparedStatement stmt = conn.prepareStatement(sqlStatement);
					
					ResultSet result = stmt.executeQuery();
					ResultSetMetaData rsmd = result.getMetaData();
					DefaultTableModel model =(DefaultTableModel) LuxuryTable.getModel();
					
					model.setRowCount(0);
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					
					for(int i=0;i<cols;i++) {
						colName[i]=rsmd.getColumnName(i+1);}
					
					
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
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		lLoadButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		lLoadButton.setBounds(46, 60, 149, 40);
		LuxuryCarPanel.add(lLoadButton);
		
		JLabel lSelectLabel = new JLabel("Select a Car ID: ");
		lSelectLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lSelectLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 18));
		lSelectLabel.setBounds(31, 117, 181, 26);
		LuxuryCarPanel.add(lSelectLabel);
		
		lIDComboBox = new JComboBox();
		lIDComboBox.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent ae) {
				

				String tmp = (String)lIDComboBox.getSelectedItem();
				String sqlStatement = "SELECT * FROM LUXURYCAR WHERE LCar_ID = ?";
				
				try {
					Connection conn = db.getConnection();
					PreparedStatement stmt = conn.prepareStatement(sqlStatement);
					stmt.setString(1, tmp);
					ResultSet result = stmt.executeQuery();
					
					if(result.next()) {
					String add1 = result.getString("LCar_ID");
					lIDTextField.setText(add1);
					String add2 = result.getString("PlateNo");
					lPlateNoTextField.setText(add2);
					String add3 = result.getString("Model");
					lModelTextField.setText(add3);
					String add4 = result.getString("Capacity");
					lCapacityTextField.setText(add4);
					String add5 = result.getString("Price");
					lPriceTextField.setText(add5);
					}
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,e);
				}
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
		lIDComboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lIDComboBox.setBounds(31, 153, 181, 33);
		LuxuryCarPanel.add(lIDComboBox);
		
		lIDTextField = new JTextField();
		lIDTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lIDTextField.setEditable(false);
		lIDTextField.setColumns(10);
		lIDTextField.setBounds(21, 244, 66, 33);
		LuxuryCarPanel.add(lIDTextField);
		
		lPlateNoTextField = new JTextField();
		lPlateNoTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lPlateNoTextField.setEditable(false);
		lPlateNoTextField.setColumns(10);
		lPlateNoTextField.setBounds(113, 244, 99, 33);
		LuxuryCarPanel.add(lPlateNoTextField);
		
		lModelTextField = new JTextField();
		lModelTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lModelTextField.setEditable(false);
		lModelTextField.setColumns(10);
		lModelTextField.setBounds(232, 244, 275, 33);
		LuxuryCarPanel.add(lModelTextField);
		
		lCapacityTextField = new JTextField();
		lCapacityTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lCapacityTextField.setEditable(false);
		lCapacityTextField.setColumns(10);
		lCapacityTextField.setBounds(525, 244, 38, 33);
		LuxuryCarPanel.add(lCapacityTextField);
		
		lPriceTextField = new JTextField();
		lPriceTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lPriceTextField.setEditable(false);
		lPriceTextField.setColumns(10);
		lPriceTextField.setBounds(591, 244, 135, 33);
		LuxuryCarPanel.add(lPriceTextField);
		
		JLabel lIDLabel = new JLabel("ID");
		lIDLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		lIDLabel.setBounds(46, 212, 29, 33);
		LuxuryCarPanel.add(lIDLabel);
		
		JLabel lPlateNoLabel = new JLabel("PlateNo");
		lPlateNoLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		lPlateNoLabel.setBounds(127, 212, 74, 33);
		LuxuryCarPanel.add(lPlateNoLabel);
		
		JLabel lModelLabel = new JLabel("CarModel");
		lModelLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		lModelLabel.setBounds(314, 212, 99, 33);
		LuxuryCarPanel.add(lModelLabel);
		
		JLabel lCapacityLabel = new JLabel("Capacity");
		lCapacityLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		lCapacityLabel.setBounds(503, 212, 80, 33);
		LuxuryCarPanel.add(lCapacityLabel);
		
		JLabel lPriceLabel = new JLabel("Price");
		lPriceLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
		lPriceLabel.setBounds(635, 212, 60, 33);
		LuxuryCarPanel.add(lPriceLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(251, 20, 475, 169);
		LuxuryCarPanel.add(scrollPane_1);
		
		LuxuryTable = new JTable();
		scrollPane_1.setViewportView(LuxuryTable);
		
		JButton lConfirmButton = new JButton("Confirm");
		lConfirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(lIDTextField.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(lConfirmButton, "You did not select a car. Please select a car.");
				 }
				 else {
					 String confirmid = lIDTextField.getText();
					 String confirmplateno = lPlateNoTextField.getText();
					 String confirmmodel = lModelTextField.getText();
					 String confirmcapacity = lCapacityTextField.getText();
					 String confirmprice = lPriceTextField.getText();
					 String userName =lUsernameTextField.getText();
					 int lconfirm = JOptionPane.showConfirmDialog(lConfirmButton, "Do you want to rent this " + confirmid + " car?", "Confirm Dialog", JOptionPane.YES_NO_OPTION);
					 if(lconfirm == JOptionPane.YES_OPTION) {
					
					 JOptionPane.showMessageDialog(lConfirmButton, "You select " + confirmid + " car.");
					 
					 CarBooking carBooking = new CarBooking();
					 carBooking.id_update(confirmid);
					 carBooking.model_update(confirmmodel);
					 carBooking.plateno_update(confirmplateno);
					 carBooking.capacity_update(confirmcapacity);
					 carBooking.price_update(confirmprice);
					 carBooking.username_update(userName);
					 dispose();
					 carBooking.setVisible(true);
					 
					 }
				}
				} 
		});
		lConfirmButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 17));
		lConfirmButton.setBounds(201, 287, 120, 21);
		LuxuryCarPanel.add(lConfirmButton);
		
		lUsernameTextField = new JTextField();
		lUsernameTextField.setEditable(false);
		lUsernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lUsernameTextField.setColumns(10);
		lUsernameTextField.setBounds(10, 10, 231, 28);
		LuxuryCarPanel.add(lUsernameTextField);
		
		JButton lPreviousPageButton = new JButton("Previous Page");
		lPreviousPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(lPreviousPageButton, "Back to previous page?\nAll information at here will be deleted.", "Confirm Dialog", JOptionPane.YES_NO_OPTION);
				if(confirm == JOptionPane.YES_OPTION) {
					
					String lusername = eUsernameTextField.getText();

					UserHome userhome = new UserHome(lusername);
					userhome.username_update(lusername);
					dispose();
					userhome.setVisible(true);
					
				}
			}
		});
		lPreviousPageButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 17));
		lPreviousPageButton.setBounds(413, 287, 181, 21);
		LuxuryCarPanel.add(lPreviousPageButton);
		
		JButton EconomicCarButton = new JButton("Economic Car");
		EconomicCarButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 23));
		EconomicCarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParentPanel.removeAll();
				ParentPanel.add(EconomicCarPanel);
				ParentPanel.repaint();
				ParentPanel.revalidate();
			}
		});
		
		JButton LuxuryCarButton = new JButton("Luxury Car");
		LuxuryCarButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 23));
		LuxuryCarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParentPanel.removeAll();
				ParentPanel.add(LuxuryCarPanel);
				ParentPanel.repaint();
				ParentPanel.revalidate();
			}
		});
		ButtonPanel.add(EconomicCarButton);
		
		JButton PremiumCarButton = new JButton("Premium Car");
		PremiumCarButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 23));
		PremiumCarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParentPanel.removeAll();
				ParentPanel.add(PremiumCarPanel);
				ParentPanel.repaint();
				ParentPanel.revalidate();
			}
		});
		
		ButtonPanel.add(PremiumCarButton);
		ButtonPanel.add(LuxuryCarButton);
		filleIDComboBox();
		fillpIDComboBox();
		filllIDComboBox();
		
	}
}

