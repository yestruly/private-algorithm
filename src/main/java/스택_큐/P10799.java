package 스택_큐;

import java.util.Scanner;
import java.util.Stack;

public class P10799 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] sticks = sc.next().split("");
    Stack<Character> stack = new Stack<>();
    int count = 0;

    for (int i = 0; i < sticks.length; i++) {
      if(sticks[i].equals("(")){
        stack.push('(');
      }else{
        if(sticks[i-1].equals("(")){
          stack.pop();
          count+=stack.size();
        }else{
          count++;
          stack.pop();
        }
      }
    }
    System.out.println(count);
  }

}
