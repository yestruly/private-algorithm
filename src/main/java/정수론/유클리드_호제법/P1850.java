package 정수론.유클리드_호제법;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P1850 {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    long a = sc.nextLong();
    long b = sc.nextLong();
    long result = gcd(a, b);

    for (long i = 0; i < result; i++) {
      bw.write("1");
    }
    bw.flush();
    bw.close();
  }

  private static long gcd(long a, long b) {
    if(b==0){
      return a;
    }
    return gcd(b, a%b);
  }

}
