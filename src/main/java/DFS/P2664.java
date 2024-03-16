package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2664 {

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

    dfs(x,1);
    System.out.println(Arrays.toString(visited));
    System.out.println(visited[y]>0 ? visited[y]-1:-1);
  }

  static void dfs(int node, int depth){
    visited[node] = depth;

    for(int tmp : list[node]){
      if(visited[tmp] == 0){
        dfs(tmp, depth+1);
      }
    }
  }
}
