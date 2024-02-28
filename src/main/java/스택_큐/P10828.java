package 스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P10828 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    ArrayList<Integer> stack = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String s = st.nextToken();

      if(s.equals("push")){
        int num = Integer.parseInt(st.nextToken());
        stack.add(num);
      }else if(s.equals("pop")){
        if(stack.isEmpty()){
          System.out.println("-1");
        }else{
          System.out.println(stack.remove(stack.size()-1));
        }
      }else if(s.equals("size")){
        System.out.println(stack.size());
      }else if (s.equals("empty")){
        if(stack.isEmpty()){
          System.out.println("1");
        }else{
          System.out.println("0");
        }
      } else if (s.equals("top")) {
        if(stack.isEmpty()){
          System.out.println("-1");
        }else{
          System.out.println(stack.get(stack.size()-1));
        }
      }
    }
  }

}
