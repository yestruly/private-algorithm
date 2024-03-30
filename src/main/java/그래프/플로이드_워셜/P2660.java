package 그래프.플로이드_워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2660 {
  private static final int INF = 987654321;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == j) {
          arr[i][j] = 0;
        } else {
          arr[i][j] = INF;
        }
      }
    }
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      if (x == -1 && y == -1) {
        break;
      }
      arr[x][y] = 1;
      arr[y][x] = 1;
    }

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
         arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
        }
      }
    }

    int score = INF;
    int people[] = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      int tmp = 0;
      for (int j = 1; j <= n; j++) {
        if (arr[i][j] != INF) {
          tmp = Math.max(tmp, arr[i][j]);
        }
      }
      people[i] = tmp;
      score = Math.min(tmp, score);
    }

    int count = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <=n ; i++) {
      if(people[i] == score){
        count++;
        sb.append(i+" ");
      }
    }

    System.out.println(score+" "+count);
    System.out.println(sb.toString());

    }

  }
