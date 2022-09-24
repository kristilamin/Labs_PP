package main.buttons;
import main.bank.Bank;
import java.io.IOException;
public class DeleteDepositCommand implements Command {
    private final Bank theBank;
    public DeleteDepositCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        theBank.deleteDeposit();
    }
}