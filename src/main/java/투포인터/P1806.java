package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1806 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());
    int[] arr = new int[n+1];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int answer = Integer.MAX_VALUE;
    int left = 0;
    int right = 0;
    int sum = 0;
    while (left<=right && right<=n){
      if(sum < s){
        sum+=arr[right++];
      }else if(sum>=s && answer > right-left){
        answer = Math.min(answer, right-left);
      }else{
        sum-=arr[left++];
      }
    }

    System.out.println(answer==Integer.MAX_VALUE ? 0 : answer);

  }

}
