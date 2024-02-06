package 스택_큐;

import java.util.*;

public class 기능개발 {
  public int[] solution(int[] progresses, int[] speeds) {
    if(progresses.length > 100 || speeds.length > 100||progresses.length !=speeds.length){
      return null;
    }

    Queue<Double> queue = new LinkedList<>();
    Queue<Integer> answerQueue = new LinkedList<>();

    for (int i = 0; i < progresses.length; i++) {
      queue.add(Math.ceil((100.0 - progresses[i]) / speeds[i]));
    }
    System.out.println(queue);

    while (!queue.isEmpty()){
      int cnt = 1;
      double tmp = queue.remove();
      while (!queue.isEmpty() && tmp >= queue.peek()){
        queue.remove();
        cnt++;
      }
      answerQueue.add(cnt);
    }

    int[] answer = new int[answerQueue.size()];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = answerQueue.remove();
    }

    return answer!=null ? answer : null;
  }


}
