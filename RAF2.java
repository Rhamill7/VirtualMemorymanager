import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RAF2 {

	public byte[] raf(int pageNumber) {

		// the file representing the simulated disk
		File fileName;
		RandomAccessFile disk = null;
		byte[] data = new byte[256];

		try {
			fileName = new File("BACKING_STORE");
			disk = new RandomAccessFile(fileName, "r");
			// seek to byte position specified in pageNumber
			disk.seek(pageNumber * 256);
			disk.read(data);
			disk.close();
		} catch (IOException e) {
			System.err.println("Unable to start the disk");
			System.exit(1);
		}
		return data;
	}
}
