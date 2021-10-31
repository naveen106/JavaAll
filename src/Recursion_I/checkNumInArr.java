package Recursion_I;

public class checkNumInArr {

  static int count = -1;
  static boolean isInIt = true;
  public static boolean checkNumber(int[] input, int x) {
    if(count == input.length - 1)
      return false;
    count++;

    if(input[count] == x){
      isInIt = true;
      return isInIt;
    }
    else
    isInIt = false;
    checkNumber(input, x);
    return isInIt;
  }

  public static void main(String[] args) {
    int[] arr = {1,2,3,5,4};
    System.out.println(checkNumber(arr, 6));
  }
}
