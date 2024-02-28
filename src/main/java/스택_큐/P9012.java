package 스택_큐;

import java.util.Scanner;
import java.util.Stack;

public class P9012 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    for(int i=0; i<n; i++){
      String str = sc.next();
      if(isVps(str)){
        System.out.println("YES");
      }else{
        System.out.println("NO");
      }
    }
  }

  public static boolean isVps(String str){
    Stack<String> stack = new Stack<>();
    for(String s : str.split("")){
      if(s.equals("(")){
        stack.push(s);
      }else{
        if(stack.isEmpty()){
          return false;
        }
        stack.pop();
      }
    }

    if(stack.isEmpty()){
      return true;
    }
    return false;
  }

}
