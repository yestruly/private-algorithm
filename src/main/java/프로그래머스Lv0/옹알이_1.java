package 프로그래머스Lv0;

public class 옹알이_1 {

  public int solution(String[] babbling) {
    int answer = 0;
    String[] sounds = {"aya", "ye", "woo", "ma"};

    for (int i = 0; i < babbling.length; i++) {
      for (String sound : sounds) {
        if (babbling[i].contains(sound)) {
          System.out.println(babbling[i]);
          babbling[i] = babbling[i].replace(sound, "*");
        }
      }
    }

    for (String bab : babbling) {
      boolean isTrue = true;
      for (int i = 0; i < bab.length(); i++) {
        if (bab.charAt(i) != '*') {
          isTrue = false;
          break;
        }
      }
      if (isTrue) {
        answer++;
      }
    }

    return answer;
  }
}
