package main.buttons;
import main.bank.Bank;
import java.io.IOException;
public class ListOfBanksCommand implements Command {
    private final Bank theBank;
    public ListOfBanksCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        theBank.listOfBanks();
    }
}