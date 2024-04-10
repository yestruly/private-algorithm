package 동적계획법;

import java.util.Scanner;

public class P4811 {

  public static void main(String[] args) {
    long[][] dp = new long[31][31];
    for(int i=1; i<=30; i++){
      dp[0][i] = 1;
    }

    for (int i = 1; i <=30; i++) {
      for (int j = 0; j < 30; j++) {
        if(j==0){
          dp[i][j] = dp[i-1][j+1];
        }else{
          dp[i][j] = dp[i][j-1] + dp[i-1][j+1];
        }
      }
    }

    Scanner sc= new Scanner(System.in);
    while(true){
      int n = sc.nextInt();
      if(n==0){
        break;
      }
      System.out.println(dp[n][0]);;
    }
  }

}
