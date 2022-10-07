package main.buttons;
import main.bank.Bank;
import main.deposits.Deposit;
import java.io.IOException;
import static main.Main.in;
import static main.bank.Bank.*;
public class ChangeDepositCommand implements Command {
    private final Bank theBank;
    public ChangeDepositCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        System.out.print("\nEnter number of Bank to change its Deposit: ");
        int num = Integer.parseInt(in.nextLine());
        System.out.print("Enter number of Deposit: ");
        int numOfDeposit = Integer.parseInt(in.nextLine());
        if(num == 1){
            privatDeposits.set(numOfDeposit-1, new Deposit());
            privatDeposits.forEach(System.out::println);
        }if(num == 2){
            monoDeposits.set(numOfDeposit-1, new Deposit());
            monoDeposits.forEach(System.out::println);
        }if(num == 3){
            alfaDeposits.set(numOfDeposit-1, new Deposit());
            alfaDeposits.forEach(System.out::println);
        }
    }
}