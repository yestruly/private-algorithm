package 트리.트라이;

import java.util.Scanner;

public class P14425 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    Node root = new Node();
    while (n>0){
      String str = sc.next();
      Node tmp = root;
      for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if(tmp.next[c-'a'] == null){
          tmp.next[c-'a'] = new Node();
        }
        tmp = tmp.next[c-'a'];
        if(i==str.length()-1){
          tmp.isEnd = true;
        }
      }
      n--;
    }

    int count = 0;

    while (m>0){
      String str = sc.next();
      Node tmp = root;
      for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if(tmp.next[c-'a'] == null){
          break;
        }
        tmp = tmp.next[c-'a'];
        if(i==str.length()-1 && tmp.isEnd){
          count++;
        }
      }
    }

    System.out.println(count);
  }
  private static class Node{
    Node[] next = new Node[26];
    boolean isEnd;
  }
}
