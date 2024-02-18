package 정수론.유클리드_호제법;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P21568 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a= Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    long gcd = gcd(a,b);

    if(c%gcd != 0){
      System.out.println(-1);
    }else {
      int mok = (int) (c/gcd);
      long arr[] = excute(a,b);
      System.out.println(arr[0]*mok +" "+arr[1]*mok);
    }
  }

  private static long[] excute(int a, int b) {
    long[] arr = new long[2];
    if(b==0){
      arr[0] = 1;
      arr[1] = 0;
      return arr;
    }
    long mok = a/b;
    long[] tmp = excute(b, a%b);
    arr[0] = tmp[1];
    arr[1] = tmp[0] - tmp[1]*mok;
    return arr;

  }

  private static long gcd(long a, long b) {
    if(b==0){
      return a;
    }
    return gcd(b, a%b);
  }

}
