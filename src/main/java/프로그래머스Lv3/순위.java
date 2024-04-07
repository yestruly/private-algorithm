package 프로그래머스Lv3;

public class 순위 {
  public static int solution(int n, int[][] results) {
    int answer = 0;
    final int INF = 987654321;
    int[][] dp = new int[n+1][n+1];
    for (int i = 1; i <=n ; i++) {
      for (int j = 1; j <=n ; j++) {
        dp[i][j] = INF;
        if(i==j){
          dp[i][j] = 0;
        }
      }
    }

    for(int []item : results){
      dp[item[0]][item[1]] = 1;
    }

    for (int k = 1; k <=n ; k++) {
      for (int i = 1; i <=n ; i++) {
        for (int j = 1; j <=n ; j++) {
          dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
        }
      }
    }

    answer = n;
    for (int i = 1; i <=n ; i++) {
      for (int j = 1; j <=n ; j++) {
        if(i==j){
          continue;
        }
        if(dp[i][j] == INF && dp[j][i] == INF){
          answer--;
          break;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution(5, new int[][]{{4,3},{4,2},{3,2},{1,2},{2,5}}));
  }
}
