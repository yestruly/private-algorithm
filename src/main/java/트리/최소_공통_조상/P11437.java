package 트리.최소_공통_조상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11437 {
  static ArrayList<Integer> tree[];
  static boolean visit[];
  static int depth[];
  static int parents[];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    tree= new ArrayList[n+1];
    visit = new boolean[n+1];
    depth = new int[n+1];
    parents = new int[n+1];
    for (int i = 0; i <=n ; i++) {
      tree[i] = new ArrayList<>();
    }

    for (int i = 0; i < n-1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      tree[s].add(e);
      tree[e].add(s);
    }

    bfs(1);
    int m = Integer.parseInt(br.readLine());
    for(int i=0; i<m; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      System.out.println(lca(a,b));
    }
  }
  static int lca(int a, int b){
    if(depth[a] < depth[b]){
      int tmp = a;
      a = b;
      b = a;
    }

    while(depth[a]!=depth[b]){
      a = parents[a];
    }

    while (a!=b){
      a = parents[a];
      b= parents[b];
    }

    return a;
  }

  static void bfs(int i){
    Queue<Integer> queue = new LinkedList<>();
    queue.add(i);
    int size = 1;
    int level = 1;
    int count = 0;

    while(!queue.isEmpty()){
      int tmp = queue.remove();
      for(int node : tree[tmp]){
        if(!visit[node]){
          visit[node] = true;
          queue.add(node);
          parents[node] = tmp;
          depth[node] = level;
        }
      }

      if(count == size){
        level++;
        count = 0;
        size = queue.size();
      }
    }
  }

}
