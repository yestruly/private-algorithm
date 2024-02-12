package 정렬;

import java.util.Arrays;

public class K번째수 {
  public static int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];

    for (int i = 0; i < commands.length; i++) {
      int[] tmp = new int[commands[i][1]-commands[i][0]+1];
      int idx=0;
      for (int j = commands[i][0]-1; j <commands[i][1] ; j++) {
       tmp[idx++] = array[j];
      }

      quickSort(tmp,0, tmp.length-1);
      Arrays.toString(tmp);
    }

    return answer;
  }

  static void quickSort(int[] arr, int left, int right){
    int pl = left;
    int pr = right;
    int x = arr[(pl+pr)/2];

    do {
      while (arr[pl]<x) pl++;
      while (arr[pl] > x) pl--;
      if(pl<=pr){
        int tmp = arr[pl];
        arr[pl] = arr[pr];
        arr[pr] = tmp;
        pl++;
        pl++;
      }
    }while (pl<=pr);

    if(left < pr){
      quickSort(arr, left, pr);
    }
    if (right > pr){
      quickSort(arr,pl,right);
    }
  }
  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(new int[]{1,5,2,6,3,7,4},new int[][]{{2,5,3},{4,4,1},{1,7,3}})));
  }
}
