package main.buttons;
import main.bank.Bank;
import java.io.IOException;
public class FindDepositCommand implements Command {
    private final Bank theBank;
    public FindDepositCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        theBank.findDeposit();
    }
}