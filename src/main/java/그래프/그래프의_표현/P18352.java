package 그래프.그래프의_표현;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P18352 {
  static  int n, m, k, x;
  static ArrayList<Integer>[] list;
  static int[] visited;
  static ArrayList<Integer> result;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    k = sc.nextInt();
    x = sc.nextInt();
    list = new ArrayList[n+1];
    result = new ArrayList<>();
    for (int i = 1; i <=n ; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 1; i <=n ; i++) {
      int s = sc.nextInt();
      int e = sc.nextInt();
      list[s].add(e);
    }

    visited = new int[n+1];
    for (int i = 0; i <n+1 ; i++) {
      visited[i] = -1;
    }
    bfs(x);

    for (int i = 0; i <=n; i++) {
      if(visited[i] == k){
        result.add(k);
      }
    }

    Collections.sort(result);
    for(int item : result){
      System.out.println(result);
    }

  }

  private static void bfs(int x) {
    Queue<Integer> queue  =new LinkedList<>();
    queue.add(x);
    visited[x]++;
    while (!queue.isEmpty()){
      int tmp = queue.poll();
      for(int item : list[tmp]){
        if(visited[item] == -1){
          visited[item] = visited[tmp]+1;
          queue.add(item);
        }
      }
    }
  }

}
