package 투포인터;

import java.util.Scanner;

public class P2018 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    int p1 = 1;
    int p2 = 1;
    int cnt = 1;
    int sum = 1;

    while(p2 != N){
      if(sum == N){
        cnt++;
        p2++;
        sum+=p2;
      }else if(sum > N){
        sum-=p1;
        p1++;
      }else{
        sum+=p2;
        p2++;
      }
    }

    System.out.println(cnt);
  }

}
