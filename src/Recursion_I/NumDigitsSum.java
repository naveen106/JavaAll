package Recursion_I;

public class NumDigitsSum {
  static int sumOfDigits(int n){
    int sum;

    if(n < 10)
    return n;

    sum = (n % 10) + sumOfDigits(n/10);
    return sum;
  }
  public static void main(String[] args) {
    int n = 6355;
    System.out.println(sumOfDigits(n));
  }

}
