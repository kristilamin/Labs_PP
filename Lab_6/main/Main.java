package main;
import main.bank.Bank;
import main.buttons.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Bank bank = new Bank();
        Map<Integer, Command> commands = new HashMap<>();
        commands.put(1, new ListOfBanksCommand(bank));
        commands.put(2, new CreateBankCommand(bank));
        commands.put(3, new ListOfDepositsCommand(bank));
        commands.put(4, new SortByParameterCommand(bank));
        commands.put(5,new CreateDepositCommand(bank));
        commands.put(6,new DeleteDepositCommand(bank));
        commands.put(7,new ChangeDepositCommand(bank));
        commands.put(8,new FindDepositCommand(bank));
        while (true) {
            int choice = 0;
            Scanner in = new Scanner(System.in);
            System.out.println("\n-----Main options-----");
            System.out.println("\nPrint list of existed Banks - [1]");
            System.out.println("Create a Bank - [2]");
            System.out.println("Print list of Deposits - [3]");
            System.out.println("Sort Deposits by parameter - [4]");
            System.out.println("Create a Deposit - [5]");
            System.out.println("Delete a Deposit - [6]");
            System.out.println("Change a Deposit - [7]");
            System.out.println("Find a Deposit - [8]");
            System.out.println("Exit - [9]");
            System.out.print("\n>>>What would you like to do?  ");
            try {
                choice = in.nextInt();
                if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6 && choice != 7 && choice != 8)
                    throw new IOException();
                switch (choice) {
                    case 1 ->
                        commands.get(1).execute();
                    case 2 ->
                        commands.get(2).execute();
                    case 3 ->
                        commands.get(3).execute();
                    case 4 ->
                        commands.get(4).execute();
                    case 5 ->
                        commands.get(5).execute();
                    case 6 ->
                        commands.get(6).execute();
                    case 7 ->
                        commands.get(7).execute();
                    case 8 ->
                            commands.get(8).execute();
                }
            } catch (IOException e) { break; }
        }
    }
}