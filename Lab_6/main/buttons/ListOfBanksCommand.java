package main.buttons;
import main.bank.Bank;
import java.io.IOException;
import static main.bank.Bank.*;
public class ListOfBanksCommand implements Command {
    private final Bank theBank;
    public ListOfBanksCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        System.out.println("\n-----List of Banks-----\n");
        System.out.println(allBanks.get(0).get(0));
        System.out.println(allBanks.get(1).get(0));
        System.out.println(allBanks.get(2).get(0));
        if(allBanks.size() > 3)
            System.out.println(allBanks.get(3).get(0));
        if(allBanks.size() > 4)
            System.out.println(allBanks.get(4).get(0));
    }
}