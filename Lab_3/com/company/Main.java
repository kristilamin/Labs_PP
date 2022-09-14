package com.company;
import com.company.battle.Battle;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        Battle.hello();
        while (true) {
            Battle.options();
            int choose = in.nextInt();
            if (choose == 3)
                break;
            if (choose < 1 || choose > 3)
                System.out.println("\nWrong input!");
            else if (choose == 1) {
                Battle.duelFight(in);
            } else if (choose == 2)
                Battle.teamFight(in);
        }
    }
}
