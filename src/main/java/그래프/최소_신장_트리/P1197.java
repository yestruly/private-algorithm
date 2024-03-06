package 그래프.최소_신장_트리;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1197 {

  static int[] parent;
  static PriorityQueue<Edge> queue;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int v = sc.nextInt();
    int e = sc.nextInt();
    parent = new int[v+1];
    queue = new PriorityQueue<>();
    for (int i = 0; i < v; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < e; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      int value = sc.nextInt();
      queue.add(new Edge(start,end,value));
    }

    int cnt = 0;
    int answer = 0;
    while (cnt < v-1){
      Edge tmp = queue.poll();
      if(find(tmp.start)!= find(tmp.end)){
        union(tmp.start, tmp.end);
        answer+=tmp.value;
        cnt++;
      }
    }

    System.out.println(answer);
  }

  private static void union(int start, int end) {
    int parentS = find(start);
    int parentE = find(end);
    if(parentS!=parentE){
      parent[parentE] = parentS;
    }
  }

  private static int find(int n) {
    if(parent[n]==n){
      return n;
    }else {
      return parent[n] = find(parent[n]);
    }
  }

  private static class Edge implements Comparable<Edge>{
    int start;
    int end;
    int value;

    public Edge(int start, int end, int value) {
      this.start = start;
      this.end = end;
      this.value = value;
    }

    @Override
    public int compareTo(Edge o) {
      return this.value-o.value;
    }
  }
}
