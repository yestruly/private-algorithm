package 그래프.플로이드_워셜;

import java.io.*;
import java.util.*;

public class P14938 {
  static final int INF = 987654321;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer  st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());

    int[] item = new int[n+1];
    int[][] dp = new int[n+1][n+1];
    for (int i = 1; i <=n; i++) {
      for(int j=1; j<=n ;j++){
        dp[i][j] = INF;
        if(i==j){
          dp[i][j] = 0;
        }
      }
    }

    st = new StringTokenizer(br.readLine());
    for(int i=1; i<=n; i++){
      item[i] = Integer.parseInt(st.nextToken());
    }

    for(int i=0; i<r; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());
      dp[s][e] = value;
      dp[e][s] = value;
    }

    for(int k=1; k<=n; k++){
      for(int i=1; i<=n ;i++){
        for(int j=1; j<=n ;j++){
          dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
        }
      }
    }

    int total = 0;
    for(int i=1; i<=n; i++){
      int tmp = 0;
      for(int j=1; j<=n; j++){
        if(dp[i][j] <=m){
          tmp+=item[j];
        }
      }
      total = Math.max(tmp, total);
    }
    System.out.println(total);
  }

}
