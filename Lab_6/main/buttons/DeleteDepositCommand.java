package main.buttons;
import main.bank.Bank;
import java.io.IOException;
import static main.Main.in;
import static main.bank.Bank.*;
public class DeleteDepositCommand implements Command {
    private final Bank theBank;
    public DeleteDepositCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        System.out.print("\nEnter number of Bank to delete from there a Deposit: ");
        int num = Integer.parseInt(in.nextLine());
        System.out.print("Enter number of Deposit: ");
        int numOfDeposit = Integer.parseInt(in.nextLine());
        System.out.println();
        if(num == 1){
            privatDeposits.remove(numOfDeposit-1);
            privatDeposits.forEach(System.out::println);
        }if(num == 2){
            monoDeposits.remove(numOfDeposit-1);
            monoDeposits.forEach(System.out::println);
        }if(num == 3){
            alfaDeposits.remove(numOfDeposit-1);
            alfaDeposits.forEach(System.out::println);
        }
    }
}