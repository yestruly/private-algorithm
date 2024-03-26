package 프로그래머스Lv3;

import java.util.ArrayList;

public class 네트워크 {
  public int solution(int n, int[][] computers) {
    int answer = 0;
    boolean[] visit = new boolean[n];
    ArrayList<Integer>[] list = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if(i==j){
          continue;
        }
        if(computers[i][j] == 1){
          list[i].add(j);
          list[j].add(i);
        }
      }
    }

    for (int i = 0; i < n; i++) {
      if(!visit[i]){
        dfs(i, list, visit);
        answer++;
      }
    }
    return answer;
  }

  private static void dfs(int i, ArrayList<Integer>[] list, boolean[] visit) {
    if(visit[i]){
      return;
    }

    visit[i] = true;
    for(int item : list[i]){
      if(!visit[item]){
        dfs(item, list, visit);
      }
    }
  }

}
