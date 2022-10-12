package main.bank;
import main.deposit.Deposit;
import java.util.Comparator;
import java.util.Objects;
import static main.bank.Bank.getAllBanks;
import static main.bank.Bank.getAllDeposits;
public class BankService {
    // for CreateBankCommand and CreateDepositCommand
    public static void moreBanks() {
        Deposit newDeposit = new Deposit();
        int flag = 0;
        for(int i = 0; i < getAllBanks().size(); i++){
            if(Objects.equals(getAllBanks().get(i).getName(), newDeposit.getBankName())){
                flag = 1;
                break;
            }
        }
        if(flag == 0)
            getAllBanks().add(new Bank(newDeposit.getBankName()));
        getAllDeposits().add(newDeposit);
        getAllDeposits().forEach(System.out::println);
    }
    // for SortByParameterCommand
    public static void sorting(String bankName, Comparator<Deposit> comparing){
        showByBanks(bankName);
        getAllDeposits().sort(comparing);
        showByBanks(bankName);
    }
    public static void showByBanks(String bankName){
        for(int i = 0; i < getAllDeposits().size(); i++){
            if(Objects.equals(getAllDeposits().get(i).getBankName(), bankName))
                System.out.println(getAllDeposits().get(i).toString());
        }
        System.out.println();
    }
}