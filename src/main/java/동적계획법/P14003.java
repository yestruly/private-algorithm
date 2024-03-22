package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14003 {
  static int n;
  static int[] A = new int[1000001];;
  static int[] B = new int[1000001];;
  static int[] D = new int[1000001];;
  static int[] answer = new int[1000001];
  static int max;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <=n ; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }


    int idx = 0;
    B[++max] = A[1];
    D[1] = 1;

    for (int i = 2; i <=n ; i++) {
      if(B[max] < A[i]){
        B[++max] = A[i];
        D[i] = max;
      }else{
        idx = binarySearch(1, max,A[i]);
        B[idx] = A[i];
        D[i] = idx;
      }
    }

    System.out.println(max);
    idx = max;
    int tmp = B[max]+1;

    for (int i = n; i >=1 ; i--) {
      if(D[i]==idx && A[i]<tmp){
        answer[idx] = A[i];
        tmp = A[i];
        idx--;
      }
    }
    for (int i = 1; i <=max ; i++) {
      System.out.print(answer[i]+" ");
    }
  }

  private static int binarySearch(int left, int right, int now) {
    int mid=0;
    while (left<right){
      mid =  (left+right)/2;
      if(B[mid] < now){
        left = mid+1;
      }else {
        right = mid;
      }
    }
    return left;
  }
}
