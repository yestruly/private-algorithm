package 프로그래머스Lv2;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.plaf.IconUIResource;

public class 게임_맵_최단거리 {
  static int[] dx = {1,0,-1,0};
  static int[] dy = {0,-1,0,1};

  public static int solution(int[][] maps) {
    int count = 0;
    int visit[][] = new int[maps.length][maps[0].length];
    bfs( maps, visit);
    count = visit[maps.length-1][maps[0].length-1];


    return count==0 ? -1 : count;
  }

  static void bfs(int[][] maps, int[][] visit){
    Queue<int[] > queue = new LinkedList<>();
    queue.add(new int[]{0,0});
    visit[0][0] = 1;

    while (!queue.isEmpty()){
      int[] arr = queue.remove();
      int tmpX = arr[0];
      int tmpY = arr[1];
      for (int i = 0; i < 4; i++) {
        int nX = tmpX+dx[i];
        int nY = tmpY+dy[i];

        if(nX <0 || nY <0 || nX >= maps.length || nY >= maps[0].length){
          continue;
        }

        if(visit[nX][nY] == 0  && maps[nX][nY] ==1 ){
          visit[nX][nY] = visit[tmpX][tmpY]+1;
          queue.add(new int[]{nX,nY});
        }
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
  }

}
