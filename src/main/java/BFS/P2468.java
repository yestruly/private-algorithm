package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
            count++;
            bfs(i, j, h);
          }
        }
      }
      max = Math.max(max, count);
    }

    System.out.println(max);
  }

  static void bfs(int x, int y, int num) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{x, y});
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      int[] tmp = queue.remove();
      for (int i = 0; i < 4; i++) {
        int nX = tmp[0] + dx[i];
        int nY = tmp[1] + dy[i];

        if (nX >= 0 && nY >= 0 && n > nX && n > nY && !visited[nX][nY] && graph[nX][nY] > num) {
          visited[nX][nY] = true;
          queue.add(new int[]{nX, nY});
        }
      }
    }
  }

}
