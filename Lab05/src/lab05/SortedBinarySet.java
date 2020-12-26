package lab05;

public class SortedBinarySet {
	/** represent the simple array that holds the list values */
	public double[] theData;
	/** holds the length of the storage array */
	private int capacity;
	/** holds the number of elements in the list */
	private int size;

	/** constant for initial storage array capacity */
	private static final int INITIAL_STORAGE_CAPACITY = 11;

	/** keep this FALSE for lab; we will play with this in the assignment **/
	public boolean usesBinarySearch = false;

	/** default constructor */
	public SortedBinarySet(){
		theData = new double[INITIAL_STORAGE_CAPACITY];
		capacity = theData.length;
		size = 0;
	}

	public SortedBinarySet(double[] input){
		// TODO (for assignment, not lab)
		theData = new double[INITIAL_STORAGE_CAPACITY];
		capacity = theData.length;
		size = 0;
		for(int x=0; x < input.length; x++) {
			insert(input[x]);
			if(findIndex(x) < x) {
				remove(x);
			}
		}
	}

	public boolean empty(){
		if(size == 0) {
			return true;
		}
		return false; //placeholder
	}

	public int size(){
		return size; //placeholder
	}

	public void grow(){
		capacity = theData.length * 2;
		double[] NewData = new double[capacity];
		for(int i = 0; i < size; i++) {
			NewData[i] = theData[i];
		}
		theData = NewData;
		
	}

	public String toString(){
		String s = "";
		for(int i = 0; i < size; i++) {
			s += theData[i] + " ";
		}
		return "Elements: " + s + " Capacity: " + capacity + " Size: " + size;
	}

	public void clear() {
		for(int i = 0; i < capacity; i++) {
			theData[i] = 0.0;
		}
		size = 0;
	}

	public boolean insert(double newVal){
		if(size == capacity) {
			grow();
		}
		int index = findIndex(newVal);
		if(index >= 0) {
			return false;
		}
		else {
			index = Math.abs(index) - 1;
			for(int i = index; i < capacity; i++) {
				double element = theData[i];
				theData[i] = newVal;
				newVal = element;
			}
			size++;
			return true;
		}
	}

	public boolean remove(double element){
		int index = findIndex(element);
		if(index >= 0) {
			size--;
			theData[index] = 0.0; //IDK if this is necessary
			for(int i = index; i < theData.length - 1; i++) {
				theData[i] = theData[i+1];
			}
			return true;
		}
		return false; 
	}


	private int sequentialFind(double target) {
		for(int i = 0; i < size; i++) {
			if(theData[i] == target) {
				return i;
			}
			if(theData[i] > target) {
				return -i - 1;
			}
		}
		return -size - 1;//placeholder
	}

	private int binaryFind(double target) {
		int min = 0, max = size - 1;
		int mid = (max+min) / 2;
		while(min <= max) {
			mid = (max+min) / 2;
			if(theData[mid] == target) {
				return mid;
			}
			else if(theData[mid] > target) {
				max = mid - 1;
			}
			else if(theData[mid] < target) {
				min = mid + 1;
			}
		}
		return -min - 1;
	}

	public int findIndex(double target) {
		usesBinarySearch = true;
		if (usesBinarySearch) {
			return binaryFind(target);
		} else {
			return sequentialFind(target);
		}
	}

	public boolean containsAll(double[] elements){
		for(int i = 0; i < elements.length -1; i++) {
			if(binaryFind(elements[i]) < 0) {
				System.out.println(elements[i]);
				return false;
			}
		}
		return true;
	}

	public boolean contains(double element){
		if (binaryFind(element) >= 0) {
			return true;
		}
		return false; // placeholder
	}

}
