package 동적계획법;

import java.util.Scanner;

public class P2342 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[][][] dp = new int[100001][5][5];
    int[][] dn = {{0, 2, 2, 2, 2}, {2, 1, 3, 4, 3}, {2, 3, 1, 3, 4}, {2, 4, 3, 1, 3},
        {2, 3, 4, 3, 1}};

    for (int i = 0; i < 100001; i++) {
      for (int j = 0; j < 5; j++) {
        for (int k = 0; k < 5; k++) {
          dp[i][j][k] = 100001*4;
        }
      }
    }

    dp[0][0][0] = 0;

    int n = 0;
    int s = 1;
    while (true) {
      n = sc.nextInt();
      if (n == 0) {
        break;
      }

      for (int i = 0; i < 5; i++) {
        if (n == i) {
          continue;
        }
        for (int j = 0; j < 5; j++) {
          dp[s][i][n] = Math.min(dp[s][i][n], dp[s - 1][i][j] + dn[j][n]);
        }
      }

      for (int j = 0; j < 5; j++) {
        if (n == j) {
          continue;
        }
        for (int i = 0; i < 5; i++) {
          dp[s][n][j] = Math.min(dp[s][n][j], dp[s - 1][i][j] + dn[i][n]);
        }
      }
      s++;
    }
    s--;

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        min = Math.min(min, dp[s][i][j]);
      }
    }
    System.out.println(min);
  }
}
