package 프로그래머스Lv2;

import java.util.Arrays;

public class 멀리_뛰기 {
  public static long solution(int n) {
    long answer = 0;
    long dp [] = new long[n+1];
    if(n==1){
      return 1;
    }else if(n==2){
      return 2;
    }

    dp[1] = 1;
    dp[2] = 2;
    for(int i=3; i<=n; i++){
      dp[i] = (dp[i-1]+dp[i-2])%1234567;
    }
    return dp[n];

  }

  public static void main(String[] args) {
    System.out.println(solution(4));
  }

}
