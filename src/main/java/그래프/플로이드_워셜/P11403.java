package 그래프.플로이드_워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11403 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] distance = new int[n+1][n+1];

    for (int i = 1; i <=n ; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j <=n ; j++) {
        distance[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int k = 1; k <=n ; k++) {
      for (int i = 1; i <=n ; i++) {
        for (int j = 1; j <=n ; j++) {
          if(distance[i][k]==1 && distance[k][j] ==1){
            distance[i][j] = 1;
          }
        }
      }
    }

    for (int i =1; i <=n ; i++) {
      for (int j = 1; j <=n ; j++) {
        System.out.print(distance[i][j]+" ");
      }
      System.out.println();
    }
  }

}
