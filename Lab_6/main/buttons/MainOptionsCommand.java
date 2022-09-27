package main.buttons;
import main.bank.Bank;
import java.io.IOException;
public class MainOptionsCommand implements Command {
    private final Bank theBank;
    public MainOptionsCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        theBank.mainOptions();
    }
}