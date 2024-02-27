package 그래프.위상정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1948 {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    ArrayList<ArrayList<Node>> city = new ArrayList<ArrayList<Node>>();
    ArrayList<ArrayList<Node>> reverseCity = new ArrayList<ArrayList<Node>>();
    int[] inDegree = new int [n+1];
    for (int i = 0; i <=n ; i++) {
      city.add(new ArrayList<>());
      reverseCity.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());

      city.get(s).add(new Node(e, time));
      reverseCity.get(e).add(new Node(s, time));
      inDegree[e]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());
    queue.add(start);
    int[]result = new int[n+1];

    while (!queue.isEmpty()){
      int tmp = queue.remove();
      for(Node route : city.get(tmp)){
        inDegree[route.city]--;
        result[route.city] = Math.max(result[route.city], result[tmp]+route.time);
        if(inDegree[route.city]==0){
          queue.add(route.city);
        }
      }
    }

    int cnt = 0;
    boolean[] visited = new boolean[n+1];
    queue.add(end);
    visited[end] = true;
    while (!queue.isEmpty()){
      int tmp = queue.remove();
      for(Node route : reverseCity.get(tmp)){
        if(result[route.city]+ route.time == result[tmp]){
          cnt++;
          if(!visited[route.city]){
            visited[route.city] = true;
            queue.add(route.city);
          }
        }
      }
    }

    System.out.println(result[end]);
    System.out.println(cnt);
  }

  private static class Node {
    int city;
    int time;

    public Node(int city, int time) {
      this.city = city;
      this.time = time;
    }
  }
}
