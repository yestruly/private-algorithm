package 스택_큐;

import java.util.Scanner;
import java.util.Stack;

public class P10773 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int k = sc.nextInt();
    Stack<Integer> stack = new Stack<>();
    while (k > 0){
      int n = sc.nextInt();
      if(n==0){
        stack.pop();
      }else{
        stack.push(n);
      }
      k--;
    }

    long sum = 0;
    if (stack.isEmpty()){
      System.out.println("0");
      return;
    }

    while (!stack.isEmpty()){
      sum+=stack.pop();
    }

    System.out.println(sum);
  }

}
