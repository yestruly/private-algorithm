package 프로그래머스Lv0;

import java.util.Scanner;

public class 저축_PPCE기출문제 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int start = sc.nextInt();
    int before = sc.nextInt();
    int after = sc.nextInt();

    int money = start;
    int month = 1;
    while (money < 70) {
      money +=
          before
      ;
      month++;
    }
    while (
        money
            < 100) {

      money+=after
      ;
      month++;
    }

    System.out.println(month);
  }

}
