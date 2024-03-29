package 프로그래머스Lv2;

public class N개의_최소공배수 {
  public int solution(int[] arr) {
    int answer =arr[0];
    for (int i = 1; i < arr.length; i++) {
      answer = answer*arr[i]/gcd(arr[i], answer);
    }
    return answer;
  }

  public int gcd(int a, int b ){
    if(b==0){
      return a;
    }
    return gcd(b, a%b);
  }
}
