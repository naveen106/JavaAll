package LinkedList;
class LinkedListNode<T> {
  T data;
  LinkedListNode<T> next;

  public LinkedListNode(T data) {
    this.data = data;
  }
}

public class EliminateDuplicates {

  static LinkedListNode<Integer> makeList() {
    LinkedListNode<Integer> head = new LinkedListNode<>(1);
    LinkedListNode<Integer> newNode_1 = new LinkedListNode<>(1);
    LinkedListNode<Integer> newNode_2 = new LinkedListNode<>(1);
    LinkedListNode<Integer> newNode_3 = new LinkedListNode<>(2);
    LinkedListNode<Integer> newNode_5 = new LinkedListNode<>(3);
//    LinkedListNode<Integer> newNode_6 = new LinkedListNode<>(4);
    LinkedListNode<Integer> newNode_4 = new LinkedListNode<>(3);
//    LinkedListNode<Integer> newNode_7 = new LinkedListNode<>(5);
//    LinkedListNode<Integer> newNode_8 = new LinkedListNode<>(6);
//    LinkedListNode<Integer> newNode_9 = new LinkedListNode<>(7);
//    LinkedListNode<Integer> newNode_10 = new LinkedListNode<>(8);

    head.next = newNode_1;
    newNode_1.next = newNode_2;
    newNode_2.next = newNode_3;
    newNode_3.next = newNode_4;
    newNode_4.next = newNode_5;
//    newNode_5.next = newNode_6;
//    newNode_6.next = newNode_7;
//    newNode_7.next = newNode_8;
//    newNode_8.next = newNode_9;
//    newNode_9.next = newNode_10;
    return head;
  }

  static void print(LinkedListNode<Integer> head) {
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
  }

  static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
    LinkedListNode<Integer> current = head.next;
    LinkedListNode<Integer> mainNode = head;

    while(current != null) {
      if(mainNode.data.equals(current.data)) {
        mainNode.next = current;
        mainNode = current;
      }
      else {
        current = current.next;
      }
    }
    mainNode.next = null;
    return head;
  }


  public static void main(String[] args) {
    LinkedListNode<Integer> head = makeList();
    head = removeDuplicates(head);
    print(head);
  }
}
