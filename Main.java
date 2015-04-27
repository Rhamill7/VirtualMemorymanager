/**
 * Robbie Hamill 201213786 CES 3rd Yr ACE3 V0.5
 * 
 * NOTE: Code contained in default package. All other code was retrieved from
 * OS concept files.
 * 
 * v0.1 - Began by getting classes and packages from book provided with the
 * exercise. Observed how RAF worked in relation to backing storage. Created a
 * scanner to scan in the input file. Put in a loop to do while the file has a
 * next value. Handles each virtual address location individually.
 * 
 * v0.2 - researched bit shifting and created a getOffset method and a
 * getPageNumber method to take the virtual address and get both numbers into
 * variables of their own. Encountered a possible error where the values once
 * bit shifted would be negative. As the numbers should be 32 bits so should
 * include a number of 0's before the offset and page number. Figured out the
 * problem was caused by the signed right shift operator rather than and
 * unsigned right shift.
 * 
 * v0.3 - created page method to check if the page number was contained within
 * the page table discovered that all entries but be set to the value of -1 as
 * the value 0 is a possible page number. added a boolean value to turn true if
 * the pageNumber was found in the page table. this replaced the need for an
 * empty method entirely which saved time.
 * 
 * v0.4 - Added an raf class which has selected parts from the RAF class
 * provided. Uses the disk.seek method to seek out the page number in backing
 * storage and put it into a byte array which is then copied over to the correct
 * index position in main memory and the page table is updated.
 * 
 * v0.5 - Added physical method to print the physical address and get the value
 * obtained from the physical address location in main memory. Gives an error
 * where not all physical address are correct and also the values are wrong.
 * 
 * v0.6 - Became aware of the fact that an exact copy of backing storage was
 * being put in physical memory so the values given out from the 2D array were 
 * correct but the physical addresses were wrong. Reworked The handling of copying
 * data from backing storage and into main memory.
 * 		  
 * v0.7 - Code still produced the correct values but the Physical addresses were wrong.
 * Decided to rework the full program and split it up into different classes rather than
 * struggling with the one class.
 * 
 * v0.8 - Tried for continuous hours of debugging through the program to try and understand
 * why the physical address did not work even after re implementing all of the code.
 * Found that each time the frame number was retrieved from the page table the frame numbers
 * were out by 1 each time. 
 * 
 * v0.9 - Decided it was best to redo the page table as a hash map instead that allowed a
 * page to map exactly to a frame. Once this was implemented the physical addresses were correct.
 * 
 * v1.0 - Implemented the TLB using a limited size hashmap and an ArrayList. When The 
 * TLB reached size 16 and another page mapping to a frame was to be added the first element in 
 * the array list would be removed from the page table and the List.
 *   
 * v1.1 - Attempted to implement a smaller physical memory size of 128 instead of 256
 * added some code to deal with the condition that if the frame number returned
 * as -1 this would mean main memory was full and that a frame would have to 
 * be replaced in order for it to work correctly. When main memory became full
 * this caused an array error that deleted everything from the implemented queue 
 * 		  
 * 
 * TODO: Figure out why some physical address are wrong and some are right and
 * fix the errors. Fix errors of wrong values fetched from main memory.
 * Implement TLB using replacement algorithms. Add test class to test methods.
 */

public class Main {

	public static void main(String[] args) {
		// create new instance of simple program and begin
		VirtualAddressScanner start = new VirtualAddressScanner();
		start.begin();
	}

}
