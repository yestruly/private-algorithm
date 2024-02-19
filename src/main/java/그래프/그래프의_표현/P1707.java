package 그래프.그래프의_표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P1707 {
  static ArrayList<Integer> list[];
  static boolean visited[];
  static int check[];
  static boolean isGraph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      String[] s= br.readLine().split(" ");
      int v = Integer.parseInt(s[0]);
      int e = Integer.parseInt(s[1]);
      list = new ArrayList[v+1];
      visited = new boolean[v+1];
      check = new int[v+1];
      isGraph = true;
      for (int j = 1; j <=v; j++) {
        list[j]=new ArrayList<Integer>();
      }
      for (int j = 0; j < e; j++) {
        s = br.readLine().split(" ");
        int num1 = Integer.parseInt(s[0]);
        int num2 = Integer.parseInt(s[1]);
        list[num1].add(num2);
        list[num2].add(num1);
      }

      for (int j = 1; j <= v; j++) {
        if(isGraph){
          dfs(i);
        }else {
          break;
        }
      }
      if(isGraph){
        System.out.println("YES");
      }else {
        System.out.println("NO");
      }
    }
  }

  private static void dfs(int i) {
    visited[i] = true;
    for(int item : list[i]){
      if(!visited[item]){
        check[item] = (check[i]+1)%2;
        dfs(item);
      }else if(check[item] == check[i]){
        isGraph = false;
      }
    }
  }

}
