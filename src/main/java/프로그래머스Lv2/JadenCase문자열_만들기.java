package 프로그래머스Lv2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class JadenCase문자열_만들기 {
  public static String solution(String s) {
    String answer = "";
    String[] arr = s.toLowerCase().split("");

    boolean isGap = true;
    for(String str: arr){
      answer += isGap ? str.toUpperCase() : str;
      isGap = str.equals(" ")?true:false;
    }
    return answer;
  }

  public static void main(String[] args) {
    String s = solution("for the what 1what  ");
    System.out.println("  for the what 1what  ".length()+" "+s.length());
    System.out.println(s);
    System.out.println("for the what 1what  ");
  }

}
