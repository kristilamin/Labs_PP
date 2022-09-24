package main.buttons;
import main.bank.Bank;
import java.io.IOException;
public class SortByParameterCommand implements Command {
    private final Bank theBank;
    public SortByParameterCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        theBank.sortByParameter();
    }
}