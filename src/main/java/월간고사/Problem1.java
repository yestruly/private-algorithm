package 월간고사;

public class Problem1 {
  public long solution(int N, int K, int[] arr) {
    if (N <3 || N>200000 || K > N-1 || K < 1|| arr.length > 1000000000){
      return 0;
    }
    long answer = 0;
    long idx = 0;
    while (idx < K){
      answer += arr[(int) idx++]*2;
    }

    idx++;
    answer += arr[(int) idx];

    for (long i = idx+1; i <arr.length ; i++) {
      answer += arr[(int)i] - arr[(int)i-1];
    }
    return answer;
  }

}
