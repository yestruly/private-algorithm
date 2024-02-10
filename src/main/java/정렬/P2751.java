package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P2751 {

  public static int[] arr;
  public static int[] tmp;
  public static long result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    arr = new int[n + 1];
    tmp = new int[n + 1];

    for (int i = 0; i < n+1; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    sort(1, n);
    for (int i = 1; i < n; i++) {
      bw.write(arr[i]+" \n");
    }

    bw.flush();;
    bw.close();


  }

  private static void sort(int start, int end) {
    if(end-start < 1){
      return;
    }

    int medium = (start+end)/2;
    sort(start, medium);
    sort(medium+1, end);

    for (int i = start; i <= end; i++) {
      tmp[i] = arr[i];
    }

    int k = start;
    int idx1 = start;
    int idx2 = medium+1;

    Arrays.toString(arr);

    while (idx1 < medium && idx2 <end){
      if (tmp[idx1] > tmp[idx2]){
        arr[k++] = tmp[idx2++];
      }else {
        arr[k++] = tmp[idx1++];
      }
    }

    while (idx1<=medium){
      arr[k++] = tmp[idx1++];
    }

    while (idx2 <=end){
      arr[k++] = tmp[idx2++];
    }
  }

}
