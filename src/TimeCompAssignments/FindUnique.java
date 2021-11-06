package TimeCompAssignments;

public class FindUnique {
  static int findUnique(int[] arr) {
    int a = arr[0];

    for(int i = 1; i<arr.length; i++){
      a = a ^ arr[i];
    }
    return a;
  }

  public static void main(String[] args) {
    int[]arr = {6,1,6,3,4,3,1};//{6, 3, 7, 5, 1, 3, 5, 1, 7, 9, 6};
    System.out.println(findUnique(arr));
  }
}
