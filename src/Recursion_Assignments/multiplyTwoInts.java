package Recursion_Assignments;
public class multiplyTwoInts {
  static int multiplyTwoIntegers(int m, int n, int count, int base){
    if(count == n){
      //  m = m + base;
      return m;
    }
    m = m + base;
    count++;
    return multiplyTwoIntegers(m,n,count, base);
  }

  public static int multiplyTwoIntegers(int m, int n){
    if(m>=n){
      return  multiplyTwoIntegers(m, n, 1, m);
    }
    else
      return  multiplyTwoIntegers(n, m, 1, n);
  }

  public static void main(String[] args) {
    int product = multiplyTwoIntegers(3,27);
    System.out.println(product);
  }
}
