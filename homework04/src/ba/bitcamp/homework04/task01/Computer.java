package ba.bitcamp.homework04.task01;

public abstract class Computer {

	private String name;
	private MACAddress MAC;

	// Constructor
	public Computer(String name, char[] MAC) {
		this.name = name;
		this.MAC = new MACAddress(MAC);
	}

	// Default constructor
	public Computer() {
		this.name = "Default computer";
		this.MAC = null;
	}

	// Getters

	public String getName() {
		return name;
	}

	public MACAddress getMAC() {
		return MAC;
	}

	// Inner class
	public class MACAddress {
		private char[] address = new char[10];

		public MACAddress(char[] address) {
			this.address = address;
		}

		@Override
		public String toString() {
			String s = "\n";
			int counter = 2;
			for (int i = 0; i < address.length; i++) {
				if (i == counter) {
					s += ":";
					counter += 2;
				}
				s += address[i];
			}
			return s;
		}
	}

	@Override
	public String toString() {
		return "Computer: \n" + name + "\nMAC=" + MAC;
	}

	public boolean equalsTo(Computer other) {
		if (this.name.equals(other.name) && this.MAC.equals(other.MAC)) {
			return true;
		} else {
			return false;
		}
	}

}
