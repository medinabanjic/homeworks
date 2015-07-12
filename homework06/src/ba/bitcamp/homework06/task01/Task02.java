package ba.bitcamp.homework06.task01;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Task02 extends JFrame {

	private static final long serialVersionUID = 6812128848004695662L;

	JPanel panel = new JPanel();
	JLabel label = new JLabel("Style");
	JCheckBox bold = new JCheckBox("BOLD");
	JCheckBox italic = new JCheckBox("ITALIC");
	JButton app = new JButton("Apply");

	Font font = new Font("Serif", Font.PLAIN, 20);

	public Task02() {
		add(panel);

		panel.setLayout(new GridLayout(4, 1));
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);

		panel.add(bold);
		panel.add(italic);

		panel.add(app);
		app.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (bold.isSelected() && !italic.isSelected()) {
					font = new Font("Serif", Font.BOLD, 20);
					label.setFont(font);
				} else if (italic.isSelected() && !bold.isSelected()) {
					font = new Font("Serif", Font.ITALIC, 20);
					label.setFont(font);
				} else if (bold.isSelected() && italic.isSelected()) {
					font = new Font("Serif", Font.BOLD + Font.ITALIC, 20);
					label.setFont(font);
				} else {
					font = new Font("Serif", Font.PLAIN, 20);
					label.setFont(font);
				}

			}
		});
		setSize(500, 500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Task02();

	}

}
