package main.button;
import main.bank.Bank;
import java.io.IOException;
import java.util.Objects;
import static main.Main.in;
import static main.bank.Bank.getAllDeposits;
public class FindDepositCommand implements Command {
    private final Bank theBank;
    public FindDepositCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        System.out.print("\nFind Deposit by name [1] or by percent [2]: ");
        int check = Integer.parseInt(in.nextLine());
        if(check == 1){
            System.out.print("\nEnter name of Deposit to find: ");
            String nameDeposit = in.nextLine();
            System.out.println();
            for(int i = 0; i < getAllDeposits().size(); i++){
                if(Objects.equals(getAllDeposits().get(i).getName(), nameDeposit))
                    System.out.println(getAllDeposits().get(i).toString());
            }
        }if(check == 2){
            System.out.print("\nEnter percent of Deposit to find: ");
            int percentDeposit = Integer.parseInt(in.nextLine());
            System.out.println();
            for(int i = 0; i < getAllDeposits().size(); i++){
                if(getAllDeposits().get(i).getPercent() == percentDeposit)
                    System.out.println(getAllDeposits().get(i).toString());
            }
        }
    }
}