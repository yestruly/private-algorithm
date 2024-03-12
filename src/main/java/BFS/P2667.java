package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P2667 {
  static int n;
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
          bfs(i,j);
        }
      }
    }

    Collections.sort(list);
    System.out.println(list.size());
    for(int item : list){
      System.out.println(item);
    }
  }

  static void bfs(int x, int y){
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{x,y});
    visited[x][y] = true;
    int count = 1;
    while (!queue.isEmpty()){
      int[] tmp = queue.poll();
      int nX = tmp[0];
      int nY = tmp[1];
      for (int i = 0; i < 4; i++) {
        int tmpX = nX + dx[i];
        int tmpY = nY + dy[i];
        if(tmpX>=0 && tmpY>=0 && tmpY<n && tmpX<n && arr[tmpX][tmpY] == 1 && !visited[tmpX][tmpY]){
          visited[tmpX][tmpY] = true;
          count++;
          queue.add(new int[]{tmpX, tmpY});
        }
      }
    }
    list.add(count);
  }

}
