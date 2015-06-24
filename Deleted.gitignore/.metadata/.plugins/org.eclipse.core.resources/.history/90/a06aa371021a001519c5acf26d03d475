package ba.bitcamp.exercises.ass9_14;

public class BusNetwork extends Network implements Functionable {

	private int counter;

	public BusNetwork(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isFunctioning() {
		counter = 0;
		for (int i = 0; i < computers.length; i++) {
			if (computers[i] != null) {
				counter++;
			}
		}

		if (counter >= 2) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void addComputer(Computer c) throws IllegalArgumentException {
		if (c instanceof Server) {
			throw new IllegalArgumentException("This is server!");
		} else {

			ArrayManipulation.extendArray(computers);
			computers[computers.length - 1] = c;
			if (c instanceof Client) {
				Client cl = (Client) c;
				cl.connect(this);
			}
		}

	}

	@Override
	public void removeComputer(Computer c) throws IllegalArgumentException {
		if (c instanceof Client) {
			Client cl = (Client) c;
			for (int i = 0; i < computers.length; i++) {
				if (computers[i].equalsTo(cl)) {
					cl.disconnect();
					ArrayManipulation.shrinkArray(computers, i);
					return;
				}
			}
		} else {
			throw new IllegalArgumentException("This is server!");
		}
		throw new IllegalArgumentException("Computer not found!");
	}

	@Override
	public String toString() {
		return "BusNetwork is functioning: " + isFunctioning()
				+ "\nIt has connected: " + counter + " computers.";
	}

}
