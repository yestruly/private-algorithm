package 정렬;

import java.util.Arrays;

public class H_Index {
  public int solution(int[] citations) {
    int answer = 0;
    quickSort(citations,0,citations.length-1);

    for (int i = 0; i < citations.length; i++) {
      int h = citations.length-i;
      if(citations[i] >=h){
        answer = h;
        break;
      }
    }
    return answer;
  }

  private void quickSort(int[] citations, int left, int right) {
    if(left >= right){
      return;
    }

    int pivot = partition(citations,left,right);
    quickSort(citations,left,pivot-1);
    quickSort(citations,pivot+1, right);
  }

  private int partition(int[] arr, int left, int right) {
    int pivot = arr[left];
    int i=left;
    int j= right;

    while (i<j){
      while (arr[j] > pivot && i<j){
        j--;
      }
      while (arr[i]<=pivot && i<j){
        i++;
      }
      swap(arr,i,j);
    }
    swap(arr,left,i);
    return i;
  }

  private void swap(int[] arr, int left, int right) {
    int tmp =arr[left];
    arr[left] = arr[right];
    arr[right] = tmp;
  }

}