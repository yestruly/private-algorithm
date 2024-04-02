package 구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16507 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[][] arr = new int[r + 1][c + 1];
    int[][] dp = new int[r + 1][c + 1];

    for (int i = 1; i <= r; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= c; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 1; i <= r; i++) {
      for (int j = 1; j <= c; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
      }
    }

    while (k-- > 0) {
      st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());

      long area = dp[i][j] - (dp[x - 1][j] + dp[i][y - 1] - dp[x - 1][y - 1]);
      int under = ((i - x) + 1) * ((j - y) + 1);
      System.out.println(area / under);
    }
  }

}
