package ba.bitcamp.homework03.task01;

public class StoryTest {

	public static void main(String[] args) {
		// I remember before, when I was in the last row in BITCamp classroom,
		// I had a team.
		Character c1 = new Character("Mladen", "Male", true);
		Character c2 = new Character("Gordan", "Male", true);

		// We were working on a project which was not easy at all.
		// But we made our goal a crystal clear, defeat homework.
		Goal g1 = new Goal(1, Event.DEFEAT, c1);
		// I was working very hard to solve the task I was given.
		// I knew the deadline was close.
		Protagonist p1 = new Protagonist("Medina", "Female", false, g1);

		// But there was a problem, I had the same task as Ramiz had.
		// As he did not have the knowledge he was cheating.
		// He copied my code, and to be worse, he deleted mine while I was on a
		// break

		Character c3 = new Character("Ramiz", "Male", false);
		p1.setEnemy(c3);
		// I needed help. At the beginning Mladen was in my team, but now I
		// asked Gordan if
		// he could help as we work the best when three of us work together.
		// He accepted.
		p1.addHelper(c2);
		p1.addHelper(c1);

		// This improved my thinking speed. I was capable of destroying this
		// code.
		p1.improveCapability();
		// Now Ramiz had not a chance.
		p1.accomplishGoal();
		System.out.println(p1);
		// Soon after this, he died alone. :)
		c3.killCharacter();

	}

}
