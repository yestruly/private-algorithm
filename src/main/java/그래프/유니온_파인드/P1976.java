package 그래프.유니온_파인드;

import java.util.Scanner;

public class P1976 {
  static int[] parent;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m =sc.nextInt();
    int[][] cities = new int[n+1][n+1];
    parent = new int[m+1];
    int[] route = new int[m+1];

    for (int i = 1; i <=n ; i++) {
      for (int j = 1; j <=n ; j++) {
        cities[i][j] = sc.nextInt();
      }
    }
    for (int i = 1; i <=m ; i++) {
      route[i] = sc.nextInt();
    }

    for (int i = 1; i <=m ; i++) {
      parent[i] =i;
    }

    for (int i = 1; i <=n ; i++) {
      for (int j = 1; j <=n ; j++) {
        if(cities[i][j] == 1){
          union(i,j);
        }
      }
    }

    int idx = find(route[1]);
    for (int i = 2; i <=m ; i++) {
      if(idx != find(route[i])){
        System.out.println("NO");
        return;
      }
    }
    System.out.println("YES");
  }

  private static int find(int i) {
    if(i == parent[i]){
      return i;
    }
    return parent[i] = find(parent[i]);
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a!=b){
      parent[b] = a;
    }
  }

}
