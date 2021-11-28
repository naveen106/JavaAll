package LinkedList;

class Solution{
  //findMidPoint of linked list.
  static LinkedListNode<Integer> findMid(LinkedListNode<Integer> head){
    LinkedListNode<Integer> slow = head;
    LinkedListNode<Integer> fast = head;

    while(fast.next != null && fast.next.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }


  //merge two LinkedList //just like mergeSort of arrays. the mergeSort() below returns the single head of two list(like single element of array)
  static LinkedListNode<Integer> sortAndMergeList(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2){
    LinkedListNode<Integer> newHead = null;

    if(head1 == null)
      return head2;

    if(head2 == null)
      return head1;

    if(head1.data < head2.data){
      newHead = head1;
      newHead.next = sortAndMergeList(head1.next, head2);
    }

    else{
      newHead = head2;
      newHead.next = sortAndMergeList(head2.next, head1);
    }

    return newHead;
  }

  public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {

    if(head == null || head.next == null)
      return head;

    LinkedListNode<Integer> mid = findMid(head); //findMid
    LinkedListNode<Integer> secondHead = mid.next; //mid.next becomes head of right LinkedList
    mid.next = null; //break the connection.

    LinkedListNode<Integer> left = mergeSort(head);  //runs until head == null or head.next == null and returns head (like in arrays, a single item)
    LinkedListNode<Integer> right = mergeSort(secondHead); //now same thing for the right linked list.

    return sortAndMergeList(left, right); //now merge and short them at the same time, like the merge() function of mergesort algorithm.
  }
}



public class MergeSortLL {

  public static void main(String[] args) {
    LinkedListNode<Integer> head = new MakeLinkedList().MakeLinkedList();
    head = Solution.mergeSort(head);

    while(head.next != null){
      System.out.print(head.data + " ");
      head = head.next;
    }
  }
}
