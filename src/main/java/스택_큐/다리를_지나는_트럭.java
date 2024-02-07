package 스택_큐;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;
    int sumWeight = 0;
    Queue<Integer> queue = new LinkedList<>();

    for(int item : truck_weights){
      while (true){
        if(queue.isEmpty()){
          queue.add(item);
          sumWeight+=item;
          answer++;
          break;
        }else if(queue.size() == bridge_length){
          sumWeight -= queue.remove();
        }else {
          if(sumWeight + item <= weight){
            sumWeight+=item;
            queue.add(item);
            answer++;
            break;
          }else {
            queue.add(0);
            answer++;
          }
        }
      }
    }
    return answer;
  }


}
