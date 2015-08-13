package ba.bitcamp.homework11.task02;

import java.util.Random;

public class ThreeThreads {

	public static void main(String[] args) {

		Thread t = new MyThread();
		t.start();
		try {
			t.join();
			t = new MyThread();
			t.start();
			t.join();
			t = new MyThread();
			t.start();
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This is a class for threads
	 * 
	 * @author medina.banjic
	 *
	 */
	private static class MyThread extends Thread {

		private static int ring;

		@Override
		public void run() {

			if (ring == 0) {
				ring = 1;
				for (int i = 1; i <= 10; i++) {
					System.out.println(i);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else if (ring == 1) {
				ring = 2;
				for (int i = 0; i < 4; i++) {
					System.out.println("BitCamp");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				Random rand = new Random();
				for (int i = 0; i < 5; i++) {
					System.out.println(rand.nextInt(5) + 1);
					try {
						Thread.sleep(700);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}

	}

}
