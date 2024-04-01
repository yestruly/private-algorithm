package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1766 {
  static ArrayList<Integer> list[];
  static int degree[];
  static int n;
  static int m;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    degree = new int[n+1];
    list = new ArrayList[n+1];

    for (int i = 1; i <=n ; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      list[s].add(e);
      degree[e]++;
    }

    dfs(degree);

  }

  static void dfs(int[] degree){
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 1; i <=n ; i++) {
      if(degree[i] == 0){
        pq.add(i);
      }
    }
    StringBuilder sb = new StringBuilder();

    while (!pq.isEmpty()){
      int tmp = pq.remove();
      sb.append(tmp+" ");
      for(int item : list[tmp]){
        degree[item]--;
        if(degree[item] == 0){
          pq.offer(item);
        }
      }
    }
    System.out.println(sb);
  }

}
