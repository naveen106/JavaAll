//haven't made this program 10^9 + 7 (to have the value under integer max limit
public class CountSetBits {
  public static void main(String[] args) {
    int n = 5;
    int count = 0;
    for(int i = 1; i<=n; i++){
      String binary = Integer.toBinaryString(i);

      for(int j = 0; j<binary.length(); j++) {
        if (binary.charAt(j) == '1') {
          count++;
        }
      }
    }
    System.out.println(count);
  }
}
