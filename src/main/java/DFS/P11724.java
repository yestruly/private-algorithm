package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11724 {
  static ArrayList<Integer> [] arr;
  static boolean visited[];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    arr = new ArrayList[n+1];
    visited = new boolean[n+1];

    for (int i = 1; i <=n ; i++) {
      arr[i] = new ArrayList<>();
    }
    for (int i = 0; i <m ; i++) {
      st = new StringTokenizer(br.readLine());
      int num1 = Integer.parseInt(st.nextToken());
      int num2 = Integer.parseInt(st.nextToken());
      arr[num1].add(num2);
      arr[num2].add(num1);
    }

    int cnt =0;
    for (int i = 1; i <= n; i++) {
      if(!visited[i]){
        cnt++;
        dfs(i);
      }
    }
    System.out.println(cnt);
  }

  private static void dfs(int i) {
    if(visited[i]){
      return;
    }

    visited[i] = true;
    for(int item : arr[i]){
      if(!visited[item]){
        dfs(item);
      }
    }
  }

}
