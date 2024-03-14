package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {

  static int arr[][];
  static int visited[][];
  static int dx[] = {1, 0, -1, 0};
  static int dy[] = {0, -1, 0, 1};
  static Queue<int[]> queue = new LinkedList<>();
  static int n, m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[m][n];
    visited = new int[m][n];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        if (arr[i][j] == 1) {
          queue.add(new int[]{i, j});
        }
      }
    }

    System.out.println(bfs());

  }

  static int bfs() {
    while (!queue.isEmpty()) {
      int[] tmp = queue.poll();
      int x = tmp[0];
      int y = tmp[1];
      for (int i = 0; i < 4; i++) {
        int tmpX = x + dx[i];
        int tmpY = y + dy[i];
        if(tmpX<0 || tmpY<0 || tmpX>=m || tmpY >=n){
          continue;
        }
        if (visited[tmpX][tmpY] == 0 && arr[tmpX][tmpY] ==0) {
          visited[tmpX][tmpY] = visited[x][y] + 1;
          arr[tmpX][tmpY] = 1;
          queue.add(new int[]{tmpX, tmpY});

        }
      }
    }

    for (int array[] : arr) {
      for (int item : array) {
        if (item == 0) {
          return -1;
        }
      }
    }

    int max = Integer.MIN_VALUE;
    for (int array[] : visited) {
      for (int item : array) {
        max = Math.max(max, item);
      }
    }

    return max;
  }

}
