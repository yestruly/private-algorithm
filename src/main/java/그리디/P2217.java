package 그리디;

import java.util.Arrays;
import java.util.Scanner;

public class P2217 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    int weight = 0;

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    Arrays.sort(arr);
    for (int i = 0; i < n; i++) {
      weight = Math.max(arr[i]*(n-i), weight);
    }

    System.out.println(weight);
  }

}
