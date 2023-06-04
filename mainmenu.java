import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainmenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainmenu frame = new mainmenu();
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
	public mainmenu() {
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 684);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 153));
		panel.setBounds(0, 0, 865, 647);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel Title = new JLabel("Payakan Car Rental System", SwingConstants.CENTER);
		Title.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 35));
		Title.setBounds(133, 44, 581, 39);
		panel.add(Title);
		
		JButton CustomerButton = new JButton();
		CustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
        		Gui gui = new Gui();
        		gui.setVisible(true);
				
			}
		});
		CustomerButton.setText("CUSTOMER LOGIN");
		CustomerButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
		CustomerButton.setFocusable(false);
		CustomerButton.setBackground(new Color(152, 251, 152));
		CustomerButton.setBounds(202, 134, 447, 68);
		panel.add(CustomerButton);
		
		JButton RegisterButton = new JButton();
		RegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
        		UserRegistration userregistration = new UserRegistration();
        		userregistration.setVisible(true);
				
			}
		});
		RegisterButton.setText("CUSTOMER REGISTER");
		RegisterButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
		RegisterButton.setFocusable(false);
		RegisterButton.setBackground(new Color(0, 206, 209));
		RegisterButton.setBounds(202, 240, 447, 68);
		panel.add(RegisterButton);
		
		JButton AdminButton = new JButton();
		AdminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
        		adminGui admingui = new adminGui();
        		admingui.setVisible(true);
				
			}
		});
		AdminButton.setText("ADMIN LOGIN");
		AdminButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
		AdminButton.setFocusable(false);
		AdminButton.setBackground(new Color(216, 191, 216));
		AdminButton.setBounds(202, 349, 447, 68);
		panel.add(AdminButton);
		
		JButton ExitButton = new JButton();
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		ExitButton.setText("EXIT");
		ExitButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
		ExitButton.setFocusable(false);
		ExitButton.setBackground(new Color(240, 128, 128));
		ExitButton.setBounds(202, 454, 449, 68);
		panel.add(ExitButton);
	}
}
