package ba.bitcamp.homework06.task01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Task06 extends JFrame {

	private static final long serialVersionUID = -2965882029521653487L;

	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JTextField sec = new JTextField(23);
	JButton started = new JButton("Start");
	Timer t = new Timer(1000, new Action());
	int s;

	public Task06() {
		add(panel);

		panel.add(label);
		label.setText("0");
		panel.add(sec);
		panel.add(started);
		started.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(sec.getText());
				t.start();

			}
		});

		setSize(300, 150);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			s = Integer.parseInt(label.getText());
			s--;
			label.setText(Integer.toString(s));

			if (s == 0) {
				t.stop();
				sec.setText("");
			}

		}
	}

	public static void main(String[] args) {
		new Task06();

	}

}
