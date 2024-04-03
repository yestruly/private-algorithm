package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16952 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long n = Long.parseLong(st.nextToken());
    long m = Long.parseLong(st.nextToken());

    int count = 1;
    while (n!=m){
      if(m<n){
        count = -1;
        break;
      }
      if(m%2 != 0 && m%10 !=1){
        count= -1;
        break;
      }

      if(m%2 == 0){
        m/=2;
      } else if(m%10 == 1){
        m/=10;
      }
      count++;

    }

    System.out.println(count);
  }

}
