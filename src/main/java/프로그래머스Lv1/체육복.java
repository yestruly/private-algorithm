package 프로그래머스Lv1;

import java.util.Arrays;

public class 체육복 {
  public static int solution(int n, int[] lost, int[] reserve) {
    int answer = 0;
    answer = n-lost.length;
    Arrays.sort(lost);
    Arrays.sort(reserve);

    for (int i = 0; i < lost.length; i++) {
      for (int j = 0; j < reserve.length; j++) {
        if(lost[i] == reserve[j]){
          answer++;
          lost[i] = -1;
          reserve[j] = -1;
          break;
        }
      }
    }

    for (int i = 0; i < lost.length; i++) {
      for (int j = 0; j < reserve.length; j++) {
        if(Math.abs(lost[i]-reserve[j]) == 1){
          answer++;
          lost[i] = -1;
          reserve[j] = -1;
          break;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(3, new int[]{3}, new int[]{1}));
  }

}
