package 그래프.유니온_파인드;

import java.util.Scanner;

public class P1717 {
  static int[] arr;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n= sc.nextInt();
    int m = sc.nextInt();
    arr = new int[n+1];

    for(int i=1; i<arr.length; i++){
      arr[i] = i;
    }

    for(int i=0; i<m; i++){
      int x = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      if(x == 0){
        union(a,b);
      }else{
        if(check(a,b)){
          System.out.println("YES");
        }else{
          System.out.println("NO");
        }
      }
    }
  }

  private static boolean check(int a, int b) {
    int rootA = find(a);
    int rootB = find(b);

    if(rootA == rootB){
      return true;
    }
    return false;
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if(a!=b){
      arr[b] = a;
    }

  }

  private static int find(int a) {
    if(arr[a] == a){
      return a;
    }
    return arr[a] = find(arr[a]);
  }

}
