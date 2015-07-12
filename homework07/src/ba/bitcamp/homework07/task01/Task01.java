package ba.bitcamp.homework07.task01;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Task01 extends JPanel {

	private static final long serialVersionUID = 5768722134355654674L;
	private static final int PANEL_WIDTH = 600;
	private static final int PANEL_HEIGHT = 600;
	private static final int CIRCLE_SIZE = 50;

	private int x;
	private int y;
	long t;

	private static Task01 instance;

	public Task01() {

		x = Task01.PANEL_WIDTH / 2;
		y = Task01.PANEL_HEIGHT / 2;
		addKeyListener(new KeyHandler());
		;
		setFocusable(true);
		t = System.currentTimeMillis();
		System.out.println(t);
	}

	public static Task01 getInstance() {
		if (instance == null) {
			instance = new Task01();
		}
		return instance;
	}

	public void moveRight() {
		if (x > 0 + Task01.CIRCLE_SIZE / 2) {
			x += 5;
			repaint();
		}
	}

	public void moveLeft() {
		if (x > 0 + Task01.CIRCLE_SIZE / 2) {
			x -= 5;
			repaint();
		}
	}

	public void moveUp() {
		if (y > 0 + Task01.CIRCLE_SIZE / 2) {
			y -= 5;
			repaint();
		}
	}

	public void moveDown() {
		if (y < Task01.PANEL_HEIGHT - Task01.CIRCLE_SIZE / 2) {
			y += 5;
			repaint();
		}
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillOval(x - Task01.CIRCLE_SIZE / 2, y - Task01.CIRCLE_SIZE / 2, Task01.CIRCLE_SIZE, Task01.CIRCLE_SIZE);
	}

	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setContentPane(new Task01());
		window.setTitle("Task 01");
		window.setSize(Task01.PANEL_WIDTH + 15, Task01.PANEL_HEIGHT + 40);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
