package LinkedList;
public class BubbleSortLL {
  //method overloading
  static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head, LinkedListNode<Integer> tail, LinkedListNode<Integer>smallest){

    if(head == smallest){
      return head;
    }

    if(head.next == smallest){
      return head;
    }

    LinkedListNode<Integer> temp = head.next, temp2;

    if(head.next.data < head.data){
      temp2 = head.next.next;
      head.next = temp2;
    }

    temp = bubbleSort(head, tail, smallest);
    return temp;
  }

  static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head){
    LinkedListNode<Integer>tail = null;  //come back here later if error, to check value of tail.

    if(head == null){
      tail = head;
      return head;
    }

    if(head.next == null) {
      tail = head;
      return head;
    }

    LinkedListNode<Integer> temp = head.next, temp2;

    if(head.next.data < head.data){
      temp2 = head.next.next;
      head.next = temp2;
    }

    temp.next = bubbleSort(head);
    //return temp;
    LinkedListNode<Integer>smallest  = head, pointer = head.next;

    while(pointer != null){
      if(pointer.data < smallest.data) //finding the smallest node to return at the end.
      smallest = pointer;
      pointer = pointer.next;
    }

    LinkedListNode<Integer> newHead = temp;
    newHead = bubbleSort(temp, tail, smallest);
    return newHead;
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