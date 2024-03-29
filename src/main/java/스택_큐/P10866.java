package 스택_큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P10866 {

  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n =Integer.parseInt(br.readLine());
    Deque<Integer> deque = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      if (str.equals("push_front")) {
        int num = Integer.parseInt(br.readLine());
        deque.addFirst(num);

      }
      if (str.equals("push_back")) {
        int num =Integer.parseInt(br.readLine());
        deque.addLast(num);

      }
      if (str.equals("pop_front")) {
        if (deque.isEmpty()) {
          bw.append(-1+"\n");
        } else {
          bw.append(deque.removeFirst()+"\n");
        }
      }
      if (str.equals("pop_back")) {
        if (deque.isEmpty()) {
          bw.append(-1+"\n");
        } else {
          bw.append(deque.removeLast()+"\n");
        }
      }
      if (str.equals("size")) {
        bw.append(deque.size()+"\n");
      }
      if (str.equals("empty")) {
        if (deque.isEmpty()) {
          bw.append(1+"\n");
        } else {
          bw.append(0+"\n");
        }

      }
      if (str.equals("front")) {
        if (deque.isEmpty()) {
          bw.append(-1+"\n");
        } else {
          bw.append(deque.getFirst()+"\n");
        }
      }
      if (str.equals("back")) {
        if (deque.isEmpty()) {
          bw.append(-1+"\n");
        } else {
          bw.append(deque.getLast()+"\n");
        }
      }
    }
    br.close();
    bw.flush();
    bw.close();
  }

}
