package 프로그래머스Lv1;

import java.lang.reflect.Array;
import java.util.*;

public class 과일_장수 {
  public static int solution(int k, int m, int[] score) {
    int answer = 0;
    //버블소트
    for (int i = 0; i < score.length-1; i++) {
      for (int j = 0; j < score.length-1-i; j++) {
        if(score[j] > score[j+1]){
          int tmp = score[j];
          score[j] =score[j+1];
          score[j+1] = tmp;
        }
      }
    }

    for (int i = score.length; i >=m ; i-=m) {
      answer += score[i-m]*m;
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(3,4,new int[]{1,2,3,1,2,3,1}));
  }

}
