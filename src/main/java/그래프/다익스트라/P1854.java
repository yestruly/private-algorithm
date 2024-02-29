package 그래프.다익스트라;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1854 {
  static final int INF = 100000000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[][] arr = new int[1001][1001];
    PriorityQueue<Integer>[] pq = new PriorityQueue[n+1];
    Comparator<Integer> comparator = new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1<o2 ? 1 : -1;
      }
    };

    for (int i = 0; i <=n; i++) {
      pq[i] = new PriorityQueue<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());

      arr[start][end] = value;
    }

    PriorityQueue<NodeEdge> queue = new PriorityQueue<>();
    queue.add(new NodeEdge(1,0));
    pq[1].add(0);

    while (!queue.isEmpty()){
      NodeEdge tmp = queue.poll();
      for (int i = 1; i <=n ; i++) {
        if(arr[tmp.edge][i] !=0){
          if(pq[i].size() < k){
            pq[i].add(tmp.value+arr[tmp.edge][i]);
            queue.add(new NodeEdge(i, tmp.value+arr[tmp.edge][i]));
          } else if (pq[i].peek() > tmp.value+arr[tmp.edge][i]) {
            pq[i].poll();
            pq[i].add(tmp.value+arr[tmp.edge][i]);
            queue.add(new NodeEdge(i, tmp.value+arr[tmp.edge][i]));

          }
        }
      }
    }

    for (int i = 1; i <=n ; i++) {
      if(pq[i].size() == k){
        bw.write(pq[i].peek()+"\n");
      }else {
        bw.write(-1+"\n");
      }
    }

    bw.flush();
    bw.close();
    br.close();
  }

  private static class NodeEdge implements Comparable<NodeEdge>{
    int edge;
    int value;

    public NodeEdge(int edge, int value) {
      this.edge = edge;
      this.value = value;
    }

    @Override
    public int compareTo(NodeEdge o) {
      return this.value < o.value ? -1 : 1;
    }
  }
}
