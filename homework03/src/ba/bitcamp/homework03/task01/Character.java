package ba.bitcamp.homework03.task01;

public class Character extends StoryElement {

	private String gender;
	protected boolean isAlive;
	private boolean isCapable;

	public Character(String name, String gender, boolean isCapable) {
		super(name);
		this.gender = gender;
		this.isAlive = true;
		this.isCapable = isCapable;
	}

	/**
	 * Gets isCapable
	 * 
	 * @return Boolean value true - if character is capable, and false - if
	 *         character is not capable
	 */
	public boolean getIsCapable() {
		return isCapable;
	}

	/**
	 * Method that kills Character, turns isAlive to false Turns isCapable to
	 * false
	 */
	public void killCharacter() {
		if (isAlive == true) {
			isAlive = false;
			isCapable = false;
		}
	}

	/**
	 * Turns isCapale to true if it was false, character has to be alive
	 */
	public void improveCapability() {
		if (isCapable == false && isAlive == true) {
			isCapable = true;
		} else if (isAlive == false) {
			System.out.println("Dead!");
		} else {
			System.out.println("Capable already!");
		}
	}

	/**
	 * Converts to string
	 */
	public String toString() {
		return "Name: " + getName() + "\nGender: " + gender + "\nCapable: "
				+ isCapable + "\nAlive: " + isAlive;
	}

}
