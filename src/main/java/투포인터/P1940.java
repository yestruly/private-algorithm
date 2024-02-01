package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    int p1 = 0;
    int p2 = N-1;
    int cnt= 0;

    while(p1 < p2){
      if(arr[p1]+arr[p2] == M){
        cnt++;
        p1++;
        p2--;
      }else if(arr[p1]+arr[p2] < M){
        p1++;
      }else{
        p2--;
      }
    }

    System.out.println(cnt);
  }

}
