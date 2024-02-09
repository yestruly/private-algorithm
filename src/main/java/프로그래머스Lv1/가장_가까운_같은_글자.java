package 프로그래머스Lv1;

import java.util.HashMap;

public class 가장_가까운_같은_글자 {
  public int[] solution(String s) {
    int[] answer = new int[s.length()];
    HashMap<String, Integer> map = new HashMap<>();

    for(int i=0; i<s.length(); i++){
      if(!map.containsKey(s.substring(i,i+1))){
        answer[i] = -1;
        map.put(s.substring(i,i+1), i);
      }else{
        answer[i] = i-map.get(s.substring(i,i+1));
        map.put(s.substring(i,i+1),i);
      }
    }
    return answer;
  }

}
