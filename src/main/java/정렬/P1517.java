package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1517 {

  public static int[] arr;
  public static int[] tmp;
  public static long result;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    arr = new int[n+1];
    tmp = new int[n+1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n+1; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    result = 0;
    sort(1,n);
    System.out.println(result);
  }

  private static void sort(int start, int end) {
    int medium = start + (end-start) /2;

    if(end - start < 1){
      return;
    }

    sort(start, medium);
    sort(medium+1, end);
    for (int i = start; i <end+1 ; i++) {
      tmp[i] = arr[i];
    }

    int k = start;
    int idx1 = start;
    int idx2 = medium+1;
    while (idx1<=medium && idx2 <= end){
      if(tmp[idx1] > tmp[idx2]){
        arr[k] = tmp[idx2];
        result = result+idx2-k;
        k++;
        idx2++;
      }else {
        arr[k] = tmp[idx1];
        k++;
        idx1++;
      }
    }

    while (idx1<=medium){
      arr[k] = tmp[idx1];
      k++;
      idx1++;
    }

    while (idx2<=end){
      arr[k] = tmp[idx2];
      k++;
      idx2++;
    }
  }

}
