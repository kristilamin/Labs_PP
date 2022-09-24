package main.buttons;
import main.bank.Bank;
import java.io.IOException;
public class ListOfDepositsCommand implements Command{
    private final Bank theBank;
    public ListOfDepositsCommand(Bank bank){
        this.theBank = bank;
    }
    @Override
    public void execute() throws IOException {
        theBank.listOfDeposits();
    }
}