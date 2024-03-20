package 동적계획법;

import java.util.ArrayList;
import java.util.Scanner;

public class P9252 {
  static char[] s1;
  static char[] s2;
  static long[][] arr;
  static ArrayList<Character> list;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    s1 = sc.next().toCharArray();
    s2 = sc.next().toCharArray();
    arr = new long[s1.length+1][s2.length+1];
    list= new ArrayList<>();

    for (int i = 1; i <=s1.length ; i++) {
      for (int j = 1; j <=s2.length ; j++) {
        if(s1[i-1] == s2[j-1]){
          arr[i][j] = arr[i-1][j-1]+1;
        }else{
          arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
        }
      }
    }

    System.out.println(arr[s1.length][s2.length]);
    getText(s1.length, s2.length);
    for (int i = list.size()-1; i >=0 ; i--) {
      System.out.print(list.get(i));
    }
    System.out.println();
  }

  private static void getText(int r, int c) {
    if(r==0 || c==0){
      return;
    }
    if(s1[r-1] == s2[c-1]){
      list.add(s1[r-1]);
      getText(r-1,c-1);
    }else{
      if(arr[r-1][c] > arr[r][c-1]){
        getText(r-1,c);
      }else{
        getText(r,c-1);
      }
    }
  }

}
