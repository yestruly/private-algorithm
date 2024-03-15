package 조합;

import java.util.Scanner;

public class P1010 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[][] dp = new int[30][30];
    for (int i = 0; i < 30; i++) {
      dp[i][0] = 1;
      dp[i][i] = 1;
      dp[i][1] = i;
    }

    for (int i = 2; i <30 ; i++) {
      for (int j = 1; j <i ; j++) {
        dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
      }
    }
    int t = sc.nextInt();

    for (int i = 0; i < t; i++) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      System.out.println(dp[m][n]);
    }

  }

}
