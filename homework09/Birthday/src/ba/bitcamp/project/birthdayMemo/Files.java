package ba.bitcamp.project.birthdayMemo;

import java.io.File;

public class Files {

	private File users;

	private File active;

	public Files() {
		File s = new File("");
		this.users = new File(s.getAbsolutePath() + "/users.txt").createNewFile();
		this.active = new File(s.getAbsolutePath() + "/active.txt").createNewFile();
		
	}

	public File getUsers() {
		return users;
	}

	public void setUsers(File users) {
		this.users = users;
	}

	public File getActive() {
		return active;
	}

	public void setActive(File active) {
		this.active = active;
	}

}
