import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;

public class Teacher extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher frame = new Teacher();
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
	public Teacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFormattedTextField frmtdtxtfldUsernam = new JFormattedTextField();
		frmtdtxtfldUsernam.setText("Username: ");
		frmtdtxtfldUsernam.setBounds(93, 75, 225, 36);
		contentPane.add(frmtdtxtfldUsernam);
		
		JFormattedTextField frmtdtxtfldPassword = new JFormattedTextField();
		frmtdtxtfldPassword.setText("Password: ");
		frmtdtxtfldPassword.setBounds(93, 109, 225, 36);
		contentPane.add(frmtdtxtfldPassword);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(103, 174, 89, 23);
		contentPane.add(btnLogIn);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage m = new MainPage();
				m.setVisible(true);
			}
		});
		btnBack.setBounds(229, 174, 89, 23);
		contentPane.add(btnBack);
		
		JTextArea txtrPleaseEnterUsername = new JTextArea();
		txtrPleaseEnterUsername.setText("Please enter username and password:");
		txtrPleaseEnterUsername.setLineWrap(true);
		txtrPleaseEnterUsername.setForeground(Color.RED);
		txtrPleaseEnterUsername.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtrPleaseEnterUsername.setEditable(false);
		txtrPleaseEnterUsername.setBackground(SystemColor.menu);
		txtrPleaseEnterUsername.setBounds(10, 23, 395, 41);
		contentPane.add(txtrPleaseEnterUsername);
	}
}
