package main.buttons;
import main.bank.Bank;
import main.deposits.Deposit;
import java.io.IOException;
import java.util.Objects;
import static main.Main.in;
import static main.bank.Bank.*;
public class FindDepositCommand implements Command {
    private final Bank theBank;
    public FindDepositCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        System.out.print("\nFind Deposit by name [1] or by percent [2]: ");
        int check = Integer.parseInt(in.nextLine());
        if(check == 1){
            System.out.print("Enter name of Deposit to find: ");
            String nameDeposit = in.nextLine();
            findByName(nameDeposit);
        }if(check == 2){
            System.out.print("Enter percent of Deposit to find: ");
            int percentDeposit = Integer.parseInt(in.nextLine());
            findByPercent(percentDeposit);
        }
    }
    private void findByName(String nameDeposit){
        for (Deposit privatDeposit : privatDeposits) {
            if (Objects.equals(privatDeposit.getName(), nameDeposit))
                System.out.println("\nPrivatBank\n" + privatDeposit);
        }for (Deposit monoDeposit : monoDeposits) {
            if (Objects.equals(monoDeposit.getName(), nameDeposit))
                System.out.println("\nMonoBank\n" + monoDeposit);
        }for (Deposit alfaDeposit : alfaDeposits) {
            if (Objects.equals(alfaDeposit.getName(), nameDeposit))
                System.out.println("\nAlfaBank\n" + alfaDeposit);
        }
    }
    private void findByPercent(int percentDeposit){
        for (Deposit privatDeposit : privatDeposits) {
            if (Objects.equals(privatDeposit.getPercent(), percentDeposit))
                System.out.println("\nPrivatBank\n" + privatDeposit);
        }for (Deposit monoDeposit : monoDeposits) {
            if (Objects.equals(monoDeposit.getPercent(), percentDeposit))
                System.out.println("\nMonoBank\n" + monoDeposit);
        }for (Deposit alfaDeposit : alfaDeposits) {
            if (Objects.equals(alfaDeposit.getPercent(), percentDeposit))
                System.out.println("\nAlfaBank\n" + alfaDeposit);
        }
    }
}