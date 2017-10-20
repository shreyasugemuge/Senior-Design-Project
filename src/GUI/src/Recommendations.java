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
import java.awt.SystemColor;

public class Recommendations extends JFrame {

	private JPanel contentPane;
	private JTextField txtRecommendations;
	private JTextField textField;

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
		txtRecommendations.setBounds(22, 11, 276, 22);
		contentPane.add(txtRecommendations);
		
		JTextArea txtrRv = new JTextArea();
		txtrRv.setEditable(false);
		txtrRv.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtrRv.setBackground(UIManager.getColor("Button.background"));
		txtrRv.setText("Current Grade: 91%");
		txtrRv.setBounds(145, 37, 128, 22);
		contentPane.add(txtrRv);
		
		JButton btnLogOff = new JButton("Log off");
		btnLogOff.setBounds(110, 218, 89, 23);
		contentPane.add(btnLogOff);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseClass c = new ChooseClass();
				c.setVisible(true);
			}
		});
		btnBack.setBounds(209, 218, 89, 23);
		contentPane.add(btnBack);
		
		JTextPane txtpnBehp = new JTextPane();
		txtpnBehp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnBehp.setText("BEHP 5000");
		txtpnBehp.setEditable(false);
		txtpnBehp.setBackground(new Color(218, 165, 32));
		txtpnBehp.setBounds(46, 36, 89, 23);
		contentPane.add(txtpnBehp);
		
		textField = new JTextField();
		textField.setBounds(35, 228, -867, -243);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrBehavior = new JTextArea();
		txtrBehavior.setEditable(false);
		txtrBehavior.setText("Behavior:");
		txtrBehavior.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtrBehavior.setBackground(Color.LIGHT_GRAY);
		txtrBehavior.setBounds(10, 70, 143, 22);
		contentPane.add(txtrBehavior);
		
		JTextArea txtrCurrent = new JTextArea();
		txtrCurrent.setEditable(false);
		txtrCurrent.setText("Current:");
		txtrCurrent.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtrCurrent.setBackground(Color.LIGHT_GRAY);
		txtrCurrent.setBounds(155, 70, 103, 22);
		contentPane.add(txtrCurrent);
		
		JTextArea txtrReccommendation = new JTextArea();
		txtrReccommendation.setEditable(false);
		txtrReccommendation.setText("Reccommendation:");
		txtrReccommendation.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtrReccommendation.setBackground(Color.LIGHT_GRAY);
		txtrReccommendation.setBounds(260, 70, 164, 22);
		contentPane.add(txtrReccommendation);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(10, 93, 143, 22);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textArea_1.setBackground(Color.LIGHT_GRAY);
		textArea_1.setBounds(10, 116, 143, 22);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textArea_2.setBackground(Color.LIGHT_GRAY);
		textArea_2.setBounds(10, 139, 143, 22);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setEditable(false);
		textArea_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textArea_3.setBackground(Color.LIGHT_GRAY);
		textArea_3.setBounds(10, 162, 143, 22);
		contentPane.add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setEditable(false);
		textArea_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textArea_4.setBackground(Color.LIGHT_GRAY);
		textArea_4.setBounds(10, 185, 143, 22);
		contentPane.add(textArea_4);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setEditable(false);
		textArea_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textArea_5.setBackground(Color.LIGHT_GRAY);
		textArea_5.setBounds(155, 93, 103, 22);
		contentPane.add(textArea_5);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setEditable(false);
		textArea_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textArea_6.setBackground(Color.LIGHT_GRAY);
		textArea_6.setBounds(155, 116, 103, 22);
		contentPane.add(textArea_6);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setEditable(false);
		textArea_7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textArea_7.setBackground(Color.LIGHT_GRAY);
		textArea_7.setBounds(155, 139, 103, 22);
		contentPane.add(textArea_7);
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setEditable(false);
		textArea_8.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textArea_8.setBackground(Color.LIGHT_GRAY);
		textArea_8.setBounds(155, 162, 103, 22);
		contentPane.add(textArea_8);
		
		JTextArea textArea_9 = new JTextArea();
		textArea_9.setEditable(false);
		textArea_9.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textArea_9.setBackground(Color.LIGHT_GRAY);
		textArea_9.setBounds(155, 185, 103, 22);
		contentPane.add(textArea_9);
		
		JTextArea textArea_10 = new JTextArea();
		textArea_10.setEditable(false);
		textArea_10.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textArea_10.setBackground(Color.LIGHT_GRAY);
		textArea_10.setBounds(260, 93, 164, 22);
		contentPane.add(textArea_10);
		
		JTextArea textArea_11 = new JTextArea();
		textArea_11.setEditable(false);
		textArea_11.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textArea_11.setBackground(Color.LIGHT_GRAY);
		textArea_11.setBounds(260, 116, 164, 22);
		contentPane.add(textArea_11);
		
		JTextArea textArea_12 = new JTextArea();
		textArea_12.setEditable(false);
		textArea_12.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textArea_12.setBackground(Color.LIGHT_GRAY);
		textArea_12.setBounds(260, 139, 164, 22);
		contentPane.add(textArea_12);
		
		JTextArea textArea_13 = new JTextArea();
		textArea_13.setEditable(false);
		textArea_13.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textArea_13.setBackground(Color.LIGHT_GRAY);
		textArea_13.setBounds(260, 162, 164, 22);
		contentPane.add(textArea_13);
		
		JTextArea textArea_14 = new JTextArea();
		textArea_14.setEditable(false);
		textArea_14.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textArea_14.setBackground(Color.LIGHT_GRAY);
		textArea_14.setBounds(260, 185, 164, 22);
		contentPane.add(textArea_14);
	}
}
