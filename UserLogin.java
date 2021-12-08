package logowanko;

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
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

@SuppressWarnings("unused")
public class UserLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField email;
    private JPasswordField pass;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;
    private JButton btnNewButton_1;
    private JTextField email_rej;
    private JPasswordField pass_rej;
    private JPasswordField pass2_rej;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin frame = new UserLogin();
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
    public UserLogin() {
    	setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1280, 720);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(Color.ORANGE);
        contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        email = new JTextField();
        email.setCaretColor(Color.BLACK);
        email.setBorder(new LineBorder(Color.GREEN, 2, true));
        email.setForeground(Color.BLACK);
        email.setBackground(Color.WHITE);
        email.setFont(new Font("Avenir", Font.PLAIN, 32));
        email.setBounds(188, 314, 227, 40);
        contentPane.add(email);
        email.setColumns(10);

        pass = new JPasswordField();
        pass.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN));
        pass.setToolTipText("");
        pass.setForeground(Color.BLACK);
        pass.setBackground(Color.WHITE);
        pass.setFont(new Font("Avenir", Font.PLAIN, 32));
        pass.setBounds(188, 410, 227, 40);
        contentPane.add(pass);

        JLabel lblUsername = new JLabel("Email");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setFont(new Font("Channel", Font.PLAIN, 23));
        lblUsername.setBounds(246, 247, 132, 68);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Hasło");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Channel", Font.PLAIN, 23));
        lblPassword.setBounds(246, 350, 132, 68);
        contentPane.add(lblPassword);

        btnNewButton = new JButton("Zaloguj");
        btnNewButton.setBorder(UIManager.getBorder("DesktopIcon.border"));
        btnNewButton.setForeground(Color.DARK_GRAY);
        btnNewButton.setBackground(Color.PINK);
        btnNewButton.setFont(new Font("Channel", Font.PLAIN, 13));
        btnNewButton.setBounds(246, 468, 106, 48);
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String userName = email.getText();
                @SuppressWarnings("deprecation")
				String password = pass.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/wytwornia",
                        "root", "");

                    PreparedStatement stmt = (PreparedStatement) connection
                        .prepareStatement("Select email, password from users where email=? and password=?");

                    stmt.setString(1, userName);
                    stmt.setString(2, password);
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        dispose();
                        UserHome ah = new UserHome(userName);
                        ah.setTitle("Witamy w wytwórni filmowej");
                        ah.setVisible(true);
                        JOptionPane.showMessageDialog(btnNewButton, "Logowanie poprawne");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Zle haslo lub email");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        contentPane.add(btnNewButton);
        
        btnNewButton_1 = new JButton("Nie pamiętam hasła");
        btnNewButton_1.setForeground(Color.DARK_GRAY);
        btnNewButton_1.setFont(new Font("Channel", Font.PLAIN, 13));
        btnNewButton_1.setBackground(Color.PINK);
        btnNewButton_1.setBounds(188, 528, 227, 48);
        contentPane.add(btnNewButton_1);
                
        JLabel lblNewLabel = new JLabel("Zaloguj");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Channel", Font.PLAIN, 35));
        lblNewLabel.setBounds(210, 150, 243, 96);
        contentPane.add(lblNewLabel);
                        
        JLabel lblZarejestruj = new JLabel("Zarejestruj");
        lblZarejestruj.setForeground(Color.WHITE);
        lblZarejestruj.setFont(new Font("Channel", Font.PLAIN, 35));
        lblZarejestruj.setBounds(814, 150, 388, 96);
        contentPane.add(lblZarejestruj);
                                
        JLabel lblUsername_1 = new JLabel("Email");
        lblUsername_1.setForeground(Color.WHITE);
        lblUsername_1.setFont(new Font("Channel", Font.PLAIN, 23));
        lblUsername_1.setBackground(Color.BLACK);
        lblUsername_1.setBounds(888, 247, 132, 68);
        contentPane.add(lblUsername_1);
                                        
        email_rej = new JTextField();
        email_rej.setForeground(Color.BLACK);
        email_rej.setFont(new Font("Avenir", Font.PLAIN, 32));
        email_rej.setColumns(10);
        email_rej.setCaretColor(Color.BLACK);
        email_rej.setBorder(new LineBorder(Color.GREEN, 2, true));
        email_rej.setBackground(Color.WHITE);
        email_rej.setBounds(844, 314, 227, 40);
        contentPane.add(email_rej);
                                                
        JLabel lblPassword_1 = new JLabel("Hasło");
        lblPassword_1.setForeground(Color.WHITE);
        lblPassword_1.setFont(new Font("Channel", Font.PLAIN, 23));
        lblPassword_1.setBackground(Color.CYAN);
        lblPassword_1.setBounds(888, 350, 132, 68);
        contentPane.add(lblPassword_1);
                                                        
        pass_rej = new JPasswordField();
        pass_rej.setToolTipText("");
        pass_rej.setForeground(Color.BLACK);
        pass_rej.setFont(new Font("Avenir", Font.PLAIN, 32));
        pass_rej.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), Color.GREEN, Color.GREEN, Color.GREEN));
        pass_rej.setBackground(Color.WHITE);
        pass_rej.setBounds(844, 410, 227, 40);
        contentPane.add(pass_rej);
                                                                
        JLabel lblPassword_1_1 = new JLabel("Powtórz hasło");
        lblPassword_1_1.setForeground(Color.WHITE);
        lblPassword_1_1.setFont(new Font("Channel", Font.PLAIN, 23));
        lblPassword_1_1.setBackground(Color.CYAN);
        lblPassword_1_1.setBounds(844, 454, 227, 68);
        contentPane.add(lblPassword_1_1);
                                                                        
        pass2_rej = new JPasswordField();
        pass2_rej.setToolTipText("");
        pass2_rej.setForeground(Color.BLACK);
        pass2_rej.setFont(new Font("Avenir", Font.PLAIN, 32));
        pass2_rej.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN));
        pass2_rej.setBackground(Color.WHITE);
        pass2_rej.setBounds(844, 515, 227, 40);
        contentPane.add(pass2_rej);
                                                                                
        JButton btnZarejestruj = new JButton("Zarejestruj");
        btnZarejestruj.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		@SuppressWarnings({ "deprecation" })
				String pass = pass_rej.getText();
        		String email = email_rej.getText();
        		@SuppressWarnings("deprecation")
				String pass2 = pass2_rej.getText();
        		if(pass.equals(pass2) && !email.equals("") && !pass.equals("")) {
        		  try {
                      Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/wytwornia",
                          "root", "");

                      PreparedStatement stmt = (PreparedStatement) connection
                          .prepareStatement("Insert into users (email,password,code,admin) values (?,?,'0','0')");

                      stmt.setString(1, email);
                      stmt.setString(2, pass);
                      int rs = stmt.executeUpdate();
                      JOptionPane.showMessageDialog(btnNewButton, "Zarejestrowano użytkownika, możesz się zalogować");
                         	  
        	    	      } catch (SQLException sqlException) {
        	                    sqlException.printStackTrace();
        	    	      } 
        	}else {
        			JOptionPane.showMessageDialog(btnNewButton,"Błąd, możliwe rozwiązania :\n 1. Wpisz takie same hasła\n 2. Nie zostawiaj pustych pól");
        	}
        	}
        });
        btnZarejestruj.setForeground(Color.DARK_GRAY);
        btnZarejestruj.setFont(new Font("Channel", Font.PLAIN, 13));
        btnZarejestruj.setBackground(Color.PINK);
        btnZarejestruj.setBounds(888, 567, 132, 48);
        contentPane.add(btnZarejestruj);
                                                                                
        label = new JLabel("");
        label.setIcon(new ImageIcon("/Users/szymonmarczak/eclipse-workspace/Wytwornia/png/layout logowanie.png"));
        label.setBackground(Color.DARK_GRAY);
        label.setBounds(0, 0, 1280, 720);
        contentPane.add(label);
    }
}