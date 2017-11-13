import java.util.Scanner;

public class SinglyLinkedListTest<T> {
	
	public static void main(String[] args)
    {             
	Scanner scan = new Scanner(System.in);
    /* Creating object of class linkedList */
    SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
    list1.insertAtStart(2);
    list1.insertAtStart(3);
    list1.insertAtStart(27);
    list1.insertAtStart(3);
    list1.insertAtStart(3);
    list1.insertAtEnd(1);
   // list1.display();
    list1.insertAtPos(5, 2);
  //  list1.display();
    //list1.deleteAtPos(1);
   // list1.display();
    list1.update(8, 1);
    System.out.println("Before Sorting of Integers");
    list1.display();

    list1.bubbleSort();
    System.out.println("After Sorting of Integers");
    list1.display();
    
    
    SinglyLinkedList<String> list2 = new SinglyLinkedList<>();
    list2.insertAtStart("A");
    list2.insertAtStart("B");
    list2.insertAtStart("A");
    list2.insertAtStart("Z");
    list2.insertAtStart("N");
    list2.insertAtEnd("J");
    //list2.display();
    list2.insertAtPos("M", 2);
    System.out.println("Before Sorting of String");
    list2.display();
    
    list2.bubbleSort();
    System.out.println("After Sorting of String");
    list2.display();
    
    }

}
