package 프로그래머스Lv2;

import java.util.HashMap;

public class 의상 {
  public static int solution(String[][] clothes) {
    int answer = 1;
    HashMap<String,Integer> map = new HashMap<>();
    for(String[] s : clothes){
      String str = s[1];
      map.put(str, map.getOrDefault(str,0)+1);
    }
    for(String s : map.keySet()){
      answer*=(map.get(s)+1);
    }

    return answer-1;
  }

  public static void main(String[] args) {
    System.out.println(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
  }

}
