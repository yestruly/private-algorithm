package 기하;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17387 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long x1 = Integer.parseInt(st.nextToken());
    long y1 = Integer.parseInt(st.nextToken());
    long x2 = Integer.parseInt(st.nextToken());
    long y2 = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    long x3 = Integer.parseInt(st.nextToken());
    long y3 = Integer.parseInt(st.nextToken());
    long x4 = Integer.parseInt(st.nextToken());
    long y4 = Integer.parseInt(st.nextToken());

    boolean isTrue = isCross(x1,y1,x2,y2,x3,y3,x4,y4);
    if(isTrue){
      System.out.println("1");
    }else{
      System.out.println("0");
    }
  }

  private static boolean isCross(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
    int abc = ccw(x1,y1,x2,y2,x3,y3);
    int abd = ccw(x1, y1, x2, y2, x4, y4);
    int cda = ccw(x3, y3, x4, y4, x1, y1);
    int cdb = ccw(x3, y3, x4, y4, x2, y2);

    if(abc*abd == 0 && cda*cdb == 0 ){
      return isOverlap(x1,y1,x2,y2,x3,y3,x4,y4);
    }else if(abc*abd < 0 && cda*cdb < 0 ){
      return true;
    }
    return false;
  }

  private static boolean isOverlap(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
    if(Math.min(x1,x2) <= Math.max(x3,x4) && Math.min(x3,x4) <= Math.max(x1,x2) &&
        Math.min(y1,y2) <= Math.max(y3,y4) && Math.min(y3,y4) <= Math.max(y1,y2)){
      return true;
    }

    return false;
  }

  private static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
    long tmp = (x1*y2 + x2*y3 + x3*y1) - (x1*y3 + x2*y1 + x3*y2);
    if(tmp > 0){
      return 1;
    }else if(tmp==0){
      return 0;
    }else{
      return -1;
    }
  }


}
