package ba.bitcamp.homework06.task01;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Task08 extends JFrame {

	private static final long serialVersionUID = -2795770455985941323L;
	private JLabel usernameLabel = new JLabel("Username:");
	private JLabel passwordLabel = new JLabel("Password:");
	private JLabel confirmLabel = new JLabel("Confirm:");
	private JTextField usernameTxtF = new JTextField();
	private JPasswordField passPassword = new JPasswordField();
	private JPasswordField passConfirm = new JPasswordField();
	private JButton clear = new JButton("Clear");
	private JButton submit = new JButton("Submit");

	public Task08() {
		setLayout(new FlowLayout());
		usernameTxtF.setPreferredSize(new Dimension(200, 20));
		passPassword.setPreferredSize(new Dimension(200, 20));
		passConfirm.setPreferredSize(new Dimension(200, 20));

		clear.addActionListener(new Action());
		submit.addActionListener(new Action());

		add(usernameLabel);
		add(usernameTxtF);
		add(passwordLabel);
		add(passPassword);
		add(confirmLabel);
		add(passConfirm);
		add(clear);
		add(submit);

		setTitle("Task 08");
		setSize(300, 150);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == clear) {
				usernameTxtF.setText("");
				passPassword.setText("");
				passConfirm.setText("");
			} else if (e.getSource() == submit) {
				System.out.println(String.valueOf(passPassword.getPassword()));
				System.out.println(String.valueOf(passConfirm.getPassword()));
				if (usernameTxtF.getText().length() < 6) {
					JOptionPane.showMessageDialog(null, "Username must have at least 6 characters");
				} else
					if (!String.valueOf(passPassword.getPassword()).equals(String.valueOf(passConfirm.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Passwords do not match");
				} else if (passPassword.getPassword().length < 6) {
					JOptionPane.showMessageDialog(null, "Password must have at least 6 characters");
				} else if (!hasDigitAndCharacter(passPassword.getPassword())) {
					JOptionPane.showMessageDialog(null,
							"Password must contain at least one digit and one special character\n(@ # ^ %)");

				} else {
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Form is succesfully filled");
					System.exit(0);

				}

			}
		}

		private boolean hasDigitAndCharacter(char[] password) {
			for (int i = 0; i < password.length; i++) {
				if (password[i] >= 48 && password[i] <= 57) {
					for (int j = 0; j < password.length; j++) {
						if ((password[j] >= 33 && password[j] <= 46) || (password[j] >= 58 && password[j] <= 64)) {
							return true;
						}
					}
				}
			}
			return false;
		}
	}

	public static void main(String[] args) {
		new Task08();
	}
}
