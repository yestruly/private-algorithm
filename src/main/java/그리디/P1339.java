package 그리디;

import java.util.Arrays;
import java.util.Scanner;

public class P1339 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] words = new String[n];
    int[] nums = new int[26];

    for (int i = 0; i < n; i++) {
      words[i] = sc.next();
    }

    for (int i = 0; i < n; i++) {
      int length = words[i].length()-1;
      for (int j = 0; j < words[i].length(); j++) {
        char c= words[i].charAt(j);
        nums[(int)c-65] += (int)Math.pow(10, length);
        length--;
      }
    }
    Arrays.sort(nums);
    int tmp = 9;
    int answer = 0;
    for (int i = nums.length-1; i >=0 ; i--) {
      if(nums[i] == 0){
        break;
      }
      answer += nums[i]*tmp;
      tmp--;
    }

    System.out.println(answer);
  }

}
