package 그리디;

import java.util.*;
public class P2839 {

  public static void main(String[] args) {
    Scanner sc =new Scanner(System.in);
    int n = sc.nextInt();
    int count = 0;

    while(n >= 0){
      if(n%5== 0){
        count += n/5;
        System.out.println(count);
        return;
      }
      if(n<3){
        System.out.println("-1");
        return;
      }

      n-=3;
      count++;
    }
  }

}
