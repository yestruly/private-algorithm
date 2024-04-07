package 그래프.플로이드_워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10159 {

  public static void main(String[] args) throws IOException {
    final int INF = 987654321;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    int[][] dp = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] = INF;
        if (i == j) {
          dp[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      dp[s][e] = 1;
    }

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
        }
      }
    }

    for (int i = 1; i <=n ; i++) {
      int count = 0;
      for (int j = 1; j <=n ; j++) {
        if(dp[i][j]==INF && dp[j][i]==INF){
          count++;
        }
      }

      System.out.println(count);
    }
  }

}
