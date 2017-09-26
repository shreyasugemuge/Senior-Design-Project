import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTextPane;

public class StudentInfo extends JFrame {

	private JPanel contentPane;
	private JTextField txtTeacher;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfo frame = new StudentInfo();
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
	public StudentInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Extract Performance");
		btnNewButton.setBounds(216, 80, 164, 30);
		contentPane.add(btnNewButton);
		
		JButton btnExtractBehaviors = new JButton("Extract Behaviors");
		btnExtractBehaviors.setBounds(216, 121, 164, 30);
		contentPane.add(btnExtractBehaviors);
		
		JButton btnReccommendatios = new JButton("Recommendations");
		btnReccommendatios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recommendations r = new Recommendations();
				r.setVisible(true);
			}
		});
		btnReccommendatios.setBounds(216, 162, 164, 30);
		contentPane.add(btnReccommendatios);
		
		JComboBox comboBox = new JComboBox();
		
		for (int i =1; i < 111; i++) {
			comboBox.addItem(i);
		}
		
		comboBox.setBounds(91, 97, 99, 23);
		contentPane.add(comboBox);
		
		txtTeacher = new JTextField();
		txtTeacher.setBackground(UIManager.getColor("Button.background"));
		txtTeacher.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 36));
		txtTeacher.setEditable(false);
		txtTeacher.setText("WELCOME");
		txtTeacher.setBounds(142, 11, 147, 58);
		contentPane.add(txtTeacher);
		txtTeacher.setColumns(10);
		
		JButton btnMainPage = new JButton("Main Page");
		btnMainPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MainPage m = new MainPage();
				m.setVisible(true);
			}
		});
		btnMainPage.setBounds(115, 214, 104, 23);
		contentPane.add(btnMainPage);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(229, 214, 89, 23);
		contentPane.add(btnLogOut);
		
		JTextPane txtpnStudent = new JTextPane();
		txtpnStudent.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnStudent.setText("Student:");
		txtpnStudent.setEditable(false);
		txtpnStudent.setBackground(new Color(218, 165, 32));
		txtpnStudent.setBounds(32, 97, 59, 23);
		contentPane.add(txtpnStudent);
	}
}
