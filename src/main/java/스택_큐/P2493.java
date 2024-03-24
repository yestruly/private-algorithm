package 스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P2493 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Stack<int[]> stack = new Stack<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <=n ; i++) {
      int num = Integer.parseInt(st.nextToken());
      while (!stack.isEmpty()){
        int tmp[] = stack.peek();
        int data = tmp[0];
        int idx = tmp[1];

        if(data > num){
          System.out.print(idx+" ");
          break;
        }else {
          stack.pop();
        }

      }

      if(stack.isEmpty()){
        System.out.print("0 ");
      }
      stack.push(new int[]{num, i});
    }
  }

}
