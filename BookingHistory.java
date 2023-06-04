import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class BookingHistory extends JFrame {

	private JPanel contentPane;
	private JTable BookingHistoryTable;
	
	CarRentalJDBC db = new CarRentalJDBC();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingHistory frame = new BookingHistory();
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
	public BookingHistory() {
		setTitle("Booking History");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setBounds(0, 0, 793, 562);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBookingHistory = new JLabel("Booking History");
		lblBookingHistory.setBounds(203, 25, 369, 43);
		lblBookingHistory.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 38));
		panel.add(lblBookingHistory);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 89, 728, 316);
		panel.add(scrollPane);
		
		BookingHistoryTable = new JTable();
		scrollPane.setViewportView(BookingHistoryTable);
		
		JButton LoadHistoryButton = new JButton("Load History");
		LoadHistoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection conn = db.getConnection();
					JOptionPane.showMessageDialog(LoadHistoryButton, "Booking History is printed!");
					
					String sqlStatement = "SELECT * FROM carbooking";
					PreparedStatement stmt = conn.prepareStatement(sqlStatement);
					
					ResultSet result = stmt.executeQuery();
					ResultSetMetaData rsmd = result.getMetaData();
					DefaultTableModel model =(DefaultTableModel) BookingHistoryTable.getModel();
					
					model.setRowCount(0);
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					
					for(int i=0;i<cols;i++) {
						colName[i]=rsmd.getColumnName(i+1);
					}
					
					
					model.setColumnIdentifiers(colName);
					String bookingid,carid,plateno,carmodel,capacity,price,username,duration,totalprice;
					
					while (result.next()) {
						bookingid = result.getString(1);
						carid = result.getString(2);
						plateno = result.getString(3);
						carmodel = result.getString(4);
						capacity = result.getString(5);
						price = result.getString(6);
						username = result.getString(7);
						duration = result.getString(8);
						totalprice = result.getString(9);
						
						String[] row = {bookingid,carid,plateno,carmodel,capacity,price,username,duration,totalprice};
						model.addRow(row);
					}
					
				} catch (Exception le) {
					le.printStackTrace();
				}
				
			}
		});
		LoadHistoryButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
		LoadHistoryButton.setBounds(31, 415, 191, 43);
		panel.add(LoadHistoryButton);
		
		JButton PreviousPageButton = new JButton("Previous Page");
		PreviousPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
        		AdminMenu adminmenu = new AdminMenu();
        		adminmenu.setVisible(true);
				
			}
		});
		PreviousPageButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 22));
		PreviousPageButton.setBounds(500, 466, 259, 74);
		panel.add(PreviousPageButton);
	}

}
