package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P7795 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());

    while (t>0){
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int[] a = new int[A];
      int[] b = new int[B];

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < A; i++) {
        a[i] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < B; i++) {
        b[i] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(b);
      Arrays.sort(a);
      int count = 0;
      for (int i = 0; i < A; i++) {
        for (int j = 0; j < B; j++) {
          if(a[i] <= b[j]){
            break;
          }else{
            count++;
          }
        }
      }

      System.out.println(count);
      t--;
    }

  }

}
