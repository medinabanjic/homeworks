package ba.bitcamp.project.birthdayMemo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Month extends JFrame {

	private static final long serialVersionUID = -7317348737907959271L;

	// Panels
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();

	// Labels
	JLabel enquiry = new JLabel("Enter month: ");
	JLabel info = new JLabel("");
	JLabel example = new JLabel("ex: 5 = May, 12 = December");

	// TextField
	JTextField month = new JTextField(15);

	// Buttons
	JButton ok = new JButton("OK");
	JButton cancel = new JButton("Cancel");

	// variables
	private String monthF = "";

	public Month() {
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
		panel.add(example);
		panel.add(month);

		// OK button
		panel.add(ok);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				monthF = month.getText();
				search(monthF);

			}
		});

		// Cancel button
		panel.add(cancel);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				monthF = "";
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
	 * This method searches for a given month in array of strings.
	 * 
	 * @param month
	 */
	public void search(String month) {
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
		String[] text = new String[array.length];
		int j = 0;
		for (int i = 0; i < array.length; i++) {

			String line = array[i];
			String[] pair = line.split(" ");
			String user = pair[0];
			String date = pair[1];

			String months = date.substring(4, 5);

			if (months.equals(month)) {
				text[j] = user + "'s birthday is on: " + date;
				j++;
			}
		}
		int counter1 = 0;
		for (int i = 0; i < text.length; i++) {
			if (text[i] == null) {
				counter1++;
			}
		}

		text = Arrays.copyOf(text, text.length - counter1);
		String s = "";
		if (text.length > 0) {
			for (int x = 0; x < text.length; x++) {
				if (x == text.length - 1) {
					s += text[x];
				} else {
					s += text[x] + "<br>";
				}
			}

			info.setText("<html>" + s + "</html>");

		}
	}

	public String getNameF() {
		return monthF;
	}
}
