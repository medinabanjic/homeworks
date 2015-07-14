package ba.bitcamp.homework07.task04;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Task04 extends JPanel {

	private static final long serialVersionUID = -6757160331735203206L;
	private static final int PANEL_WIDTH = 600;
	private static final int PANEL_HEIGHT = 600;
	private static final int CIRCLE_SIZE = 50;

	private int x;
	private int y;

	public Task04() {

		x = Task04.PANEL_WIDTH / 2;
		y = Task04.PANEL_HEIGHT / 2;
		addKeyListener(new KeyHandler());
		setFocusable(true);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillOval(x - Task04.CIRCLE_SIZE / 2, y - Task04.CIRCLE_SIZE / 2, Task04.CIRCLE_SIZE, Task04.CIRCLE_SIZE);
	}

	private class KeyHandler extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (x < Task04.PANEL_WIDTH - Task04.CIRCLE_SIZE / 2) {
					x += 5;
					repaint();
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (x > 0 + Task04.CIRCLE_SIZE / 2) {
					x -= 5;
					repaint();
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (y > 0 + Task04.CIRCLE_SIZE / 2) {
					y -= 5;
					repaint();
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (y < Task04.PANEL_HEIGHT - Task04.CIRCLE_SIZE / 2) {
					y += 5;
					repaint();
				}
			}
		}
	}

	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setContentPane(new Task04());
		window.setTitle("Task 04");
		window.setSize(Task04.PANEL_WIDTH + 15, Task04.PANEL_HEIGHT + 40);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
