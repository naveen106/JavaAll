package Recursion_Assignments;

public class checkPalindrome {
  public static boolean isStringPalindrome(String input, int start, int end, boolean isPalindrome){
    if(start<=end){
      if(input.charAt(start++) != input.charAt(end--)){ //incrementing start and end after using the current value of them.
        isPalindrome = false;
        return isPalindrome;
      }

      else if(end-start == 1 || end == start){
        isPalindrome = true;
        return isPalindrome;
      }
    }
    return isStringPalindrome(input, start, end, isPalindrome);
  }

  public static void main(String[] args) {
    String input = "naman";
    boolean answer = isStringPalindrome(input, 0, input.length()-1, true);
    System.out.println(answer);
  }
}
