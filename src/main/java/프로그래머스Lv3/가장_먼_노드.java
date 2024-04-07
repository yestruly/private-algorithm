package 프로그래머스Lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 가장_먼_노드 {
  static ArrayList<Integer> graph[];
  static int[] distance;
  public static int solution(int n, int[][] edge) {
    int answer = 0;
    graph = new ArrayList[n+1];
    for (int i = 0; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }


    for (int i = 0; i < edge.length; i++) {
      int start = edge[i][0];
      int end = edge[i][1];
      graph[start].add(end);
      graph[end].add(start);

    }
    distance = new int[n+1];
    bfs(1);
    System.out.println(Arrays.toString(distance));
    Arrays.sort(distance);
    int max = distance[n];

    for(int item : distance){
      if(max == item){
        answer++;
      }
    }
    return answer;
  }

  private static void bfs(int node) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(node);
    distance[node] = 1;

    while (!queue.isEmpty()){
      int tmp = queue.remove();
      for(int item : graph[tmp]){
        if(distance[item] == 0){
          distance[item] += distance[tmp]+1;
          queue.add(item);
        }
      }
    }

  }

  public static void main(String[] args) {
    System.out.println(solution(6, new int[][]{{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}}));
  }

}
