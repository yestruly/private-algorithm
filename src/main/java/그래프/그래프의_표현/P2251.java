package 그래프.그래프의_표현;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2251 {
  static int[] sender = {0,0,1,1,2,2};
  static int[] receiver = {1,2,0,2,0,1};
  static boolean[][] visited;
  static boolean [] answer;
  static int[] now;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    now = new int[3];
    now[0] = sc.nextInt();
    now[1] = sc.nextInt();
    now[2] = sc.nextInt();
    visited = new boolean[201][201];
    answer = new boolean[201];

    bfs();
    for (int i = 0; i < answer.length; i++) {
      if(answer[i]){
        System.out.print(i+" ");
      }
    }
  }

  private static void bfs() {
    Queue<AB> queue = new LinkedList<>();
    queue.add(new AB(0,0));
    visited[0][0] = true;
    answer[now[2]] = true;
    while (!queue.isEmpty()){
      AB tmp = queue.poll();
      int a = tmp.a;
      int b = tmp.b;
      int c = now[2] -a-b;
      for (int i = 0; i < 6; i++) {
        int[] next  = {a,b,c};
        next[receiver[i]] += next[sender[i]];
        next[sender[i]] = 0;
        if(next[receiver[i]] > now[receiver[i]]){
          next[sender[i]] = next[receiver[i]] - now[receiver[i]];
          next[receiver[i]] = now[receiver[i]];
        }
        if(!visited[next[0]][next[1]]){
          visited[next[0]][next[1]] = true;
          queue.add(new AB(next[0], next[1]));
          if(next[0] == 0){
            answer[next[2]] = true;
          }
        }
      }
    }
  }

  private static class AB {
    int a;
    int b;
    public AB(int a, int b){
      this.a = a;
      this.b = b;
    }
  }
}
