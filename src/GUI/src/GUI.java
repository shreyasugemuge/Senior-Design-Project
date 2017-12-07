import java.awt.EventQueue;
import javax.swing.UIManager.*;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;

public class GUI {

	private JFrame frame;
	private JTextField textField_1;
	private JPanel MainPage;
	private JPanel Recommendations;
	private JPanel studentInfo;
	private JPanel uploadPage;
	private JPanel logOn;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel MainPage = new JPanel();
		frame.getContentPane().add(MainPage, "name_5558742978566544");
		MainPage.setLayout(null);
		MainPage.setVisible(true);
		
		JPanel uploadPage = new JPanel();
		frame.getContentPane().add(uploadPage, "name_5558745901919521");
		uploadPage.setLayout(null);
		uploadPage.setVisible(false);
		
		JPanel Recommendations = new JPanel();
		frame.getContentPane().add(Recommendations, "name_5560257366833202");
		Recommendations.setLayout(null);
		Recommendations.setVisible(false);
		
		JPanel studentInfo = new JPanel();
		studentInfo.setLayout(null);
		frame.getContentPane().add(studentInfo, "name_5561135494033861");
		studentInfo.setVisible(false);
		
		textField_2 = new JTextField();
		textField_2.setBounds(22, 11, 276, 32);
		textField_2.setText("Recommendation Report");
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 21));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.menu);
		Recommendations.add(textField_2);
		
		JButton button_8 = new JButton("Log off");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage.setVisible(true);
				Recommendations.setVisible(false);
			}
		});
		button_8.setBounds(110, 218, 89, 23);
		Recommendations.add(button_8);
		
		JButton button_9 = new JButton("Back");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentInfo.setVisible(true);
				Recommendations.setVisible(false);
			}
		});
		button_9.setBounds(209, 218, 89, 23);
		Recommendations.add(button_9);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(321, 10, 89, 23);
		textPane_3.setText("BEHP 5000");
		textPane_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPane_3.setEditable(false);
		textPane_3.setBackground(new Color(218, 165, 32));
		Recommendations.add(textPane_3);
		
		JPanel logOn = new JPanel();
		logOn.setLayout(null);
		frame.getContentPane().add(logOn, "name_5560273367071821");
		
		JTextArea textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setText("WELCOME TO ABRS");
		textArea.setLineWrap(true);
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 26));
		textArea.setEditable(false);
		textArea.setBackground(SystemColor.menu);
		textArea.setBounds(101, 19, 268, 49);
		MainPage.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setText("Please choose your identity:");
		textArea_1.setForeground(new Color(255, 0, 0));
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea_1.setEditable(false);
		textArea_1.setBackground(SystemColor.menu);
		textArea_1.setBounds(29, 79, 395, 41);
		MainPage.add(textArea_1);
		
		JButton button = new JButton("TEACHER");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				uploadPage.setVisible(true);
				MainPage.setVisible(false);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.setBackground(SystemColor.menu);
		button.setBounds(39, 131, 188, 63);
		MainPage.add(button);
		
		JButton button_1 = new JButton("STUDENT");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logOn.setVisible(true);
				MainPage.setVisible(false);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		button_1.setBackground(SystemColor.menu);
		button_1.setBounds(236, 131, 188, 63);
		MainPage.add(button_1);
		
		Button button_2 = new Button("SIGN UP");
		button_2.setBackground(Color.ORANGE);
		button_2.setBounds(187, 210, 98, 41);
		MainPage.add(button_2);
		
		JButton button_3 = new JButton("Upload...");
		button_3.setBounds(138, 73, 148, 35);
		uploadPage.add(button_3);
		
		JButton button_4 = new JButton("Upload...");
		button_4.setBounds(138, 128, 148, 35);
		uploadPage.add(button_4);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Grade file:");
		textPane.setEditable(false);
		textPane.setBackground(Color.ORANGE);
		textPane.setBounds(53, 73, 75, 35);
		uploadPage.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("Log file:");
		textPane_1.setEditable(false);
		textPane_1.setBackground(Color.ORANGE);
		textPane_1.setBounds(53, 128, 75, 35);
		uploadPage.add(textPane_1);
		
		JButton button_5 = new JButton("Log off");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage.setVisible(true);
				uploadPage.setVisible(false);
			}
		});
		button_5.setBounds(130, 203, 89, 23);
		uploadPage.add(button_5);
		
		JButton button_6 = new JButton("Proccess");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recommendations.setVisible(true);
				uploadPage.setVisible(false);
			}
		});
		button_6.setBounds(315, 100, 90, 35);
		uploadPage.add(button_6);
		
		JButton button_7 = new JButton("Main page");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage.setVisible(true);
				uploadPage.setVisible(false);
			}
		});
		button_7.setBounds(229, 203, 112, 23);
		uploadPage.add(button_7);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setText("Please upload grade and log files:");
		textArea_2.setLineWrap(true);
		textArea_2.setForeground(Color.RED);
		textArea_2.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea_2.setEditable(false);
		textArea_2.setBackground(SystemColor.menu);
		textArea_2.setBounds(10, 21, 395, 41);
		uploadPage.add(textArea_2);
		
		
		
		JFormattedTextField frmtdtxtfldUsernameUser = new JFormattedTextField();
		frmtdtxtfldUsernameUser.setText("Username: USER");
		frmtdtxtfldUsernameUser.setBounds(91, 75, 225, 36);
		logOn.add(frmtdtxtfldUsernameUser);
		
		JFormattedTextField frmtdtxtfldPassword = new JFormattedTextField();
		frmtdtxtfldPassword.setText("Password: *********");
		frmtdtxtfldPassword.setBounds(91, 120, 225, 36);
		logOn.add(frmtdtxtfldPassword);
		
		JButton button_11 = new JButton("Log In");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentInfo.setVisible(true);
				logOn.setVisible(false);
			}
		});
		button_11.setBounds(81, 184, 89, 23);
		logOn.add(button_11);
		
		JButton button_12 = new JButton("Back");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage.setVisible(true);
				logOn.setVisible(false);
			}
		});
		button_12.setBounds(207, 184, 89, 23);
		logOn.add(button_12);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setText("Please enter username and password:");
		textArea_5.setLineWrap(true);
		textArea_5.setForeground(Color.RED);
		textArea_5.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea_5.setEditable(false);
		textArea_5.setBackground(SystemColor.menu);
		textArea_5.setBounds(10, 23, 395, 41);
		logOn.add(textArea_5);
		
		
		
		JButton button_13 = new JButton("Extract Performance");
		button_13.setBounds(216, 80, 164, 30);
		studentInfo.add(button_13);
		
		JButton button_14 = new JButton("Extract Behaviors");
		button_14.setBounds(216, 121, 164, 30);
		studentInfo.add(button_14);
		
		JButton button_15 = new JButton("Recommendations");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recommendations.setVisible(true);
				studentInfo.setVisible(false);
			}
		});
		button_15.setBounds(216, 162, 164, 30);
		studentInfo.add(button_15);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110"}));
		comboBox.setBounds(91, 97, 99, 23);
		studentInfo.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setText("WELCOME");
		textField_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 36));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.menu);
		textField_1.setBounds(142, 11, 147, 58);
		studentInfo.add(textField_1);
		
		JButton button_16 = new JButton("Main Page");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage.setVisible(true);
				studentInfo.setVisible(false);
			}
		});
		button_16.setBounds(115, 214, 104, 23);
		studentInfo.add(button_16);
		
		JButton button_23 = new JButton("Log Out");
		button_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage.setVisible(true);
				studentInfo.setVisible(false);
			}
		});
		button_23.setBounds(229, 214, 89, 23);
		studentInfo.add(button_23);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("Student:");
		textPane_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPane_2.setEditable(false);
		textPane_2.setBackground(new Color(218, 165, 32));
		textPane_2.setBounds(32, 97, 59, 23);
		studentInfo.add(textPane_2);
	}
}
