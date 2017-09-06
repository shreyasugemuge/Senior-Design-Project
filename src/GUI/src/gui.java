import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.SystemColor;

public class gui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.RED);
		frame.setBounds(100, 100, 654, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrWelcomeToAbrs = new JTextArea();
		txtrWelcomeToAbrs.setLineWrap(true);
		txtrWelcomeToAbrs.setFont(new Font("Monospaced", Font.BOLD, 24));
		txtrWelcomeToAbrs.setBackground(Color.CYAN);
		txtrWelcomeToAbrs.setForeground(Color.RED);
		txtrWelcomeToAbrs.setText("WELCOME TO ABRS");
		txtrWelcomeToAbrs.setBounds(203, 51, 222, 49);
		frame.getContentPane().add(txtrWelcomeToAbrs);
		
		JTextArea txtrNotePlease = new JTextArea();
		txtrNotePlease.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtrNotePlease.setBackground(Color.LIGHT_GRAY);
		txtrNotePlease.setLineWrap(true);
		txtrNotePlease.setForeground(Color.RED);
		txtrNotePlease.setText("Note: Please choose your identity.");
		txtrNotePlease.setBounds(127, 163, 395, 41);
		frame.getContentPane().add(txtrNotePlease);
		
		JButton btnTeacher = new JButton("TEACHER");
		btnTeacher.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTeacher.setBackground(new Color(240, 240, 240));
		btnTeacher.setBounds(99, 256, 188, 63);
		frame.getContentPane().add(btnTeacher);
		
		JButton btnStudent = new JButton("STUDENT");
		btnStudent.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnStudent.setBackground(SystemColor.menu);
		btnStudent.setBounds(350, 256, 188, 63);
		frame.getContentPane().add(btnStudent);
	}
}
