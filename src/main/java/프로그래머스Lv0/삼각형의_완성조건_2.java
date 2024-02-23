package 프로그래머스Lv0;

public class 삼각형의_완성조건_2 {
  public int solution(int[] sides) {
    int answer = 0;
    int max = sides[0] > sides[1] ? sides[0] : sides[1];
    int min = sides[0] < sides[1] ? sides[0] : sides[1];
    int num = 1;
    int sum = 0;

    while (num <= max){
      sum = num+min;
      if(sum > max){
        answer++;
      }
      num++;
    }

    sum = max+min;
    while (sum > num){
      num++;
      answer++;
    }


    return answer;
  }

}
