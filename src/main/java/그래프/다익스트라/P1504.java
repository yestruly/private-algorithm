package 그래프.다익스트라;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.AnnotatedArrayType;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1504 {
  static ArrayList<Node> graph[];
  static int[] distance;
  static boolean[] visited;
  static final int INF = 987654321;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());
    graph = new ArrayList[n+1];
    distance = new int[n+1];
    for (int i = 1; i <=n ; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      graph[a].add(new Node(b,c));
      graph[b].add(new Node(a,c));
    }


    st = new StringTokenizer(br.readLine());
    int v1 = Integer.parseInt(st.nextToken());
    int v2 = Integer.parseInt(st.nextToken());

    visited = new boolean[n+1];
    int answer1 = 0;
    answer1+= dijkstra(1,v1);
    answer1+= dijkstra(v1,v2);
    answer1+= dijkstra(v2,n);

    int answer2 = 0;
    answer2+= dijkstra(1,v2);
    answer2+= dijkstra(v2,v1);
    answer2+= dijkstra(v1,n);

    int result = answer1>=INF&&answer2>=INF ? -1 : Math.min(answer1, answer2);
    bw.write(result+"\n");
    bw.flush();
    bw.close();
    br.close();
  }

  private static int dijkstra(int a, int b) {
    Arrays.fill(distance, INF);
    Arrays.fill(visited,false);
    distance[1] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(a, 0));
    while (!pq.isEmpty()){
      Node tmp = pq.poll();
      if(!visited[tmp.edge]){
        visited[tmp.edge] = true;
        for (Node node : graph[tmp.edge]){
          if(distance[node.edge] > tmp.value + node.value){
            distance[node.edge] = tmp.value + node.value;
            pq.add(new Node(node.edge, distance[node.edge]));
          }
        }
      }
    }

    return distance[b];
  }

  static class Node implements Comparable<Node> {
    int edge;
    int value;

    public Node(int edge, int value) {
      this.edge = edge;
      this.value = value;
    }

    @Override
    public int compareTo(Node o) {
      return value-o.value;
    }
  }

}
