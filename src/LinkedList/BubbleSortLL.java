package LinkedList;

public class BubbleSortLL {
  public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
    LinkedListNode<Integer> swapFirst = head, pointer = head;
    LinkedListNode<Integer> smallest = null, greatest = null;

    while (pointer.next != null) {
      if (pointer.data < pointer.next.data)
        smallest = pointer;
      else
        greatest = pointer;
    }
    return smallest;
  }
  public static void main(String[] args) {

  }
}
