package 그래프.다익스트라;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1916 {

  static int n, m, start, end;
  static boolean[] visited;
  static int[] distance;
  static ArrayList<Node> list[];


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    visited = new boolean[n + 1];
    distance = new int[n + 1];
    list = new ArrayList[n + 1];

    for (int i = 0; i <= n; i++) {
      list[i] = new ArrayList<>();
    }
    Arrays.fill(distance, Integer.MAX_VALUE);

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());

      list[start].add(new Node(end, value));
    }

    st = new StringTokenizer(br.readLine());
    int s = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());

    bw.write(dijkstra(s, e) + "\n");
    bw.flush();
    bw.close();
    br.close();
  }

  private static int dijkstra(int start, int end) {
    PriorityQueue<Node> queue = new PriorityQueue<>();
    distance[start] = 0;
    queue.add(new Node(start, 0));

    while (!queue.isEmpty()) {
      Node tmp = queue.remove();
      if (!visited[tmp.edge]) {
        visited[tmp.edge] = true;

        for (Node target : list[tmp.edge]) {
          if (!visited[target.edge]
              && distance[target.edge] > distance[tmp.edge] + target.value) {
            distance[target.edge] = distance[tmp.edge] + target.value;
            queue.add(new Node(target.edge, distance[tmp.edge] + target.value));
          }
        }
      }
    }
    return distance[end];

  }
}

class Node implements Comparable<Node> {

  int edge;
  int value;

  public Node(int edge, int value) {
    this.edge = edge;
    this.value = value;
  }

  @Override
  public int compareTo(Node o) {
    return this.value - o.value;
  }
}

