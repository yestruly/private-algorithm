package 프로그래머스Lv0;

public class 저주의_숫자3 {

  public int solution(int n) {
    int answer = 0;
    for (int i = 0; i < n; i++) {
      answer++;
      while (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
        answer++;
      }
    }
    return answer;
  }

}
