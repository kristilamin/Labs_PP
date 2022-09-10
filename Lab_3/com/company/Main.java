package com.company;
import com.company.droid.BaseDroid;
import com.company.droid.Teams;
import com.company.battle.Battle;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.println();
        Battle.Hello();
        while (true) {
            System.out.println("\nFighter vs Fighter - [1]");
            System.out.println("Team vs Team - [2]");
            System.out.println("Exit - [3]");
            System.out.print("\nChoose battle style: ");
            int choose = in.nextInt();
            if (choose == 3)
                break;
            if (choose < 1 || choose > 3)
                System.out.println("\nWrong input!");
            else if (choose == 1) {
                Teams droid1 = new Teams();
                droid1.showFighters();
                System.out.print("Choose first fighter: ");
                int numfighter1 = in.nextInt();
                System.out.print("Choose second fighter: ");
                int numfighter2 = in.nextInt();
                BaseDroid firstDroid = Battle.chooseFighter(numfighter1, droid1);
                BaseDroid secondDroid = Battle.chooseFighter(numfighter2, droid1);
                Battle battleArena = new Battle(firstDroid, secondDroid);
                battleArena.startFight1vs1();
                Battle.Congratulation();
            } else if (choose == 2)
                Battle.teamFight(in);
        }
    }
}