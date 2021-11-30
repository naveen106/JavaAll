package LinkedList;

public class swapTwoNodes {

  static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
    if(head == null || head.next == null)
      return head;

    if(i == j)
      return head;

    //later, firstNode will point to the node which is just before the first node to be swapped.
    //secondNode for just before the second node to be swapped.
    LinkedListNode<Integer> firstNode = head, secondNode;

    //this way I is always less than 0, and I can traverse the node through i only.
    if(i>j){
      int temp = i;
      i = j;
      j = temp;
    }

    if(i == 0)//for edge case where i = 0.
      i = 1;

    int count = 0;

    //for edge case where i = 0.
    if(i != 0 && i != 1)
      while(count < i-1){
        if(firstNode.next == null)return null;
        firstNode = firstNode.next;
        count++;
      }

    //for edge case where j = i+1
    if(j == i+1){
      LinkedListNode<Integer> temp1 = firstNode.next;
      LinkedListNode<Integer> temp2 = firstNode.next.next;

      temp1.next = temp2.next;
      temp2.next = temp1;
      firstNode.next = temp2;
      return head;
    }

    count = i;
    secondNode = firstNode.next;

    //focus here!!! count is starting from i, not zero, don't forget that.
    while(count < j-1){
      if(secondNode.next == null)return null;
      secondNode = secondNode.next;
      count++;
    }

    //for edge case where i = 0
    if(i == 0 && firstNode == head){
      LinkedListNode<Integer> swapNode = secondNode.next, temp2 = swapNode.next;

      swapNode.next = firstNode.next;
      secondNode.next = firstNode; //or head.
      firstNode.next = temp2;
      return swapNode;
    }

    LinkedListNode<Integer> swapNode1, swapNode2, address1, address2;

    swapNode1 = firstNode.next;
    address1 = swapNode1.next;

    swapNode2 = secondNode.next;
    address2 = swapNode2.next;

    firstNode.next = swapNode2;
    swapNode2.next = address1;

    secondNode.next = swapNode1;
    swapNode1.next = address2;

    return head;
  }

  public static void main(String[] args) {
    LinkedListNode<Integer> head = new MakeLinkedList().MakeLinkedList();
    head = swapNodes(head, 1, 4);

    while(head != null){
      System.out.print(head.data + " ");
      head = head.next;
    }
  }
}
