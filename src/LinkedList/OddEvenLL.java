package LinkedList;

class EvenAfterOdd {
  public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
    if(head == null || head.next == null)return head;

    LinkedListNode<Integer> evenHead = null;
    LinkedListNode<Integer> oddHead = null;
    LinkedListNode<Integer> temp = head;

    /////////find odd and even heads//////
    if((head.data ^ 1) == head.data + 1)
      evenHead = head;

    else
      oddHead = head;

    //if we already have evenHead, then we need to find oddHead now.
    if(oddHead == null){
      while(temp.next != null && (temp.next.data ^ 1) != temp.next.data - 1)   //when temp.next.data is not odd
        temp = temp.next;

      if(temp.next != null)
        oddHead = temp.next; //if it is odd, then oddHead should be equal to temp.next
    }

    if(temp.next == null) return head; //if list is fully even or odd.
    temp = head;

    //if we have oddHead, we need to find evenHead.
    if(evenHead == null){
      while(temp.next != null && (temp.next.data ^ 1) != temp.next.data + 1) //when temp.next.data is not even
        temp = temp.next;

      if(temp.next != null)
        evenHead = temp.next; //similarly like before, evenHead = temp.next;
    }
    if(temp.next == null) return head; //if list is fully even or odd.


    ////////////////////////Now the main solution of the answer, version_2 ////////////////////////////////////
    LinkedListNode<Integer> evenTail = evenHead;
    LinkedListNode<Integer> oddTail = oddHead;
    LinkedListNode<Integer> pointer = oddHead.next;

    while(evenTail.next != null && (evenTail.next.data ^ 1) == evenTail.next.data + 1)
    evenTail = evenTail.next;

    while(pointer != null){  //traversing through oddHead because returning list would start from odd Head.

      if((pointer.data ^ 1) == pointer.data + 1 && pointer != evenHead && pointer != evenTail){

        evenTail.next = pointer; //add the node to tail off even list.
        evenTail = evenTail.next;  //update the tail of even list

        pointer = pointer.next; //move pointer to next node.
      }

      else{
        if(pointer != evenHead && pointer != evenTail){
          oddTail.next = pointer;  //add pointer to OddTail to make oddList.
          oddTail = oddTail.next;  //update oddTail.next to be new list tail.
        }
        //if pointer.data is odd, then just traverse the list, no need to do anything else.
        pointer = pointer.next; //move pointer forward.
      }
    }

    oddTail.next = evenHead; // join oddTail to evenHead.
    evenTail.next = null; //make the last node of the newly made list to null.
    return oddHead; //return head of the list.
  }
}

public class OddEvenLL {
  public static void main(String[] args) {
    LinkedListNode<Integer> head = new MakeLinkedList().MakeLinkedList();
    head = EvenAfterOdd.evenAfterOdd(head);

    while(head != null){
      System.out.print(head.data + " ");
      head = head.next;
    }
  }
}
