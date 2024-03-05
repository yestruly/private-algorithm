package 그래프.플로이드_워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11404 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    int [][] distance = new int[n+1][n+1];

    for (int i = 1; i <=n ; i++) {
      for (int j = 1; j <=n ; j++) {
        if(i==j){
          distance[i][j] = 0;
        }else {
          distance[i][j] = 10000001;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      StringTokenizer st= new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());
      if(distance[s][e] > value){
        distance[s][e] = value;
      }
    }

    for (int k = 1; k <=n ; k++) {
      for (int i = 1; i <=n ; i++) {
        for (int j = 1; j <=n ; j++) {
          distance[i][j] = Math.min(distance[i][j], distance[k][j]+distance[i][k]);
        }
      }
    }

    for (int i = 1; i <=n ; i++) {
      for (int j = 1; j <=n ; j++) {
        if(distance[i][j]==10000001){
          System.out.print("0 ");
        }else {
          System.out.print(distance[i][j]+" ");
        }
      }
      System.out.println();
    }

  }

}
