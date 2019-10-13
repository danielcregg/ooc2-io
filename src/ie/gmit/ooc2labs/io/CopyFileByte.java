package ie.gmit.ooc2labs.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CopyFileByte {
	public static void main(String args[]) {
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		int b = 0; // Reading and Writing bytes but read method returns int

		try {
			inputStream = new FileInputStream(".\\resources\\input.txt");
			outputStream = new FileOutputStream(".\\resources\\output.txt");

			// Note: The read method below returns an int instead of a byte.
			/*
			 * The reason for it returning the value as an int is that it needs to return a
			 * value between 0-255, as well as being able to indicate when there is no more
			 * bytes to read from the file. By using an int, you can return the full range
			 * of positive unsigned values 0-255, as well as indicate when the file is
			 * complete. It would not be able to provide this with only the 256 distinct
			 * values of a byte value, half of which are negative by Java default.A byte of
			 * data is an unsigned value with a range from 0 to 255, while a byte in java is
			 * defined to range from -128 to 127, which doesn't make sense when reading
			 * binary data. read() returns an integer to allow it to use all of the
			 * non-negative values to represent valid data, and a negative value to signal
			 * end of data. In general, a function should indicate an error condition or
			 * exception using a different mechanism from the one it uses to return data. In
			 * the simplest case, it can return a value that cannot be used to represent
			 * valid data, to ensure its meaning is unambiguous.
			 */

			while ((b = inputStream.read()) != -1) {
				// Uncomment next 7 lines to see bytes copied - http://www.asciitable.com/
				System.out.printf("%d - %c\n", b, b);
				// Sleep for half a second (500 milliseconds)
				TimeUnit.MILLISECONDS.sleep(500);
				// Write byte to output.txt
				outputStream.write(b);
			}

			System.out.println("\nCopy complete! See resources/output.txt");
		} catch (FileNotFoundException fnfExceptionObject) {
			System.out.println("File NOT copied because file not found! See error below:");
			fnfExceptionObject.printStackTrace();
		} catch (InterruptedException ieExceptionObject) {
			System.out.println("Sleep was interrupted! See error below:");
			ieExceptionObject.printStackTrace();
		} catch (IOException ioExceptionObject) {
			System.out.println("Write was interrupted! See error below:");
			ioExceptionObject.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException ioObject) {
				ioObject.printStackTrace();
			}
		}
	}
}
