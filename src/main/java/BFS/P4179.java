package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4179 {
  static Queue<int[]> q1;
  static Queue<int[]> q2;
  static int arr1[][];
  static int arr2[][];
  static char[][] board;
  static int[] dx = {1,0,-1,0};
  static int[] dy = {0,-1,0,1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    board = new char[n][m];
    arr1 = new int[n][m];
    arr2 = new int[n][m];
    q1 = new LinkedList<>();
    q2 = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < m; j++) {
        board[i][j] = s.charAt(j);
        arr1[i][j] = -1;
        arr2[i][j] = -1;

        if(board[i][j] == 'F'){
          arr1[i][j] = 0;
          q1.add(new int[]{i,j});
        }
        if(board[i][j] == 'J'){
          arr2[i][j] = 0;
          q2.add(new int[]{i,j});
        }
      }
    }
    while (!q1.isEmpty()){
      int[] tmp = q1.remove();
      int x = tmp[0];
      int y = tmp[1];

      for (int i = 0; i < 4; i++) {
        int nx = x+dx[i];
        int ny = y+dy[i];

        if(nx<0 || ny <0 || nx >=n || ny>=m || board[nx][ny] == '#'){
          continue;
        }
        if(arr1[nx][ny] >=0){
          continue;
        }
        arr1[nx][ny] = arr1[x][y]+1;
        q1.add(new int[]{nx, ny});
      }
    }

    while (!q2.isEmpty()){
      int[] tmp = q2.remove();
      int x = tmp[0];
      int y = tmp[1];

      for (int i = 0; i < 4; i++) {
        int nx = x+dx[i];
        int ny = y+dy[i];

        if(nx<0 || ny <0 || nx >=n || ny>=m){
          System.out.println(arr2[x][y]+1);
          return;
        }
        if(arr2[nx][ny] >=0 || board[nx][ny] == '#'){
          continue;
        }
        arr2[nx][ny] = arr2[x][y]+1;
        q2.add(new int[]{nx, ny});
      }
    }
    System.out.println("IMPOSSIBLE");
  }

}
