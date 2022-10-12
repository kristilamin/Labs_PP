package main.button;
import main.bank.Bank;
import main.deposit.Deposit;
import java.io.IOException;
import java.util.Comparator;
import static main.Main.in;
import static main.bank.BankService.sorting;
public class SortByParameterCommand implements Command {
    private final Bank theBank;
    public SortByParameterCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        System.out.print("\nSort Deposits by percent [1] or by money [2]: ");
        int choose = Integer.parseInt(in.nextLine());
        System.out.print("\nEnter name of Bank to sort its Deposits: ");
        String bankName = in.nextLine();
        if(choose == 1){
            System.out.println("\nDeposits sorted by percent:\n");
            sorting(bankName,Comparator.comparing(Deposit::getPercent));
        }else if (choose == 2){
            System.out.println("\nDeposits sorted by money:\n");
            sorting(bankName, Comparator.comparing(Deposit::getMoney));
        }
    }
}