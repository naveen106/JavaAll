package Recursion_Assignments;

import java.util.Arrays;

public class Staircase{
  public static int staircase(int n){
    if(n == 0) return 1;
    if(n < 0) return 0;

    int count = staircase(n-1);
    int count2 = staircase(n-2);
    int count3 = staircase(n-3);
    return count+count2+count3;
  }

    public static void main(String[] args) {
      System.out.println(staircase(4));
    }

}
