package LinkedList;
public class BubbleSortLL {

  static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head){
    LinkedListNode<Integer> pointer = head.next, smallest = head;
    while(pointer != null){
      if(pointer.data < smallest.data)
        smallest = pointer;
      pointer = pointer.next;
    }
    return smallest;
  }

  public static void main(String[] args) {
    LinkedListNode<Integer> head = new MakeLinkedList().MakeLinkedList();
    head = bubbleSort(head);
    System.out.println(head);
  }
}