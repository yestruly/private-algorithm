package 프로그래머스Lv1;

import java.util.Arrays;

public class 카드_뭉치 {
  public static String solution(String[] cards1, String[] cards2, String[] goal) {
    String answer = "";
    String[] cards = new String[goal.length];

    int idx1 = 0;
    int idx2 = 0;
    int cardIdx = 0;

    while (cardIdx != cards.length){
      if(idx1 < cards1.length){
        cards[cardIdx++] = cards1[idx1++];
      }
      if(idx2 < cards2.length){
        cards[cardIdx++] = cards2[idx2++];
      }
      System.out.println(Arrays.toString(cards));
    }

    for (int i = 0; i < goal.length; i++) {
      if(!goal[i].equals(cards[i])){
        return "No";
      }
    }
    return "Yes";
  }

  public static void main(String[] args) {
    System.out.println(solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
  }

}
