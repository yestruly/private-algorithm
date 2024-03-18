package 동적계획법;

import java.util.Scanner;

public class P2193 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long d[][] = new long[n+1][2];
    d[1][0]  = 0;
    d[1][1]  = 1;

    for (int i = 2; i <=n ; i++) {
      d[i][0] = d[i-1][0]+d[i-1][1];
      d[i][1] = d[i-1][0];
    }

    System.out.println(d[n][1]+d[n][0]);
  }

}
