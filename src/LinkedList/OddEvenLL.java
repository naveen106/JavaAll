package LinkedList;

 class EvenAfterOdd {
  public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
    if(head == null)return head;

    LinkedListNode<Integer> evenHead = null;
    LinkedListNode<Integer> oddHead = null;
    LinkedListNode<Integer> temp = head;

    /////////find odd and even heads//////
    if((head.data ^ 1) == head.data + 1)
      evenHead = head;

    else
      oddHead = head;

    //if we already have evenHead, then we need to find oddHead now.
    if(evenHead != null && oddHead == null){
      while(temp.next != null && (temp.next.data ^ 1) != temp.next.data - 1)   //when temp.next.data is not odd
        temp = temp.next;

      if(temp.next != null)
        oddHead = temp.next; //if it is odd, then oddHead should be equal to temp.next
    }

    if(temp.next == null) return head; //if list is fully even or odd.
    temp = head;

    //if we have oddHead, we need to find evenHead.
    if(oddHead != null && evenHead == null){
      while(temp.next != null && (temp.next.data ^ 1) != temp.next.data + 1) //when temp.next.data is not even
        temp = temp.next;

      if(temp.next != null)
        evenHead = temp.next; //similarly like before, evenHead = temp.next;
    }

    if(temp.next == null) return head; //if list is fully even or odd.
    temp = head;


    ////////////Now the main solution of the answer, version_1 //////////////

    LinkedListNode<Integer> evenTail = evenHead;
    LinkedListNode<Integer> tempOddHead = oddHead;
    //   LinkedListNode<Integer> temp2 = null;

    while(tempOddHead.next != null){  //traversing through oddHead because returning list would start from odd Head.

      if((tempOddHead.next.data ^ 1) == tempOddHead.next.data + 1){  //meaning = if tempOddHead.next.data is even
        //	temp2 = tempOddHead;

        while(evenTail.next != null && (evenTail.next.data ^ 1) != evenTail.next.data - 1) // meaning = if eventail.next.data is odd (traverse evenHead till you find an odd node(which is oddHead))
          evenTail = evenTail.next; //haven't thought much about it...but what if evenTail.next == null???

        evenTail.next = tempOddHead.next; //add the node to tail off even list.
        evenTail = evenTail.next;  //update the tail of even list
        tempOddHead.next = tempOddHead.next.next; //cut the connection of odd node from that even node which gets added to even list.
      }

      else if(tempOddHead.next != null) //if its odd we just need to traverse, and do nothing.
        tempOddHead = tempOddHead.next;

    }

    tempOddHead.next = evenHead;
    evenTail.next = null;
    return oddHead;

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
