package ba.bitcamp.exercises.ass9_14;

public class StarNetwork extends Network implements Functionable {

	private Server myServer;
	private int counter;

	public StarNetwork(String name, Server myServer) {
		super(name);
		this.myServer = myServer;
	}

	@Override
	public boolean isFunctioning() {
		counter = 0;
		for (int i = 0; i < computers.length; i++) {
			if (computers[i] != null) {
				counter++;
			}
		}
		if (myServer.getNewComputersLimit() < counter) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void addComputer(Computer c) {
		if (c instanceof Server) {
			throw new IllegalArgumentException("This is server!");
		} else {

			ArrayManipulation.extendArray(computers);
			computers[computers.length - 1] = c;
			if (c instanceof Client) {
				Client cl = (Client) c;
				cl.connect(myServer);
			}
		}

	}

	@Override
	public void removeComputer(Computer c) {
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

}
