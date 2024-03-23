package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1926 {

  static boolean[][] visited;
  static int[][] arr;
  static Queue<int[]> queue = new LinkedList<>();
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static int max = 0;
  static int n, m;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    boolean isZero = true;
    arr = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        if (arr[i][j] == 1) {
          isZero = false;
        }
      }
    }

    if (isZero) {
      System.out.println("0");
      System.out.println("0");
      return;
    }

    int count=0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == 1 && !visited[i][j]) {
          bfs(i,j);
          count++;
        }
      }
    }

    System.out.println(count);
    System.out.println(max);
  }

  private static void bfs(int i, int j) {
    visited[i][j] = true;
    queue.add(new int[]{i, j});
    int area = 1;
    while (!queue.isEmpty()) {
      int[] tmp = queue.poll();
      int x = tmp[0];
      int y = tmp[1];
      for (int k = 0; k < 4; k++) {
        int tmpX = x + dx[k];
        int tmpY = y + dy[k];
        if (tmpX >= 0 && tmpY >= 0 && tmpX < n && tmpY < m && !visited[tmpX][tmpY] && arr[tmpX][tmpY]==1) {
          visited[tmpX][tmpY] = true;
          queue.add(new int[]{tmpX, tmpY});
          area++;
        }
      }
    }
    max = Math.max(area,max);
  }

}
