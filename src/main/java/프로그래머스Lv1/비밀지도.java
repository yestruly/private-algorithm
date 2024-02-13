package 프로그래머스Lv1;

import java.util.Arrays;

public class 비밀지도 {
  public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];
    String[] map1 = decode(arr1, n);
    String[] map2 = decode(arr2,n);
    for (int i = 0; i < n; i++) {
      String tmp = "";
      for (int j = 0; j < map1[i].length(); j++) {
        if(map1[i].charAt(j) == '1' || map2[i].charAt(j)=='1'){
          tmp += "#";
        }else{
          tmp+=" ";
        }
      }
      answer[i] = tmp;
    }

    return answer;
  }

  private static String[] decode(int[] arr, int n) {
    String[] nums = new String[n];

    for (int i = 0; i < n; i++) {
      String num = Integer.toString(arr[i],2);
      if(num.length() < n){
        int cnt = 0;
        String zero = "";
        while (cnt != n- num.length()){
          zero+="0";
          cnt++;
        }
        num = zero+num;
      }
      nums[i] = num;
    }
    return nums;

  }

}
