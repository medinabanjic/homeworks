package ba.bitcamp.exercises.ass9_14;

public class Client extends Computer implements Connectable {

	private Computer connectedToComp;
	private Network connectedToNet;

	public Client(String name, char[] MAC) {
		super(name, MAC);
	}

	@Override
	public void connect(Computer c) throws IllegalArgumentException {
		if (connectedToComp != null || connectedToNet != null) {
			throw new IllegalArgumentException("It is already connected!");
		}
		connectedToComp = c;
	}

	@Override
	public void connect(Network net) throws IllegalArgumentException {
		if (connectedToComp != null || connectedToNet != null) {
			throw new IllegalArgumentException("It is already connected!");
		}
		connectedToNet = net;

	}

	@Override
	public void disconnect() {
		connectedToComp = null;
		connectedToNet = null;

	}

	@Override
	public String toString() {
		return "Client connected to:\n " + connectedToComp + "\n"
				+ connectedToNet + "\n " + super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (connectedToComp == null) {
			if (other.connectedToComp != null)
				return false;
		} else if (!connectedToComp.equals(other.connectedToComp))
			return false;
		if (connectedToNet == null) {
			if (other.connectedToNet != null)
				return false;
		} else if (!connectedToNet.equals(other.connectedToNet))
			return false;
		return true;
	}

}
