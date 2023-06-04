import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class UserRegistration extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JLabel icnum;
    private JTextField ticnum;
    private JTextField email;
    private JLabel add;
    private JTextArea tadd;
    private JTextField username;
    private JTextField mob;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JCheckBox term;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    UserRegistration frame = new UserRegistration();
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

    public UserRegistration() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 700);

        setResizable(true);
        setTitle("Customer Registration Form");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ticnum = new JTextField();
        ticnum.setFont(new Font("Tahoma", Font.PLAIN, 15));
        ticnum.setSize(228, 30);
        ticnum.setLocation(214, 200);
        contentPane.add(ticnum);
        
        JPanel CustomerRegistrationPanel = new JPanel();
        CustomerRegistrationPanel.setBackground(Color.PINK);
        CustomerRegistrationPanel.setBounds(0, 0, 1000, 663);
                CustomerRegistrationPanel.setLayout(null);
        
                btnNewButton = new JButton("Register");
                btnNewButton.setBounds(214, 527, 194, 75);
                btnNewButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (term.isSelected()) {
                            String fullName = firstname.getText();
                            String icnumber = ticnum.getText();
                            String address = tadd.getText();
                            String emailId = email.getText();
                            String userName = username.getText();
                            String mobileNumber = mob.getText();
                            int len = mobileNumber.length();
                            int iclen = icnumber.length();
                            String password = passwordField.getText();

                            String msg = "" + fullName;
                            msg += " \n";
                            if (len != 10)
                            {
                                JOptionPane.showMessageDialog(btnNewButton, "Enter a valid Mobile number");
                            }
                            if(iclen != 12)
                            {
                                JOptionPane.showMessageDialog(btnNewButton, "Enter a valid Identification card number");
                            }
                            try {
                                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcrms", "root", "");

                                String query = "INSERT INTO CarCustomer values('" + fullName + "','" + icnumber + "','" + address + "','" + userName + "','" +
                                        password + "','" + emailId + "','" + mobileNumber + "')";

                                Statement sta = connection.createStatement();
                                int x = sta.executeUpdate(query);
                                if (x == 0) {
                                    JOptionPane.showMessageDialog(btnNewButton, "This is already exist");
                                } else {
                                    JOptionPane.showMessageDialog(btnNewButton,
                                            "Welcome, " + msg + "Your account is sucessfully created");
                                    //WILL GO TO CUSTOMER LOGIN PAGE
                                }
                                connection.close();
                            } catch (Exception exception) {
                                exception.printStackTrace();
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(btnNewButton, "Please Validate the License Number");
                        }
                    }
                });
                btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 22));
                
                        JLabel lblNewUserRegister = new JLabel("Customer Registration");
                        lblNewUserRegister.setBounds(273, 43, 458, 50);
                        lblNewUserRegister.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
                        
                                JLabel lblName = new JLabel("Full Name:");
                                lblName.setBounds(58, 140, 129, 43);
                                lblName.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
                                
                                        firstname = new JTextField();
                                        firstname.setBounds(214, 145, 228, 30);
                                        firstname.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                        firstname.setColumns(10);
                                        
                                        
                                                icnum = new JLabel("IC Number:");
                                                icnum.setBounds(57, 205, 130, 20);
                                                icnum.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
                                                
                                                        add = new JLabel("Address:");
                                                        add.setBounds(58, 250, 100, 20);
                                                        CustomerRegistrationPanel.add(add);
                                                        add.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
                                                        contentPane.add(CustomerRegistrationPanel);
                                                        CustomerRegistrationPanel.add(btnNewButton);
                                                        CustomerRegistrationPanel.add(lblNewUserRegister);
                                                        CustomerRegistrationPanel.add(lblName);
                                                        CustomerRegistrationPanel.add(firstname);
                                                        CustomerRegistrationPanel.add(icnum);
                                                        
                                                                tadd = new JTextArea();
                                                                tadd.setBounds(214, 250, 228, 75);
                                                                CustomerRegistrationPanel.add(tadd);
                                                                tadd.setFont(new Font("Tahoma", Font.PLAIN, 15));
                                                                tadd.setLineWrap(true);
                                                                
                                                                
                                                                        JLabel lblEmailAddress = new JLabel("Email Address:");
                                                                        lblEmailAddress.setBounds(46, 345, 158, 36);
                                                                        CustomerRegistrationPanel.add(lblEmailAddress);
                                                                        lblEmailAddress.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
                                                                        
                                                                                email = new JTextField();
                                                                                email.setBounds(214, 347, 228, 30);
                                                                                CustomerRegistrationPanel.add(email);
                                                                                email.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                                                email.setColumns(10);
                                                                                
                                                                                        JLabel lblUsername = new JLabel("Username:");
                                                                                        lblUsername.setBounds(556, 149, 121, 25);
                                                                                        CustomerRegistrationPanel.add(lblUsername);
                                                                                        lblUsername.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
                                                                                        
                                                                                                JLabel lblPassword = new JLabel("Password:");
                                                                                                lblPassword.setBounds(556, 250, 121, 25);
                                                                                                CustomerRegistrationPanel.add(lblPassword);
                                                                                                lblPassword.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
                                                                                                
                                                                                                        passwordField = new JPasswordField();
                                                                                                        passwordField.setBounds(703, 244, 228, 30);
                                                                                                        CustomerRegistrationPanel.add(passwordField);
                                                                                                        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                                                                        
                                                                                                                JLabel lblMobileNumber = new JLabel("Mobile number:");
                                                                                                                lblMobileNumber.setBounds(528, 350, 165, 25);
                                                                                                                CustomerRegistrationPanel.add(lblMobileNumber);
                                                                                                                lblMobileNumber.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 20));
                                                                                                                
                                                                                                                        mob = new JTextField();
                                                                                                                        mob.setBounds(703, 347, 228, 30);
                                                                                                                        CustomerRegistrationPanel.add(mob);
                                                                                                                        mob.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                                                                                        mob.setColumns(10);
                                                                                                                        
                                                                                                                                username = new JTextField();
                                                                                                                                username.setBounds(703, 145, 228, 30);
                                                                                                                                CustomerRegistrationPanel.add(username);
                                                                                                                                username.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                                                                                                                username.setColumns(10);
                                                                                                                                
                                                                                                                                        term = new JCheckBox("Valid License Number");
                                                                                                                                        term.setBounds(361, 433, 271, 50);
                                                                                                                                        CustomerRegistrationPanel.add(term);
                                                                                                                                        term.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 18));
                                                                                                                                        
                                                                                                                                        JButton MainMenuButton = new JButton("Main Menu");
                                                                                                                                        MainMenuButton.addActionListener(new ActionListener() {
                                                                                                                                        	public void actionPerformed(ActionEvent e) {
                                                                                                                                        		
                                                                                                                                        		dispose();
                                                                                                                                        		mainmenu menu = new mainmenu();
                                                                                                                                        		menu.setVisible(true);
                                                                                                                                        		
                                                                                                                                        	}
                                                                                                                                        });
                                                                                                                                        MainMenuButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 22));
                                                                                                                                        MainMenuButton.setBounds(583, 527, 194, 75);
                                                                                                                                        CustomerRegistrationPanel.add(MainMenuButton);
    }
}
