import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class adminGui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JPanel contentPane;
    private JPanel panel;
    private JButton MainMenuButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    adminGui frame = new adminGui();
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
    public adminGui() {
    	setTitle("Admin Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        panel = new JPanel();
        panel.setBackground(new Color(0, 153, 153));
        panel.setBounds(0, 0, 1000, 560);
        contentPane.add(panel);
                panel.setLayout(null);
        
                JLabel lblNewLabel = new JLabel("Admin Login");
                lblNewLabel.setBounds(323, 50, 328, 54);
                panel.add(lblNewLabel);
                lblNewLabel.setForeground(Color.BLACK);
                lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 46));
                
                        JLabel lblUsername = new JLabel("Admin ID:");
                        lblUsername.setBounds(232, 168, 173, 52);
                        panel.add(lblUsername);
                        lblUsername.setBackground(Color.BLACK);
                        lblUsername.setForeground(Color.BLACK);
                        lblUsername.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 31));
                        
                                textField = new JTextField();
                                textField.setBounds(415, 161, 281, 68);
                                panel.add(textField);
                                textField.setFont(new Font("Arial", Font.PLAIN, 32));
                                textField.setColumns(10);
                                
                                        passwordField = new JPasswordField();
                                        passwordField.setBounds(415, 286, 281, 68);
                                        panel.add(passwordField);
                                        passwordField.setFont(new Font("Arial", Font.PLAIN, 32));
                                        
                                                JLabel lblPassword = new JLabel("Password:");
                                                lblPassword.setBounds(208, 293, 197, 52);
                                                panel.add(lblPassword);
                                                lblPassword.setForeground(Color.BLACK);
                                                lblPassword.setBackground(Color.CYAN);
                                                lblPassword.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 31));
                                                
                                                        btnNewButton = new JButton("Login");
                                                        btnNewButton.setBounds(266, 434, 162, 73);
                                                        panel.add(btnNewButton);
                                                        btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 26));
                                                        
                                                        MainMenuButton = new JButton("Main Menu");
                                                        MainMenuButton.addActionListener(new ActionListener() {
                                                        	public void actionPerformed(ActionEvent e) {
                                                        		
                                                        		dispose();
                                                        		mainmenu menu = new mainmenu();
                                                        		menu.setVisible(true);
                                                        		
                                                        	}
                                                        });
                                                        MainMenuButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 26));
                                                        MainMenuButton.setBounds(556, 434, 197, 73);
                                                        panel.add(MainMenuButton);
                                                        btnNewButton.addActionListener(new ActionListener() {

                                                            public void actionPerformed(ActionEvent e) {
                                                                String userName = textField.getText();
                                                                String password = passwordField.getText();

                                                                try {
                                                                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcrms",
                                                                            "root", "");

                                                                    PreparedStatement st = (PreparedStatement) connection
                                                                            .prepareStatement("Select ADMIN_ID, PASSWORD from admin where ADMIN_ID=? and PASSWORD=?");

                                                                    st.setString(1, userName);
                                                                    st.setString(2, password);
                                                                    ResultSet rs = st.executeQuery();
                                                                    if (rs.next()) {
                                                                        
                                                                        dispose();
                                                                		AdminMenu adminmenu = new AdminMenu();
                                                                		adminmenu.setVisible(true);
                                                                		
                                                                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in.");
                                                                    } else {
                                                                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                                                                    }
                                                                } catch (SQLException sqlException) {
                                                                    sqlException.printStackTrace();
                                                                }
                                                            }
                                                        });
    }
}