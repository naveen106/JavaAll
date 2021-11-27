package LinkedList;

public class reverseLLrecursively {
  static LinkedListNode<Integer> makeList() {
    LinkedListNode<Integer> head = new LinkedListNode<>(5);
    LinkedListNode<Integer> newNode_1 = new LinkedListNode<>(5);
    LinkedListNode<Integer> newNode_2 = new LinkedListNode<>(7);
    LinkedListNode<Integer> newNode_3 = new LinkedListNode<>(8);
    LinkedListNode<Integer> newNode_4 = new LinkedListNode<>(3);
    LinkedListNode<Integer> newNode_5 = new LinkedListNode<>(36);

    head.next = newNode_1;
    newNode_1.next = newNode_2;
    newNode_2.next = newNode_3;
    newNode_3.next = newNode_4;
    newNode_4.next = newNode_5;
    return head;
  }
  static LinkedListNode<Integer> prev = null;
  static LinkedListNode<Integer> newHead = null;

  public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
    if(head == null)
      return head;

    LinkedListNode<Integer> current = head;
    LinkedListNode<Integer> next = head.next;

    current.next = prev;
    prev = current;
//    current = next;

    if(head.next == null){
      //newHead = head;
      return head;//newHead;
    }

    return reverseLinkedListRec(head.next);
    ///return head;
  }


  static void print(LinkedListNode<Integer> head) {
    while (head != null){
      System.out.print(head.data + " ");
      head = head.next;
    }
  }

  public static void main(String[] args) {
    LinkedListNode<Integer> head = makeList();
    head = reverseLinkedListRec(head);
    print(head);

  }


}
