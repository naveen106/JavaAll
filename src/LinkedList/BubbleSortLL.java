package LinkedList;
public class BubbleSortLL {

  static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head){
    LinkedListNode<Integer> pointer = head.next, smallest = head, greatest = head;
    while(pointer != null){
      if(pointer.data < smallest.data)
        smallest = pointer;

      else if(pointer.data > greatest.data)
        greatest = pointer;

      pointer = pointer.next;
    }

    LinkedListNode<Integer> swapFirst = head, startingHead;
    if(head.next.data < head.data)
      startingHead = head.next;
    else
      startingHead = head;

  //  int runOnce = 1;
    //1 iteration of bubble swapping of all the nodes.

  /*   while(true){
      if(swapFirst.data > swapFirst.next.data){
        //swap
        LinkedListNode<Integer> addressOfNext = swapFirst.next.next;
        swapFirst.next.next = swapFirst; //connecting comparing node to swapFirst node.
        swapFirst.next = addressOfNext; //connecting swapFirst node to next node of second comparing node.
      }
      else
        swapFirst = swapFirst.next;
      if(swapFirst.next == null)
      break;
    }*/




    return startingHead;
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