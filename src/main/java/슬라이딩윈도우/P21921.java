package 슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P21921 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] sum = new int[n];
    int max = 0;
    int count = 0;
    int tmp = 0;

    for (int i = 0; i < x; i++) {
      tmp += arr[i];
      sum[i] = tmp;
      max=Math.max(sum[i],max);
    }

    for (int i = x; i <n ; i++) {
      tmp += (arr[i]-arr[i-x]);
      sum[i] = tmp;
      max=Math.max(sum[i], max);
    }

    for(int item : sum){
      if(item==max){
        count++;
      }
    }

    if(max==0){
      System.out.println("SAD");
    }else{
      System.out.println(max);
      System.out.println(count);
    }
  }
}
