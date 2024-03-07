package 투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class P2230 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    Arrays.sort(arr);
    int left = 0;
    int right = 0;
    int answer = Integer.MAX_VALUE;
    while (left<=right && right<n){
      int tmp = arr[right]-arr[left];
      if (tmp >= m){
        answer = Math.min(answer,tmp);
      }

      if(tmp==m){
        break;
      }else if(tmp < m){
        right++;
      }else{
        left++;
      }
    }
    System.out.println(answer);
  }

}
