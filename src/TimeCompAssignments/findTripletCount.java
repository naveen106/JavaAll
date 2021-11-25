package TimeCompAssignments;
import java.util.*;
public class findTripletCount {

  static int tripletSum(int[] arr, int num) {
    int l, r,count = 0;
    Arrays.sort(arr);

    for (int i = 0; i < arr.length - 2; i++) {
      l = i + 1;
      r = arr.length - 1;
      int target = num-arr[i];


      while(l<r){
        int sum = arr[l] + arr[r];
        if(sum < target){
          l++;
        }
        else if(sum > target){
          r--;
        }
        else {
          count++;
          r--;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[]arr = {6, 1, 6, 5, 3, 2, 5, 0, 5, 6, 0};
    System.out.println(tripletSum(arr,5));
  }
}
