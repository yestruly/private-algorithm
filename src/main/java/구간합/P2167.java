package 구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2167 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] arr = new int[n][m];

    for (int i = 0; i <n ; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    st = new StringTokenizer(br.readLine());
    int k = Integer.parseInt(st.nextToken());

    while (k>0){
      st = new StringTokenizer(br.readLine());
      int sum = 0;

      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      for (int a = i-1; a <x ; a++) {
        for (int b = j-1; b < y; b++) {
          sum+=arr[a][b];
        }
      }
      System.out.println(sum);
      k--;
    }
  }

}
