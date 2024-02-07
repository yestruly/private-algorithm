package 프로그래머스Lv1;

public class 크기가_작은_부분_문자열 {
  class Solution {
    public int solution(String t, String p) {
      if(p.length() > 18 || p.length() < 1 ||
      t.length() > 10000 || t.length() < p.length()){
        return 0;
      }
      int answer = 0;
      int length = p.length();

      for (int i = 0; i < t.length()-length+1; i++) {
        if(Long.valueOf(t.substring(i,i+length)) <= Long.valueOf(p)){
          answer++;
        }
      }
      return answer;
    }
  }

}
