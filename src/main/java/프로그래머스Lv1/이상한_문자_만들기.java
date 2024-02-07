package 프로그래머스Lv1;

public class 이상한_문자_만들기 {
  public static String solution(String s) {
    s.toLowerCase();
    System.out.println(s);
    String answer = "";
    String[] arr = s.split(" ",-1);
    int idx = 0;
    for(String str:arr){
      String tmp = "";
      for (int i = 0; i < str.length(); i++) {
        if(i%2 != 0){
          tmp += str.substring(i,i+1).toUpperCase();
        }else {
          tmp+=str.substring(i,i+1).toLowerCase();
        }
      }
      arr[idx++] = tmp;
    }

    for (int i = 0; i < arr.length; i++) {
      if(i == arr.length-1){
        answer += arr[i];
      }else {
        answer += (arr[i]+ " ");
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(solution("try hello world"));
  }

}
