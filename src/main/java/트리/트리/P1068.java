package 트리.트리;

import java.util.ArrayList;
import java.util.Scanner;

public class P1068 {
  static int n;
  static int m;
  static boolean visited[];
  static int answer = 0;
  static ArrayList<Integer> tree[];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    visited = new boolean[n];
    tree = new ArrayList[n];
    for (int i = 0; i <n; i++) {
      tree[i] = new ArrayList<>();
    }

    int root = 0;
    for (int i = 0; i <n ; i++) {
      int n = sc.nextInt();
      if(n!=-1){
        tree[i].add(n);
        tree[n].add(i);
      }else{
        root = i;
      }
    }

    m = sc.nextInt();
    if(m == root){
      System.out.println(0);
    }else{
      dfs(root);
      System.out.println(answer);
    }
  }

  public static void dfs(int n){
    visited[n] = true;
    int child = 0;

    for(int item : tree[n]){
      if(!visited[item] && item != m){
        child++;
        dfs(item);
      }
    }
    if(child==0){
      answer++;
    }
  }

}
