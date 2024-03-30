package 프로그래머스Lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 귤_고르기 {
  public static int solution(int k, int[] tangerine) {
    int answer = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int item : tangerine){
      map.put(item, map.getOrDefault(item,0)+1);
    }

    List<Integer>list = new ArrayList<>(map.keySet());
    Collections.sort(list,
        (v1, v2) -> (map.get(v2).compareTo(map.get(v1))));

    for(int item : list){
      int val =k-=map.get(item);
      answer++;
      if(val<=0){
        break;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(6, new int[]{1,3,2,5,4,5,2,3}));
  }

}
