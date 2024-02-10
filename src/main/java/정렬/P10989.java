package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P10989 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    br.close();

    sort(arr, 5); //가능한 최대 자리수는 5(10,000)
    for (int i = 0; i < n; i++) {
      bw.write(arr[i]+"\n");
    }
    bw.flush();
    bw.close();
  }

  private static void sort(int[] arr, int maxSize) {
    int[] tmp = new int[arr.length];
    int jarisu = 1;
    int cnt = 0;

    while (cnt != maxSize){
      int[] bucket = new int[10];
      for (int i = 0; i < arr.length; i++) {
        bucket[(arr[i]/jarisu) % 10]++;
      }
      Arrays.toString(bucket);

      for (int i = 1; i < 10; i++) {
        bucket[i] += bucket[i-1];
      }

      for (int i = arr.length-1; i >=0 ; i--) {
        tmp[bucket[(arr[i]/jarisu)%10]-1] = arr[i];
        bucket[(arr[i]/jarisu)%10]--;
      }
      Arrays.toString(tmp);

      for (int i = 0; i < arr.length; i++) {
        arr[i] = tmp[i];
      }
      jarisu *=10;
      cnt++;
    }
  }

}
