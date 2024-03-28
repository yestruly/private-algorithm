package 프로그래머스Lv2;

import java.util.ArrayList;

public class 하노이의_탑 {
  public int[][] solution(int n) {
    int[][] answer = {};
    ArrayList<int[]> list =new ArrayList<>();
    hanoi(n, 1,2,3, list);
    answer = list.stream().toArray(int[][]::new);
    return answer;
  }

  private void hanoi(int n, int start, int middle, int end, ArrayList<int[]> list) {
    if(n==0){
      return;
    }
    hanoi(n-1, start,end,middle, list);
    list.add(new int[]{start,end});
    hanoi(n-1, middle,start,end,list);
  }


}
