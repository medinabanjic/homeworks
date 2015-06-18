package ba.bitcamp.homework02.task01;

public class Company {

	private String name;
	private Employee director;
	private Employee[] workers;

	/**
	 * Constructor.
	 * 
	 * @param name
	 * @param director
	 * @param workers
	 */
	public Company(String name, Employee director, Employee[] workers) {
		super();
		this.name = name;
		this.director = director;
		this.workers = workers;
	}

	/**
	 * Gets number of employees.
	 * 
	 * @return
	 */
	public int getEmployedNumber() {
		return workers.length;
	}

	/**
	 * Calculates total salaries one company workers.
	 * 
	 * @return
	 */
	public int getTotalSalaries() {
		int sum = 0;
		for (int i = 0; i < workers.length; i++) {
			sum += workers[i].getMonthSalary();
		}
		return sum;
	}

	/**
	 * Calculates how many of the employees are women.
	 * 
	 * @return
	 */
	public int getTotalWomanEmployed() {
		int sum = 0;
		for (int i = 0; i < workers.length; i++) {
			if (workers[i].getGender().equals("Female")) {
				sum += workers[i].getMonthSalary();
			}
		}
		return sum;
	}

	/**
	 * Adds a given sum to salaries for all workers.
	 * 
	 * @param sum
	 */
	public void addSalary(int sum) {
		for (int i = 0; i < workers.length; i++) {
			sum = workers[i].getMonthSalary() + sum;
			workers[i].setMonthSalary(sum);
		}
	}

	/**
	 * Converts to string so that we can print these attributes.
	 */
	public String toString() {
		String s = "";
		s = "\nCompany: " + name;
		s += "\nDirector: " + director;
		s += "\nNumber of employees: " + workers.length;
		return s;
	}

}
