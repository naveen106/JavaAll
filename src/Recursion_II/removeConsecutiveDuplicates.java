package Recursion_II;
public class removeConsecutiveDuplicates {

  public static String removeConsecutiveDuplicates(String s) {
    if(s.length() <=1)
      return s;

    if(s.charAt(0) == s.charAt(1)){
      return removeConsecutiveDuplicates(s.substring(1));
    }

    else{
      String smallPart = removeConsecutiveDuplicates(s.substring(1));
      return s.charAt(0) + smallPart;
    }
  }

  public static void main(String[] args) {
    String str = removeConsecutiveDuplicates("CCooddiinnggNNiinnnnjjjjaaaassss");
    System.out.println(str);
  }
}