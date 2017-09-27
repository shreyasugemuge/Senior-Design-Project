import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class UploadPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtWelcome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UploadPage frame = new UploadPage();
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
	public UploadPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtWelcome = new JTextField();
		txtWelcome.setText("WELCOME");
		txtWelcome.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtWelcome.setEditable(false);
		txtWelcome.setColumns(10);
		txtWelcome.setBackground(UIManager.getColor("Button.background"));
		txtWelcome.setBounds(149, 12, 137, 35);
		contentPane.add(txtWelcome);
		
		JButton btnUpload = new JButton("Upload...");
		btnUpload.setBounds(138, 121, 137, 23);
		contentPane.add(btnUpload);
		
		JButton btnUpload_1 = new JButton("Upload...");
		btnUpload_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpload_1.setBounds(138, 169, 137, 23);
		contentPane.add(btnUpload_1);
		
		JTextPane txtpnGradeFile = new JTextPane();
		txtpnGradeFile.setBackground(new Color(218, 165, 32));
		txtpnGradeFile.setEditable(false);
		txtpnGradeFile.setText("Grade file:");
		txtpnGradeFile.setBounds(69, 121, 59, 23);
		contentPane.add(txtpnGradeFile);
		
		JTextPane txtpnLogFile = new JTextPane();
		txtpnLogFile.setText("Log file:");
		txtpnLogFile.setEditable(false);
		txtpnLogFile.setBackground(new Color(218, 165, 32));
		txtpnLogFile.setBounds(69, 169, 59, 23);
		contentPane.add(txtpnLogFile);
		
		JButton btnLogOff = new JButton("Log off");
		btnLogOff.setBounds(98, 215, 89, 23);
		contentPane.add(btnLogOff);
		
		JButton btnNewButton = new JButton("Proccess");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentInfo si = new StudentInfo();
				si.setVisible(true);
			}
		});
		btnNewButton.setBounds(319, 140, 90, 35);
		contentPane.add(btnNewButton);
		
		JButton btnMainPage = new JButton("Main page");
		btnMainPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage m = new MainPage();
				m.setVisible(true);
			}
		});
		btnMainPage.setBounds(207, 215, 112, 23);
		contentPane.add(btnMainPage);
		
		JTextArea txtrPleaseUploadGrade = new JTextArea();
		txtrPleaseUploadGrade.setText("Please upload grade and log files:");
		txtrPleaseUploadGrade.setLineWrap(true);
		txtrPleaseUploadGrade.setForeground(Color.RED);
		txtrPleaseUploadGrade.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtrPleaseUploadGrade.setEditable(false);
		txtrPleaseUploadGrade.setBackground(SystemColor.menu);
		txtrPleaseUploadGrade.setBounds(14, 69, 395, 41);
		contentPane.add(txtrPleaseUploadGrade);
	}
}
