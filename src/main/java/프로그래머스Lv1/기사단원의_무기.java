package 프로그래머스Lv1;

public class 기사단원의_무기 {
  public int solution(int number, int limit, int power) {
    int answer = 0;

    for (int i = 1; i <=number ; i++) {
      int cnt = measure(i);
      if(cnt > limit){
        answer+=power;
      }else{
        answer+=cnt;
      }
    }

    return answer;
  }

  private int measure(int i) {
    int cnt = 0;
    for (int j = 1; j*j <= i ; j++) {
      if(j*j == i){
        cnt++;
      } else if (i%j == 0) {
        cnt+=2;
      }
    }
    return cnt;
  }

}
