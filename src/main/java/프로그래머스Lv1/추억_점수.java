package 프로그래머스Lv1;

import java.util.HashMap;

public class 추억_점수 {
  public int[] solution(String[] name, int[] yearning, String[][] photo) {
    int[] answer = new int[photo.length];
    HashMap<String, Integer> map = new HashMap<>();

    for(int i=0; i<name.length; i++){
      map.put(name[i],yearning[i]);
    }
    System.out.println(map);

    int idx = 0;
    for(String[] strings : photo){
      int result = 0;
      for(String str : strings){
        if(map.containsKey(str)){
          result += map.get(str);
        }else {
          continue;
        }
      }
      answer[idx++] = result;
    }
    return answer;
  }

}
