package 프로그래머스Lv1;

public class 최소직사각형 {
  public int solution(int[][] sizes) {
    int answer = 0;

    for(int i=0; i<sizes.length; i++){
      if(sizes[i][0] < sizes[i][1]){
        int tmp = sizes[i][0];
        sizes[i][0] = sizes[i][1];
        sizes[i][1] = tmp;
      }
    }

    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    for(int[] items : sizes){
      if(items[0] > max1){
        max1 = items[0];
      }

      if(items[1] > max2){
        max2= items[1];
      }
    }
    return max1*max2;
  }

}
