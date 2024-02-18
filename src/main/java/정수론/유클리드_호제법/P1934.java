package 정수론.유클리드_호제법;

import java.util.Scanner;

public class P1934 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      System.out.println(a*b/gcd(a,b));
    }
  }

  private static int gcd(int a, int b) {
    if(b == 0){
      return a;
    }
    return gcd(b, a%b);
  }

}
