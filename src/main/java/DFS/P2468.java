package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2468 {

  static boolean visited[][];
  static int graph[][];
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, -1, 0, 1};
  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    graph = new int[n][n];
    int maxVal = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
        if (maxVal < graph[i][j]) {
          maxVal = graph[i][j];
        }
      }
    }

    int max = Integer.MIN_VALUE;
    for (int h = 1; h <= maxVal; h++) {
      visited = new boolean[n][n];
      int count = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (!visited[i][j] && graph[i][j] > h) {
            count+=dfs(i,j,h);
          }
        }
      }
      max = Math.max(max, count);
    }

    System.out.println(max);
  }

  static int dfs(int x, int y, int h) {
    visited[x][y] = true;
    for (int i = 0; i < 4; i++) {
      int nX = x + dx[i];
      int nY = y + dy[i];
      if (nX < 0 || nY < 0 || nX >= n || nY >= n
          || visited[nX][nY] || graph[nX][nY] <= h) {
        continue;
      }
      dfs(nX, nY, h);
    }
    return 1;
  }

}
