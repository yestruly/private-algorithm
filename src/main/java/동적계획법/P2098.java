package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2098 {
  static int n;
  static int[][] w;
  static int[][] d;
  static final int INF = 1000000*16+1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;
    n = Integer.parseInt(br.readLine().trim());
    w = new int[16][16];
    d = new int[16][1<<16];

    for (int i = 0; i < n; i++) {
      st= new StringTokenizer(br.readLine().trim());
      for (int j = 0; j < n; j++) {
        w[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    System.out.println(tsp(0,1));
  }

  static int tsp(int c, int v){
    if(v==(1<<n)-1){
      return w[c][0] == 0 ? INF : w[c][0];
    }

    if(d[c][v]!=0){
      return d[c][v];
    }
    int min = INF;
    for (int i = 0; i < n; i++) {
      if(w[c][i] !=0 && (v&(1<<i))==0){
        min = Math.min(min, tsp(i,(v|(1<<i)))+w[c][i]);
      }
    }

    d[c][v] = min;
    return d[c][v];
  }

}
