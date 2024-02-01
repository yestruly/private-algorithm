package 구간합;

import java.util.Scanner;

public class P10986 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    long answer = 0;
    long[] sum = new long[N];
    long[] index = new long[M];
    sum[0] = sc.nextInt();

    for (int i = 1; i < N; i++) {
      sum[i] = sum[i-1] + sc.nextInt();
    }

    for (int i = 0; i < N; i++) {
      int reminder = (int)sum[i] % M;
      if(reminder == 0){
        answer++;
      }
      index[reminder]++;
    }

    for (int i = 0; i < M; i++) {
      if(index[i]>0){
        answer  += (index[i] * (index[i]-1) / 2);
      }
    }

    System.out.println(answer);
  }

}
