package 프로그래머스Lv1;

public class 시저_암호 {
  public static String solution(String s, int n) {
    if(n>25 || n<1 || s.length() > 8000){
      return null;
    }
    String answer = "";
    char[] arr = s.toCharArray();

    for(char c :arr){
      if(c==' '){
        answer += " ";
      }else{
        c +=n;
        System.out.println(c);
        if ((c>'Z' && c<'a') || c>'z'){
          c -=26;
          answer+= c;
        }else{
          answer+= c;
        }

      }
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println((int)'z'-'a');
    System.out.println((int)'Z'+" "+(int)'@');
    System.out.println(solution("ABCDEFGHIJKLMNOPQRSTUVWXYZ",25));
  }

}
