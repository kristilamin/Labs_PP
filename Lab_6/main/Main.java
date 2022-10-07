package main;
import main.bank.Bank;
import main.buttons.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        Bank bank = new Bank();
        Map<Integer, Command> commands = new HashMap<>();
        commands.put(1, new ListOfBanksCommand(bank));
        commands.put(2, new CreateBankCommand(bank));
        commands.put(3, new ListOfDepositsCommand(bank));
        commands.put(4, new SortByParameterCommand(bank));
        commands.put(5, new CreateDepositCommand(bank));
        commands.put(6, new DeleteDepositCommand(bank));
        commands.put(7, new ChangeDepositCommand(bank));
        commands.put(8, new FindDepositCommand(bank));
        commands.put(9, new MainOptionsCommand(bank));
        while (true) {
            commands.get(9).execute();
            try {
                int choice = Integer.parseInt(in.nextLine());
                if (choice == 9)
                    break;
                for(int i = 1; i <= commands.size(); i++){
                    if(choice == i)
                        commands.get(choice).execute();
                }
            } catch (IOException e) { break; }
        }
    }
}