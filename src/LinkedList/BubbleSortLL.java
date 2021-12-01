package LinkedList;
public class BubbleSortLL {
  //method overloading
//  static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head, LinkedListNode<Integer> tail, LinkedListNode<Integer>smallest){
//
//    if(head == smallest){
//      return head;
//    }
//
//    if(head.next == smallest){
//      return head;
//    }
//
//    LinkedListNode<Integer> temp = head.next, temp2;
//
//    if(head.next.data < head.data){
//      temp2 = head.next.next;
//      head.next = temp2;
//    }
//
//    temp = bubbleSort(head, tail, smallest);
//    return temp;
//  }
  static LinkedListNode<Integer> tail = null;  //come back here later if error, to check value of tail.
  static LinkedListNode<Integer> smallest = null;
  static int length = -1;
  static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {

    //getting the smallest node and the tail node(the greatest node).
    if (smallest == null) {
      LinkedListNode<Integer> pointer = head.next;
      smallest = tail = head;

      while (pointer != null) {
        if (pointer.data < smallest.data) //finding the smallest node to return at the end.
          smallest = pointer;

        else if (pointer.data > tail.data)
          tail = pointer;

        pointer = pointer.next;
        length++;
      }
    }

    if (head == null || tail.next == null && head == tail) {
      tail = head;
      return head;
    }

    if (head.next == null || head.next == tail) {
      tail = head;
      return head;
    }

    LinkedListNode<Integer> temp = head.next, temp2;

    if (head.next.data < head.data) {
      temp2 = head.next.next;
      head.next = temp2;
    }


      temp.next = bubbleSort(head);
      length--;
      LinkedListNode<Integer> newHead = temp;

      if(length >= 0)
      temp.next = bubbleSort(newHead);

    return temp;
  }

  public static void main(String[] args) {
    LinkedListNode<Integer> head = new MakeLinkedList().MakeLinkedList();
    head = bubbleSort(head);

    while(head != null){
      System.out.print(head.data + " ");
      head = head.next;
    }
  //  System.out.println(head.data);
  }
}