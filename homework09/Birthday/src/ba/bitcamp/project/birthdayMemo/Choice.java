package ba.bitcamp.project.birthdayMemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Choice extends JFrame {

	private static final long serialVersionUID = -8659792827568404845L;

	// Panels
	JPanel choose1 = new JPanel();
	JPanel choose2 = new JPanel();

	// Buttons
	JButton cSearch = new JButton("Search for birthdays");
	JButton cAdd = new JButton("Add new birthday");
	JButton cRemove = new JButton("Delete birthday");
	JButton cLogOut = new JButton("LOG OUT");

	JLabel picLabel = new JLabel();

	public Choice() throws IOException {
		picLabel = new JLabel(new ImageIcon(Choice.class.getResource("/ba/bitcamp/project/birthdayMemo/presents.jpg")));
		choose1.add(picLabel);
		setTitle("What do You want to do?");
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 250);
		setResizable(false);
		setLocationRelativeTo(null);

		// Panel 2
		add(choose1);
		choose1.setBackground(Color.WHITE);
		choose1.setLayout(new FlowLayout(FlowLayout.CENTER));
		choose1.add(cSearch);
		choose1.add(cAdd);
		choose1.add(cRemove);
		choose1.add(cLogOut);

		// Search button
		cSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Search();

			}
		});

		// Add button
		cAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Add();

			}
		});
		
		//Remove button
		cRemove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Please, enter name: ");
				remove(name);
				
			}
		});

		// Log Out button
		cLogOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		setVisible(true);

	}
	
	public void remove(String name) {
		Files activeFile = new Files();
		File file = (activeFile.getActive());
		Scanner sc;
		ArrayList<String> entries = new ArrayList<>();
		try {
			sc = new Scanner(file);

			while (sc.hasNextLine()) {
				entries.add(sc.nextLine());
			}
			sc.close();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		for (int i = 0; i < entries.size(); i++) {

			String line = entries.get(i);
			String[] pair = line.split(" ");
			String user = pair[0];

			if (user.equals(name)) {
				entries.remove(line);
				break;
			}
		}

		try {

			PrintWriter pw = new PrintWriter(file);
			for (int i = 0; i < entries.size(); i++)
				pw.println(entries.get(i));
			pw.close();

		} catch (FileNotFoundException e1) {
		}
	}

}