package 그래프.최소_신장_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1414 {

  static int n, sum;
  static int[] parent;
  static PriorityQueue<Edge> queue;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    parent = new int[n];
    queue = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      char[] tmp = st.nextToken().toCharArray();
      for (int j = 0; j < n; j++) {
        int num = 0;
        if(tmp[j] >='a' && tmp[j] <='z'){
          num = tmp[j]- 'a' +1;
        }else if(tmp[j] >= 'A' && tmp[j] <= 'Z'){
          num = tmp[j] - 'A' + 27;
        }

        sum += num;
        if(i!=j && num!=0){
          queue.add(new Edge(i,j,num));
        }
      }
    }

    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }

    int cnt=0;
    int answer = 0;
    while (!queue.isEmpty()){
      Edge tmp = queue.poll();
      if(find(tmp.start) != find(tmp.end)){
        union(tmp.start, tmp.end);
        answer += tmp.value;
        cnt++;
      }
    }

    if(cnt == n-1){
      System.out.println(sum-answer);
    }else {
      System.out.println(-1);
    }

  }

  private static void union(int start, int end) {
    int a = find(start);
    int b = find(end);

    if(a!=b){
      parent[b] = a;
    }
  }

  private static int find(int num) {
    if(parent[num]==num){
      return num;
    }else{
      return parent[num] = find(parent[num]);
    }
  }

  private static class Edge implements Comparable<Edge> {

    int start;
    int end;
    int value;

    public Edge(int start, int end, int value) {
      this.start = start;
      this.end = end;
      this.value = value;
    }

    public int compareTo(Edge e) {
      return this.value - e.value;
    }
  }
}
