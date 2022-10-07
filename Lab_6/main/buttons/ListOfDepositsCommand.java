package main.buttons;
import main.bank.Bank;
import java.io.IOException;
import static main.Main.in;
import static main.bank.Bank.*;
public class ListOfDepositsCommand implements Command{
    private final Bank theBank;
    public ListOfDepositsCommand(Bank bank){ this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        System.out.print("\nEnter number of Bank: ");
        int num = Integer.parseInt(in.nextLine());
        System.out.println();
        if(num == 1)
            privatDeposits.forEach(System.out::println);
        if(num == 2)
            monoDeposits.forEach(System.out::println);
        if(num == 3)
            alfaDeposits.forEach(System.out::println);
    }
}