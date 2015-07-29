package ba.bitcamp.project.birthdayMemo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Name extends JFrame {

	private static final long serialVersionUID = -1501534532990474276L;

	// Panels
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();

	// Labels
	JLabel enquiry = new JLabel("Enter name: ");
	JLabel info = new JLabel("");

	// TextField
	JTextField name = new JTextField(15);

	// Buttons
	JButton ok = new JButton("OK");
	JButton cancel = new JButton("Cancel");

	// variables
	private String nameF = "";

	public Name() {
		setBackground(Color.WHITE);
		setLayout(new GridLayout(2, 1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 300);
		setResizable(false);
		setLocationRelativeTo(null);

		// panel
		add(panel);
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(new Dimension(150, 150));
		panel.add(enquiry);
		panel.add(name);

		// OK button
		panel.add(ok);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nameF = name.getText();
				search(nameF);

			}
		});

		// Cancel button
		panel.add(cancel);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nameF = "";
				setVisible(false);
				new Search();

			}
		});

		// panel 2
		add(panel2);
		panel2.setLayout(new FlowLayout());
		panel2.setPreferredSize(new Dimension(150, 150));
		panel2.add(info);
		setVisible(true);
	}

	/**
	 * This method searches for a given name in array of strings.
	 * 
	 * @param name
	 */
	public void search(String name) {
		Files activeFile = new Files();
		File file = (activeFile.getActive());
		Scanner sc;
		int counter = 0;
		String[] array = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				counter++;
				sc.nextLine();
			}
			array = new String[counter];
			sc.close();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			sc = new Scanner(file);

			for (int i = 0; i < array.length; i++) {
				array[i] = sc.nextLine();
			}
			sc.close();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		for (int i = 0; i < array.length; i++) {

			String line = array[i];
			String[] pair = line.split(" ");
			String user = pair[0];
			String date = pair[1];

			if (user.equals(name)) {
				info.setText("Birthday is on: " + date);
				break;
			} else {
				info.setText(null);
			}
		}

	}

	public String getNameF() {
		return nameF;
	}

}
