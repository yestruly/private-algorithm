package 프로그래머스Lv2;

import java.util.Arrays;

public class 구명보트 {
  public int solution(int[] people, int limit) {
    int answer = 0;
    Arrays.sort(people);
    int idx = 0;
    for(int i=people.length-1 ; i>=idx ; i--){
      if(people[idx]+people[i] <= limit){
        answer++;
        idx++;
      }else{
        answer++;
      }
    }
    return answer;
  }

}
