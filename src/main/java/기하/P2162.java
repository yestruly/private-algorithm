package 기하;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2162 {
  static int[] parent = new int[3001];
  static int[][] lines = new int[3001][4];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());

    for (int i = 1; i <=n ; i++) {
      parent[i] = -1;
    }

    for (int i = 1; i <=n ; i++) {
      st = new StringTokenizer(br.readLine());
      lines[i][0] = Integer.parseInt(st.nextToken());
      lines[i][1] = Integer.parseInt(st.nextToken());
      lines[i][2] = Integer.parseInt(st.nextToken());
      lines[i][3] = Integer.parseInt(st.nextToken());

      for (int j = 1; j < i; j++) {
        if(isCross(lines[i][0], lines[i][1], lines[i][2],lines[i][3],
            lines[j][0], lines[j][1], lines[j][2],lines[j][3])){
          union(i,j);
        }
      }
    }

    int group = 0;
    int count = 0;
    for (int i = 1; i <=n ; i++) {
      if(parent[i]<0){
        group++;
        count = Math.min(count, parent[i]);
      }
    }
    System.out.println(group);
    System.out.println(Math.abs(count));

  }

  private static void union(int i, int j) {
    int p = find(i);
    int q = find(j);

    if (p==q){
      return;
    }
    parent[p] += parent[q];
    parent[q] = p;
  }

  private static int find(int i) {
    if(parent[i] < 0){
      return i;
    }

    return parent[i] = find(parent[i]);
  }

  private static boolean isCross(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
    int abc = ccw(x1,y1,x2,y2,x3,y3);
    int abd = ccw(x1,y1,x2,y2,x4,y4);
    int cda = ccw(x3,y3,x4,y4,x1,y1);
    int cdb = ccw(x3,y3,x4,y4,x2,y2);
    if(abc*abd == 0 && cda*cdb == 0){
      return isOverlap(x1,y1,x2,y2,x3,y3,x4,y4);
    }else if(abc*abd<=0 && cda*cdb<=0){
      return true;
    }
    return false;
  }

  private static int ccw(long x1, long y1, long x2, long y2, long x3, long y3){
    long data = (x1*y2 + x2*y3 + x3*y1) - (x2*y1 + x3*y2 + x1*y3);
    if(data > 0){
      return 1;
    }else if(data==0){
      return 0;
    }else {
      return -1;
    }
  }
  private static boolean isOverlap(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4){
    if(Math.min(x1,x2) <= Math.max(x3,x4) && Math.min(x3,x4) <= Math.max(x1,x2) &&
        Math.min(y1,y2) <= Math.max(y3,y4) && Math.min(y3,y4) <= Math.max(y1,y2)){
      return true;
    }
    return false;
  }

}
