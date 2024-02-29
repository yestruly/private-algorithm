package 그래프.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753 {
  static ArrayList<Node> list[];
  static boolean visited[];
  static int[] distance;
  static int v, e, k;
  static PriorityQueue<Node> queue;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    v = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(br.readLine());

    list = new ArrayList[v+1];
    visited = new boolean[v+1];
    distance = new int[v+1];
    queue = new PriorityQueue<>();

    for (int i = 1; i <=v ; i++) {
      list[i] = new ArrayList<>();
    }
    for (int i = 0; i <=v ; i++) {
      distance[i] = Integer.MAX_VALUE;
    }

    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());
      int node = Integer.parseInt(st.nextToken());
      int edge = Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());

      list[node].add(new Node(edge, value));
    }

    queue.add(new Node(k, 0));
    System.out.println(queue);
    distance[k] = 0;

    while (!queue.isEmpty()){
      Node tmp = queue.poll();
      if(visited[tmp.edge]){
        continue;
      }
      visited[tmp.edge] = true;
      for(Node target : list[tmp.edge]){
        if(distance[tmp.edge]+target.value < distance[target.edge]){
          distance[target.edge] = distance[tmp.edge]+target.value;
          queue.offer(new Node(target.edge, distance[target.edge]));
        }
      }
    }

    for (int i = 1; i <distance.length ; i++) {
      if(visited[i]){
        System.out.println(distance[i]);
      }else{
        System.out.println("INF");
      }
    }

  }

  private static class Node implements Comparable<Node> {
    int edge;
    int value;

    public Node(int edge, int value) {
      this.edge = edge;
      this.value = value;
    }

    @Override
    public int compareTo(Node o) {
      if(this.value > o.value){
        return 1;
      }

      return -1;
    }
  }
}
