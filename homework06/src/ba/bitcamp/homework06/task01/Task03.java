package ba.bitcamp.homework06.task01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Task03 extends JFrame {
	private static final long serialVersionUID = 4192459733063855610L;

	JPanel panel = new JPanel();

	// labels

	JLabel username = new JLabel("Username");
	JLabel password = new JLabel("Password");

	// textboxes

	JTextField user = new JTextField(15);
	private JPasswordField pass = new JPasswordField(15);

	public Task03() {
		add(panel);

		panel.add(username);
		panel.add(user);

		panel.add(password);
		panel.add(pass);
		pass.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String correctPassword = "1234";
				String givenPassword = String.valueOf(pass.getPassword());
				String correctUsername = "Mujo";
				String givenUsername = String.valueOf(user.getText());
				if (correctPassword.equals(givenPassword) && correctUsername.equals(givenUsername)) {
					System.exit(0);
				} else {
					JOptionPane.showMessageDialog(null, "Input is wrong!");
					user.setText("");
					pass.setText("");

				}

			}
		});

		setSize(300, 150);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Task03();
	}
}
