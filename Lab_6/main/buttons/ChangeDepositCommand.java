package main.buttons;
import main.bank.Bank;
import java.io.IOException;
public class ChangeDepositCommand implements Command {
    private final Bank theBank;
    public ChangeDepositCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        theBank.changeDeposit();
    }
}