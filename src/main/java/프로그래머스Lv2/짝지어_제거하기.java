package 프로그래머스Lv2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 짝지어_제거하기 {
  public int solution(String s)
  {
    int answer = -1;
    Stack<Character> stack = new Stack<>();
    char[] arr =s.toCharArray();

    for(char c : arr){
      if(stack.isEmpty() || stack.peek()!=c){
        stack.push(c);
      }else{
        stack.pop();
      }
    }

    answer = stack.isEmpty() ? 1 : 0;
    return answer;
  }
}
