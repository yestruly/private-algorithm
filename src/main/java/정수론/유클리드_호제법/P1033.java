package 정수론.유클리드_호제법;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class P1033 {

  static ArrayList<Node>[] list;
  static long lcm;
  static long arr[];
  static boolean visited[];

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = sc.nextInt();
    list = new ArrayList[n];
    arr = new long[n];
    visited = new boolean[n];
    lcm = 1;
    for (int i = 0; i < n; i++) {
      list[i] = new ArrayList<Node>();
    }

    for (int i = 0; i < n - 1; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int p = sc.nextInt();
      int q = sc.nextInt();

      list[a].add(new Node(b,p,q));
      list[b].add(new Node(a,p,q));
      lcm *= ((p*q)/gcd(p,q));
    }

    arr[0] = lcm;
    dfs(0);
    long mgcd = arr[0];
    for (int i = 1; i < n; i++) {
      mgcd =gcd(mgcd, arr[i]);
    }

    for (int i = 0; i < n; i++) {
      System.out.println(arr[i] / mgcd);
    }

  }

  private static void dfs(int node) {
    visited[node] = true;
    for(Node item : list[node]){
      int next = item.getB();
      if(!visited[next]){
        arr[next] = arr[node] * item.getQ()/ item.getP();
        dfs(next);
      }

    }

  }

  private static long gcd(long p, long q) {
    if(q==0){
      return p;
    }
    return gcd(q, p%q);
  }
}

class Node {

  int b;
  int p;
  int q;

  public Node(int b, int p, int q) {
    this.b = b;
    this.p = p;
    this.q = q;
  }

  public int getB() {
    return b;
  }

  public int getP() {
    return p;
  }

  public int getQ() {
    return q;
  }
}
