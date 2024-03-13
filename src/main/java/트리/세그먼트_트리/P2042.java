package 트리.세그먼트_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P2042 {
  static long[] tree;

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
    int treeSize = (int) Math.pow(2, height+1);
    int startIdx = treeSize/2 -1;

    tree = new long[treeSize+1];
    for (int i = startIdx+1; i <= startIdx+n; i++) {
      tree[i] = Long.parseLong(br.readLine());
    }

    setTree(treeSize-1);
    for (int i = 0; i < m+k; i++) {
      st = new StringTokenizer(br.readLine());
      long a = Long.parseLong(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      long e = Long.parseLong(st.nextToken());
      if(a==1){
        changeVal(startIdx+s, e);
      }
      else if(a==2){
        s = s+startIdx;
        e = e+startIdx;
        System.out.println(getSum(s, (int)e));
      }else {
        return;
      }
    }
  }

  private static long getSum(int s, int e) {
    long sum = 0;
    while (s<=e){
      if(s%2 == 1){
        sum+=tree[s];
        s++;
      }
      if(e%2 == 0){
        sum+= tree[e];
        e--;
      }
    }

    return sum;
  }

  private static void changeVal(int start, long val) {
    long diff = val-tree[start];
    while (start > 0){
      tree[start] += diff;
      start/=2;
    }
  }

  private static void setTree(int treeSize) {
    while (treeSize != 1){
      tree[treeSize/2] += tree[treeSize];
    }
    treeSize--;
  }

}
