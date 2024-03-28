package 스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P24511 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] queueStack = new int[n];
    Deque<Integer> deque = new ArrayDeque<>();
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      queueStack[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      if(queueStack[i] == 0){
        deque.add(num);
      }
    }

    StringBuffer sb = new StringBuffer();
    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
     int tmp = Integer.parseInt(st.nextToken());
     deque.offerFirst(tmp);
      System.out.print(deque.pollLast()+" ");
    }
  }

}
