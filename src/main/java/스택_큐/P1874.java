package 스택_큐;

import java.util.Scanner;
import java.util.Stack;

public class P1874 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int [N];
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    Stack<Integer> stack = new Stack<>();
    StringBuffer sb = new StringBuffer();
    int num = 1;
    boolean result = true;

    for (int i = 0; i < N; i++) {
      int tmp = arr[i];
      if(tmp >= num){
        while (tmp >= num){
          stack.push(num++);
          sb.append("+\n");
        }
        stack.pop();
        sb.append("-\n");
      }else {
        int pop = stack.pop();
        if(pop > tmp){
          System.out.println("No");
          result=false;
          break;
        }else {
          sb.append("-\n");
        }
      }
    }
    if(result){
      System.out.println(sb.toString());
    }
  }

}
