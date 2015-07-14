package ba.bitcamp.homework07.task05;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Task05 extends JPanel implements KeyListener {

	private static final long serialVersionUID = -5003206853478005187L;
	private static final int PANEL_WIDTH = 600;
	private static final int PANEL_HEIGHT = 600;
	private static final int CIRCLE_SIZE = 50;

	private int x;
	private int y;

	public Task05() {

		x = Task05.PANEL_WIDTH / 2;
		y = Task05.PANEL_HEIGHT / 2;
		addKeyListener(this);
		setFocusable(true);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillOval(x - Task05.CIRCLE_SIZE / 2, y - Task05.CIRCLE_SIZE / 2, Task05.CIRCLE_SIZE, Task05.CIRCLE_SIZE);
	}

	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setContentPane(new Task05());
		window.setTitle("Task 05");
		window.setSize(Task05.PANEL_WIDTH + 15, Task05.PANEL_HEIGHT + 40);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (x < Task05.PANEL_WIDTH - Task05.CIRCLE_SIZE / 2) {
				x += 5;
				repaint();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (x > 0 + Task05.CIRCLE_SIZE / 2) {
				x -= 5;
				repaint();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (y > 0 + Task05.CIRCLE_SIZE / 2) {
				y -= 5;
				repaint();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (y < Task05.PANEL_HEIGHT - Task05.CIRCLE_SIZE / 2) {
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
