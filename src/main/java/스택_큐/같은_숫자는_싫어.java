package 스택_큐;

import java.util.*;
import java.util.stream.IntStream;

public class 같은_숫자는_싫어 {
  public int[] solution(int []arr) {
    int[] answer = {};
    Stack<Integer> stack = new Stack<>();
    stack.push(arr[0]);

    for(int i=0; i<arr.length; i++){
      if(stack.peek() != arr[i]){
        stack.push(arr[i]);
      }
    }

    answer = new int[stack.size()];
    for (int i = answer.length-1; i >=0 ; i--) {
      answer[i] = stack.pop();
    }

    return answer;
  }

}
