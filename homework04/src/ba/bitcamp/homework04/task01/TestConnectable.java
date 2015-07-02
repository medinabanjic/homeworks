package ba.bitcamp.homework04.task01;

public class TestConnectable {

	public static void main(String[] args) {

		char[] a1 = new char[] { 'J', 'H', '5', 'D', 'U', '4', '5', 'H', 'R',
				'R' };
		char[] a2 = new char[] { 'G', 'H', '9', 'L', 'U', '4', '3', 'H', 'F',
				'D' };
		char[] a3 = new char[] { 'S', 'E', '9', '5', 'U', '4', '6', 'H', 'T',
				'B' };

		Client c1 = new Client("Computer 1", a1);

		Client c2 = new Client("MY COMP", a3);
		Server s1 = new Server("MY SERVER", a2, 2);
		BusNetwork bs = new BusNetwork("Eagle");
		StarNetwork sn = new StarNetwork("Neki", s1);
		try {
			c1.connect(s1);
			c1.disconnect();
			System.out.println(c1);

			bs.addComputer(c2);
			bs.addComputer(c1);
			System.out.println(bs.isFunctioning());
			bs.removeComputer(c1);
			c2.disconnect();

			sn.addComputer(c2);
			bs.isFunctioning();
			
		} catch (Exception e) {
		}

	}

}
