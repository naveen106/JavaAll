package LinkedList;

public class DeleteMiddleNode {

  static LinkedListNode<Integer> deleteMidNode(LinkedListNode<Integer> head){
    if(head == null || head.next == null)
      return null;

    LinkedListNode<Integer> slow = head, fast = head;

    if(head.next.next == null){
      LinkedListNode<Integer> temp = head.next;
      head.next = null; //breaking the connection of head node from second node, not just returning head.next.
      return temp;
    }

    LinkedListNode<Integer> prevSlow = head;

    while(true){//while(fast.next != null && fast.next.next != null){
      prevSlow = slow;
      if(fast.next == null && fast.next.next == null)
        break;

      slow = slow.next;
      fast = fast.next.next;
    }

//    //Node prevSlow = head;
//
//    while(prevSlow.next != slow)
//      prevSlow = prevSlow.next;
//
//    prevSlow.next = slow.next;
//    slow.next = null;
    return prevSlow;
  }

  public static void main(String[] args) {
    LinkedListNode<Integer> head = new MakeLinkedList().MakeLinkedList();
    head = deleteMidNode(head);

    while(head != null){
      System.out.print(head + " ");
      head = head.next;
    }
  }
}
