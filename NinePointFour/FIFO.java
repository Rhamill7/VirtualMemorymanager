package NinePointFour;

import java.util.ArrayList;

public class FIFO extends ReplacementAlgorithm {

	public FIFO(int pageFrameCount) {
		super(pageFrameCount);
	}

	@Override
	public void insert(int pageNumber) {
		// int tlb[]= new int[16];
		ArrayList<Integer> tlb = new ArrayList<Integer>();
		tlb.add(pageNumber);
	}
}
