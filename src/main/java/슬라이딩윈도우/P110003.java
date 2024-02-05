package 슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P110003 {
  //이해 필요

  public static final Scanner sc = new Scanner(System.in);
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(bf.readLine());

    Deque<Node> deque = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      int now = Integer.parseInt(st.nextToken());

      while(!deque.isEmpty() && deque.getLast().data > now){
        deque.removeLast();
      }

      bw.write(deque.getFirst().data+ " ");
    }
    bw.flush();
    bw.close();
  }

  static class Node{
    private int data;
    private int idx;

    Node(int data, int idx){
      this.data = data;
      this.idx = idx;
    }
  }
}
