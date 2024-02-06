package 정렬;

import java.util.Scanner;

//선택정렬
public class P1427 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String n = sc.next();
    int[] arr = new int[n.length()];

    for (int i = 0; i < n.length(); i++) {
      arr[i] = n.charAt(i)-'0';
    }

    for (int i = 0; i < n.length(); i++) {
      int maxIdx = i;
      for (int j = i+1; j <n.length() ; j++) {
        if(arr[maxIdx] < arr[j]){
          maxIdx = j;
        }
      }

      if (arr[i] < arr[maxIdx]){
        int tmp = arr[maxIdx];
        arr[maxIdx] = arr[i];
        arr[i] = tmp;
      }
    }

    for(int item : arr){
      System.out.print(item);
    }
  }

}
