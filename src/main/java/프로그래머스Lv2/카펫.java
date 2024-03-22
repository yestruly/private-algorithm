package 프로그래머스Lv2;

public class 카펫 {
  public int[] solution(int brown, int yellow) {
    int[] answer = new int[2];
    for (int i = 3; i <brown+yellow ; i++) {
      int height = i;
      int width = (brown+yellow)/height;
      if(width<3){
        continue;
      }

      if(height<=width){
        if ((height+width-2)*2 == brown && (height-2)*(width-2) == yellow){
          answer[1] = height;
          answer[0]= width;
        }
      }
    }
    return answer;
  }
}
