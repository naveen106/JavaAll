package Recursion_II;
import java.util.*;
public class quickSort {

  public static void swap(int[]arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static int pivot(int[]arr, int start) {
    int pivot = arr[start];
    int swapIdx = start;

    for (int i = start + 1; i < arr.length; i++) {
      if (arr[i] < pivot) {
        swapIdx++;
        swap(arr, swapIdx, i);
      }
    }
    swap(arr,start,swapIdx);
    return swapIdx;
  }
  public static void quickSort(int[]arr, int start, int end){
    if(start<end){
      int pivotIndex = pivot(arr,start);
      quickSort(arr,start,pivotIndex-1);
      quickSort(arr,pivotIndex+1,end);
    }
  }

  public static void main(String[] args) {
    int[] arr = {7,4,5,9,0,12,5,1,2,8,0,-1,-5,7};
    quickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }
}