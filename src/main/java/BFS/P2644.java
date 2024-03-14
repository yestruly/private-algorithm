package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2644 {

  static int x, y;
  static int visited[];
  static ArrayList<Integer> list[];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());

    list = new ArrayList[n + 1];
    visited = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      list[i] = new ArrayList<>();
    }

    int m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      list[s].add(e);
      list[e].add(s);
    }
    bfs(x);
    System.out.println(visited[y]>0 ? visited[y]:-1);
  }

  static void bfs(int node) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(node);

    while (!queue.isEmpty()){
      int tmp = queue.poll();
      if(tmp == y){
        break;
      }
      for(int item : list[tmp]){
        if(visited[item] == 0){
          queue.add(item);
          visited[item] = visited[tmp]+1;
        }
      }
    }
  }

}
