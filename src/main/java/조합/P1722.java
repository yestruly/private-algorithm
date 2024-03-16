package 조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1722 {

  public static void main(String[] args) throws IOException {
    long[] f = new long[21];
    int[] s = new int[21];
    boolean[] visited = new boolean[21];

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());

    int q = Integer.parseInt(st.nextToken());
    f[0] = 1;
    for (int i = 1; i <=n ; i++) {
      f[i] = f[i-1]*i;
    }

    if(q==1){
      long k = Long.parseLong(st.nextToken());
      for (int i = 1; i <=n ; i++) {
        for (int j = 1, count =1; j <=j ; j++) {
          if(visited[j]){
            continue;
          }
          if(k<=count*f[n-i]){
            k -= ((count-1)*f[n-i]);
            s[i] = j;
            visited[j] = true;
            break;
          }
          count++;
        }
      }

      for (int i = 1; i <=n ; i++) {
        System.out.print
            (s[i]+" ");
      }
    }else {
      long k = 1;
      for (int i = 1; i <=n ; i++) {
        s[i] = Integer.parseInt(st.nextToken());
        long count = 0;
        for (int j = 1; j <s[i] ; j++) {
          if(!visited[j]){
            count++;
          }
        }
        k+= count*f[n-i];
        visited[s[i]] = true;
      }
      System.out.println(k);
    }
   }

}
