import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu frame = new AdminMenu();
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
	public AdminMenu() {
		setTitle("Admin Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 684);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 153, 102));
		panel.setBounds(0, 0, 865, 647);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel Title = new JLabel("Admin Menu", SwingConstants.CENTER);
		Title.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 35));
		Title.setBounds(133, 44, 581, 39);
		panel.add(Title);
		
		JButton AddCarButton = new JButton();
		AddCarButton.setText("Car Registration");
		AddCarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
        		AddCar addcar = new AddCar();
        		addcar.setVisible(true);
				
			}
		});
		AddCarButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
		AddCarButton.setFocusable(false);
		AddCarButton.setBackground(new Color(152, 251, 152));
		AddCarButton.setBounds(202, 134, 447, 68);
		panel.add(AddCarButton);
		
		JButton DeleteCarButton = new JButton();
		DeleteCarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
        		DeleteCar deletecar = new DeleteCar();
        		deletecar.setVisible(true);
			
			}
		});
		DeleteCarButton.setText("Delete A Car");
		DeleteCarButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
		DeleteCarButton.setFocusable(false);
		DeleteCarButton.setBackground(new Color(0, 206, 209));
		DeleteCarButton.setBounds(202, 240, 447, 68);
		panel.add(DeleteCarButton);
		
		JButton BookingHistoryButton = new JButton();
		BookingHistoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
         		BookingHistory bookinghistory = new BookingHistory();
         		bookinghistory.setVisible(true);
				
			}
		});
		BookingHistoryButton.setText("Booking History");
		BookingHistoryButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
		BookingHistoryButton.setFocusable(false);
		BookingHistoryButton.setBackground(new Color(216, 191, 216));
		BookingHistoryButton.setBounds(202, 349, 447, 68);
		panel.add(BookingHistoryButton);
		
		JButton LogOutButton = new JButton();
		LogOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = JOptionPane.showConfirmDialog(LogOutButton, "Are you sure to log out?","Confirm Dialog",JOptionPane.YES_NO_OPTION);
                
                if (a == JOptionPane.YES_OPTION) {
                    
                    dispose();
            		mainmenu menu = new mainmenu();
            		menu.setVisible(true);
                }
				
				
			}
		});
		LogOutButton.setText("Log Out");
		LogOutButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
		LogOutButton.setFocusable(false);
		LogOutButton.setBackground(new Color(240, 128, 128));
		LogOutButton.setBounds(202, 454, 449, 68);
		panel.add(LogOutButton);
	}
}

