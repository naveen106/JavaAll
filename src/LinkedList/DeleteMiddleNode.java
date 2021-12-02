package LinkedList;
/*
* You have been given a singly Linked List of N nodes.
* Your task is to delete the middle node of this List.
* If there is no middle node in the list to delete, return an empty list (i.e. NULL).
* If there are two middle nodes in the list, delete the first one.
* Follow up :
* Can you solve it in only one traversal of the Linked List using O(1) space?
*/

public class DeleteMiddleNode {

  static LinkedListNode<Integer> deleteMidNode(LinkedListNode<Integer> head){
    if(head == null || head.next == null)
      return null;

    if(head.next.next == null){
      LinkedListNode<Integer> temp = head.next;
      head.next = null; //breaking the connection of head node from second node, not just returning head.next.
      return temp;
    }

    LinkedListNode<Integer> slow = head, prevOfSlow = head, fast = head.next;

    while(fast != null){//while(fast.next != null && fast.next.next != null){

      //if List length is even
      if(fast.next == null)
        break;
      prevOfSlow = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    prevOfSlow.next = prevOfSlow.next.next;
    return head;
  }

  public static void main(String[] args) {
    LinkedListNode<Integer> head = new MakeLinkedList().MakeLinkedList();
    head = deleteMidNode(head);

    while(head != null){
      System.out.print(head.data + " ");
      head = head.next;
    }
  }
}
