package 프로그래머스Lv2;

public class 타겟_넘버 {

  static int answer;

  public int solution(int[] numbers, int target) {

    dfs(numbers, 0, target, 0);
    return answer;
  }

  static void dfs(int[] numbers, int idx, int target, int sum) {
    if(sum==target){
      answer++;
    }else{
      dfs(numbers, idx+1, target, sum+numbers[idx]);
      dfs(numbers, idx+1, target, sum-numbers[idx]);
    }
  }
}

