package 프로그래머스Lv3;

import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {

  public static int[] solution(String[] operations) {
    int[] answer = new int[2];
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    PriorityQueue<Integer> reversePq = new PriorityQueue<>(Collections.reverseOrder());
    for (String str : operations) {
      String[] tmp = str.split(" ");
      if (tmp[0].contains("I")) {
        pq.add(Integer.parseInt(tmp[1]));
        reversePq.add(Integer.parseInt(tmp[1]));
      }
      int min = 0;
      int max = 0;
      if (tmp[0].contains("D")) {
        if (!pq.isEmpty()) {
          if (Integer.parseInt(tmp[1]) == 1) {
            max = reversePq.poll();
            pq.remove(max);
          } else {
            min = pq.poll();
            reversePq.remove(min);
          }
        }
      }
    }

    if (!pq.isEmpty()) {
      answer[0] = reversePq.poll();
      answer[1] = pq.poll();
    } else {
      answer = new int[]{0, 0};
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(
        new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}));
  }

}
