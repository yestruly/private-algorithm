package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13398 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int[] left = new int[n];
    int[] right = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    left[0] = arr[0];
    right[n-1] = arr[n-1];

    int result = left[0];
    for (int i = 1; i <n ; i++) {
      left[i] = Math.max(left[i-1]+arr[i], arr[i]);
      result = Math.max(result, left[i]);
    }

    for (int i = n-2; i >=0 ; i--) {
      right[i] = Math.max(right[i+1]+arr[i], arr[i]);
    }

    for (int i = 1; i <n-1 ; i++) {
      result = Math.max(left[i-1]+right[i+1],result);
    }

    System.out.println(result);

  }

}
