package 프로그래머스Lv1;

public class 과일_장수_다른풀이 {
  public static int solution(int k, int m, int[] score) {
    int answer = 0;
    //퀵정렬
    quickSort(score,0,score.length-1);
    for (int i = score.length; i >=m ; i-=m) {
      answer += score[i-m]*m;
    }

    return answer;
  }

  private static void quickSort(int[] arr, int left, int right) {
    if(left>=right){
      return;
    }

    int pivot = partition(arr,left,right);
    quickSort(arr,left,pivot-1);
    quickSort(arr,pivot+1,right);

  }

  private static int partition(int[] arr, int left, int right) {
    int pivot = arr[left];
    int i = left;
    int j= right;

    while (i<j){
      while (arr[j]>pivot && i<j){
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

  private static void swap(int[] arr, int left, int right) {
    int tmp = arr[left];
    arr[left] = arr[right];
    arr[right] =tmp;
  }


  public static void main(String[] args) {
    System.out.println(solution(3,4,new int[]{1,2,3,1,2,3,1}));
  }

}
