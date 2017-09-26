import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class Recommendations extends JFrame {

	private JPanel contentPane;
	private JTextField txtRecommendations;
	private JLabel txtHomework;
	private JLabel txtSpendAt;
	private JLabel txtStartStuding;
	private JLabel txtAttendAt;
	private JTextField textField;
	private JLabel txtParticipateIn;
	private JLabel lblSpendAt;
	private JLabel lblDoNotMiss;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recommendations frame = new Recommendations();
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
	public Recommendations() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtRecommendations = new JTextField();
		txtRecommendations.setText("Recommendation Report");
		txtRecommendations.setFont(new Font("Tahoma", Font.BOLD, 21));
		txtRecommendations.setEditable(false);
		txtRecommendations.setColumns(10);
		txtRecommendations.setBackground(UIManager.getColor("Button.background"));
		txtRecommendations.setBounds(22, 11, 276, 32);
		contentPane.add(txtRecommendations);
		
		JTextArea txtrRv = new JTextArea();
		txtrRv.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtrRv.setBackground(UIManager.getColor("Button.background"));
		txtrRv.setText("Current Grade: 91%");
		txtrRv.setBounds(170, 55, 128, 22);
		contentPane.add(txtrRv);
		
		JButton btnLogOff = new JButton("Log off");
		btnLogOff.setBounds(111, 215, 89, 23);
		contentPane.add(btnLogOff);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseClass c = new ChooseClass();
				c.setVisible(true);
			}
		});
		btnBack.setBounds(210, 215, 89, 23);
		contentPane.add(btnBack);
		
		txtHomework = new JLabel();
		txtHomework.setBackground(UIManager.getColor("Button.background"));
		txtHomework.setText("- Start working on assignments 5 days before due date.\r\n");
		txtHomework.setBounds(22, 79, 414, 22);
		contentPane.add(txtHomework);
		
		JTextPane txtpnBehp = new JTextPane();
		txtpnBehp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnBehp.setText("BEHP 5000");
		txtpnBehp.setEditable(false);
		txtpnBehp.setBackground(new Color(218, 165, 32));
		txtpnBehp.setBounds(48, 54, 89, 23);
		contentPane.add(txtpnBehp);
		
		txtSpendAt = new JLabel();
		txtSpendAt.setText("- Spend at least 2 hours a day reading upcoming materials.\r\n");
		txtSpendAt.setBounds(22, 124, 359, 14);
		contentPane.add(txtSpendAt);
		
		txtStartStuding = new JLabel();
		txtStartStuding.setText("- Start studing for an exam 4 days before the exam date.\r\n");
		txtStartStuding.setBounds(22, 142, 391, 14);
		contentPane.add(txtStartStuding);
		
		txtAttendAt = new JLabel();
		txtAttendAt.setText("- Attend at least 4 unit discussions.\r\n");
		txtAttendAt.setBounds(22, 96, 314, 14);
		contentPane.add(txtAttendAt);
		
		textField = new JTextField();
		textField.setBounds(35, 228, -867, -243);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtParticipateIn = new JLabel();
		txtParticipateIn.setText("- Participate in at least 3 bonus points activities.");
		txtParticipateIn.setBounds(22, 157, 316, 12);
		contentPane.add(txtParticipateIn);
		
		lblSpendAt = new JLabel("- Spend at least 1 hour for each unit studying for the final exam.");
		lblSpendAt.setBounds(22, 111, 379, 14);
		contentPane.add(lblSpendAt);
		
		lblDoNotMiss = new JLabel("- Do not miss more than 2 online meetings.");
		lblDoNotMiss.setBounds(22, 174, 305, 14);
		contentPane.add(lblDoNotMiss);
	}

}
