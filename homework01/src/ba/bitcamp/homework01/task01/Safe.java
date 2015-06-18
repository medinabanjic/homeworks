package ba.bitcamp.homework01.task01;

public class Safe {
	private String name;
	private Integer safeBalance;

	public Safe(String name) {
		super();
		this.name = name;
		this.safeBalance = 0;
	}

	/**
	 * This method adds money to our safe.
	 * 
	 * @param money
	 *            = money we want to add to safe
	 * @return
	 * 
	 *         Returns new safe balance, integer value.
	 */
	public int addMoney(int money) {
		return safeBalance += money;
	}

	/**
	 * Gets name.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method clears the safe. Takes all the money.
	 */
	public void clearSafe() {
		safeBalance = 0;
	}

	/**
	 * This method prints out the money balance.
	 */
	public void printBalance() {

		if (safeBalance == 0) {
			System.out.println("It is empty...");
		} else if (safeBalance > 0 && safeBalance <= 20) {
			System.out.println("There is some, but not much.");
		}

		else if (safeBalance > 20 && safeBalance <= 100) {
			System.out.println("There is some.");
		} else {
			System.out.println("There is a lot.");
		}
	}
}
