package 이진탐색;

import java.util.Scanner;

public class P2343 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] arr = new int[n];
    int start = 0;
    int end = 0;

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
      if(arr[i] > start){
        start = arr[i];
      }
      end += arr[i];
    }

    while (start <= end){
      int mid = (start+end)/2;
      int sum = 0;
      int cnt = 0;

      for (int i = 0; i < n; i++) {
        if(sum + arr[i] > mid){
          cnt++;
          sum = 0;
        }
        sum+=arr[i];
      }
      if(sum!=0){
        cnt++;
      }
      if(cnt > m){
        start = mid+1;
      }else{
        end = mid-1;
      }
    }

    System.out.println(start);
  }

}
