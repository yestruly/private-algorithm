package 트리.트리;

import java.util.ArrayList;
import java.util.Scanner;

public class P11725 {
  static int n;
  static boolean visited[];
  static int answer[];
  static ArrayList<Integer>[] list;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    visited = new boolean[n+1];
    answer = new int[n+1];
    list = new ArrayList[n+1];

    for (int i = 1; i <=n ; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 1; i < n; i++) {
      int s = sc.nextInt();
      int e = sc.nextInt();
      list[s].add(e);
      list[e].add(s);
    }

    dfs(1);

    for(int i=2; i<=n;i++){
      System.out.println(answer[i]);
    }
  }

  private static void dfs(int i) {
    visited[i] = true;
    for(int item : list[i]){
      if(!visited[item] ){
          answer[item] = i;
          dfs(item);
      }
    }
  }
}
