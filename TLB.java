import java.util.ArrayList;
import java.util.HashMap;

public class TLB {

	HashMap<Integer, Integer> TLB = new HashMap<Integer, Integer>();
	ArrayList<Integer> FIFOQueue = new ArrayList<Integer>();

	public TLB() {
	}

	public void addtoTLB(int pageNumber, int frameNumber) {
		// Put value into Hash Map and remove first if size is 16.
		if (TLB.size() >= 16) {
			TLB.remove(FIFOQueue.get(0));
			FIFOQueue.remove(0);
			
		}
		// addtoTLB
		TLB.put(pageNumber, frameNumber);
		FIFOQueue.add(pageNumber);
	}
	//get the frame number
	public int getFrame(int pageNumber) {
		int frameNumber = TLB.get(pageNumber);
		return frameNumber;

	}

	// checkTLBv for page number
	public boolean checkTLB(int pageNumber) {
		if (TLB.containsKey(pageNumber)) {
			return true;

		} else {
			return false;
		}

	}
}