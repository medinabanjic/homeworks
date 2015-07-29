package ba.bitcamp.project.birthdayMemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Welcome extends JFrame {

	private static final long serialVersionUID = 152107980606741342L;

	// Panels

	JPanel welcome1 = new JPanel();
	JPanel welcome2 = new JPanel();

	// Labels

	JLabel wLabel1 = new JLabel("You are?");

	// Buttons

	JButton wLogIn = new JButton("LOG IN");
	JButton wExit = new JButton("EXIT");
	JButton wGit = new JButton("GIT");

	// Text Fields

	JTextField wUsername = new JTextField(20);

	// Text Areas

	JTextArea wNote = new JTextArea(" Note: " + "\n If you are a new user, choose your username "
			+ "\n and use it next time. It will automatically " + "\n save it.");

	JLabel picLabel;

	public Welcome() throws IOException {
		picLabel = new JLabel(new ImageIcon(Welcome.class.getResource("/ba/bitcamp/project/birthdayMemo/happy.jpg")));
		welcome1.add(picLabel);

		setTitle("Welcome!");
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);

		// Plane 1
		add(welcome1, BorderLayout.NORTH);
		welcome1.setLayout(new FlowLayout(FlowLayout.CENTER));
		welcome1.setBackground(Color.ORANGE);
		welcome1.setPreferredSize(new Dimension(300, 310));
		welcome1.add(wLabel1);
		welcome1.add(wUsername);
		welcome1.add(wGit);

		// Log In button
		welcome1.add(wLogIn);
		wLogIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				boolean isNew = true;
				Files users = new Files();
				// try to read usernames and if entered username is found in
				// this file do not make a new file
				try {
					Scanner sc = new Scanner(users.getUsers());
					while (sc.hasNextLine()) {
						String user = sc.nextLine();
						if (user.equals(wUsername.getText())) {
							isNew = false;
							try {
								new Choice();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						}

					}
				} catch (FileNotFoundException e3) {
					e3.printStackTrace();
				}
				// if the user is new then make a new file (active file), and
				// write username to file users
				if (isNew) {
					PrintWriter pw;
					try {
						pw = new PrintWriter(users.getUsers());
						pw.println(wUsername.getText());
						pw.close();

					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					try {
						new Choice();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					setVisible(false);
				}

			}
		});

		// GIT button
		wGit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "https://github.com/MedinaBanjicBITCamp/BirthdayMemoApplication";
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				} catch (java.io.IOException e1) {
					System.out.println(e1.getMessage());
				}

			}
		});

		// Exit button
		welcome1.add(wExit);
		wExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}

		});

		// Plane 2
		add(welcome2, BorderLayout.CENTER);
		welcome2.setLayout(new BorderLayout());
		welcome2.add(wNote);
		wNote.setEditable(false);

		setVisible(true);

	}

	public static void main(String[] args) {
		try {
			new Welcome();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setwUsername(Object o) {
		this.wUsername = (JTextField) o;

	}

}
