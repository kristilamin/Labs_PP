package main.buttons;
import main.bank.Bank;
import java.io.IOException;
public class CreateDepositCommand implements Command {
    private final Bank theBank;
    public CreateDepositCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        theBank.createDeposit();
    }
}