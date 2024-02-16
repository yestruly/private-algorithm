package 정수론.소수_구하기;

import java.util.Scanner;

public class P1747 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[1000001];
    for (int i = 2; i <arr.length ; i++) {
      arr[i] = i;
    }

    for (int i = 2; i <Math.sqrt(arr.length); i++) {
      if(arr[i] == 0) {
        continue;
      }
      for (int j = i+i; j < arr.length ; j = j+i) {
        arr[j] = 0;
      }
    }

    int idx = n;
    while (true){
      if(arr[idx]!=0){
        if(isPalindrome(arr[idx])){
          System.out.println(arr[idx]);
          break;
        }
      }
      idx++;
    }
  }

  private static boolean isPalindrome(int num) {
    char[] arr = String.valueOf(num).toCharArray();
    int startIdx = 0;
    int endIdx = arr.length-1;
    while (startIdx < endIdx){
      if(arr[startIdx]!=arr[endIdx]){
        return false;
      }
      startIdx++;
      endIdx--;
    }
    return true;
  }

}
