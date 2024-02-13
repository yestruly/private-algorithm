package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P13023 {
  static ArrayList<Integer>[] arr;
  static boolean visited[];
  static boolean arrive;
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m =Integer.parseInt(st.nextToken());
    arr = new ArrayList[n];
    visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      arr[i] = new ArrayList<>();
    }

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(bf.readLine());
      int num1 = Integer.parseInt(st.nextToken());
      int num2 = Integer.parseInt(st.nextToken());
      arr[num1].add(num2);
      arr[num2].add(num1);
    }

    for (int i = 0; i < n; i++) {
      dfs(i,1);
      if(arrive){
        break;
      }
    }

    if(arrive){
      System.out.println(1);
    }else {
      System.out.println(0);
    }
  }

  private static void dfs(int now, int depth) {
    if(depth == 5 || arrive){
      arrive = true;
      return;
    }

    visited[now]=  true;
    for(int item : arr[now]){
      if(!visited[item]){
        dfs(item, depth+1);
      };
    }
    visited[now] = false;

  }
}
