package 조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13251 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m = Integer.parseInt(br.readLine());
    int[] n = new int[51];
    int total =  0;

    StringTokenizer st= new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      n[i] = Integer.parseInt(st.nextToken());
      total+=n[i];
    }

    int k = Integer.parseInt(br.readLine());
    double answer = 0.0;
    double[] probability = new double[51];
    for (int i = 0; i < m; i++) {
      if(n[i] >= k){
        probability[i] = 1.0;
        for (int j = 0; j < k; j++) {
          probability[i]*= (double)(n[i]-k)/(total-k);
        }
        answer+=probability[i];
      }
    }

    System.out.println(answer);
  }
}
