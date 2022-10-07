package main.buttons;
import main.bank.Bank;
import main.deposits.Deposit;
import java.io.IOException;
import java.util.Comparator;
import static main.Main.in;
import static main.bank.Bank.*;
public class SortByParameterCommand implements Command {
    private final Bank theBank;
    public SortByParameterCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        System.out.print("\nSort Deposits by percent [1] or by money [2]: ");
        int choose = Integer.parseInt(in.nextLine());
        System.out.print("\nEnter number of Bank: ");
        int num = Integer.parseInt(in.nextLine());
        if(choose == 1){
            System.out.println("\nDeposits sorted by percent:\n");
            sorting(num, Comparator.comparing(Deposit::getPercent));
        }else if (choose == 2){
            System.out.println("\nDeposits sorted by money:\n");
            sorting(num, Comparator.comparing(Deposit::getMoney));
        }
    }
    private void sorting(int num, Comparator<Deposit> comparing){
        if(num == 1){
            privatDeposits.forEach(System.out::println);
            System.out.println();
            privatDeposits.sort(comparing);
            privatDeposits.forEach(System.out::println);
        }if(num == 2){
            monoDeposits.forEach(System.out::println);
            System.out.println();
            monoDeposits.sort(comparing);
            monoDeposits.forEach(System.out::println);
        }if(num == 3){
            alfaDeposits.forEach(System.out::println);
            System.out.println();
            alfaDeposits.sort(comparing);
            alfaDeposits.forEach(System.out::println);
        }
    }
}