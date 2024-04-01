package 프로그래머스Lv2;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {
  public String solution(String[] participant, String[] completion) {
    String answer = "";
    HashMap<String,Integer> map = new HashMap<>();

    for(String name : participant){
      map.put(name, map.getOrDefault(name, 0)+1);
    }

    for(String name : completion){
      map.put(name, map.get(name)-1);
    }

    for(Map.Entry<String, Integer> entry : map.entrySet()){
      if(entry.getValue() == 1){
        answer = entry.getKey();
      }
    }
    return answer;
  }
}
