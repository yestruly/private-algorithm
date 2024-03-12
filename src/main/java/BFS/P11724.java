package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11724 {
  static ArrayList<Integer> graph[];
  static boolean visited[];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    graph = new ArrayList[n+1];
    visited = new boolean[n+1];

    for (int i = 0; i <=n ; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      graph[start].add(end);
      graph[end].add(start);
    }

    int cnt=0;
    for (int i = 1; i <=n ; i++) {
      if(!visited[i]){
        bfs(i);
        cnt++;
      }
    }

    System.out.println(cnt);
  }

  private static void bfs(int i) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(i);
    visited[i] = true;

    while (!queue.isEmpty()){
      int tmp = queue.remove();

      for(int item : graph[tmp]){
        if(!visited[item]){
          visited[item] = true;
          queue.add(item);
        }
      }
    }
  }

}
