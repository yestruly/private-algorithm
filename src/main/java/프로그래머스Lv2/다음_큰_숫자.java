package 프로그래머스Lv2;

public class 다음_큰_숫자 {
  public int solution(int n) {
    int answer = n+1;
    int oneCnt = Integer.bitCount(n);

    while (true){
      int binaryCnt = Integer.bitCount(answer);
      if(binaryCnt == oneCnt){
        break;
      }

      answer++;
    }
    return answer;
  }
}
