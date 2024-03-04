package 슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2559 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }


    int sum = 0;
    for (int i = 0; i < k; i++) {
      sum+= arr[i];
    }

    int result = sum;
    for (int i = k; i <n ; i++) {
      sum+= arr[i] - arr[i-k];
      result = Math.max(result, sum);
    }

    System.out.println(result);
  }

}
