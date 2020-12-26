package lab05;

public class Tester {
	public static void main(String[] args) {
		double arr[] = new double[] {3.85, 0.3};
		SortedBinarySet s = new SortedBinarySet();
		System.out.println("Empty value of s: " + s.empty());
		System.out.println("Original size of s: " + s.size());
		//Inserts a bunch of values
		s.insert(1.35);
		s.insert(0.3);
		s.insert(0.27);
		s.insert(2.91);
		s.insert(4.17);
		s.insert(0.923);
		s.insert(0.0);
		s.insert(1.67);
		System.out.println("SortedBinarySet before growing:        " + s);
		s.insert(1.83);
		s.insert(2.31);
		s.insert(-2.31);
		s.insert(3.85);
		s.insert(0.12);
		s.insert(0.04);
		s.insert(4.25);
		s.insert(3.14);
		s.insert(8.27);
		s.insert(5.63);
		s.insert(3.74);
		s.insert(9.33);
		//Prints out the toString Method
		System.out.println("SortedBinarySet after growing:         "+ s);
		//Clears all values
		s.clear();
		//Prints out the toString Method
		System.out.println("S after being Cleared: " + s);
		
		//Assignment Tests
		
		//Removes the value 0.12 from the array and moves values down
		System.out.println("Removes the value 0.12" + s.remove( 0.12));
		//Removes the value 0.12 from the array and moves values down
		System.out.println(s.contains(0.124));
		System.out.println("contains all?: " + s.containsAll(arr));
		
		double[] values = new double[] {0.12,1.37,2.4,7.5,4.2,5.1,6.3};
		SortedBinarySet test2 = new SortedBinarySet(values);
		//Removes the value 0.12 from the array and moves values down
		System.out.println("Removes the value 0.12" + s.remove( 0.12));
		if(test2.findIndex(0.12) > 0) {
			System.err.println("TEST FAILED: element still in array");
		}
		if(test2.findIndex(1.37) != 1) {
			System.err.println("TEST FAILED: wrong index returned by method");
		}
		if(test2.contains(7.5) != true) {
			System.err.println("TEST FAILED: method should return true for this value");
		}
		if(test2.contains(2.7) != false) {
			System.err.println("TEST FAILED: method should return false for this value");
		}
		double[] values2 = new double[] {1.2,3.5,4.3,5.1,6.3};
		if(test2.containsAll(values2) == true) {
			System.err.println("TEST FAILED: method should return false");
		}
	}
}
