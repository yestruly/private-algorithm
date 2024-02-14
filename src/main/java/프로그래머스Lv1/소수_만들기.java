package 프로그래머스Lv1;

public class 소수_만들기 {
  public int solution(int[] nums) {
    if (nums.length > 50 || nums.length <2){
      return 0;
    }
    int answer = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i+1; j < nums.length; j++) {
        for (int k = j+1; k <nums.length ; k++) {
          int num = nums[i]+nums[j]+nums[k];
          if(check(num)){
            answer++;
          }
        }
      }

    }

    return answer;
  }

  private boolean check(int num) {
    for (int i = 2; i < num/2; i++) {
      if(num % i==0){
        return false;
      }
    }
    return true;
  }

}
