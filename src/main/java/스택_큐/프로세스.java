package 스택_큐;

import java.util.*;
public class 프로세스 {
  public int solution(int[] priorities, int location) {
    int answer = 0;
    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

    for(int item : priorities){
      queue.add(item);
    }
    System.out.println(queue);

    while(!queue.isEmpty()){
      for(int i=0; i<priorities.length; i++){
        if(queue.peek() == priorities[i]){
          if(location == i){
            answer++;
            return answer;
          }
          queue.poll();
          answer++;
        }
      }
    }
    return -1;
  }

}
