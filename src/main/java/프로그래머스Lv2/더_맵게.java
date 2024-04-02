package 프로그래머스Lv2;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 더_맵게 {
  public int solution(int[] scoville, int K) {
    int answer = 0;
    PriorityQueue<Integer> pq =new PriorityQueue<>();

    for(int item : scoville){
      pq.add(item);
    }

    while (!pq.isEmpty()){
      int x = pq.remove();

      if(x<K){
        if(pq.isEmpty()){
          return -1;
        }

        int y = pq.remove();
        pq.add(x+y*2);
        answer++;
      }
    }
    return answer;
  }
}
