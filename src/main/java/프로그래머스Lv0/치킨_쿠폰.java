package 프로그래머스Lv0;

public class 치킨_쿠폰 {
  public int solution(int chicken) {
    int answer = 0;
    int coupon = chicken;

    while(coupon >= 10){
      int left = coupon%10;
      answer += coupon/10;
      coupon = left + coupon/10;
    }
    return answer;
  }

}
