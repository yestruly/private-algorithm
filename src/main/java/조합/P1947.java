package 조합;

import java.util.Scanner;

public class P1947 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long[] arr = new long[1000001];
    long mod = 1000000000;
    arr[1] = 0;
    arr[2] = 1;
    for (int i = 3; i <=n ; i++) {
      arr[i] = (i-1)*(arr[i-1]+arr[i-2]) % mod;
    }

    System.out.println(arr[n]);
  }

}
