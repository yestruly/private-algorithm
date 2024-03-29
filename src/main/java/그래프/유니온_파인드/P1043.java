package 그래프.유니온_파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P1043 {
  static int[] parent;
  static int[] truePerson;
  static ArrayList<Integer> list [];
  static int result;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n =sc.nextInt();
    int m =sc.nextInt();
    int t = sc.nextInt();
    truePerson = new int[t];
    for (int i = 0; i < t; i++) {
      truePerson[i] = sc.nextInt();
    }

    list = new ArrayList[m];
    for (int i = 0; i < m; i++) {
      list[i] = new ArrayList<>();
      int party  = sc.nextInt();
      for (int j = 0; j < party; j++) {
        list[i].add(sc.nextInt());
      }
    }

    parent = new int[n+1];
    for (int i = 0; i <=n ; i++) {
      parent[i]=i;
    }

    for (int i = 0; i < m; i++) {
      int first = list[i].get(0);
      for (int j = 1; j <list[i].size(); j++) {
        union(first,list[i].get(j));
      }
    }

    for (int i = 0; i < m; i++) {
      boolean isTrue = true;
      int cur =list[i].get(0);
      for (int j = 0; j < truePerson.length; j++) {
        if(find(cur) == find(truePerson[j])){
          isTrue = false;
          break;
        }
      }
      if(isTrue){
        result++;
      }
    }
    System.out.println(result);
  }

  private static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if(a!=b){
      parent[b] = a;
    }
  }

  private static int find(int a) {
    if(a==parent[a]){
      return a;
    }else{
      return parent[a] = find(parent[a]);
    }
  }

}
