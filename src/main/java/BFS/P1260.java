package BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1260 {
  static ArrayList<Integer>[] arr;
  static boolean[] visited;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int v = sc.nextInt();

    arr = new ArrayList[n+1];
    for (int i = 1; i <=n ; i++) {
      arr[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      int s = sc.nextInt();
      int e = sc.nextInt();
      arr[s].add(e);
      arr[e].add(s);
    }

    for (int i = 1; i <=n ; i++) {
      Collections.sort(arr[i]);
    }

    visited = new boolean[n+1];
    dfs(v);
    System.out.println();
    visited = new boolean[n+1];
    bfs(v);
  }

  private static void bfs(int node) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(node);
    visited[node] = true;

    while(!queue.isEmpty()){
      int data = queue.remove();
      System.out.print(data+" ");
      for(int item : arr[data]){
        if(!visited[item]){
          visited[item] = true;
          queue.add(item);
        }
      }
    }

  }

  private static void dfs(int node) {
    System.out.print(node+" ");
    visited[node] = true;

    for(int item : arr[node]){
      if(!visited[item]){
        dfs(item);
      }
    }
  }

}
