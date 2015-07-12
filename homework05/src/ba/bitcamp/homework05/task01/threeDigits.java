package ba.bitcamp.homework05.task01;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class threeDigits extends JFrame {

	private static final long serialVersionUID = -8264429902999920657L;

	protected JButton[] buttons = new JButton[10];
	protected String num = "";

	public threeDigits() {

		setLayout(new GridLayout(10, 1));
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(Integer.toString(i));
			add(buttons[i]);
			buttons[i].addActionListener(new Action());
		}
		
		setTitle("Three Digit Number");
		setVisible(true);
		setSize(350, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new threeDigits();
	}

	private class Action implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < buttons.length; i++) {
				if (e.getSource() == buttons[i]) {
					num += buttons[i].getText();
				}
				if (num.length() == 3) {
					JOptionPane.showMessageDialog(null,"Number: " + num);
					System.exit(0);
				}
			}
		}
	}
}