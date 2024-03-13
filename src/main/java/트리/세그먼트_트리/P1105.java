package 트리.세그먼트_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1105 {
  static long[] tree;
  static int MOD;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int height = 0;
    int length = n;
    while (length!=0){
      length/=2;
      height++;
    }

    int treeSize = (int)Math.pow(2,height+1);
    int startIdx =treeSize/2 -1;

    MOD = 1000000007;
    tree = new long[treeSize+1];
    for (int i = 0; i < tree.length; i++) {
      tree[i] = 1;

    }

    for (int i = startIdx+1; i <=startIdx+n ; i++) {
      tree[i] = Long.parseLong(br.readLine());
    }

    setTree(treeSize-1);

    for (int i = 0; i < m+k; i++) {
      st = new StringTokenizer(br.readLine());
      long a= Long.parseLong(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      long e = Long.parseLong(st.nextToken());
      if(a==1){
        swapVal(startIdx+s,e);
      }else if(a==2){
        s = s+startIdx;
        e = e+startIdx;
        System.out.println(getMul(s, (int)e));
      }else{
        return;
      }
    }
  }

  private static long getMul(int s, int e) {
    long muls = 1;
    while (s<=e){
      if(s%2==1){
        muls = muls*tree[s] % MOD;
        s++;
      }
      if(e%2==0){
        muls = muls*tree[e] % MOD;
        e--;
      }

      s/=2;
      e/=2;
    }
    return muls;
  }

  private static void swapVal(int i, long e) {
    tree[i] = e;
    while (i>1){
      i/=2;
      tree[i] = tree[i*2]%MOD * tree[i*2+1]%MOD;
    }
  }

  static void setTree(int i){
    while (i!=1){
      tree[i/2 ] = tree[i]*tree[i/2]%MOD;
      i--;
    }

  }

}
