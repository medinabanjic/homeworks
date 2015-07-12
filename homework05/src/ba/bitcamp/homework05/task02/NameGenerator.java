package ba.bitcamp.homework05.task02;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NameGenerator extends JFrame {

	private static final long serialVersionUID = 1291710380325984607L;

	protected String name;
	protected String surname;
	protected JLabel nameText = new JLabel();
	protected JLabel surnameText = new JLabel();
	protected JButton buttonName = new JButton("First name");
	protected JButton buttonSurname = new JButton("Last name");

	public NameGenerator() {
		setTitle("Name Generator");
		setLayout(new GridLayout(1, 4));
		setVisible(true);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(buttonName);
		add(nameText);
		add(surnameText);
		add(buttonSurname);

		buttonName.addActionListener(new Action());
		buttonSurname.addActionListener(new Action());

	}

	public static class Name {
		protected String[] names = { "Jane", "John", "Michael" };

		private String generateName() {
			return names[(int) (Math.random() * names.length)];
		}

		public String toString() {
			return generateName();
		}
	}

	public static class Surname {
		protected String[] surnames = { "Doe", "Snow", "Jordan" };

		private String generateSurname() {
			return surnames[(int) (Math.random() * surnames.length)];
		}

		public String toString() {
			return generateSurname();
		}
	}

	public class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonName) {
				name = new Name().toString();
				nameText.setText(name);
			} else if (e.getSource() == buttonSurname) {
				surname = new Surname().toString();
				surnameText.setText(surname);
			}

		}

	}

	public static void main(String[] args) {
		new NameGenerator();

	}

}