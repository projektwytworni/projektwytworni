package logowanko;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.JTable;

@SuppressWarnings("unused")
public class UserHome extends JFrame {

    private static final long serialVersionUID = 1 ;
    private JPanel contentPane;
    private JLabel label;
    private JLabel lblNewLabel;

    
    public static void main(String[] args) {
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
    }

    public UserHome() {
    	getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1280, 720);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.ORANGE);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblNewLabel = new JLabel("Panel użytkownika");
        lblNewLabel.setFont(new Font("Channel", Font.PLAIN, 20));
        lblNewLabel.setBounds(656, 6, 314, 39);
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton_2 = new JButton("Wyloguj");
        btnNewButton_2.setBounds(552, 41, 124, 29);
        contentPane.add(btnNewButton_2);
        btnNewButton_2.setFont(new Font("Channel", Font.PLAIN, 13));
        label = new JLabel("");
        label.setIcon(new ImageIcon("/Users/szymonmarczak/eclipse-workspace/Wytwornia/png/layout ogólny.png"));
        label.setBackground(Color.DARK_GRAY);
        label.setBounds(0, 0, 1280, 720);
        contentPane.add(label);
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 int a = JOptionPane.showConfirmDialog(btnNewButton_2, "Jestes pewien ?");
                 
                 if (a == JOptionPane.YES_OPTION) {
                     dispose();
                     UserLogin obj = new UserLogin();
                 
                     obj.setVisible(true);
                 }
                 dispose();
                 UserLogin obj = new UserLogin();

               
                 obj.setVisible(true);

             }
        	
        });
    }

  
    public UserHome(String userSes) {

       /* setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1280, 720);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.ORANGE);
        setContentPane(contentPane);
        contentPane.setLayout(null);
    	JButton btnNewButton_1 = new JButton("New button");
    	btnNewButton_1.setBounds(162, 94, 117, 29);
    	getContentPane().add(btnNewButton_1);
        JButton btnNewButton = new JButton("Wyloguj");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 39));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(btnNewButton, "Jestes pewien ?");
                
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    UserLogin obj = new UserLogin();
                
                    obj.setVisible(true);
                }
                dispose();
                UserLogin obj = new UserLogin();

              
                obj.setVisible(true);

            }
        });
        btnNewButton.setBounds(247, 118, 491, 114);
        contentPane.add(btnNewButton);
        JButton button = new JButton("Zmień hasło\r\n");
        button.setBackground(UIManager.getColor("Button.disabledForeground"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangePassword bo = new ChangePassword(userSes);
                bo.setTitle("Zmien haslo");
                bo.setVisible(true);

            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 35));
        button.setBounds(247, 320, 491, 114);
        contentPane.add(button);
  */  
    	getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1280, 720);
        setResizable(false);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JButton btnNewButton_2 = new JButton("Wyloguj");
        menuBar.add(btnNewButton_2);
        btnNewButton_2.setFont(new Font("Channel", Font.PLAIN, 13));
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 int a = JOptionPane.showConfirmDialog(btnNewButton_2, "Jestes pewien ?");
                 
                 if (a == JOptionPane.YES_OPTION) {
                     dispose();
                     UserLogin obj = new UserLogin();
                 
                     obj.setVisible(true);
                 }else {
                	 
                 }
                 

               
                 

             }
        	
        });
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.ORANGE);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblNewLabel = new JLabel("Panel użytkownika");
        lblNewLabel.setFont(new Font("Channel", Font.PLAIN, 20));
        lblNewLabel.setBounds(656, 6, 314, 39);
        contentPane.add(lblNewLabel);
        label = new JLabel("");
        label.setIcon(new ImageIcon("/Users/szymonmarczak/eclipse-workspace/Wytwornia/png/layout ogólny.png"));
        label.setBackground(Color.DARK_GRAY);
        label.setBounds(0, 0, 1280, 720);
        contentPane.add(label);
        
    }
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
		
	}
}