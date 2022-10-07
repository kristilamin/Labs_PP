package main.buttons;
import main.bank.Bank;
import main.deposits.Deposit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static main.Main.in;
import static main.bank.Bank.*;
public class CreateBankCommand implements Command {
    private final Bank theBank;
    public CreateBankCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        List<Bank> newBank = new ArrayList<>();
        List<Bank> newBank2 = new ArrayList<>();
        int chose = 1, repeat = 0;
        System.out.print("\nEnter name of Bank: ");
        String nameOfBank = in.nextLine();
        getMoreDeposits(newBank, repeat, nameOfBank);
        allBanks.add(newBank);
        System.out.print("\n>>>One more Bank? [1 - yes, 0 - no]: ");
        chose = Integer.parseInt(in.nextLine());
        if(chose == 1){
            System.out.print("\nEnter name of Bank: ");
            String nameOfBank2 = in.nextLine();
            getMoreDeposits(newBank2, repeat, nameOfBank2);
            allBanks.add(newBank2);
        }
    }
    private void getMoreDeposits(List<Bank> newBank, int repeat, String nameOfBank) {
        int chose;
        enteringDepositData(newBank, nameOfBank, repeat);
        while (true){
            System.out.print("\n>>>Add one more Deposit? [1 - yes, 0 - no]: ");
            chose = Integer.parseInt(in.nextLine());
            if(chose == 0)
                break;
            repeat++;
            enteringDepositData(newBank, nameOfBank, repeat);
        }
    }
    private void enteringDepositData(List<Bank> newBank, String nameOfBank, int repeat) {
        Bank bank = new Bank(nameOfBank, new Deposit());
        newBank.add(bank);
        for(int i = 0; i <= repeat; i++)
            System.out.println(newBank.get(i).getDeposit());
    }
}