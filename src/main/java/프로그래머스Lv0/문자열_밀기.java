package 프로그래머스Lv0;

public class 문자열_밀기 {

  public int solution(String A, String B) {
    String tmp = A;

    for (int i = 0; i < A.length(); i++) {
      if (tmp.equals(B)) {
        return i;
      }

      tmp = tmp.substring(tmp.length() - 1, tmp.length()) + tmp.substring(0, tmp.length() - 1);
    }
    return -1;
  }

}
