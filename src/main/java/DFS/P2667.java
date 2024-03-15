package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P2667 {
  static int n, count;
  static boolean visited[][];
  static int arr[][];
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static ArrayList<Integer> list = new ArrayList<>();

  public static void main(String[] args)  {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    arr = new int[n][n];
    visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      String str = sc.next();
      for (int j = 0; j < n; j++) {
        arr[i][j] = str.charAt(j)-'0';
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if(arr[i][j]==1 && !visited[i][j]){
          dfs(i,j);
          list.add(count+1);
          count = 0;
        }
      }
    }

    Collections.sort(list);
    System.out.println(list.size());
    for(int item : list){
      System.out.println(item);
    }
  }

  static void dfs(int x, int y){
    visited[x][y] = true;
    for (int i = 0; i < 4; i++) {
      int tmpX = x+dx[i];
      int tmpY = y+dy[i];
      if(tmpX>=0 && tmpY>=0 && tmpY<n && tmpX<n && arr[tmpX][tmpY] == 1 && !visited[tmpX][tmpY]){
        count++;
        dfs(tmpX, tmpY);
      }
    }
  }
}
