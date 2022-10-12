package main.button;
import main.bank.*;
import java.io.IOException;
import static main.Main.in;
public class CreateBankCommand implements Command {
    private final Bank theBank;
    public CreateBankCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        BankService.moreBanks();
        while (true){
            System.out.print("\n>>>Add one more Bank? [1 - yes, 0 - no]: ");
            int chose = Integer.parseInt(in.nextLine());
            if(chose == 0)
                break;
            BankService.moreBanks();
        }
    }
}