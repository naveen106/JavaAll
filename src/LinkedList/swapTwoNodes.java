package LinkedList;

import java.util.Scanner;

public class swapTwoNodes {

  static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
    //////////////// THIS PART OF CODE DOESN'T WORK WELL WITH (j-i = 1, i=0 and j = 1,2,3 maybe others too...but this part doesn't handle edge cases very well////////////
//    if(head == null || head.next == null)
//      return head;
//
//    if(i == j)
//      return head;
//
//    //later, firstNode will point to the node which is just before the first node to be swapped.
//    //secondNode for just before the second node to be swapped.
//    LinkedListNode<Integer> firstNode = head, secondNode;
//
//    //this way i is always less than 0 and I can traverse the node through i only.
//    if(i>j){
//      int temp = i;
//      i = j;
//      j = temp;
//    }
//
//    if(i == 0 && j != 2 && j != 1)//for edge case where i = 0.
//      i = 1;
//
//    int count = 0;
//
//    //while loop will only run i is not zero or 1.
//    if(i != 0 || i != 1)
//      while(count < i-1){
//        if(firstNode.next == null) //for case when i>listLength
//          return null;
//
//        firstNode = firstNode.next;
//        count++;
//      }
//
//    //for edge case where j = i+1
//        if(j == i+1 && i != 1){  //in case of i=0..i is = 1
//            LinkedListNode<Integer> temp1 = firstNode.next;
//            LinkedListNode<Integer> temp2 = firstNode.next.next;
//
//            temp1.next = temp2.next;
//            temp2.next = temp1;
//            firstNode.next = temp2;
//            return head;
//        }
//
//    count = i;
//    secondNode = firstNode.next;
//
//    //LOOK CAREFULLY!! count starts from i, not zero.
//    while(count < j-1){
//      if(secondNode.next == null) //for case when j>listLength
//        return null;
//      secondNode = secondNode.next;
//      count++;
//    }
//
//    //for edge case where i = 0
////    if(firstNode == head){
////      LinkedListNode<Integer> swapNode = secondNode.next, temp2 = swapNode.next;
////
////      swapNode.next = firstNode.next.next;
////      secondNode.next = firstNode; //or head.
////      firstNode.next = temp2;
////      return swapNode;
////    }
//
//        LinkedListNode<Integer> swapNode1, swapNode2, address1, address2;
//
//        //setting reference of variable to appropriate node of the list.
//        swapNode1 = firstNode.next;
//        address1 = swapNode1.next; //address of node connected to swapNode1.
//
//        swapNode2 = secondNode.next;
//        address2 = swapNode2.next;
//
//        //now do the swapping.
//        firstNode.next = swapNode2;
//        swapNode2.next = address1;
//
//        secondNode.next = swapNode1;
//        swapNode1.next = address2;
//
//    return head;


    ////////////////////NOW THE SOLUTION WHICH WORKS //////////////////////////////////////
    if (head == null || head.next == null)
      return head;

    if (i == j)
      return head;

    LinkedListNode<Integer> currentNode = head, prev = null;
    LinkedListNode<Integer> firstNode = null, secondNode = null, firstNodePrev = null, secondNodePrev = null;
    int pos = 0;

    while (currentNode != null) {
      if (pos == i) {
        firstNodePrev = prev;
        firstNode = currentNode;
      } else if (pos == j) {
        secondNodePrev = prev;
        secondNode = currentNode;
      }

      prev = currentNode;
      currentNode = currentNode.next;
      pos++;
    }

    if(firstNodePrev != null)
    firstNodePrev.next = secondNode;

    else
    head = secondNode;

    if(secondNodePrev != null)
    secondNodePrev.next = firstNode;

    else
    head = firstNode;

    LinkedListNode<Integer> currentFirstNode = secondNode.next;
    secondNode.next = firstNode.next;
    firstNode.next = currentFirstNode;

    return head;
  }

  public static void main(String[] args) {
    LinkedListNode<Integer> head = new MakeLinkedList().MakeLinkedList();
    Scanner input = new Scanner(System.in);
    System.out.println("Enter index of two nodes to be swapped:    ");

    head = swapNodes(head, input.nextInt(), input.nextInt());
    input.close();

    while(head != null){
      System.out.print(head.data + " ");
      head = head.next;
    }
  }
}
