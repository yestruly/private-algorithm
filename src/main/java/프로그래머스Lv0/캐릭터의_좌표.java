package 프로그래머스Lv0;

import java.util.Arrays;

public class 캐릭터의_좌표 {
  public static int[] solution(String[] keyinput, int[] board) {
    int[] answer = new int[2];
    int maxX = board[0]/2;
    int maxY = board[1]/2;

    for(String key : keyinput) {
      if (key.equals("up")) {
        answer[1] +=1;
      } else if (key.equals("down")) {
        answer[1] -= 1;
      } else if (key.equals("left")) {
        answer[0] -=1;
      } else {
        answer[0] +=1;
      }

      if (Math.abs(answer[0]) > maxX){
        answer[0] = answer[0]>0?maxX:maxX*-1;
      }
      if (Math.abs(answer[1]) > maxY){
        answer[1] = answer[1]>0?maxY:maxY*-1;
      }
    }


    return answer;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(new String[]{"up", "up", "up", "down"}, new int[]{3,3})));
  }

}
