package main.button;
import main.bank.Bank;
import java.io.IOException;
import static main.bank.Bank.getAllBanks;
public class ListOfBanksCommand implements Command {
    private final Bank theBank;
    public ListOfBanksCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        System.out.println("\n-----List of Banks-----\n");
        getAllBanks().forEach(System.out::println);
    }
}