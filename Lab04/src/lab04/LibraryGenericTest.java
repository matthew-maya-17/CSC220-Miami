package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Testing class for generic Library.
 *
 */
public class LibraryGenericTest {

  public static void main(String[] args) {

    // test a library that uses names (String) to id patrons
    Library<String> lib1 = new Library<String>();
    lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib1.add(9780446580342L, "David Baldacci", "Simple Genius");

    String patron1 = "Jane Doe";

    if (!lib1.checkout(9780330351690L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (!lib1.checkout(9780374292799L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: second checkout");
    ArrayList<LibraryBook<String>> booksCheckedOut1 = lib1
        .lookup(patron1);
    if (booksCheckedOut1 == null
        || booksCheckedOut1.size() != 2
        || !booksCheckedOut1.contains(new Book(9780330351690L, "Jon Krakauer",
            "Into the Wild"))
        || !booksCheckedOut1.contains(new Book(9780374292799L,
            "Thomas L. Friedman", "The World is Flat"))
        || !booksCheckedOut1.get(0).getHolder().equals(patron1)
        || !booksCheckedOut1.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1))
        || !booksCheckedOut1.get(1).getHolder().equals(patron1)
        || !booksCheckedOut1.get(1).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1)))
      System.err.println("TEST FAILED: lookup(holder)");
    if (!lib1.checkin(patron1))
      System.err.println("TEST FAILED: checkin(holder)");

    // test a library that uses phone numbers (PhoneNumber) to id patrons
    Library<PhoneNumber> lib2 = new Library<PhoneNumber>();
    lib2.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib2.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib2.add(9780446580342L, "David Baldacci", "Simple Genius");

    PhoneNumber patron2 = new PhoneNumber("305.555.1234");

    if (!lib2.checkout(9780330351690L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (!lib2.checkout(9780374292799L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: second checkout");
    ArrayList<LibraryBook<PhoneNumber>> booksCheckedOut2 = lib2
        .lookup(patron2);
    if (booksCheckedOut2 == null
        || booksCheckedOut2.size() != 2
        || !booksCheckedOut2.contains(new Book(9780330351690L, "Jon Krakauer",
            "Into the Wild"))
        || !booksCheckedOut2.contains(new Book(9780374292799L,
            "Thomas L. Friedman", "The World is Flat"))
        || !booksCheckedOut2.get(0).getHolder().equals(patron2)
        || !booksCheckedOut2.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1))
        || !booksCheckedOut2.get(1).getHolder().equals(patron2)
        || !booksCheckedOut2.get(1).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1)))
      System.err.println("TEST FAILED: lookup(holder)");
    if (!lib2.checkin(patron2))                           
      System.err.println("TEST FAILED: checkin(holder)");
    
    System.out.println("Testing done.");
    
    // FILL IN for tests
    // test a library that uses phone numbers (PhoneNumber) to id patrons
//    Library<PhoneNumber> lib3 = new Library<PhoneNumber>();
//    lib3.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
//    lib3.add(9780330351690L, "Jon Krakauer", "Into the Wild");
//    lib3.add(9780446580342L, "David Baldacci", "Simple Genius");
//
//    PhoneNumber patron3 = new PhoneNumber("631-353-9789");
//
//    if (!lib3.checkout(9780330351690L, patron3, 1, 1, 2008))
//      System.err.println("TEST FAILED: first checkout");
//    if (!lib3.checkout(9780374292799L, patron3, 1, 1, 2008))
//      System.err.println("TEST FAILED: second checkout");
//    ArrayList<LibraryBook<PhoneNumber>> booksCheckedOut3 = lib3
//        .lookup(patron3);
//    if (booksCheckedOut3 == null
//        || booksCheckedOut3.size() != 2
//        || !booksCheckedOut3.contains(new Book(9780330351690L, "Jon Krakauer",
//            "Into the Wild"))
//        || !booksCheckedOut3.contains(new Book(9780374292799L,
//            "Thomas L. Friedman", "The World is Flat"))
//        || !booksCheckedOut3.get(0).getHolder().equals(patron3)
//        || !booksCheckedOut3.get(0).getDueDate().equals(
//            new GregorianCalendar(2008, 1, 1))
//        || !booksCheckedOut3.get(1).getHolder().equals(patron3)
//        || !booksCheckedOut3.get(1).getDueDate().equals(
//            new GregorianCalendar(2008, 1, 1)))
//      System.err.println("TEST FAILED: lookup(holder)");
//    if (!lib3.checkin(patron3))                           
//      System.err.println("TEST FAILED: checkin(holder)");
    
    // FOR LAB: write tests for getInventoryList
    ArrayList<LibraryBook<String>> lib1Inventory = lib1.getInventoryList();
    for(int i = 1; i < lib1Inventory.size(); ++i) {
    	if(lib1Inventory.get(i).getIsbn() < lib1Inventory.get(i - 1).getIsbn()) {
    		 System.err.println("TEST FAILED: getInventoryList for Library<String>");
    	}
    }
    ArrayList<LibraryBook<PhoneNumber>> lib2Inventory = lib2.getInventoryList();
    for(int i = 1; i < lib2Inventory.size(); ++i) {
    	if(lib2Inventory.get(i).getIsbn() < lib2Inventory.get(i - 1).getIsbn()) {
    		 System.err.println("TEST FAILED: getInventoryList for Library<String>");
    	}
    }
    
    // test a medium library: you will use this for homework
    Library<String> lib3 = new Library<String>();    
    lib3.addAll("Mushroom_Publishing.txt");
    
    String patron3 = "Barack Obama";
    lib3.checkout(9781843190028L, patron3, 1, 1, 1989);
    lib3.checkout(9781843190400L, patron3, 1, 1, 3975);
    lib3.checkout(9781843190936L, patron3, 1, 1, 1889);
    lib3.checkout(9781843193319L, patron3, 1, 1, 2063);
    lib3.checkout(9781843190998L, patron3, 1, 1, 1990);
    
    ArrayList<LibraryBook<String>> lib3Inventory = lib3.getOrderedByAuthor();
    for(int i = 1; i < lib3Inventory.size(); ++i) {
    	if(lib3Inventory.get(i).getAuthor().compareTo(lib3Inventory.get(i - 1).getAuthor()) < 0 || (lib3Inventory.get(i).getAuthor().compareTo(lib3Inventory.get(i - 1).getAuthor()) == 0 && lib3Inventory.get(i).getTitle().compareTo(lib3Inventory.get(i - 1).getTitle()) < 0) ) {
    		 System.err.println("TEST FAILED: getOrderedByAuthor for Library<String>"); 
    	}
    }
    ArrayList<LibraryBook<String>> lib3DueDates = lib3.getOverdueList(12, 13, 2000);
    for(int i = 1; i < lib3DueDates.size(); ++i) {
    	if(lib3DueDates.get(i).getDueDate().compareTo(lib3DueDates.get(i - 1).getDueDate()) < 0) {
    		 System.err.println("TEST FAILED: getOverdueList for Library<String>");
    	}
    }
  }
}
