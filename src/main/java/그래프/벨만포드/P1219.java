package 그래프.벨만포드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1219 {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n, m, start, end;
  static long distance[];
  static long money[];
  static Edge edges[];

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    edges = new Edge[n+1];
    distance = new long[n+1];
    money = new long[n+1];
    Arrays.fill(distance, Long.MIN_VALUE);

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());
      edges[i] = new Edge(s, e, value);
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      money[i] = Long.parseLong(st.nextToken());
    }

    distance[start] = money[start];
    for (int i = 0; i < n+100; i++) {
      for (int j = 0; j < m; j++) {
        int start = edges[j].start;
        int end = edges[j].end;
        int value = edges[j].value;

        if(distance[start] == Long.MIN_VALUE){
          continue;
        } else if (distance[start] == Long.MAX_VALUE) {
          distance[end] = Long.MAX_VALUE;
        }else if(distance[end]<distance[start]+money[end]-value){
          distance[end] = distance[start]+money[end]-value;
          if(i>=n-1){
            distance[end] = Long.MAX_VALUE;
          }
        }
      }
    }
    if(distance[end] == Long.MIN_VALUE){
      System.out.println("gg");
    }else if (distance[end] == Long.MAX_VALUE){
      System.out.println("Gee");
    }else {
      System.out.println(distance[end]);
    }
  }

  private static class Edge {
    int start;
    int end;
    int value;

    public Edge(int start, int end, int value) {
      this.start = start;
      this.end = end;
      this.value = value;
    }
  }
}
