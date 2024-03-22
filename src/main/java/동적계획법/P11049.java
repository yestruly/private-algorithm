package 동적계획법;

import java.util.Scanner;

public class P11049 {
  static int n;
  static int[][] dp;
  static Matrix[] matrices;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    dp = new int[n+1][n+1];
    matrices = new Matrix[n+1];

    for (int i = 0; i < n+1; i++) {
      for (int j = 0; j < n+1; j++) {
        dp[i][j] = -1;
      }
    }

    for (int i = 1; i <= n; i++) {
      int x= sc.nextInt();
      int y = sc.nextInt();
      matrices[i] = new Matrix(x,y);
    }

    System.out.println(execute(1,n));
  }

  private static int execute(int s, int e) {
    int result = Integer.MAX_VALUE;

    if(dp[s][e] != -1){
      return dp[s][e];
    }
    if(s==e){
      return 0;
    }
    if(s+1==e){
      return matrices[s].y *matrices[s].x* matrices[e].x;
    }

    for (int i = s; i <e ; i++) {
      result = Math.min(result, matrices[s].y*matrices[i].x*matrices[e].x + execute(s,i) +execute(i+1,e));
    }
    return dp[s][e] = result;
  }

  static class Matrix{
    int x;
    int y;

    public Matrix(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

}
