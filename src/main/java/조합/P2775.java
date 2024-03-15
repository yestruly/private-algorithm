package 조합;

import java.util.Scanner;

public class P2775 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[][] dp = new int[15][15];
    for (int i = 0; i < 15; i++) {
      dp[i][1] = 1;
      dp[0][i] = i;
    }

    for (int i = 1; i <15 ; i++) {
      for (int j = 2; j < 15; j++) {
        dp[i][j] = dp[i-1][j]+dp[i][j-1];
      }
    }

    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      int k = sc.nextInt();
      int n = sc.nextInt();
      System.out.println(dp[k][n]);
    }
  }

}
