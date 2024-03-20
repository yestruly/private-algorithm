package 프로그래머스Lv0;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 안전지대 {
  public static int solution(int[][] board) {
    int answer = 0;
    int[] dx = {0,1,-1,0,-1,1,1,-1};
    int[] dy = {1,0,0,-1,-1,1,-1,1};
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if(board[i][j] == 1){
          queue.add(new int[]{i,j});
        }
      }
    }

    while (!queue.isEmpty()){
      int[] cur = queue.remove();

      for (int i = 0; i < dx.length; i++) {
        int x = cur[0]+dx[i];
        int y = cur[1]+dy[i];

        if(x<0 || y<0 || x>=board.length || y>=board.length){
          continue;
        }
        board[x][y] = 1;
      }
    }


    for(int[] cur : board){
      for(int item : cur){
        if(item==0){
          answer++;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(new int[][]{{0, 0, 0, 0, 0},{0, 0, 0, 0, 0},{0, 0, 0, 0, 0},{0,0,1,1,0},{0, 0, 0, 0, 0}}));
  }

}
