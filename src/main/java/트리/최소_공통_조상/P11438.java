package 트리.최소_공통_조상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11438 {
  static ArrayList<Integer> tree[];
  static boolean[] visited;
  static int[] depth;
  static int[][] parents;
  static int kMax;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    tree = new ArrayList[n+1];
    visited = new boolean[n+1];
    depth = new int[n+1];
    for (int i = 0; i <=n ; i++) {
      tree[i] = new ArrayList<>();
    }

    for (int i = 0; i < n-1; i++) {
      StringTokenizer st= new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      tree[s].add(e);
      tree[e].add(s);
    }

    int tmp=1;
    kMax = 0;
    while (kMax<=n){
      tmp <<=1;
      kMax++;
    }
    parents = new int[kMax+1][n+1];
    bfs(1);
    for (int k = 1; k <=kMax ; k++) {
      for (int i = 1; i <=n ; i++) {
        parents[k][i] = parents[k-1][parents[k-1][i]];
      }
    }

    int m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      StringTokenizer st= new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      System.out.println(lca(a,b));
    }

  }
  static int lca(int a, int b){
    if(depth[a] > depth[b]){
      int tmp = a;
      a =b;
      b = tmp;
    }

    for (int k = kMax; k >=0 ; k--) {
      if(Math.pow(2,k) <= depth[b]-depth[a]){
        if(depth[a] <= depth[parents[k][b]]){
          b = parents[k][b];
        }
      }
    }

    for (int i = kMax; i >=0 ; i--) {
      if(parents[i][a] != parents[i][b]){
        a = parents[i][a];
        b = parents[i][b];
      }
    }

    int result = a;
    if(a!=b){
      result = parents[0][result];
    }

    return  result;
  }

  static void bfs(int i){
    Queue<Integer> queue = new LinkedList<>();
    queue.add(i);
    visited[i] = true;
    int size = 1;
    int level = 1;
    int count = 0;

    while(!queue.isEmpty()){
      int tmp = queue.remove();
      for(int node : tree[tmp]){
        if(!visited[node]){
          visited[node] = true;
          queue.add(node);
          parents[0][node] = tmp;
          depth[node] = level;
        }
      }
      count++;

      if(count==size){
        count = 0;
        size = queue.size();
        level++;
      }
    }
  }

}
