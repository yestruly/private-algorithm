package 프로그래머스Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class 문자열_내_마음대로_정렬하기 {
  public static String[] solution(String[] strings, int n) {
    String[] answer = new String[strings.length];
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < strings.length; i++) {
      map.put(strings[i].substring(n,n+1),i);
    }
    System.out.println(map);

    ArrayList<String> keySet = new ArrayList<>(map.keySet());
    Collections.sort(keySet);
    int idx = 0;
    for(String key : keySet){
      answer[idx] = strings[map.get(key)];
      idx++;
    }
    return answer;
  }

  public static void main(String[] args) {

    System.out.println(Arrays.toString(solution(new String[]{"abce", "abcd", "cdx"},2)));
  }

}
