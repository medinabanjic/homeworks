package ba.bitcamp.homework03.task01;

public class Goal extends StoryElement {

	public static final int EASY = 0;
	public static final int HARD = 1;
	public static final int IMPOSSIBLE = 2;

	private int difficulty;
	private int toDo;
	private Character toDoWith;

	public Goal(int difficulty, int defeat, Character withWhom) {
		this.difficulty = difficulty;
		this.toDo = defeat;
		this.toDoWith = withWhom;
	}

	/**
	 * Gets difficulty
	 * 
	 * @return difficulty
	 */
	public int getDificulty() {
		return difficulty;
	}

	/**
	 * Gets name
	 * 
	 * @return name
	 */
	public String getGoalName() {
		return this.getName();
	}
}
