package 스택_큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;
import javax.sound.midi.Soundbank;

public class P1264 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    Queue<Integer> queue = new LinkedList<>();
    IntStream.range(1, n+1).forEach(x -> queue.add(x));

    while (queue.size() > 1){
      queue.remove();
      queue.add(queue.remove());
    }

    System.out.println(queue.remove());
  }

}
