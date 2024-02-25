package 프로그래머스Lv0;

public class 가까운_수 {
  public int solution(int[] array, int n) {
    int answer = 0;
    int min = Integer.MAX_VALUE;
    int gap = 0;

    for(int item : array){
      gap = Math.abs(item-n);
      if(gap < min){
        min = gap;
        answer = item;
      } else if (gap == min && answer > item) {
        answer = item;
      }
    }
    return answer;
  }

}
