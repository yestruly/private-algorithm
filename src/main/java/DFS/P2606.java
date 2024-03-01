package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2606 {
  static int count;
  static ArrayList<Integer> list[];
  static boolean visited[];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    list = new ArrayList[n+1];
    visited = new boolean[n+1];

    for (int i = 1; i <=n; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      list[s].add(e);
      list[e].add(s);
    }
    count = 0;
    dfs(1);

    System.out.println(count);
  }

  private static void dfs(int i) {
    if (visited[i]){
      return;
    }

    visited[i] = true;
    for(int item : list[i]){
      if(!visited[item]){
        count++;
        dfs(item);
      }
    }
  }

}
