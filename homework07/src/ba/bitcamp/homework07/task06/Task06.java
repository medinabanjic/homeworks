package ba.bitcamp.homework07.task06;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Task06 extends JPanel {

	private static final long serialVersionUID = -6223123242675566091L;
	private static final int PANEL_WIDTH = 600;
	private static final int PANEL_HEIGHT = 600;
	private static final int CIRCLE_SIZE = 50;

	private static KeyListener keyHandler;

	private int x;
	private int y;

	public Task06() {

		x = Task06.PANEL_WIDTH / 2;
		y = Task06.PANEL_HEIGHT / 2;
		keyHandler = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (x < Task06.PANEL_WIDTH - Task06.CIRCLE_SIZE / 2) {
						x += 5;
						repaint();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (x > 0 + Task06.CIRCLE_SIZE / 2) {
						x -= 5;
						repaint();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (y > 0 + Task06.CIRCLE_SIZE / 2) {
						y -= 5;
						repaint();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (y < Task06.PANEL_HEIGHT - Task06.CIRCLE_SIZE / 2) {
						y += 5;
						repaint();
					}
				}

			}
		};

		addKeyListener(keyHandler);
		setFocusable(true);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillOval(x - Task06.CIRCLE_SIZE / 2, y - Task06.CIRCLE_SIZE / 2, Task06.CIRCLE_SIZE, Task06.CIRCLE_SIZE);
	}

	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setContentPane(new Task06());
		window.setTitle("Task 06");
		window.setSize(Task06.PANEL_WIDTH + 15, Task06.PANEL_HEIGHT + 40);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
