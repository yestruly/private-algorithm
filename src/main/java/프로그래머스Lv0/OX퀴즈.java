package 프로그래머스Lv0;

import java.util.Arrays;

public class OX퀴즈 {

  public String[] solution(String[] quiz) {
    String[] answer = new String[quiz.length];
    for (int i = 0; i < quiz.length; i++) {
      String[] tmp = quiz[i].split(" = ");
      boolean isMinus = false;
      int data = 0;

      String cur[] = tmp[0].split(" ");
      for (int k = 0; k < cur.length; k++) {
        if (cur[k].equals("+")) {
          continue;
        } else if (cur[k].equals("-")) {
          isMinus = true;
        } else {
          if(isMinus){
            data -= Integer.valueOf(cur[k]);
          }else{
            data += Integer.valueOf(cur[k]);
          }
        }

      }
      if (data == Integer.valueOf(tmp[1].trim())) {
        answer[i] = "O";
      } else {
        answer[i] = "X";
      }
    }
    return answer;
  }
}
