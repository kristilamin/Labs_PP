package main.buttons;
import main.bank.Bank;
import main.deposits.Deposit;
import java.io.IOException;
import static main.Main.in;
import static main.bank.Bank.*;
public class CreateDepositCommand implements Command {
    private final Bank theBank;
    public CreateDepositCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        System.out.print("\nEnter number of Bank to add there a Deposit: ");
        int num = Integer.parseInt(in.nextLine());
        if(num == 1){
            Deposit obj = new Deposit();
            privatDeposits.add(obj);
            privatDeposits.forEach(System.out::println);
        }if(num == 2){
            Deposit obj = new Deposit();
            monoDeposits.add(obj);
            monoDeposits.forEach(System.out::println);
        }if(num == 3){
            Deposit obj = new Deposit();
            alfaDeposits.add(obj);
            alfaDeposits.forEach(System.out::println);
        }
    }
}