package 정수론.소수_구하기;

import java.util.Scanner;

public class P1016 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long min = sc.nextLong();
    long max = sc.nextLong();
    boolean[] arr= new boolean[(int) (max-min+1)];

    for (int i = 2; i <=max ; i = i*i) {
      long tmp = i*i;
      long startIdx = min/tmp;
      if(min % tmp!=0){
        startIdx++;
      }
      for (long j = startIdx; j*tmp <= max ; j++) {
        arr[(int)((j*tmp)-min)] = true;
      }
    }

    int cnt = 0;
    for (int i = 0; i < max-min; i++) {
      if(!arr[i]){
        cnt++;
      }
    }
    System.out.println(cnt);
  }

}
