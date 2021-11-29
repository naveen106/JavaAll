package LinkedList;
//You have been given a singly linked list of integers along with two integers, 'M,' and 'N.' \
// Traverse the linked list such that you retain the 'M' nodes, then delete the next 'N' nodes.
// Continue the same until the end of the linked list.
//To put it in other words, in the given linked list, you need to delete N nodes after every M nodes.

public class skipMdeleteN {

  static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
    if(head == null || head.next == null)
      return head;

    if(N == 0)
      return head;

    if(M == 0)
      return null;

    LinkedListNode<Integer> firstTail = head;
    LinkedListNode<Integer> secondHead = head;

    while(firstTail.next != null && secondHead.next != null){
      int count = 0;

      while(count < M-1 && firstTail.next != null){
        firstTail = firstTail.next;
        count++;
      }

      secondHead = firstTail.next;
      count = 0;

      while(count < N - 1 && secondHead.next != null){
        secondHead = secondHead.next;
        count++;
      }

      if(secondHead.next != null){
        firstTail.next = secondHead.next;
        firstTail = firstTail.next;
      }
    }

    firstTail.next = null;
    return head;
  }

  public static void main(String[] args) {
    LinkedListNode<Integer> head = new MakeLinkedList().MakeLinkedList();
    head = skipMdeleteN(head, 2, 3); //try with different values of M and N where 0<=M<=10^5 and 0<=N<=10^5
    while(head.next != null){
      System.out.println(head.data + " ");
      head = head.next;
    }
  }
}
