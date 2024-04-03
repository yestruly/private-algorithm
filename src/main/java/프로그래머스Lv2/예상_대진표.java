package 프로그래머스Lv2;

public class 예상_대진표 {
  public static int solution(int n, int a, int b)
  {
    int answer = 0;

    while (Math.abs(a-b) >= 1){
      answer++;
      if(a%2==0){
        a=a/2;
      }else if(a%2!=0){
        a=(a+1)/2;
      }

      if (b%2==0){
        b=b/2;
      }else if(b%2!=0){
        b = (b+1)/2;
      }

    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(8,4,7));
  }
}
