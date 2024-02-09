package 프로그래머스Lv1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 두_개_뽑아서_더하기 {
  public static int[] solution(int[] numbers) {
    int[] answer = {};
    HashSet<Integer> set = new HashSet<>();

    for (int i = 0; i < numbers.length-1; i++) {
      for (int j = 1; j < numbers.length; j++) {
        if(i==j){
          continue;
        }
        set.add(numbers[i]+numbers[j]);
      }
    }
    answer = new int[set.size()];
    int idx = 0;
    for(int num : set){
      answer[idx++] = num;
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(new int[]{5,0,2,7}));
  }

}
