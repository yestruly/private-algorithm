package 그래프.위상정렬;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2252 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    int[] arr = new int[n+1];

    for (int i = 0; i <=n; i++) {
      list.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < m; i++) {
      int s = sc.nextInt();
      int e = sc.nextInt();
      list.get(s).add(e);
      arr[e]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <=n ; i++) {
      if(arr[i] == 0){
        queue.add(i);
      }
    }

    while (!queue.isEmpty()){
      int tmp = queue.poll();
      System.out.println(tmp);
      for(int item : list.get(tmp)){
        arr[item]--;
        if(arr[item] == 0 ){
          queue.add(item);
        }
      }
    }
  }

}
