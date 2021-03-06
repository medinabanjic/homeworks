package ba.bitcamp.homework04.task01;

public abstract class Network {

	private String name;
	protected Computer[] computers;
	
	public Network(String name) {
		this.name = name;
		this.computers = new Computer[0];
	}
	
	public abstract void addComputer(Computer c);
	
	public abstract void removeComputer(Computer c);
}
