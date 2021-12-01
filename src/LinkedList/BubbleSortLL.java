package LinkedList;
public class BubbleSortLL {
  /*
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
///////////////////// THIS IS MY APPROACH, WHICH I WAS TRYING(RECURSIVE), BUT WASN'T ABLE TO...AS YOU CAN SEE IT IS A LITTLE MESSY.
///////////////////// I'LL TRY TO DO THIS QUESTION LIKE THIS...LATER.

  static LinkedListNode<Integer> tail = null;  //come back here later if error, to check value of tail.
  static LinkedListNode<Integer> smallest = null;
  static int length = 0;
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
      LinkedListNode<Integer> newHead = temp;
      length--;
      if(length >= 0)
      temp.next = bubbleSort(newHead);

    return temp;
  }
*/

  /////////////////////////NOW RECURSIVE WAY ///////////////////////////////
  private static int length(LinkedListNode<Integer> head){
    int count = 1;
    while(head.next != null){
      head = head.next;
      count++;
    }
    return count;
  }

  public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {

    if(head==null || head.next==null)
      return head;

    int length = length(head) - 1;

    for(int i=0; i<length; i++){
      LinkedListNode<Integer> prev = null, curr = head, next = curr.next;

      while(curr.next != null){

        if(curr.data > curr.next.data){
          if(prev == null){
            curr.next = next.next;
            next.next = curr;
            prev = next;
            head = prev;
          }

          else{
            next = curr.next;
            curr.next = next.next;
            prev.next = next;
            next.next = curr;
            prev = next;
          }
        }

        else{
          prev = curr;
          curr = curr.next;
        }
      }
    }
    return head;
  }

  public static void main(String[] args) {
    LinkedListNode<Integer> head = new MakeLinkedList().MakeLinkedList();
    head = bubbleSort(head);

    while(head != null){
      System.out.print(head.data + " ");
      head = head.next;
    }
  }
}