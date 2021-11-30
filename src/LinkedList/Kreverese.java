/*Given a singly linked list of integers, reverse the nodes of the linked list 'k' at a time and
  return its modified list. 'k' is a positive integer and is less than or equal to the length of the linked list.
  If the number of nodes is not a multiple of 'k,' then left-out nodes, in the end, should be reversed as well.

  example:
           Given this linked list: 1 -> 2 -> 3 -> 4 -> 5
           For k = 2, you should return: 2 -> 1 -> 4 -> 3 -> 5
           For k = 3, you should return: 3 -> 2 -> 1 -> 5 -> 4
 */
package LinkedList;

public class Kreverese {
  public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
    if(k == 0 || k == 1)
      return head;

    if(head == null)
      return head;

    if(head.next == null)
      return head;

    LinkedListNode<Integer> current = head, prev = null, next = null;

    int count = 0;
    while(count < k && current != null){
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      count++;
    }

    if(next != null)
      head.next = kReverse(next, k);
    return prev;
  }
  public static void main(String[] args) {
    LinkedListNode<Integer> head = new MakeLinkedList().MakeLinkedList();
    head = kReverse(head, 6);
    while(head != null){
      System.out.print(head.data + " ");
      head = head.next;
    }
  }
}
