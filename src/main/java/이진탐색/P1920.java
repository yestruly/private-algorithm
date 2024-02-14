package 이진탐색;

import java.util.Arrays;
import java.util.Scanner;

public class P1920 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    Arrays.sort(arr);

    int m = sc.nextInt();
    for (int i = 0; i < m; i++) {
      int target = sc.nextInt();
      boolean find = false;
      int startIdx = 0;
      int endIdx = n-1;

      while(startIdx<=endIdx){
        int mid = (startIdx+endIdx)/2;
        if(arr[mid] < target){
          startIdx= mid+1;
        }else if(arr[mid] > target){
          endIdx = mid-1;
        }else{
          find = true;
          break;
        }
      }

      if(find){
        System.out.println(1);
      }else{
        System.out.println(0);
      }
    }
  }

}
