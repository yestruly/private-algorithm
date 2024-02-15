package 프로그래머스Lv1;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 명예의_전당1 {
  public int[] solution(int k, int[] score) {
    int[] answer = new int[score.length];
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < score.length; i++) {
      if(pq.size() < k){
        pq.add(score[i]);
      }else {
        if(pq.peek() < score[i]){
          pq.remove();
          pq.add(score[i]);
        }
      }
      answer[i] = pq.peek();
      System.out.println(pq+" "+pq.peek());

    }

    return answer;
  }
}
