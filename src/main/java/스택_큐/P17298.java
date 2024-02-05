package 스택_큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class P17298 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int[] answer = new int[n];

    String[] str = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(str[i]);
    }

    Stack<Integer> stack = new Stack<>();
    stack.push(0);

    for (int i = 1; i < n; i++) {
      while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
        answer[stack.pop()] = arr[i];
      }
      stack.push(i);
    }

    while (!stack.isEmpty()){
      answer[stack.pop()] = -1;
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < n; i++) {
      bw.write(answer[i]+" ");
    }
    bw.write("\n");
    bw.flush();

  }

}
