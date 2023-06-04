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

public class Gui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JPanel contentPane;
    private final JPanel LoginPanel = new JPanel();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    Gui frame = new Gui();
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
    public Gui() {
    	setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 46));
        lblNewLabel.setBounds(423, 13, 152, 93);
        contentPane.add(lblNewLabel);
        LoginPanel.setBackground(new Color(255, 222, 173));
        LoginPanel.setBounds(0, 0, 1000, 560);
        contentPane.add(LoginPanel);
                LoginPanel.setLayout(null);
        
                textField = new JTextField();
                textField.setBounds(426, 162, 283, 70);
                LoginPanel.add(textField);
                textField.setFont(new Font("Arial", Font.PLAIN, 32));
                textField.setColumns(10);
                
                        passwordField = new JPasswordField();
                        passwordField.setBounds(426, 283, 283, 68);
                        LoginPanel.add(passwordField);
                        passwordField.setFont(new Font("Arial", Font.PLAIN, 32));
                        
                                btnNewButton = new JButton("Login");
                                btnNewButton.setBounds(246, 411, 162, 73);
                                LoginPanel.add(btnNewButton);
                                btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 26));
                                
                                JButton btnMainMenu = new JButton("Main Menu");
                                btnMainMenu.addActionListener(new ActionListener() {
                                	public void actionPerformed(ActionEvent e) {
                                		
                                		dispose();
                                		mainmenu menu = new mainmenu();
                                		menu.setVisible(true);
                                	}
                                });
                                btnMainMenu.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 26));
                                btnMainMenu.setBounds(594, 411, 193, 73);
                                LoginPanel.add(btnMainMenu);
                                
                                        JLabel lblUsername = new JLabel("Username:");
                                        lblUsername.setBounds(246, 171, 193, 52);
                                        LoginPanel.add(lblUsername);
                                        lblUsername.setBackground(Color.BLACK);
                                        lblUsername.setForeground(Color.BLACK);
                                        lblUsername.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 31));
                                        
                                                JLabel lblPassword = new JLabel("Password:");
                                                lblPassword.setBounds(246, 291, 193, 52);
                                                LoginPanel.add(lblPassword);
                                                lblPassword.setForeground(Color.BLACK);
                                                lblPassword.setBackground(Color.CYAN);
                                                lblPassword.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 31));
                                btnNewButton.addActionListener(new ActionListener() {

                                    public void actionPerformed(ActionEvent e) {
                                        String userName = textField.getText();
                                        String password = passwordField.getText();

                                        try {
                                            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcrms",
                                                    "root", "");

                                            PreparedStatement st = (PreparedStatement) connection
                                                    .prepareStatement("Select user_name, password from carcustomer where user_name=? and password=?");

                                            st.setString(1, userName);
                                            st.setString(2, password);
                                            ResultSet rs = st.executeQuery();
                                            if (rs.next()) {
                                            	
                                            	dispose();
                                                UserHome ah = new UserHome(userName);
                                                ah.username_update(userName);
                                                ah.setVisible(true);
                                                JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
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

