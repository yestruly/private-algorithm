package 그리디;

import java.util.*;
public class P1744 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minus = new PriorityQueue<>();
    int oneCnt = 0;
    int zeroCnt = 0;

    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      int data = sc.nextInt();
      if(data > 1){
        plus.add(data);
      } else if (data < 0) {
        minus.add(data);
      }else if(data == 1){
        oneCnt++;
      }else{
        zeroCnt++;
      }
    }

    int sum = 0;
    while(plus.size() > 1){
      int x = plus.remove();
      int y = plus.remove();
      sum += x*y;
    }
    while(minus.size() > 1){
      int x = minus.remove();
      int y = minus.remove();
      sum += x*y;
    }
    if(!plus.isEmpty()){
      sum+=plus.remove();
    }
    sum+=oneCnt;

    if(zeroCnt == 0 && !minus.isEmpty()){
      sum += minus.remove();
    }


    System.out.println(sum);

  }

}
