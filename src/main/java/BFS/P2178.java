package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
  static int[] dx = {0,1,0,-1};
  static int[] dy = {1,0,-1,0};
  static int[][] arr;
  static boolean[][] visited;
  static int n, m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String nums = st.nextToken();
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(nums.substring(j,j+1));
      }
    }

    bfs(0,0);
    System.out.println(arr[n-1][m-1]);


  }

  private static void bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{x,y});
    visited[x][y] = true;

    while (!queue.isEmpty()){
      int[] data = queue.poll();
      for (int k = 0; k < dx.length; k++) {
        int i = data[0]+dx[k];
        int j = data[1]+dy[k];

        if(i>=0 && j>=0 && i<n && j<m){
          if(arr[i][j] == 1 && !visited[i][j]){
            visited[i][j] = true;
            arr[i][j] = arr[data[0]][data[1]]+1;
            queue.add(new int[]{i,j});
          }
        }
      }
    }

  }

}
