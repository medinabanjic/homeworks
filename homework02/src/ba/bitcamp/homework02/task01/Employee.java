package ba.bitcamp.homework02.task01;

public class Employee {

	private String name;
	private String gender;
	private int monthSalary;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param gender
	 * @param monthSalary
	 */
	public Employee(String name, String gender, int monthSalary) {
		super();
		this.name = name;
		this.gender = gender;
		this.setMonthSalary(monthSalary);
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
	 * Gets gender.
	 * 
	 * @return
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Gets monthly salary.
	 * 
	 * @return
	 */
	public int getMonthSalary() {
		return monthSalary;
	}

	/**
	 * Sets monthly salary.
	 * 
	 * @param monthSalary
	 */
	public void setMonthSalary(int monthSalary) {
		this.monthSalary = monthSalary;
	}

}
