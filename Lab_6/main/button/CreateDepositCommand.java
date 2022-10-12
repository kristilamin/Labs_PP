package main.button;
import main.bank.Bank;
import main.bank.BankService;
import java.io.IOException;
public class CreateDepositCommand implements Command {
    private final Bank theBank;
    public CreateDepositCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        BankService.moreBanks();
    }
}