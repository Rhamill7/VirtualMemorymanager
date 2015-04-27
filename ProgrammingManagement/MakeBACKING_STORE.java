package ProgrammingManagement;


import java.io.*;

public class MakeBACKING_STORE
{
	public static void main(String[] args) throws java.io.IOException {
		// the file representing the simulated  disk
     	File fileName;
     	RandomAccessFile disk = null;

		try {
              	fileName = new File("BACKING_STORE");
              	disk = new RandomAccessFile(fileName, "rw");
		
			for (int i = 0; i < 256*256/4; i++) {
				disk.writeInt(i);
			}
          }
          catch (IOException e) {
          	System.err.println ("Unable to create the file BACKING_STORE");
              	System.exit(1);
          }
		finally {
			disk.close();
		}
	}
}
