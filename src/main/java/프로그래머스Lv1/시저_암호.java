package 프로그래머스Lv1;

public class 시저_암호 {
  public static String solution(String s, int n) {
    if(n>25 || n<1 || s.length() > 8000){
      return null;
    }
    String answer = "";
    char[] upper = {'A','B','C','D','E','F','G', 'H','I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    char[] lower = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    char[] arr = s.toCharArray();

    for(char c :arr){
      if(c==' '){
        answer += " ";
      }else{
        if(Character.isUpperCase(c)){
          answer += toPassword(c,upper,n);
        }else{
          answer += toPassword(c,lower, n);
        }
      }
    }
    return answer;
  }

  private static String toPassword(char c, char[] chars, int n) {
    int idx = 0;
    String str="";
    for (int i = 0; i < chars.length; i++) {
      if(c==chars[i]){
        if(i+n>= chars.length){
          idx = chars.length-(i+n);
          str += idx>=0 ? chars[idx]:chars[-idx];
        }else{
          str+=chars[i+n];
        }
      }
    }
    return str;
  }

}
