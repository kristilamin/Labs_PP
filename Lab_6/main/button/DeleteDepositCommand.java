package main.button;
import main.bank.Bank;
import java.io.IOException;
import static main.Main.in;
import static main.bank.Bank.getAllDeposits;
public class DeleteDepositCommand implements Command {
    private final Bank theBank;
    public DeleteDepositCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        System.out.println("\nExisted Deposits:\n");
        getAllDeposits().forEach(System.out::println);
        System.out.print("\nEnter number of Deposit to delete: ");
        int num = Integer.parseInt(in.nextLine());
        getAllDeposits().remove(num-1);
        System.out.println();
        getAllDeposits().forEach(System.out::println);
    }
}