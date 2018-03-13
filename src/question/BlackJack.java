package question;

import java.util.Arrays;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] my_cards = Arrays.asList(line.split(" ")).stream().mapToInt(Integer::parseInt).toArray();

        if(my_cards[0] == 0) {
            System.out.print("1"); // 賭けチップ数

        } else {
            int card_total = Arrays.stream(my_cards).sum();
            if(card_total < 16){ // ★カードを引く条件の合計値を変えてみよう！★
                System.out.print("HIT");// カード引く
            } else {
                System.out.print("STAND");// 勝負
            }
        }
    }
}
