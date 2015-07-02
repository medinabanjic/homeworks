package ba.bitcamp.homework04.task01;

public class BusNetwork extends Network implements Functionable {

	private int counter;
	private int saveNumOfConnectedComp;

	public BusNetwork(String name) {
		super(name);

	}

	// Checks whether the server is functioning or not
	@Override
	public boolean isFunctioning() {
		counter = 0;
		for (int i = 0; i < computers.length; i++) {
			if (computers[i] != null) {
				counter++;
			}
		}
		saveNumOfConnectedComp = counter;
		if (counter >= 2) {
			return true;
		} else {
			return false;
		}
	}

	// Adds computer to array and connect it to BusNetwork
	@Override
	public void addComputer(Computer c) throws IllegalArgumentException {
		if (c instanceof Server) {
			throw new IllegalArgumentException("This is server!");
		} else {

			ArrayManipulation.extendArray(computers);
			if (c instanceof Client) {
				Client cl = (Client) c;
				for (int i = 0; i < computers.length; i++) {
					if (computers[i] != null) {
						computers[i] = cl;
						cl.connect(this);
						return;
					}
				}

			}
		}

	}

	// Removes computer from array and disconnect it from BusNetwork
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
				+ "\nIt has connected: " + saveNumOfConnectedComp + " computers.";
	}

}
