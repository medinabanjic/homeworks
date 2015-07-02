package ba.bitcamp.homework04.task01;

public class Server extends Computer {

	private int newComputersLimit;

	public Server(String name, char[] MAC, int newComputersLimit) {
		super(name, MAC);
		this.newComputersLimit = newComputersLimit;
	}

	public int getNewComputersLimit() {
		return newComputersLimit;
	}

	@Override
	public String toString() {
		return "\nLimit: " + newComputersLimit;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Server other = (Server) obj;
		if (newComputersLimit != other.newComputersLimit)
			return false;
		return true;
	}

}
