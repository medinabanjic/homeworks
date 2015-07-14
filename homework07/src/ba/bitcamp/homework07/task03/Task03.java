package ba.bitcamp.homework07.task03;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Task03 extends JPanel {

	private static final long serialVersionUID = 8939926108569100821L;
	private static final int PANEL_WIDTH = 600;
	private static final int PANEL_HEIGHT = 600;
	private static final int CIRCLE_SIZE = 50;

	private int x;
	private int y;

	public Task03() {

		x = Task03.PANEL_WIDTH / 2;
		y = Task03.PANEL_HEIGHT / 2;
		addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (x < Task03.PANEL_WIDTH - Task03.CIRCLE_SIZE / 2) {
						x += 5;
						repaint();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (x > 0 + Task03.CIRCLE_SIZE / 2) {
						x -= 5;
						repaint();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (y > 0 + Task03.CIRCLE_SIZE / 2) {
						y -= 5;
						repaint();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (y < Task03.PANEL_HEIGHT - Task03.CIRCLE_SIZE / 2) {
						y += 5;
						repaint();
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		setFocusable(true);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillOval(x - Task03.CIRCLE_SIZE / 2, y - Task03.CIRCLE_SIZE / 2, Task03.CIRCLE_SIZE, Task03.CIRCLE_SIZE);
	}

	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setContentPane(new Task03());
		window.setTitle("Task 03");
		window.setSize(Task03.PANEL_WIDTH + 15, Task03.PANEL_HEIGHT + 40);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
