//Ovaj zadatak sam na jednom od predavanja nadogradila, pa mi je bilo bespotrebno sada
//vratiti ga u pocetno stanje.

//Ako kliknemo na bilo koju boju u malim kvadraticima kao i na veliki pa odemo na paste u bilo koji file
// dobit cemo RGB vrijednosti, svi kvadratici osim prvih 5 jer su oni konstante 

package ba.bitcamp.homework06.task01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Task05 extends JPanel {

	private static final long serialVersionUID = 4382555051242696286L;
	JFrame window = new JFrame();

	JPanel colors = new JPanel();
	JPanel button = new JPanel();
	JPanel sliders = new JPanel();

	private static int red;
	private static int green;
	private static int blue;

	private static int redD;
	private static int greenD;
	private static int blueD;
	private static int saveI;

	JButton[] buttons = new JButton[25];
	Color[] defaultColors = new Color[] { Color.BLACK, Color.WHITE, Color.BLUE, Color.RED, Color.GREEN };

	JButton saveColor = new JButton("Click to select");
	private static Color activeColorMixed = new Color(red, green, blue);

	private static Color[] activeColor = new Color[25];

	public Task05() {
		setLayout(new GridLayout(1, 3, 1, 5));
		window.add(this);

		this.add(colors);
		colors.setLayout(new GridLayout(5, 5));

		for (int i = 0; i < buttons.length; i++) {
			saveI = i;
			buttons[i] = new JButton();
			if (i > 4) {
				redD = (int) (Math.random() * 256 - 1);
				greenD = (int) (Math.random() * 256 - 1);
				blueD = (int) (Math.random() * 256 - 1);
				buttons[i].setBackground(new Color(redD, greenD, blueD));
				activeColor[i] = new Color(redD, greenD, blueD);
			} else {
				buttons[i].setBackground(defaultColors[i]);
			}
			buttons[i].setOpaque(true);
			buttons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			buttons[i].setBorderPainted(true);
			colors.add(buttons[i]);
			buttons[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					System.out.println(activeColor[saveI]);

				}
			});

		}

		this.add(button);
		button.setBackground(Color.WHITE);
		button.setLayout(new BorderLayout());
		button.add(saveColor);
		saveColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				activeColorMixed = new Color(red, green, blue);
				System.out.println(activeColorMixed);

			}
		});
		updateButton();

		this.add(sliders);
		sliders.setBackground(Color.WHITE);
		sliders.setLayout(new GridLayout(2, 3));

		JSlider redSlider = new JSlider(0, 255);
		initSlider(redSlider, "red");

		JSlider blueSlider = new JSlider(0, 255);
		initSlider(blueSlider, "blue");

		JSlider greenSlider = new JSlider(0, 255);
		initSlider(greenSlider, "green");

		// labels

		JLabel redLabel = new JLabel("RED");
		JLabel blueLabel = new JLabel("BLUE");
		JLabel greenLabel = new JLabel("GREEN");

		sliders.add(redLabel);
		sliders.add(blueLabel);
		sliders.add(greenLabel);
		sliders.add(redSlider);
		sliders.add(blueSlider);
		sliders.add(greenSlider);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(900, 300);
		window.setVisible(true);
	}

	// final String name = Eclipse je zahtjevao quick fix, na predavanjima je
	// radilo i bez tog final

	private void initSlider(JSlider slider, final String name) {
		slider.setName(name);
		slider.setValue(0);
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(25);
		slider.setPaintTicks(true);
		slider.setOrientation(JSlider.VERTICAL);
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider changed = (JSlider) e.getSource();

				switch (name) {
				case "red":
					red = changed.getValue();
					break;
				case "green":
					green = changed.getValue();
					break;
				case "blue":
					blue = changed.getValue();
					break;
				}

				updateButton();

			}
		});

	}

	private void updateButton() {
		saveColor.setBackground(new Color(red, blue, green));
		saveColor.setOpaque(true);
		saveColor.setBorderPainted(false);
	}

	public static void main(String[] args) {
		new Task05();

	}

}
