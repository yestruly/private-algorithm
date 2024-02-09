package 프로그래머스Lv1;

public class 푸드_파이트_대회 {
  public String solution(int[] food) {
    String answer = "";
    for(int i=1; i<food.length; i++){
      if(food[i]%2 == 1){
        food[i] -= 1;
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i=1; i<food.length; i++){
      for (int j = 0; j < food[i]/2; j++) {
        sb.append(i);
      }
    }

    answer = sb + "0"+sb.reverse();

    return answer;
  }

}
