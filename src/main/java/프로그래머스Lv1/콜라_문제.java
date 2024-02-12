package 프로그래머스Lv1;

public class 콜라_문제 {
  public static int solution(int a, int b, int n) {
    int answer = 0;

    while (n >= a){
      answer +=  n/a*b;
      n =  n/a*b + n%a;

      System.out.println(n+" "+answer);
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(2,1, 20));
  }

}
