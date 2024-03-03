package 그래프.벨만포드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11657 {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n, m;
  static long distance[];
  static Edge edges[];
  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    edges = new Edge[n+1];
    distance=new long[n+1];
    Arrays.fill(distance, Integer.MAX_VALUE);

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());
      edges[i] = new Edge(start,end,time);
    }

    distance[1] = 0;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < m; j++) {
        Edge edge = edges[j];
        if(distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start]+ edge.time){
          distance[edge.end] = distance[edge.start]+ edge.time;
        }
      }
    }

    boolean isMinus = false;
    for (int i = 0; i < m; i++) {
      Edge edge = edges[i];
      if(distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start]+ edge.time){
        isMinus = true;
      }
    }

    if(isMinus){
      System.out.println("-1");
    }else {
      for (int i = 2; i <=n ; i++) {
        if(distance[i] == Integer.MAX_VALUE){
          System.out.println("-1");
        }else{
          System.out.println(distance[i]);
        }
      }
    }
  }

  private static class Edge {
    int start;
    int end;
    int time;

    public Edge(int start, int end, int time) {
      this.start = start;
      this.end = end;
      this.time = time;
    }
  }
}
