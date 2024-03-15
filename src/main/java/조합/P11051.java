package 조합;

import java.util.Scanner;

public class P11051 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[][] dp = new int[n+1][n+1];

    for (int i = 0; i <=n ; i++) {
      dp[i][i] = 1;
      dp[i][0] = 1;
      dp[i][1] = i;
    }

    for (int i = 2; i <=n ; i++) {
      for (int j = 1; j <i ; j++) {
        dp[i][j] = (dp[i-1][j]+dp[i-1][j-1])% 10007;
      }
    }

    System.out.println(dp[n][k]);
  }

}
