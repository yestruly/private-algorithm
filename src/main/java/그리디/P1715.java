package 그리디;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1715 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      pq.add(sc.nextInt());
    }

    int result = 0;
    while (pq.size() !=1){
      int x = pq.remove();
      int y = pq.remove();
      result += (x+y);
      pq.add(x+y);
    }

    System.out.println(result);
  }

}
