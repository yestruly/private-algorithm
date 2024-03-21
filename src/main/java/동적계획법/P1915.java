package 동적계획법;


import java.util.Scanner;

public class P1915 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    long[][] arr = new long[1001][1001];
    long max = Integer.MIN_VALUE;

    for (int i = 0; i <n ; i++) {
      String tmp = sc.next();
      for (int j = 0; j < m; j++) {
        arr[i][j] = Long.parseLong(String.valueOf(tmp.charAt(j)));
        if(arr[i][j] == 1 && i>0 && j>0){
          arr[i][j] = Math.min(arr[i-1][j-1], Math.min(arr[i][j-1], arr[i-1][j]))+1;
          max = Math.max(arr[i][j], max);
        }
      }
    }
    System.out.println(max*max);
  }

}
