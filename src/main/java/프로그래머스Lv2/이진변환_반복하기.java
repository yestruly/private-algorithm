package 프로그래머스Lv2;

public class 이진변환_반복하기 {
  public int[] solution(String s) {
    int[] answer = new int[2];

    while (!s.equals("1")){
      int zeroCnt = 0;
      for (int i = 0; i < s.length(); i++) {
        if(s.substring(i,i+1).equals("0")){
          zeroCnt++;
        }
      }

      int length = s.length()-zeroCnt;
      s = Integer.toBinaryString(length);
      answer[0]++;
      answer[1]+=zeroCnt;
    }

    return answer;
  }

}
