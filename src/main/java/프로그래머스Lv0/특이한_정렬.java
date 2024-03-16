package 프로그래머스Lv0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 특이한_정렬 {
  public int[] solution(int[] numlist, int n) {
    int[] answer = {};
    ArrayList<Integer> list = new ArrayList<>();
    for(int item : numlist){
      list.add(item);
    }

    Collections.sort(list, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
       if(Math.abs(n-o1)!=Math.abs(n-o2)){
         return Math.abs(n-o1) - Math.abs(n-o2);
       }
       return o2-o1;
      }
    });

    answer = list.stream().mapToInt(Integer::intValue).toArray();
    return answer;
  }

}
