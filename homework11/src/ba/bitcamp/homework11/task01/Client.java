package ba.bitcamp.homework11.task01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {

		try {
			Socket socket = new Socket("localhost", 1993);

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream()));

			Scanner in = new Scanner(System.in);

			String filePath = in.nextLine();

			writer.write(filePath);
			writer.newLine();
			writer.flush();

			System.out.println(reader.readLine());

			writer.close();
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
