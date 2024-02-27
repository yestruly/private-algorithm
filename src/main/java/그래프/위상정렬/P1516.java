package 그래프.위상정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1516 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    ArrayList<ArrayList<Integer>> list  = new ArrayList<>();
    int[] inDegree = new int[n+1];
    int[] selfBuild = new int[n+1];

    for (int i = 0; i <=n ; i++) {
      list.add(new ArrayList<>());
    }

    for (int i = 1; i <=n ; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      selfBuild[i] = Integer.parseInt(st.nextToken());
      while (true){
        int tmp = Integer.parseInt(st.nextToken());
        if(tmp == -1){
          break;
        }
        list.get(tmp).add(i);
        inDegree[i]++;
      }
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <=n ; i++) {
      if(inDegree[i] == 0){
        queue.add(i);
      }
    }

    int[]result = new int[n+1];
    while (!queue.isEmpty()){
      int tmp = queue.remove();
      for(int node : list.get(tmp)){
        inDegree[node]--;
        result[node] = Math.max(result[node], result[tmp]+selfBuild[tmp]);
        if(inDegree[node] == 0){
          queue.add(node);
        }
      }
    }

    for (int i = 1; i <=n ; i++) {
      System.out.println(selfBuild[i]+result[i]);
    }
  }

}
