package main.button;
import main.bank.Bank;
import main.bank.BankService;
import java.io.IOException;
import static main.Main.in;
import static main.bank.Bank.getAllDeposits;
public class ListOfDepositsCommand implements Command {
    private final Bank theBank;
    public ListOfDepositsCommand(Bank bank){ this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        System.out.print("\nAll Deposits [1] or Deposits of chosen Bank [2]: ");
        int choose = Integer.parseInt(in.nextLine());
        if(choose == 1){
            System.out.println();
            getAllDeposits().forEach(System.out::println);
        }if(choose == 2){
            System.out.print("\nEnter name of chosen Bank: ");
            String bankName = in.nextLine();
            System.out.println();
            BankService.showByBanks(bankName);
        }
    }
}