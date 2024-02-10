package 정렬;

import java.util.Arrays;
import java.util.Scanner;

public class P11399 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    int sum[] = new int[n];

    for (int i = 1; i <n ; i++) {
      int insertIdx = i;
      int insertVal = arr[i];

      for (int j = i-1; j >=0 ; j--) {
        if(arr[i] > arr[j]){
          insertIdx = j+1;
          break;
        }
        if(j==0){
          insertIdx = 0;
        }
      }

      for (int j = i; j >insertIdx ; j--) {
        arr[j] = arr[j-1];
      }

      arr[insertIdx] = insertVal;
    }

    sum[0] = arr[0];
    for (int i = 1; i < n; i++) {
      sum[i] = sum[i-1]+arr[i];
    }

    int answer = 0;
    for(int item : sum){
      answer+=item;
    }

    System.out.println(answer);
  }

}
