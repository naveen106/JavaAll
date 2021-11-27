package LinkedList;
import java.util.Scanner;

public class MakeLinkedList {
  //constructor function
  public LinkedListNode<Integer> MakeLinkedList(){
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
    return head;
  }
}
