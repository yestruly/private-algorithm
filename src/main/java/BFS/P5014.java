package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5014 {

  static int[] visited;
  static int f, s, g, u, d;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    f = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());
    g = Integer.parseInt(st.nextToken());
    u = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());

    visited = new int[f + 1];
    bfs(s);
    System.out.println(visited[g]==0?"use the stairs" : visited[g]-1);
  }

  static void bfs(int s) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);
    visited[s] = 1;

    while (!queue.isEmpty()) {
      int tmp = queue.remove();
      if (tmp == g) {
        break;
      }
      if (tmp + u <=f && visited[tmp + u] == 0) {
        visited[tmp + u] = visited[tmp] + 1;
        queue.add(tmp + u);
      }
      if (tmp - d > 0 && visited[tmp-d]==0){
        visited[tmp-d] = visited[tmp]+1;
        queue.add(tmp-d);
      }

    }
  }

}
