package 프로그래머스Lv2;

import java.util.Arrays;

public class 전화번호_목록 {
  public static boolean solution(String[] phone_book) {
    boolean answer = true;
    Arrays.sort(phone_book);
    for (int i = 0; i < phone_book.length-1; i++) {
      if(phone_book[i+1].startsWith(phone_book[i])){
        answer = false;
        break;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(new String[]{"12","123","1235","567","88"}));
  }
}
