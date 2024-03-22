package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1012 {
  static int n, m, k;
  static int arr[][];
  static boolean visited[][];
  static int dx[] = {1, 0, -1, 0};
  static int dy[] = {0, -1, 0, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      arr = new int[n][m];
      visited = new boolean[n][m];

      for (int j = 0; j < k; j++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        arr[a][b] = 1;
      }

      int count = 0;
      for (int j = 0; j < n; j++) {
        for (int l = 0; l < m; l++) {
          if(arr[j][l] == 1 && !visited[j][l]){
            bfs(j,l);
            count++;
          }
        }
      }
      System.out.println(count);
    }
  }
  static void bfs(int a, int b){
    Queue<int[] >queue = new LinkedList<>();
    queue.add(new int[]{a,b});
    visited[a][b] = true;

    while (!queue.isEmpty()){

      int[] tmp = queue.poll();
      for (int i = 0; i < 4; i++) {
        int x = tmp[0] + dx[i];
        int y = tmp[1] + dy[i];

        if(x<0 || y<0 || x>=n || y>=m){
          continue;
        }
        if(arr[x][y] ==1 && !visited[x][y]){
          queue.add(new int[]{x,y});
          visited[x][y] = true;
        }
      }
    }
  }

}
