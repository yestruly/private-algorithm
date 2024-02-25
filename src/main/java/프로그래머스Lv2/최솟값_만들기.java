package 프로그래머스Lv2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 최솟값_만들기 {
//  public int solution(int[] A, int[] B) {
//    int answer = 0;
//    PriorityQueue<Integer> pqA = new PriorityQueue<>();
//    PriorityQueue<Integer> pqB = new PriorityQueue<>(Collections.reverseOrder());
//
//    for (int i = 0; i < A.length; i++) {
//      pqA.add(A[i]);
//      pqB.add(B[i]);
//    }
//
//    while (!pqA.isEmpty()){
//      answer += pqA.remove() * pqB.remove();
//    }
//    return answer;
//  }

//  public int solution(int[] A, int[] B) {
//    int answer = 0;
//    Arrays.sort(A);
//    Arrays.sort(B);
//
//    for (int i = 0; i < A.length; i++) {
//      answer += A[i]*B[B.length-1-i];
//    }
//    return answer;
//  }

  public int solution(int[] A, int[] B) {
    int answer = 0;
    quickSort(A, 0, A.length-1);
    quickSort(B, 0, B.length-1);

    for (int i = 0; i < A.length; i++) {
      answer += A[i]*B[B.length-1-i];
    }
    return answer;
  }

  private void quickSort(int[] arr, int left, int right) {
   if(left>=right){
     return;
   }

   int pivot = partition(arr,left,right);
   quickSort(arr, left, pivot-1);
   quickSort(arr, pivot+1, right);


  }

  private int partition(int[] arr, int left, int right) {
    int pivot = arr[left];
    int i = left;
    int j = right;

    while (i<j){
      while (arr[j] > pivot && i<j){
        j--;
      }
      while (arr[i] <= pivot && i<j){
        i++;
      }
      swap(arr, i, j);
    }
    swap(arr, left, i);
    return i;

  }

  private void swap(int[] arr, int left, int right) {
    int tmp = arr[left];
    arr[left] = arr[right];
    arr[right] = tmp;
  }

}
