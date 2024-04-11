package 해시;

import java.io.*;
import java.util.*;

public class P1269 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] a = new int[n];
    int[] b = new int[m];

    st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++){
      a[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<m; i++){
      b[i] = Integer.parseInt(st.nextToken());
    }

    int sum = 0;
    Hashtable<Integer, Integer> tableA = new Hashtable<>();
    for(int item : a){
      tableA.put(item, 1);
    }
    for(int item : b){
      if(tableA.containsKey(item)){
        tableA.remove(item);
      }
    }

    for(Integer item : tableA.keySet()){
      sum+=tableA.get(item);
    }

    Hashtable<Integer, Integer> tableB = new Hashtable<>();
    for(int item : b){
      tableB.put(item, 1);
    }
    for(int item : a){
      if(tableB.containsKey(item)){
        tableB.remove(item);
      }
    }

    for(Integer item : tableB.keySet()){
      sum+=tableB.get(item);
    }

    System.out.println(sum);
  }

}
