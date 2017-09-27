import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class ChooseClass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseClass frame = new ChooseClass();
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
	public ChooseClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setText("WELCOME");
		textField.setFont(new Font("Tahoma", Font.BOLD, 26));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(UIManager.getColor("Button.background"));
		textField.setBounds(150, 24, 146, 35);
		contentPane.add(textField);
		
		JTextPane txtpnChooseClass = new JTextPane();
		txtpnChooseClass.setText("Choose Class:");
		txtpnChooseClass.setEditable(false);
		txtpnChooseClass.setBackground(new Color(218, 165, 32));
		txtpnChooseClass.setBounds(62, 70, 106, 23);
		contentPane.add(txtpnChooseClass);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("BEHP 5000");
		comboBox.setBounds(168, 70, 128, 23);
		contentPane.add(comboBox);
		
		JButton btnSubmit = new JButton("View recommendations");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recommendations r = new Recommendations();
				r.setVisible(true);
			}
		});
		btnSubmit.setBounds(119, 142, 172, 35);
		contentPane.add(btnSubmit);
		
		JButton btnLogOff = new JButton("Log off");
		btnLogOff.setBounds(100, 209, 89, 23);
		contentPane.add(btnLogOff);
		
		JButton btnMainPage = new JButton("Main Page");
		btnMainPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage m = new MainPage();
				m.setVisible(true);
			}
		});
		btnMainPage.setBounds(199, 209, 117, 23);
		contentPane.add(btnMainPage);
		
		JTextPane txtpnNumberOfWeeks = new JTextPane();
		txtpnNumberOfWeeks.setText("Number of weeks:");
		txtpnNumberOfWeeks.setEditable(false);
		txtpnNumberOfWeeks.setBackground(new Color(218, 165, 32));
		txtpnNumberOfWeeks.setBounds(62, 108, 117, 23);
		contentPane.add(txtpnNumberOfWeeks);
		
		JComboBox comboBox_1 = new JComboBox();
		for (int i = 1; i <= 16; i++) {
			comboBox_1.addItem(i);
		}
		comboBox_1.setBounds(179, 108, 117, 23);
		contentPane.add(comboBox_1);
	}

}
