package Recursion_II;
import java.util.Arrays;

public class mergeSort {

      public static void merge(int[] arr, int start, int mid, int end){

      int[] left = new int[mid-start + 1]; //size of the temp left array
      int[] right = new int[end - mid]; //size of the temp right array

      for (int i = 0; i < left.length; ++i)
        left[i] = arr[start + i];

      for (int j = 0; j < right.length; ++j)
        right[j] = arr[mid + 1 + j];

      int i = 0, j = 0;
      int count = start;

      while(i<left.length && j<right.length){
        if(left[i] < right[j]){
          arr[count] = left[i];
          count++;
          i++;
        }

        else{
          arr[count] = right[j];
          count++;
          j++;
        }
      }

      while(i<left.length){
        arr[count] = left[i];
        count++;
        i++;
      }

      while(j<right.length){
        arr[count] = right[j];
        count++;
        j++;
      }

    }

    public static int[] mergeSort(int[]input, int start, int end){

      if(start<end){
        int mid = start + (end-start) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid+1, end);
        merge(input, start, mid, end);
      }
      return input;
    }


public static void main(String[] args) {
    int[]arr = {65,23,123,6,3,0,54};
    arr = mergeSort(arr,0,arr.length-1);
    System.out.println(Arrays.toString(arr));

  }

}