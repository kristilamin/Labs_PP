package main.buttons;
import main.bank.Bank;
import java.io.IOException;
public class CreateBankCommand implements Command {
    private final Bank theBank;
    public CreateBankCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        theBank.createBank();
    }
}