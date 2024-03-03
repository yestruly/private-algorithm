package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2003 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int cnt=0;
    int sum = 0;
    int start = 0;
    int end = 0;

    while (true){
      if(end == n){
        break;
      }else if(sum < m){
        sum+=arr[end++];
      }else{
        sum-=arr[start++];
      }

      if(sum==m){
        cnt++;
      }
    }

    System.out.println(cnt);
  }

}
