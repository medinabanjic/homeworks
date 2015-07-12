package ba.bitcamp.homework05.task03;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Numbers extends JFrame {

	private static final long serialVersionUID = -4494894757991969347L;

	private JButton[] buttons = new JButton[10];
	private int counter = 0;
	private int[] array = new int[5];

	public Numbers() {
		setLayout(new GridLayout(2, 5, 1, 1));
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(i + "");
			buttons[i].setFont(new Font("Cambria", Font.BOLD, 30));
			buttons[i].addActionListener(new Action());
			add(buttons[i]);
		}

		setResizable(false);
		setTitle("Array");
		setSize(700, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Numbers();
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			counter++;

			for (int i = 0; i < buttons.length; i++) {
				if (e.getSource() == buttons[i]) {
					array[counter - 1] = Integer.parseInt(buttons[i].getText());

					buttons[i].setEnabled(false);
					if (Integer.parseInt(buttons[i].getText()) < 5) {
						buttons[i + 5].setEnabled(false);
					} else {
						buttons[i - 5].setEnabled(false);
					}

					if (counter == 5) {
						JOptionPane.showMessageDialog(null, Arrays.toString(array));
						System.exit(EXIT_ON_CLOSE);

					}
				}
			}

		}
	}

}
