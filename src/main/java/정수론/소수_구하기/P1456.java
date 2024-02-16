package 정수론.소수_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class P1456 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long a = sc.nextLong();
    long b = sc.nextLong();

    long[] arr = new long[(int)Math.pow(10, 7)+1];
    for (int i = 2; i < arr.length; i++) {
      arr[i]= i;
    }

    for (int i = 2; i <= Math.sqrt(arr.length); i++) {
      if (arr[i] == 0){
        continue;
      }
      for (int j = i+i; j < arr.length ; j = j+i) {
        arr[j] = 0;
      }
    }

    int cnt = 0;

    for (int i = 2; i < arr.length; i++) {
      if(arr[i] != 0){
        long tmp = arr[i];
        while ((double)arr[i] <= (double) b / tmp){
          if((double)arr[i] >= a/tmp){
            cnt++;
          }
          tmp = tmp*arr[i];
        }
      }
    }
    System.out.println(cnt);

  }

}
