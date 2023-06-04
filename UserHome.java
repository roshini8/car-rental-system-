import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class UserHome extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField UsernameTextField;

    public void username_update(String username) {
		
		UsernameTextField.setText(username);
	}
    /**
     * Launch the application.
     */
   /* public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserHome frame = new UserHome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/


//String userSes
    /**
     * Create the frame.
     */
    public UserHome(String userSes) {
    	setTitle("Home");

    	JButton SelectCarButton = new JButton("Select car");
    	SelectCarButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
    	SelectCarButton.setBounds(250, 232, 176, 21);
    	getContentPane().add(SelectCarButton);
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JButton btnNewButton = new JButton("Log Out");
        btnNewButton.setForeground(UIManager.getColor("CheckBox.foreground"));
        btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure to log out?","Confirm Dialog",JOptionPane.YES_NO_OPTION);
                
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    Gui obj = new Gui();
                    obj.setTitle("Student-Login");
                    obj.setVisible(true);
                }
              
            }
        });
        btnNewButton.setBounds(240, 385, 491, 114);
        contentPane.add(btnNewButton);
        JButton button = new JButton("Change-password\r\n");
        button.setForeground(UIManager.getColor("CheckBox.foreground"));
        button.setBackground(UIManager.getColor("Button.disabledForeground"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangePassword bo = new ChangePassword(userSes);
                bo.setTitle("Change Password");
                bo.setVisible(true);

            }
        });
        button.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
        button.setBounds(240, 224, 491, 114);
        contentPane.add(button);
        
        JButton RentCarButton = new JButton("Rent a Car");
        RentCarButton.setForeground(UIManager.getColor("CheckBox.foreground"));
        RentCarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 String userName = UsernameTextField.getText();
        		 
        		 SelectCarType selectcartype = new SelectCarType();
        		 dispose();
        		 selectcartype.eusername_update(userName);
        		 selectcartype.pusername_update(userName);
        		 selectcartype.lusername_update(userName);
				 selectcartype.setVisible(true);
        	}
        });
        RentCarButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 35));
        RentCarButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        RentCarButton.setBounds(240, 65, 491, 114);
        contentPane.add(RentCarButton);
        
        UsernameTextField = new JTextField();
        UsernameTextField.setForeground(UIManager.getColor("CheckBox.foreground"));
        UsernameTextField.setBackground(UIManager.getColor("Button.disabledForeground"));
        UsernameTextField.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 18));
        UsernameTextField.setEditable(false);
        UsernameTextField.setBounds(10, 10, 379, 34);
        contentPane.add(UsernameTextField);
        UsernameTextField.setColumns(10);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(216, 191, 216));
        panel.setBounds(0, 0, 1000, 560);
        contentPane.add(panel);
    }
}
