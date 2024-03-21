package 동적계획법;

import java.util.Scanner;

public class P1328 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int l = sc.nextInt();
    int r = sc.nextInt();
    long arr[][][] = new long[101][101][101];
    arr[1][1][1] = 1;
    for (int i = 2; i <=n ; i++) {
      for (int j = 1; j <=l ; j++) {
        for (int k = 1; k <=r ; k++) {
          arr[i][j][k] = (arr[i-1][j-1][k] + arr[i-1][j][k-1] + arr[i-1][j][k]*(i-2)) % 1000000007;
        }
      }
    }

    System.out.println(arr[n][l][r]);
  }

}
