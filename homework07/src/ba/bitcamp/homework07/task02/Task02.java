package ba.bitcamp.homework07.task02;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Task02 extends JPanel {

	private static final long serialVersionUID = -3034564265793293005L;
	private static final int PANEL_WIDTH = 600;
	private static final int PANEL_HEIGHT = 600;
	private static final int CIRCLE_SIZE = 50;

	private int x;
	private int y;

	public Task02() {

		x = Task02.PANEL_WIDTH / 2;
		y = Task02.PANEL_HEIGHT / 2;
		addKeyListener(new KeyHandler());
		setFocusable(true);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillOval(x - Task02.CIRCLE_SIZE / 2, y - Task02.CIRCLE_SIZE / 2, Task02.CIRCLE_SIZE, Task02.CIRCLE_SIZE);
	}

	private class KeyHandler implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (x < Task02.PANEL_WIDTH - Task02.CIRCLE_SIZE / 2) {
					x += 5;
					repaint();
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (x > 0 + Task02.CIRCLE_SIZE / 2) {
					x -= 5;
					repaint();
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (y > 0 + Task02.CIRCLE_SIZE / 2) {
					y -= 5;
					repaint();
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (y < Task02.PANEL_HEIGHT - Task02.CIRCLE_SIZE / 2) {
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
	}

	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setContentPane(new Task02());
		window.setTitle("Task 02");
		window.setSize(Task02.PANEL_WIDTH + 15, Task02.PANEL_HEIGHT + 40);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
