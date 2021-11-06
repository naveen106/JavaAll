package TimeComplexityAnalysis;
import java.util.*;
public class ArrayIntersection {

  public static void print(int[] arr1, int[] arr2) {
    Arrays.sort(arr1);
    Arrays.sort(arr2);

    int i = 0; int j = 0;

    while(i<arr1.length && j<arr2.length){
      if(arr1[i] == arr2[j]){
        System.out.print(arr1[i] + " ");
        i++;
        j++;
      }

      else if(arr1[i] < arr2[j])
        i++;

      else
        j++;
    }
  }

  public static void main(String[] args) {
    int [] arr1 =  {6,9,8,5};
    int[]arr2 ={9,2,4,1,8};
    print(arr1,arr2);
  }
}