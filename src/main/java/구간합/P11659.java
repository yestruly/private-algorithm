package 구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] result = new int[N+1];
    st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= N; i++) {
      result[i] = result[i-1]+ Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      System.out.println(result[m]-result[n-1]);
    }

  }

}
