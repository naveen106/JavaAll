package Recursion_I;

public class sumOfNaturalNums {
  public static int sumOfN(int n){
    if(n==0){
      return 0;
    }
    int output = n + sumOfN(n-1);
    return output;
  }
  public static void main(String[] args) {
    int n = 10;

    System.out.println(sumOfN(n));
  }
}
