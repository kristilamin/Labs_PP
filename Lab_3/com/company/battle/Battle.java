package com.company.battle;
import com.company.droid.BaseDroid;
import com.company.droid.Teams;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Battle {
    private final BaseDroid firstDroid;
    private final BaseDroid secondDroid;
    private BaseDroid attacker;
    private BaseDroid target;
    private int currentRound = 0;
    public Battle(BaseDroid firstDroid, BaseDroid secondDroid){
        this.firstDroid = firstDroid;
        this.secondDroid = secondDroid;
    }
    public int startFight1vs1() throws InterruptedException {
        int check;
        do {
            printInfo();
            check = setOpponents();
            int damage = attacker.getDamage();
            int armor = target.getArmor();
            int heal = target.getHeal();
            int accuracy = attacker.getAccuracy();
            int actualDamage = target.getHit(damage, armor, heal, accuracy);
            System.out.println("[Target] " + target.getName() + " was hit by [Attacker] " + attacker.getName() + " by weapon " + attacker.getWeapon() +
                    " with damage = " + actualDamage + "\n" + target.getName() + " health = " + target.getHealth() + "\n" + attacker.getName() +
                    " health = " + attacker.getHealth());

            TimeUnit.SECONDS.sleep(1);
        } while (target.isAlive());
        System.out.println("\n------The winner is " + attacker.getName() + "------");
        return check;
    }
    private void printInfo() {
        currentRound++;
        System.out.println("_______________________________________________________________________________________________");
        System.out.println("Round " + currentRound);
    }
    private int setOpponents() {
        if (new Random().nextBoolean()) {
            attacker = firstDroid;
            target = secondDroid;
            return 1;
        } else {
            attacker = secondDroid;
            target = firstDroid;
            return 2;
        }
    }
    public static BaseDroid chooseFighter(int number, Teams droid1){
        switch (number) {
            case 1:
                return droid1.getdroid_1();
            case 2:
                return droid1.getdroid_2();
            case 3:
                return droid1.getdroid_3();
            case 4:
                return droid1.getdroid_4();
            case 5:
                return droid1.getdroid_5();
            case 6:
                return droid1.getdroid_6();
            case 7:
                return droid1.getdroid_7();
            default:
                System.out.println("\nWrong input! [automatically chosen Droid 1]");
                return droid1.getdroid_1();
        }
    }
    public static void teamFight(Scanner in) throws InterruptedException {
        Teams droid1 = new Teams();
        droid1.showFighters();
        ArrayList<Integer> firstTeam = new ArrayList<>();
        ArrayList<Integer> secondTeam = new ArrayList<>();
        System.out.print("Choose fighters for team 1 [end - other number]: ");
        addFighters(in, firstTeam);
        System.out.print("Choose fighters for team 2 [end - other number]: ");
        addFighters(in, secondTeam);
        int checker1 = 0;
        int checker2 = 0;
        if (firstTeam.size() != secondTeam.size()) {
            System.out.println("\nTeams are not equal!");
        } else {
            for (int i = 0; i < firstTeam.size(); i++) {
                BaseDroid firstDroid = chooseFighter(firstTeam.get(i), droid1);
                BaseDroid secondDroid = chooseFighter(secondTeam.get(i), droid1);
                Battle battleArena = new Battle(firstDroid, secondDroid);
                int winner = battleArena.startFight1vs1();
                if (winner == 1) {
                    checker1++;
                } else {
                    checker2++;
                }
            }if (checker1 > checker2) {
                System.out.println("\n---------First team won!---------");
                System.out.println("\n*******************************************************************************************************\n");
                Congratulation();
            } else if (checker2 > checker1) {
                System.out.println("\n---------Second team won!---------");
                System.out.println("\n*******************************************************************************************************\n");
                Congratulation();
            } else {
                System.out.println("\n------------Draw!------------");
                System.out.println("\n*******************************************************************************************************\n");
            }
        }
    }
    private static void addFighters(Scanner in, ArrayList<Integer> firstTeam){
        while (in.hasNextInt()) {
            int adder = in.nextInt();
            if (adder > 7 || adder < 1)
                break;
            firstTeam.add(adder);
        }
    }
    public static void Hello(){
        System.out.println("""
██╗░░██╗███████╗██╗░░░░░██╗░░░░░░█████╗░
██║░░██║██╔════╝██║░░░░░██║░░░░░██╔══██╗
███████║█████╗░░██║░░░░░██║░░░░░██║░░██║
██╔══██║██╔══╝░░██║░░░░░██║░░░░░██║░░██║
██║░░██║███████╗███████╗███████╗╚█████╔╝
╚═╝░░╚═╝╚══════╝╚══════╝╚══════╝░╚════╝░
                """);
    }
    public static void Congratulation(){
        System.out.println("""

                ░░░░░░░░░░▄▄▄▄▄▄▄░░░░░░░░░░
                ░░░░░░▄▄▀▀░░░░░░░▀▀▄▄░░░░░░
                ░░░░▄▀░░░░░░░░░░░░░░░▀▄░░░░
                ░░░▄▀░░░▄▄▄▄▄▄▄▄▄▄▄░░░░█░░░
                ░░█░░▄███████████████▄░░█░░
                ░█░░▄██▀░▄▄▀███▀▄▄░▀███░░█░
                ░█░░▀█████████████████▀░░█░
                ░█░░░░▀▀████████████▀░░░░█░
                ░░█░░░░░░░░▀▀▀▀▀░░░░░░░▄▀░░
                ░░░▀▀▄▄▄▄░░░░░░░░░▄▄▄▀▀░░░░
                ░░▄██▀▄▄▄█▀▀▀▀▀▀▀█▄▄▄▀██▄░░
                ░▄▀██░░░░░▀▀▀▀▀▀▀░░░░░██▀▄░
                █░░██░░░░░░░░░░░░░░░░░██░░█
                █░░██░░░░░░░░░░░░░░░░░██░░█
                █░░██░░░░░░░░░░░░░░░░░██░░█
                █░░██░░░░░░░░░░░░░░░░░██░░█
                █░░██░░░░░░░░░░░░░░░░░██░░█
                █░░██▄░░░░░░░░░░░░░░░▄██░░█
                ▀▀▄█░█▄▄▄▄░░░░░░░▄▄▄▄█░█▄▀▀
                ░░░░░░░░░█▄▄▄▄▄▄▄█░░░░░░░░░
                ░░░░░░░░░░░░░░░░░░░░░░░░░░░
                """);
    }
}