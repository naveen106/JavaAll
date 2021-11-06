package TimeComplexityAnalysis;

public class ArrayEquilibrium {
  public static int arrayEquilibriumIndex(int[] arr){
    if(arr.length <= 1) return -1;
    int left=0, right=0;

    for(int j = 2; j<arr.length; j++)
    right = right + arr[j];
    right = right + arr[1];

    for(int i = 1; i<arr.length-1; i++){
      left = left + arr[i-1];
      right = right - arr[i];

      if(left == right)
      return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {6,1,6,5,3,2,5,0,5,6,0};
    System.out.println(arrayEquilibriumIndex(arr));
  }
}
