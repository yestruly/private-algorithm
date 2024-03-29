package 재귀;

import java.util.Scanner;

public class P11729 {
  static StringBuilder sb = new StringBuilder();
  static int move;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int count =sc.nextInt();
    hanoi(count, 1, 2, 3);
    System.out.println(move);
    System.out.println(sb);
  }

  private static void hanoi(int count, int start, int middle, int end) {
    if(count == 0){
      return;
    }
    hanoi(count-1, start, end, middle);
    move++;
    sb.append(start+" "+end+"\n");
    hanoi(count-1, middle, start, end);
  }

}
