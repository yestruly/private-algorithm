package 그리디;

import java.util.Scanner;

public class P1541 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    String[] strs = s.split("-");

    int answer = 0;
    for (int i = 0; i < strs.length; i++) {
      int tmp = sum(strs[i]);
      if(i==0){
        answer+=tmp;
      }else {
        answer-=tmp;
      }
    }
    System.out.println(answer);
  }

  private static int sum(String str) {
    String[] arr = str.split("[+]");
    int answer = 0;
    for(String s : arr){
      answer += Integer.valueOf(s);
    }

    return answer;
  }
}
