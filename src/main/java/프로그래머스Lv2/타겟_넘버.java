package 프로그래머스Lv2;

public class 타겟_넘버 {

  static int answer;

  public static int solution(int[] numbers, int target) {

    dfs(numbers, 0, target, 0);
    return answer;
  }

  static void dfs(int[] numbers, int idx, int target, int sum) {
    if (numbers.length == idx) {
      if (sum == target) {
        answer++;
      }
    } else {
      dfs(numbers, idx+1, target, sum + numbers[idx]);
      dfs(numbers, idx+1, target, sum - numbers[idx]);
    }
  }

  public static void main(String[] args) {
    System.out.println(solution(new int[]{1,1,1,1,1},3));
  }
}
