package 배열_리스트;

import java.util.Scanner;

public class P1546 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n= sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    int max = 0;
    double result = 0;

    for(int item : arr){
      result+=item;
      if(item > max){
        max = item;
      }
    }

    System.out.println(result / max * 100 / n);
  }

}
