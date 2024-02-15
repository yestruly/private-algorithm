package 프로그래머스Lv1;

import java.util.HashMap;
import java.util.HashSet;

public class 폰켓몬 {
  public int solution(int[] nums) {
    int answer = 0;
    HashSet<Integer> set =new HashSet<>();
    for(int item : nums){
      set.add(item);
    }

    if(set.size() >= nums.length/2){
      return nums.length/2;
    }else {
     return set.size();
    }

  }

}
