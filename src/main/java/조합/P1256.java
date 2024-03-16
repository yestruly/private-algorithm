package 조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1256 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[][] arr = new int[201][2001];
    for (int i = 0; i <=200; i++) {
      for (int j = 0; j <=i ; j++) {
        if(i==j || j==0){
          arr[i][j] = 1;
        }else{
          arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
          if(arr[i][j] > 1000000000){
            arr[i][j] = 1000000000;
          }
        }
      }
    }

    if(arr[n+m][m] < k){
      System.out.println(-1);
      return;
    }

    while (n!=0 || m!=0){
      if(arr[n-1+m][m] >=k){
        System.out.print("a");
        n--;
      }else{
        System.out.print("z");
        k = k-arr[n-1+m][m];
        m--;
      }
    }
  }

}
