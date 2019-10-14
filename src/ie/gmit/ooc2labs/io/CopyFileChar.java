package ie.gmit.ooc2labs.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CopyFileChar {

	public static void main(String args[]) throws IOException {
		FileReader in = null;
		FileWriter out = null;
		int c;

		try {
			in = new FileReader("resources/input.txt");
			out = new FileWriter("resources/output.txt");

			while ((c = in.read()) != -1) {
				// Uncomment to see bytes copied - http://www.asciitable.com/
				// System.out.println(c);
				System.out.printf("%d - %c\n", c, c);
				// Sleep for half a second (500 milliseconds)
				TimeUnit.MILLISECONDS.sleep(500);
				out.write(c);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}
