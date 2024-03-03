package DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class P2023 {
  static int n;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    dfs(2,1);
    dfs(2,1);
    dfs(3,1);
    dfs(5,1);
    dfs(7,1);

  }

  private static void dfs(int now, int jarisu) {
    if(jarisu == n){
      if(isPrime(now)){
        System.out.println(now);
        return;
      }
    }

    for (int i = 1; i <=9 ; i++) {
      if(i%2 == 0){
        continue;
      }
      if(isPrime(now*10+i)){
        dfs(now*10+i,jarisu+1);
      }
    }
  }

  private static boolean isPrime(int now) {
    for (int i = 2; i <now/2 ; i++) {
      if(now%i == 0){
        return false;
      }
    }

    return true;
  }


}
