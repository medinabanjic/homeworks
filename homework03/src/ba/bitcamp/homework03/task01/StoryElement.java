package ba.bitcamp.homework03.task01;

public abstract class StoryElement {
private String name;
	
	//Constructor for setting name
	public StoryElement(String name) {	
		this.name = name;
	}
	//constructor for getting name by default
	public StoryElement() {
		this("STElement");
	}	
	
	//...
	public String getName() {
		return name;
	}
	
	
}
