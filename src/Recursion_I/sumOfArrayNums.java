package Recursion_I;
public class sumOfArrayNums{
  static int count = 0;

  public static int sum(int[] input) {
    if (count == input.length-1) return input[0];
    count++;
    return sum(input) + input[count--];
  }

  public static void main(String[] args) {
    int[] array = {1,2,3,4,5};
    System.out.println(sum(array));
  }
}