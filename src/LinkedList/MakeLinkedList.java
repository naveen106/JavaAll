package LinkedList;
import java.util.Scanner;

public class MakeLinkedList {
  //constructor function
  public LinkedListNode<Integer> MakeLinkedList(){
    System.out.println("Enter numbers to make list, enter '-1' to end the list: ");
    Scanner input = new Scanner(System.in);
    int num = input.nextInt();

    LinkedListNode<Integer> head = new LinkedListNode<>(num);
    LinkedListNode<Integer> current = head;

    num = input.nextInt();
    // input -1 to terminate the loop.
    while(num >= 0){
        LinkedListNode<Integer> temp = new LinkedListNode<>(num);
        current.next = temp;
        current = current.next;
        num = input.nextInt();
    }
 //   input.close(); //if I close the Scanner…it shows 'No such element exception'. If I make two list consecutively, then it behaves like this. see 'MergeTwoSortedLL.java';
    return head;
  }
}
