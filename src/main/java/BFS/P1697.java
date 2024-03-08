package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1697 {
  static int n;
  static int k;
  static int arr[];
  static boolean visited[];
  static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    arr = new int[100001];
    visited = new boolean[100001];
    bfs(n);
   }

   static void bfs(int n){
     Queue<Integer> queue = new LinkedList<>();
     queue.add(n);
     visited[n] = true;

     while (!queue.isEmpty()){
       int tmp = queue.remove();
       if(tmp == k){
         System.out.println(arr[k]);
       }
       if(tmp-1 >=0 && !visited[tmp-1]){
         arr[tmp-1] = arr[tmp]+1;
         visited[tmp-1] = true;
         queue.add(tmp-1);
       }
       if(tmp+1 <arr.length && !visited[tmp+1]){
         arr[tmp+1] = arr[tmp]+1;
         visited[tmp+1] = true;
         queue.add(tmp+1);
       }
       if(tmp*2 < arr.length && !visited[tmp*2]){
         arr[tmp*2] = arr[tmp]+1;
         visited[tmp*2] = true;
         queue.add(tmp*2);
       }
     }

   }
}
