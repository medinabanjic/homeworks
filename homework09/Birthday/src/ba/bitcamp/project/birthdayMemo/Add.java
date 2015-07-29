package ba.bitcamp.project.birthdayMemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Add extends JFrame {

	private static final long serialVersionUID = -7170357261821886322L;
	// Panels

	JPanel add1 = new JPanel();
	JPanel add2 = new JPanel();

	// Labels

	JLabel aLabel1 = new JLabel("Name");
	JLabel aLabel2 = new JLabel("Date");

	// Buttons

	JButton aAdd = new JButton("ADD");
	JButton aCancel = new JButton("Cancel");

	// Text Fields

	JTextField aName = new JTextField(15);
	JTextField aDate = new JTextField(15);

	// Text Areas

	JTextArea aNote = new JTextArea("Note: " + "\nPlease enter date in\nformat dd.mm.");

	// files

	File activeFile = null;

	public Add() {
		// Add frame

		setTitle("Add Birthday");
		setBackground(Color.WHITE);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 400);
		setResizable(false);
		setLocationRelativeTo(null);

		// panel 1

		add(add1);
		add1.setLayout(new FlowLayout());
		add1.setPreferredSize(new Dimension(200, 200));
		add1.add(aLabel1);
		add1.add(aName);
		add1.add(aLabel2);
		add1.add(aDate);
		add1.add(aAdd);
		aAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Files active = new Files();
				File file = active.getActive();
				int counter = 0;
				Scanner sc;
				try {
					sc = new Scanner(file);
					while (sc.hasNextLine()) {
						counter++;
						sc.nextLine();
					}
					sc.close();
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				String[] array = new String[counter + 1];

				try {
					sc = new Scanner(file);

					for (int i = 0; i < array.length - 1; i++) {
						array[i] = sc.nextLine();
					}
					sc.close();
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				array[array.length - 1] = aName.getText() + " " + aDate.getText();

				try {

					PrintWriter pw = new PrintWriter(file);
					for (int i = 0; i < array.length; i++)
						pw.println(array[i]);
					pw.close();

				} catch (FileNotFoundException e1) {
				}

				setVisible(false);
				try {
					new Choice();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		add1.add(aCancel);
		aCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				aName.setText(null);
				aDate.setText(null);
				setVisible(false);

			}
		});

		// panel 2

		add(add2);
		add2.setPreferredSize(new Dimension(200, 90));
		add2.setLayout(new BorderLayout());
		add2.add(aNote);
		aNote.setEditable(false);
		setVisible(true);
	}
}