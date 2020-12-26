package lab01;

public class SumExperiment {
	
	public static int checkSum(int[] array){
		// This function will inspect the input to find any pair of values that add up to 20
		// if it find such a pair, it will return the *index* of the smallest value
		// if it does not find such as pair, it will return -1;
		int first_index = 0, last_index = array.length - 1, output = 0;
		while (output != 20) {
			output = array[first_index] + array[last_index];
			if(output > 20 && first_index != last_index) {
				last_index--;
			}
			else if (output < 20 && first_index != last_index) {
				first_index++;
			} 
			else if ( output == 20 && first_index != last_index) {
				return first_index;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		int[] array1 = new int[]{5, 7, 8, 9, 10, 15, 16};
		if (checkSum(array1) != 0)
			System.err.println("TEST1 FAILED");
		
		int[] array2 = new int[]{3, 5, 8, 9, 10, 15, 16};
		if (checkSum(array2) != 1)
			System.err.println("TEST2 FAILED");

		
		int[] array3 = new int[]{3, 4, 6, 9, 10, 14, 15};
		if (checkSum(array3) != 2)
			System.err.println("TEST3 FAILED");
		
		int[] array4 = new int[]{6, 7, 8, 9, 10, 15, 16};
		if (checkSum(array4) != -1)
			System.err.println("TEST4 FAILED");
		
		System.out.println("Done!!!");
	}
}
