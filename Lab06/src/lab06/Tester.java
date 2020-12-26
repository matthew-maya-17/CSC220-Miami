package lab06;

import java.util.Arrays;

public class Tester {
	public static void main(String[] args) {
		//LAB TESTS
		System.out.println("LAB TESTS:");
		//TESTS FOR PART 1
		System.out.println("\nTESTS FOR PART 1:");
		SortedString case0 = new SortedString("zebra");
		SortedString case1 = new SortedString("below");
		SortedString case2 = new SortedString("ELBOw");
		SortedString case3 = new SortedString("");
		SortedString case4 = new SortedString("MaTtHeW");
		SortedString case5 = new SortedString("TaHtMeW");
		System.out.println("If 0 then test1 and test2 are equal: " + case1.compareTo(case2)); //Shows test1 and test 2 are equal
		System.out.println("0: Tests are equal, #>0: first test is greater then second test, #<0: first test is less then second test ----> " + case1.compareTo(case0));
		System.out.println("0: Tests are equal, #>0: first test is greater then second test, #<0: first test is less then second test ----> " + case0.compareTo(case1));
		System.out.println("Unsorted/Sorted: " + case2); //unsorted and sorted versions of string
		//TESTS FOR PART 2
		System.out.println("\nTESTS FOR PART 2:");
		AnagramUtil test1 = new AnagramUtil();
		System.out.println("Returns True if equal, else returns false: " +test1.areAnagrams(case3, case2)); //Empty vs another string
		System.out.println("Returns True if equal, else returns false: " +test1.areAnagrams(case2, case2)); //Same String
		System.out.println("Returns True if equal, else returns false: " +test1.areAnagrams(case4, case5)); //Shuffled Strings
		System.out.println("Returns True if equal, else returns false: " +test1.areAnagrams(case4, case2)); //Two different Strings
		System.out.println("Returns True if equal, else returns false: " +test1.areAnagrams(case1, case2)); // Case insensitive Strings
		//TESTS FOR PART 3
		System.out.println("\nTESTS FOR PART 3:");
		InsertionSort<Integer> test2 = new InsertionSort<Integer>();
		Integer[] case6 = new Integer[] {1};
		Integer[] case7 = new Integer[] {4,2};
		Integer[] case8 = new Integer[] {0,1,2,3,4,5,6,7,8,9};
		Integer[] case9 = new Integer[] {17,45,2,13,21,38,12,56};
		case6 = test2.sort(case6); //sorts case6
		case7 = test2.sort(case7); //sorts case7
		case8 = test2.sort(case8); //sorts case8
		case9 = test2.sort(case9); //sorts case9
		System.out.println("Returns sorted list for case6 using insertion sort: ");
		for(int i = 0; i < case6.length; i++) {
			System.out.print(case6[i] + " ");
		}
		System.out.println("\nReturns sorted list for case7 using insertion sort: ");
		for(int i = 0; i < case7.length; i++) {
			System.out.print(case7[i] + " ");
		}
		System.out.println("\nReturns sorted list for case8 using insertion sort: ");
		for(int i = 0; i < case8.length; i++) {
			System.out.print(case8[i] + " ");
		}
		System.out.println("\nReturns sorted list for case9 using insertion sort: ");
		for(int i = 0; i < case9.length; i++) {
			System.out.print(case9[i] + " ");
		}
		InsertionSort<SortedString> test3 = new InsertionSort<SortedString>();
		String[] myarray = new String[]{"joy", "ski", "fed", "cat"}; 
		SortedString[] case10 = SortedString.toSortedString(myarray);
		case10 = test3.sort(case10); //sorts case10
		System.out.println("\nReturns sorted list for case10 using insertion sort:");
		for(int i = 0; i < case10.length; i++) {
			System.out.print(case10[i] + " ");
		}
		//TESTS FOR PART 4
		System.out.println("\nTESTS FOR PART 4:");
		test2.fit(case9);
		System.out.println("Microseconds taken to run case 9 of size 1MIL: " + test2.predict(1000000));
		
		
		
		//ASSIGNMENT TESTS
		System.out.println("\nASSIGNMENT TESTS:");
		//TESTS FOR PART 1
		System.out.println("\nTESTS FOR PART 1:");
		String[] s3 = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		System.out.print(Arrays.toString(s3));
		//TESTS FOR PART 2
		System.out.println("\nTESTS FOR PART 2:");
		MergeSort<Integer> test4 = new MergeSort<Integer>();
		case6 = test4.sort(case6); //sorts case6
		case7 = test4.sort(case7); //sorts case7
		case8 = test4.sort(case8); //sorts case8
		case9 = test4.sort(case9); //sorts case9
		System.out.println("Returns sorted list for case6 using mergesort : ");
		for(int i = 0; i < case6.length; i++) {
			System.out.print(case6[i] + " ");
		}
		System.out.println("\nReturns sorted list for case7 using mergesort : ");
		for(int i = 0; i < case7.length; i++) {
			System.out.print(case7[i] + " ");
		}
		System.out.println("\nReturns sorted list for case8 using mergesort : ");
		for(int i = 0; i < case8.length; i++) {
			System.out.print(case8[i] + " ");
		}
		System.out.println("\nReturns sorted list for case9 using mergesort : ");
		for(int i = 0; i < case9.length; i++) {
			System.out.print(case9[i] + " ");
		}
		MergeSort<SortedString> test5 = new MergeSort<SortedString>();
		case10 = test5.sort(case10); //sorts case10
		System.out.println("\nReturns sorted list for case10 using mergesort :");
		for(int j = 0; j < case10.length; j++) {
			System.out.print(case10[j] + " ");
		}
		//TESTS FOR PART 3
		System.out.println("\n\nTESTS FOR PART 3:");
		test5.fit(case10);
		System.out.println("Microseconds taken to run case 9 of size 1MIL: " + test5.predict(1000000));
	}
}
