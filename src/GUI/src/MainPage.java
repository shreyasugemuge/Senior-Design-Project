import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText("WELCOME TO ABRS");
		textArea.setLineWrap(true);
		textArea.setForeground(Color.RED);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 24));
		textArea.setBackground(Color.CYAN);
		textArea.setBounds(107, 11, 222, 49);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setText("Note: Please choose your identity.");
		textArea_1.setLineWrap(true);
		textArea_1.setForeground(Color.RED);
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea_1.setBackground(Color.LIGHT_GRAY);
		textArea_1.setBounds(29, 79, 395, 41);
		contentPane.add(textArea_1);
		
		JButton button = new JButton("TEACHER");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Teacher t = new Teacher();
				t.setVisible(true);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setBackground(SystemColor.menu);
		button.setBounds(39, 131, 188, 63);
		contentPane.add(button);
		
		JButton button_1 = new JButton("STUDENT");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student st = new Student();
				st.setVisible(true);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		button_1.setBackground(SystemColor.menu);
		button_1.setBounds(237, 131, 188, 63);
		contentPane.add(button_1);
		
		Button button_2 = new Button("SIGN UP");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp s = new SignUp();
				s.setVisible(true);
			}
		});
		button_2.setBackground(Color.ORANGE);
		button_2.setBounds(187, 210, 98, 41);
		contentPane.add(button_2);
	}

}