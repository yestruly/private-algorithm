package 프로그래머스Lv2;

import java.util.Arrays;

public class 피보나치_수 {
//  public int solution(int n) {
//    if(n<2 || n >100000){
//      return 0;
//    }
//    return fib(n) % 1234567;
//  }
//
//  public int fib(int n){
//    if(n <= 2){
//      return 1;
//    }
//    return  (fib(n-1) + fib(n-2) ) % 1234567;
//  }

  public int solution(int n) {
    int fib[] = new int[100001];
    fib[0] = 0;
    fib[1] = 1;

    for (int i = 2; i <=n ; i++) {
      fib[i] = (fib[i-1]+fib[i-2])%1234567;
    }
    return fib[n];
  }
}
