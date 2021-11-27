package LinkedList;
//merge two sorted linked list with O(1) space complexity.
public class MergeTwoSortedLL {
  //major(main part of solution) class for solution
  public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {

    if(head1 == null && head2 == null)
      return head1;

    if(head1 == null && head2 != null)
      return head2;

    if(head1 != null && head2 == null)
      return head1;

    LinkedListNode<Integer> i = head1;
    LinkedListNode<Integer> j = head2;
    LinkedListNode<Integer> finalHead = null;
    LinkedListNode<Integer> tail = null;

    if(head1.data < head2.data){
      finalHead = head1;
      i = head1.next;
      head1.next = head2;
      tail = head2;
    }

    else{
      finalHead = head2;
      j = head2.next;
      head2.next = head1;
      tail = head1;
    }

    if(i.data < j.data){
      finalHead.next = i;
      tail = i;
      i = i.next;
    }

    else{
      finalHead.next = j;
      tail = j;
      j = j.next;
    }

    while(i != null && j != null){

      if(i.data < j.data){
        tail.next = i;
        tail = i;
        i = i.next;
      }

      else{
        tail.next = j;
        tail = j;
        j = j.next;
      }
    }

    if(i == null)
      tail.next = j;

    else
      tail.next = i;

    return finalHead;
  }

  public static void main(String[] args) {
    //MakeLinkedList list1 = new MakeLinkedList();
    //MakeLinkedList list2 = new MakeLinkedList();
    //LinkedListNode<Integer> head1 = list1.MakeLinkedList();
    //LinkedListNode<Integer> head2 = list2.MakeLinkedList();

    //or try shorter version like below:
    //'new MakeLinkedList()' creates object, and then chained constructor function MakeLinkedList() returns the head of the made list.
    LinkedListNode<Integer> head1 = new MakeLinkedList().MakeLinkedList();
    LinkedListNode<Integer> head2 = new MakeLinkedList().MakeLinkedList();

    //throws NoSuchElementException if Scanner is closed in MakeLinkedList class constructor.
//    head1.print(head1);
//    System.out.println();
//    head2.print(head2);

      print(mergeTwoSortedLinkedLists(head1,head2));
  }

  //print the list(merged)
  public static void print(LinkedListNode<Integer> head) {
    while (head != null){
      System.out.print(head.data + " ");
      head = head.next;
    }
  }
}
