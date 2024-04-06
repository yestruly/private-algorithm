package 프로그래머스Lv1;

public class 이웃한_칸 {
  public int solution(String[][] board, int h, int w) {
    int answer = 0;

    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};

    for(int i=0; i<4; i++){
      int x = h+dx[i];
      int y = w +dy[i];

      if(x <0 || y< 0 || x >= board.length || y >= board[0].length){
        continue;
      }

      if(board[x][y].equals(board[h][w])){
        answer++;
      }
    }
    return answer;
  }

}
