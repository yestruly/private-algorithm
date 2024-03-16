package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2583 {
  static int m, n, k;
  static int[][] graph;
  static boolean[][] visited;
  static ArrayList<Integer> list = new ArrayList<>();
  static int[] dx = {1,0,-1,0};
  static int[] dy = {0,-1,0,1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    graph = new int[n][m];
    visited = new boolean[n][m];
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());

      for (int j = a; j <c ; j++) {
        for (int l = b; l <d ; l++) {
          graph[l][j] = 1;
         }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if(!visited[i][j] && graph[i][j] != 1){
          bfs(i,j);
        }
      }
    }
    Collections.sort(list);
    System.out.println(list.size());
    for(int item : list){
      System.out.print(item+" ");
    }
  }

  static void bfs(int i, int j){
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{i,j});
    visited[i][j] = true;
    int count = 1;

    while (!queue.isEmpty()){
      int[] tmp = queue.remove();
      int x = tmp[0];
      int y = tmp[1];

      for (int l = 0; l < 4; l++) {
        int nX = x+dx[l];
        int nY = y+dy[l];
        if(nX>=0 && nY>=0 && nX<n && nY<m){
          if(!visited[nX][nY] && graph[nX][nY] !=1){
            visited[nX][nY] = true;
            count++;
            queue.add(new int[]{nX, nY});
          }
        }
      }
    }
    list.add(count);
  }

}
