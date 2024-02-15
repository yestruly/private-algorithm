package 그리디;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1931 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] arr = new int[n][2];

    for (int i = 0; i < n; i++) {
      int x = sc.nextInt();
      int y= sc.nextInt();
      arr[i][0] =x;
      arr[i][1] = y;
    }

    Arrays.sort(arr, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if(o1[1] == o2[1]){
          return o1[0]-o2[0];
        }
        return o1[1]-o2[1];
      }
    });

    int cnt = 0;
    int end = -1;

    for(int item[] : arr){
      if(item[0]>=end){
        end = item[1];
        cnt++;
      }
    }
    System.out.println(cnt);
  }

}
