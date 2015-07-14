package ba.bitcamp.homework06.task01;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Task09 extends JFrame {

	private static final long serialVersionUID = 2337469499951262463L;
	private JTextField filePathTxtF = new JTextField();
	private JTextArea fileContentTxtA = new JTextArea();
	private String filePath;

	public Task09() {
		setLayout(new BorderLayout());
		filePathTxtF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						filePath = filePathTxtF.getText();
						TextIO.readFile(filePath);
						String text = "";
						while (!TextIO.eof()) {
							text += TextIO.getln() + "\n";
						}
						fileContentTxtA.setText(text);
						add(fileContentTxtA, BorderLayout.CENTER);
						System.out.println(text);
						repaint();
					} catch (IllegalArgumentException ex) {
						JOptionPane.showMessageDialog(null, "No such file", "Error", JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});
		add(filePathTxtF, BorderLayout.NORTH);

		setTitle("Task 09");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Task09();
	}
}
