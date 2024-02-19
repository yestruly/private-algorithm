package 그래프.그래프의_표현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1352 {
  static int n, m;
  static int[] answer;
  static boolean[] visited;
  static ArrayList<Integer>[] list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    list = new ArrayList[n + 1];
    answer = new int[n + 1];
    for (int i = 1; i < n + 1; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      list[s].add(e);
    }

    for (int i = 1; i < n + 1; i++) {
      visited = new boolean[n + 1];
      bfs(i);
    }

    int max = Integer.MIN_VALUE;
    for (int i = 1; i < n + 1; i++) {
      if (max < answer[i]) {
        max = answer[i];
      }
    }

    for (int i = 1; i < n + 1; i++) {
      if (max == answer[i]) {
        max = answer[i];
        System.out.print(i + " ");
      }
    }
  }

  private static void bfs(int x) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(x);
    visited[x] = true;

    while (!queue.isEmpty()){
      int tmp = queue.remove();
      for(int item : list[tmp]){
        if(!visited[item]){
          queue.add(item);
          visited[item] = true;
          answer[item]++;
        }
      }
    }
  }

}
