package 기하;

import java.util.Scanner;

public class P2166{

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long x[] = new long[n+1];
    long y[] = new long[n+1];

    for (int i = 0; i < n; i++) {
      x[i] = sc.nextLong();
      y[i] = sc.nextLong();
    }
    x[n] = x[0];
    y[n] = y[0];

    double result = 0;
    for (int i = 0; i < n; i++) {
      result += (x[i]*y[i+1] - x[i+1]*y[i]);
    }

    System.out.printf("%.1f",Math.abs(result)/2.0);
  }

}
