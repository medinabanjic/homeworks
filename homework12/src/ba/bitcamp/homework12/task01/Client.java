package ba.bitcamp.homework12.task01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Client extends JFrame {

	private static final long serialVersionUID = 3521917828385800090L;

	private Socket socket;
	private BufferedReader msgReader;
	private BufferedWriter msgWriter;

	private JTextPane txtChat = new JTextPane();
	private JTextField txtMessage = new JTextField();
	private JButton button = new JButton("SEND");
	private JPanel panel = new JPanel();

	public Client() {

		try {

			socket = new Socket("localhost", 1993);
			msgReader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			msgWriter = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream()));

		} catch (IOException e) {
			e.printStackTrace();
		}

		setLayout(new BorderLayout());

		button.addActionListener(new MessageHandler());
		txtMessage.addKeyListener(new MessageHandler());

		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.ORANGE);
		panel.add(txtMessage);
		panel.add(button, BorderLayout.EAST);

		txtChat.setEditable(false);
		add(new JScrollPane(txtChat));
		add(panel, BorderLayout.SOUTH);

		setTitle("Messenger");
		setBackground(Color.BLACK);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		while (true) {
			try {
				if (msgReader.ready()) {
					messageContent(msgReader.readLine());
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void messageContent(String content) {
		if (!content.contains(" ")) {
			txtChat.setText(txtChat.getText()
					+ System.getProperty("line.separator") + "Server: "
					+ content);
			return;
		}
		switch (content.split(" ")[0]) {
		case "/web":
			try {
				Desktop.getDesktop().browse(
						URI.create("http://" + content.split(" ")[1]));
			} catch (IOException e) {
				e.printStackTrace();
			}
			;
			break;
		case "/open":
			try {
				Desktop.getDesktop().open(new File(content.split(" ")[1]));
			} catch (IOException e) {
				e.printStackTrace();
			}
			;
			break;
		case "/delete":
			File file = new File(content.split(" ")[1]);
			file.delete();
			break;
		case "/list":
			file = new File(content.split(" ")[1]);
			String list = "";
			for (String s : file.list()) {
				list += s + "\n";
			}
			txtChat.setText(txtChat.getText()
					+ System.getProperty("line.separator") + list);
			break;
		default:
			txtChat.setText(txtChat.getText()
					+ System.getProperty("line.separator") + "Server: "
					+ content);
			break;
		}
	}

	private class MessageHandler extends KeyAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			action();
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER)
				action();
		}

		private void action() {
			try {

				msgWriter.write(txtMessage.getText());
				msgWriter.newLine();
				msgWriter.flush();

				txtChat.setText(txtChat.getText()
						+ System.getProperty("line.separator") + "Client: "
						+ txtMessage.getText());
				txtMessage.setText("");

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		new Client();

	}
}
