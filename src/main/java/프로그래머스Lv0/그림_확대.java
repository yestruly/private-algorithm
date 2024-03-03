package 프로그래머스Lv0;

import java.util.Arrays;

public class 그림_확대 {
  public static String[] solution(String[] picture, int k) {
    String[] answer = new String[picture.length*k];
    int cnt = 0;
    int idx = 0;
    while (cnt < picture.length) {
      String str = "";
      String tmp = picture[cnt];
      for (int i = 0; i < tmp.length(); i++) {
        String s = tmp.substring(i,i+1);
        for (int j = 0; j < k; j++) {
          str += s;
        }
      }

      for (int i = idx; i <idx+k ; i++) {
        answer[i] = str;
      }
      cnt++;
      idx+=k;
    }
    return answer;

  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(new String[]{".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...", "....x...."},2)));
  }

}
