package main.button;
import main.bank.Bank;
import main.deposit.Deposit;
import java.io.IOException;
import static main.Main.in;
import static main.bank.Bank.getAllDeposits;
public class ChangeDepositCommand implements Command {
    private final Bank theBank;
    public ChangeDepositCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        System.out.println("\nExisted Deposits:\n");
        getAllDeposits().forEach(System.out::println);
        System.out.print("\nEnter number of Deposit to change: ");
        int num = Integer.parseInt(in.nextLine());
        getAllDeposits().set(num-1, new Deposit());
        getAllDeposits().forEach(System.out::println);
    }
}