package ba.bitcamp.homework05.task04;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Editor extends JFrame {

	private static final long serialVersionUID = 9216805886899775664L;

	static JButton letter = new JButton();
	JButton left = new JButton();
	JButton right = new JButton();
	JButton insert = new JButton();

	JLabel word = new JLabel();

	private static String s = "";
	private static char[] c = new char[26];
	private static char saveLetter = ' ';
	private char index = '_';

	public Editor() {
		setLayout(new BorderLayout());

		add(letter, BorderLayout.NORTH);
		letter.setText("Generate letter");

		add(insert, BorderLayout.SOUTH);
		insert.setText("Insert");

		add(left, BorderLayout.WEST);
		left.setText("<");

		add(right, BorderLayout.EAST);
		right.setText(">");

		add(word, BorderLayout.CENTER);
		word.setText('_' + "");
		word.setHorizontalAlignment(SwingConstants.CENTER);

		letter.addActionListener(new Letter());
		insert.addActionListener(new Insertion());
		left.addActionListener(new Move());
		right.addActionListener(new Move());

		setResizable(false);
		setTitle("ID");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private class Letter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			generateLetter();
		}

		public void generateLetter() {
			for (int i = 0; i < 26; i++) {
				c[i] = (char) (97 + i);
			}
			saveLetter = c[(int) (Math.random() * (c.length + 1) - 1)];
			letter.setText("Char: " + saveLetter);

		}
	}

	private class Move implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == left) {
				if (index <= 0) {
					word.setText(s);
				} else if (index > 0) {
					index--;
					for (int i = 0; i < s.length(); i++) {
						char temp = ' ';
						s += s.charAt(i);
						if (i == index) {
							temp = s.charAt(i);
							s += "_" + temp;
							i += 2;
						}
					}
					word.setText(s);
				}

			}

		}
	}

	private class Insertion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(s.length() > 1){
			String insert = s.substring(0, index) + saveLetter + s.substring(index);
			s = insert;
			} else {
				s = saveLetter + "_";
			}
			
			
			word.setText(s);
			
			
			}
			
		

	}

	public static void main(String[] args) {

		new Editor();

	}

}
