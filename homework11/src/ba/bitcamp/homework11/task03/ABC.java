package ba.bitcamp.homework11.task03;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ABC extends JFrame{
	
	private static final long serialVersionUID = -142861769687878635L;

	private JLabel label = new JLabel();
	private JButton button = new JButton("STOP");
	
	public ABC() {
		
		Thread t = new LabelThread(label);
		
		setLayout(new BorderLayout());
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				t.interrupt();
				
			}
		});
		
		add(label);
		add(button, BorderLayout.SOUTH);
		
		setTitle("A B C");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		t.start();
	}
	
	private static class LabelThread extends Thread {
		
		private JLabel label;
		private static char letter = 'a';
		
		public LabelThread(JLabel label) {
			super();
			this.label = label;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return;
				}
				label.setText(label.getText() + letter++);				
			}
		}
	}
	
	public static void main(String[] args) {
		new ABC();
	}
}
