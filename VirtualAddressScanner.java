import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class VirtualAddressScanner {
	float TLBhit = 0;
	float TLBMiss = 0;
	float pageFault = 0;
	float TLBHitrate = 0;

	Getters get = new Getters();
	PageTable pT = new PageTable();
	RAF2 backing = new RAF2();
	PhysicalMemory mem = new PhysicalMemory();
	TLB tlb = new TLB();

	public VirtualAddressScanner() {}

//	public void FIFO(int pageNumber) {
//		pT.remove(pageNumber);
//		System.out.println(mem.getArrayList());
//		mem.makeNull();
//	}

	public void begin() {

		Getters get = new Getters();
		PageTable pT = new PageTable();
		RAF2 backing = new RAF2();
		PhysicalMemory mem = new PhysicalMemory();
		TLB tlb = new TLB();
		// FIFO fifo = new FIFO(0);
		float numOfAddresses = 0;
		try {
			Scanner scan = new Scanner(new File("InputFile.txt")); // scan
																	// InputFile
			while (scan.hasNext()) { // while file has a next
				int virtualAddress = scan.nextInt(); // set virtual address to
				int value, frameNo = 0; 
				System.out.print("\nVirtual address: " + virtualAddress);
				int offset = get.getOffset(virtualAddress);
				int pageNumber = get.getPageNumber(virtualAddress);
				// System.out.println("\n" + pageNumber);

				if (tlb.checkTLB(pageNumber) == true) {
					frameNo = tlb.getFrame(pageNumber);
					// System.out.println("Page Number"+pageNumber);
					TLBhit++;
					numOfAddresses++;
				} else {
					if (pT.contains(pageNumber)) {
						frameNo = pT.getPage(pageNumber);
						// System.out.println("HELLO" + frameNo);
						TLBMiss++;
						numOfAddresses++;
						// System.out.println(" PAGE TABLE ");
						// System.out.println(" "+ pageNumber +" "+frameNo);
					} else {
						byte[] data = backing.raf(pageNumber);
						frameNo = mem.fill(data);
						// //////////////////////////////////////////////////////////////////////////////////////////
//						if (frameNo == -1) {
//							System.out.println(pageNumber);
//							this.FIFO(pageNumber);
//							frameNo = mem.fill(data);
//							System.out.println("FRAME NUMBER XXX " + frameNo);
//						}
//						// /////////////////////////////////////////////////////////////////////////////////////////
						// System.out.println(" "+ pageNumber +" "+frameNo);
						pT.setPage(pageNumber, frameNo);
						pageFault++;
						numOfAddresses++;
						// System.out.println(" BACKING STORE ");
						tlb.addtoTLB(pageNumber, frameNo);

					}
				}
				// System.out.println("Page Number " + pageNumber);
				// System.out.println("Frame No " + frameNo);
				// numOfAddresses++;
				int physicalAddress = mem.physical(frameNo, offset);
				// System.out.println("Offset " + offset);
				System.out.print(" Physical address: " + physicalAddress);
				value = mem.value(frameNo, offset);
				System.out.print(" Value: " + value);
			}
			//Printing out the rates of the system
			float TLBHitrate = ((TLBhit * 100.00f) / numOfAddresses);
			float TLBMissrate = ((TLBMiss * 100.00f) / numOfAddresses);
			float PageFaultrate = ((pageFault * 100.00f) / numOfAddresses);
			System.out.println("\nTLB hit rate " + TLBHitrate + "%"
					+ "\nTLB miss rate " + TLBMissrate + "%"
					+ "\nPage fault rate " + PageFaultrate + "%");
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}

	}

}