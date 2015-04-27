import java.util.ArrayList;
import java.util.Arrays;

public class PhysicalMemory {

	 byte mainMemory[][] = new byte[256][256];
//	byte mainMemory[][] = new byte[128][256];
//	ArrayList<Integer> FIFO = new ArrayList<Integer>();

	public PhysicalMemory() {
		Arrays.fill(mainMemory, null);
	}

//	public void makeNull() {
//		mainMemory[0] = null;
//		System.out.println(FIFO);
//		FIFO.remove(0);
//	}

	public int fill(byte[] data) {

		for (int i = 0; i < mainMemory.length; i++) {
			if (mainMemory[i] == null) {
				mainMemory[i] = data;
//				FIFO.add(i);
//				System.out.println(FIFO);
				return i;
			}
		}
		return -1;
	}

//	public ArrayList<Integer> getArrayList() {
//		return FIFO;
//	}

	public int physical(int frameNo, int offset) {
		int physicalAddress;
		physicalAddress = (frameNo << 8 | offset); // get physical address
		return physicalAddress;
	}

	public int value(int frameNo, int offset) {
//		System.out.println(frameNo + offset);
		int value = mainMemory[frameNo][offset]; // get value from correct index
		return value;
	}
}
