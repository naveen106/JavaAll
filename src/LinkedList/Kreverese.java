package LinkedList;

public class Kreverese {
  static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
    if(head == null || head.next == null)
      return head;

    int count = 0;
    int i = 1;
    LinkedListNode<Integer> prev = null, current = head, next = current.next;
    LinkedListNode<Integer> tempHead = null;

    while(next != null){

      if(count == k*i){
        tempHead = current;
        prev = current;
        current = current.next;
        next = current.next;
      }

      current.next = prev;
      prev = current;
      current = next;
      next = current.next;
      i++;
      count++;
    }

    return tempHead;
  }
  public static void main(String[] args) {
    LinkedListNode head = new MakeLinkedList().MakeLinkedList();
    while(head != null){
      System.out.print(head.data + " ");
      head = head.next;
    }
  }
}
