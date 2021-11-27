package LinkedList;

public class checkPalindromeInLL {
  static LinkedListNode<Integer> mainHead;
  static boolean check = true;
  static LinkedListNode<Integer> makeList() {
    LinkedListNode<Integer> head = new LinkedListNode<>(3);
    LinkedListNode<Integer> newNode_1 = new LinkedListNode<>(9);
    LinkedListNode<Integer> newNode_2 = new LinkedListNode<>(1);
    LinkedListNode<Integer> newNode_3 = new LinkedListNode<>(2);
    LinkedListNode<Integer> newNode_4 = new LinkedListNode<>(9);
    LinkedListNode<Integer> newNode_5 = new LinkedListNode<>(3);

    mainHead = head;
    head.next = newNode_1;
    newNode_1.next = newNode_2;
    newNode_2.next = newNode_3;
    newNode_3.next = newNode_4;
    newNode_4.next = newNode_5;
    return head;
  }

  static void print(LinkedListNode<Integer> head) {
    while (head != null){
      System.out.print(head.data + " ");
      head = head.next;
    }
  }

  public static void main(String[] args) {
    LinkedListNode<Integer> head = makeList();
    boolean answer = isPalindrome(head);
    System.out.println(answer);
    //    print(head);
  }

  public static boolean isPalindrome(LinkedListNode<Integer> head) {
	  if(head == null)
      return true;

    if(head.next == null){
      if(!mainHead.data.equals(head.data)){
        check = false;
      }
      return check;
    }

    isPalindrome(head.next); //recursive call

    mainHead = mainHead.next;
    if(!mainHead.data.equals(head.data))
      check = false;
//    return check;
    return isPalindrome(head);
  }
}
