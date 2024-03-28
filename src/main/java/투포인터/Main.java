package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[] arr = new long[n];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      arr[i] = Long.parseLong(st.nextToken());
    }

    int left = 0;
    int right = n-1;
    long min = Long.MAX_VALUE;
    long i=0, j=0;

    while (left<right){
      long gap = arr[left]+arr[right];
      if(Math.abs(min)>Math.abs(gap)){
        min = Math.abs(gap);
        i = left;
        j =right;
      }

      if (gap >0){
        right--;
      }else if(gap<0){
        left++;
      }else{
        break;
      }
    }
    System.out.println(arr[left]+" "+arr[right]);

  }

}
