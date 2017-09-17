import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdentity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setText("Sign Up");
		textArea.setLineWrap(true);
		textArea.setForeground(Color.GRAY);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 26));
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(174, 11, 116, 39);
		contentPane.add(textArea);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setText("First Name: ");
		formattedTextField.setBounds(61, 61, 335, 27);
		contentPane.add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setText("Last Name: ");
		formattedTextField_1.setBounds(61, 86, 335, 27);
		contentPane.add(formattedTextField_1);
		
		JFormattedTextField frmtdtxtfldEmail = new JFormattedTextField();
		frmtdtxtfldEmail.setText("Email:  ");
		frmtdtxtfldEmail.setBounds(61, 112, 335, 27);
		contentPane.add(frmtdtxtfldEmail);
		
		JFormattedTextField frmtdtxtfldPassword = new JFormattedTextField();
		frmtdtxtfldPassword.setText("Password: ");
		frmtdtxtfldPassword.setBounds(61, 137, 335, 27);
		contentPane.add(frmtdtxtfldPassword);
		
		JFormattedTextField frmtdtxtfldConfirmPassword = new JFormattedTextField();
		frmtdtxtfldConfirmPassword.setText("Confirm Password: ");
		frmtdtxtfldConfirmPassword.setBounds(61, 162, 335, 27);
		contentPane.add(frmtdtxtfldConfirmPassword);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(223, 188, 173, 20);
		comboBox.addItem("Student");
		comboBox.addItem("Teacher");
		contentPane.add(comboBox);
		
		txtIdentity = new JTextField();
		txtIdentity.setEditable(false);
		txtIdentity.setText("Identity:");
		txtIdentity.setColumns(10);
		txtIdentity.setBounds(61, 188, 166, 20);
		contentPane.add(txtIdentity);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(125, 219, 89, 23);
		contentPane.add(btnSignUp);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage m = new MainPage();
				m.setVisible(true);
				
			}
		});
		btnBack.setBounds(262, 219, 89, 23);
		contentPane.add(btnBack);
	}
}
