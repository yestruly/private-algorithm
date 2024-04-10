package 프로그래머스Lv3;

public class 정수삼각형 {

  public int solution(int[][] triangle) {
    int answer = 0;
    int[][] dp = triangle;

    for (int i = 1; i < triangle.length; i++) {
      for (int j = 0; j < triangle[i].length; j++) {
        if (j == 0) {
          dp[i][j] += triangle[i - 1][j];
        } else if (j == i) {
          dp[i][j] += triangle[i - 1][j - 1];
        } else {
          dp[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
        }
        answer = Math.max(dp[i][j], answer);
      }
    }
    return answer;
  }

}
