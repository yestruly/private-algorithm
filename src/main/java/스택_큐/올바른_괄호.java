package 스택_큐;

import java.util.LinkedList;
import java.util.Queue;

public class 올바른_괄호 {
  boolean solution(String s) {
    boolean answer = true;
    if(s.length() > 100000 ){
      return false;
    }

    Queue<Character> queue = new LinkedList<>();
    for(int i=0; i<s.length(); i++){
      if(s.charAt(i) == '('){
        queue.add('(');
      }else{
        if(queue.isEmpty()){
          return false;
        }else{
          queue.remove();
        }
      }
    }

    return queue.isEmpty() ? true:false;
  }
}
