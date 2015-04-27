public class Getters {

	//Get offset
	public int getOffset(int virtualAddress) {
		return virtualAddress & 255;
	}
	//get page number
	public int getPageNumber(int virtualAddress) {
		int pageNumber = ((virtualAddress << 16) >>> 24);
		return pageNumber;
	}
}