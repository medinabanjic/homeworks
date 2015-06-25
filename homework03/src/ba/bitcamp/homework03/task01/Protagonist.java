package ba.bitcamp.homework03.task01;

public class Protagonist extends Character {

	public static final int MAX_NUM_OF_HELPERS = 3;

	private Goal mainGoal;
	private Character[] helpers;
	private Character enemy;
	private int numOfHelpers = 0;

	public Protagonist(String name, String gender, boolean isCapable,
			Goal mainGoal) {
		super(name, gender, isCapable);
		this.mainGoal = mainGoal;
		this.helpers = new Character[MAX_NUM_OF_HELPERS];

	}

	public boolean getIsAlive() {
		return this.isAlive;
	}

	/**
	 * Sets enemy.
	 * 
	 * @param enemy
	 */
	public void setEnemy(Character enemy) {
		this.enemy = enemy;
	}

	/**
	 * This method adds 1 object Character to array of Characters if there is a
	 * free space inside the array
	 * 
	 * @param helper
	 */
	public void addHelper(Character helper)
			throws ArrayIndexOutOfBoundsException {

		if (numOfHelpers == helpers.length) {
			throw new ArrayIndexOutOfBoundsException();
		} else if (numOfHelpers < helpers.length) {
			helpers[helpers.length - 1] = helper;
			numOfHelpers++;
		}

	}

	/**
	 * This method checks whether the main goal could be accomplished or not
	 */
	public void accomplishGoal() {
		int success = 0;
		// checks if the character is alive
		if (!(isAlive)) {
			System.out.println("Dead!");
		} else {

			// checks is it capable
			if (this.getIsCapable()) {
				success += 40;
			}

			// checks for each helper capability
			for (int i = 0; i < helpers.length; i++) {
				if (helpers[i] != null && helpers[i].getIsCapable()) {
					success += 20;
				}
			}

			// checks if enemy is capable
			if (enemy.getIsCapable()) {
				success -= 30;
			}

			// checks difficulty of goal
			if (mainGoal.getDificulty() == Goal.HARD) {
				success -= 20;
			} else if (mainGoal.getDificulty() == Goal.IMPOSSIBLE) {
				success -= 100;
			}

			// sets success to 100 or 0 if needed
			if (success > 100) {
				success = 100;
			} else if (success < 0) {
				success = 0;
			}

			// prints if protagonist accomplished goal or not,
			// improves characters capability or kill character from helpers
			if (success >= 50) {
				System.out.printf("Protagonist has succeed at his goal: %s",
						mainGoal.getGoalName());
				helpers[(int) (Math.random() * numOfHelpers + 1)]
						.improveCapability();
			} else if (success < 50) {
				System.out.printf(
						"Protagonist has not succeed at his goal: %s",
						mainGoal.getGoalName());
				helpers[(int) (Math.random() * (numOfHelpers + 2) - 1)]
						.killCharacter();
				helpers[(int) (Math.random() * (numOfHelpers + 2) - 1)]
						.improveCapability();
			}

		}
	}

	/**
	 * Converts to string
	 * 
	 * @return
	 */
	public String getHelpers() {
		String s = "Helpers:";
		for (int i = 0; i < helpers.length; i++) {
			s += "\n" + helpers[i] + "\n";
		}
		return s;
	}
}
