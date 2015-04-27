import java.util.Arrays;
import java.util.HashMap;

public class PageTable {
	
	boolean pageCheck[] = new boolean[256];
	HashMap<Integer, Integer> pageTable = new HashMap<Integer, Integer>();

	public PageTable() {
	}
	//check page table contains frame
	public boolean contains(int pageNumber) {
		if (pageTable.containsKey(pageNumber)) {
			return true;
		}
		return false;
	}

	// public void remove(int pageNumber) {
	// // if((Arrays.asList(pageTable)).contains(pageNumber)){
	// pageTable.remove(pageNumber);
	// }

	//Set the page in page table
	public void setPage(int pageNumber, int frameNumber) {
		pageTable.put(pageNumber, frameNumber);
	}
	//get the frame form page table
	public int getPage(int pageNumber) {
		return pageTable.get(pageNumber);

	}

}
