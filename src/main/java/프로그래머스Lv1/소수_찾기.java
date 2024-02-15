package 프로그래머스Lv1;

public class 소수_찾기 {
  public int solution(int n) {
    int answer = 0;
    for (int i = 1; i <=n ; i++) {
      if(prime(i)){
        answer++;
      }
    }
    return answer;
  }

  private boolean prime(int num) {

    for (int i = 2; i <num ; i++) {
      if(num % i==0){
        return false;
      }
    }
    return true;
  }

}
