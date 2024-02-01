package 배열_리스트;

import java.util.Scanner;

public class P11720 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String nums = sc.next();

    int answer = 0;
    for(int i=0; i<n; i++){
      answer += nums.charAt(i)-'0';
    }

    System.out.println(answer);
  }

}
