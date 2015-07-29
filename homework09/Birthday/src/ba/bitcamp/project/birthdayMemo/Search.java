package ba.bitcamp.project.birthdayMemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Search extends JFrame {

	private static final long serialVersionUID = -6885018973970669424L;

	// Planes

	JPanel search1 = new JPanel();

	// Buttons

	JButton sVname = new JButton("View by name");
	JButton sVmonth = new JButton("View by month");
	JButton sVall = new JButton("View all");
	JButton sCancel = new JButton("Cancel");

	public Search() {
		// Welcome frame

		setTitle("SEARCH");
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(240, 280);
		setResizable(false);
		setLocationRelativeTo(null);

		// Plane 1
		add(search1);
		search1.setLayout(new FlowLayout(FlowLayout.CENTER));
		search1.setBackground(Color.ORANGE);
		
		search1.add(sVname);
		sVname.setBackground(Color.WHITE);
		sVname.setOpaque(true);
		sVname.setPreferredSize(new Dimension(200, 55));
		sVname.setForeground(Color.BLUE);
		sVname.setBorderPainted(true);

		search1.add(sVmonth);
		sVmonth.setBackground(Color.WHITE);
		sVmonth.setOpaque(true);
		sVmonth.setPreferredSize(new Dimension(200, 55));
		sVmonth.setForeground(new Color(70, 150, 100));
		sVmonth.setBorderPainted(true);

		search1.add(sVall);
		sVall.setBackground(Color.WHITE);
		sVall.setOpaque(true);
		sVall.setPreferredSize(new Dimension(200, 55));
		sVall.setForeground(Color.MAGENTA);
		sVall.setBorderPainted(true);

		search1.add(sCancel);
		sCancel.setBackground(Color.WHITE);
		sCancel.setOpaque(true);
		sCancel.setPreferredSize(new Dimension(200, 55));
		sCancel.setForeground(Color.DARK_GRAY);
		sCancel.setBorderPainted(true);

		// search via name button
		sVname.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Name();
			}
		});
		
		// search via month button
				sVmonth.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new Month();
					}
				});
		
		
		//view all
		
		sVall.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dates = "";
				try {
					Files activeFile = new Files();
					File file = (activeFile.getActive());
					Scanner sc = new Scanner(file);
					while (sc.hasNextLine()) {
						
						dates += sc.nextLine() + "\n";
						
						}
						JOptionPane.showMessageDialog(null, dates);
						sc.close();

					}

				 catch (FileNotFoundException e3) {
					e3.printStackTrace();
				}
				
				
			}
		});
		
		//cancel
		
		sCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});

		setVisible(true);

	}
}