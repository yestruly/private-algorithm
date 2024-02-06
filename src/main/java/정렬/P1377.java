package 정렬;
//버블정렬

import java.io.*;
import java.util.Arrays;

public class P1377 {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    mData[] arr = new mData[n];

    for (int i = 0; i < n; i++) {
      arr[i] = new mData(Integer.parseInt(bf.readLine()),i);
    }

    Arrays.sort(arr);
    int MAX = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      if(arr[i].idx -i > MAX){
        MAX = arr[i].idx-i;
      }
    }

    System.out.println(MAX+1);
  }

  private static class mData implements Comparable<mData>{
    int data;
    int idx;

    mData(){}
    mData(int data, int idx){
      this.data = data;
      this.idx = idx;
    }

    @Override
    public int compareTo(mData o) {
      return this.data - o.data;
    }
  }
}
