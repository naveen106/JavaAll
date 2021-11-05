package Recursion_Assignments;
public class StringToInt {
  public static int convertStringToInt(String input){
    if(input.length() == 1)return Integer.parseInt(input);
    int num = convertStringToInt(input.substring(1));

    int a = input.charAt(0) - '0';
    a = a * (int)Math.pow(10, input.length()-1) + num;
    return a;
  }

  public static void main(String[] args) {
    String num = "1234005";
    int answer = convertStringToInt(num);
    System.out.println(answer);
  }
}
