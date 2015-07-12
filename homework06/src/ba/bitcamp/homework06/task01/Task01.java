package ba.bitcamp.homework06.task01;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Task01 extends JFrame{
	private static final long serialVersionUID = 6579210998533332222L;

	JPanel panel = new JPanel();
	JLabel label = new JLabel("Resize");
	JSlider size = new JSlider(2, 40);

	private int resized = 0;

	Font font = new Font("Serif", Font.PLAIN, resized);

	public Task01() {
		add(panel);
		panel.setLayout(new BorderLayout());

		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label, BorderLayout.CENTER);

		panel.add(size, BorderLayout.SOUTH);
		size.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int resized = size.getValue();
				Font font = new Font("Serif", Font.PLAIN, resized);
				label.setFont(font);

			}
		});
		setSize(500, 500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Task01();

	}
}
