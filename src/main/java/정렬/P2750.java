package 정렬;

import java.util.Scanner;

//버블정렬
public class P2750 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];

    for(int i=0; i<arr.length; i++){
      arr[i] = sc.nextInt();
    }

    for(int i=0; i<arr.length; i++){
      for(int j=0; j<n-i-1; j++){
        if(arr[j] > arr[j+1]){
          int tmp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = tmp;
        }
      }
    }

    for(int item : arr){
      System.out.println(item);
    }
  }

}
