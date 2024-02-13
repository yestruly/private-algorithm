package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Edge{
  int node;
  int value;
  Edge(){}
  Edge(int node, int value){
    this.node = node;
    this.value = value;
  }
}
public class P1167 {
  static ArrayList<Edge>[] arr;
  static boolean[] visited;
  static int[] distance;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    arr = new ArrayList[n+1];
    for (int i = 1; i <=n; i++) {
      arr[i] = new ArrayList<Edge>();
    }

    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      while (true){
        int node = sc.nextInt();
        if(node==-1){
          break;
        }
        int value = sc.nextInt();
        arr[num].add(new Edge(node, value));
      }
    }

    visited = new boolean[n+1];
    distance = new int[n+1];
    bfs(1);

    int MAX = 1;
    for (int i = 2; i <= n ; i++) {
      if(distance[i] > distance[MAX]){
        MAX = i;
      }
    }

    visited = new boolean[n+1];
    distance = new int[n+1];
    bfs(MAX);
    Arrays.sort(distance);
    System.out.println(distance[distance.length-1]);
  }

  private static void bfs(int num) {
    Queue<Integer> queue = new LinkedList<>();
    //offer -> false반환 (문제 상황 발생시)
    //add -> 예외 발생
    queue.add(num);
    visited[num] = true;

    while (!queue.isEmpty()){
      int data = queue.poll();
      for(Edge item : arr[data]){
        if(!visited[item.node]){
          queue.add(item.node);
          visited[item.node] = true;
          distance[item.node] = distance[data]+item.value;
        }
      }
    }


  }
}
