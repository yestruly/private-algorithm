package 이진탐색;

import java.util.Scanner;

public class P1300 {

  public static void main(String[] args) {
    Scanner sc =  new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int start = 1;
    int end = k;
    int answer = 0;

    while (start <= end){
      int middle = (start+end)/2;
      int cnt = 0;

      for (int i = 1; i <= n; i++) {
        cnt += Math.min(middle/i, n);
      }
      if(cnt < k){
        start = middle+1;
      }else{
        end = middle-1;
        answer = middle;
      }
    }

    System.out.println(answer);
  }

}
