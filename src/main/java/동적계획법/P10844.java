package 동적계획법;

import java.util.Scanner;

public class P10844{

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int mod = 1000000000;
    long[][] arr = new long[n+1][11];
    for (int i = 1; i <=9 ; i++) {
      arr[1][i] = 1;
    }

    for (int i = 2; i <=n ; i++) {
      arr[i][0] = arr[i-1][1];
      arr[i][9] = arr[i-1][8];

      for (int j = 1; j <= 8; j++) {
        arr[i][j] = (arr[i-1][j-1]+arr[i-1][j+1])%mod;
      }
    }

    long sum = 0;
    for (int i = 0; i <=9 ; i++) {
      sum+=arr[n][i];
    }
    System.out.println(sum);
  }

}
