package main.bank;
import main.deposits.Contribution;
import main.deposits.Deposit;
import java.util.*;
public class Bank {
    private String name;
    private Deposit deposit;
    public static List<Deposit> privatDeposits = new ArrayList<>(List.of(
            new Deposit("Deposit Yours", 15, 50000, true, true,  0.25),
            new Deposit("Deposit Good", 25, 20000, true, true,  0.25),
            new Deposit("Deposit Slava", 17, 10000, false, true,  1),
            new Contribution("Deposit Free", 15, 40000, false, true,  0.25, true),
            new Contribution("Deposit Plus", 18, 11000, true, true,  1, true) ));
    public static List<Bank> privat = new ArrayList<>(List.of(
            new Bank("PrivatBank", privatDeposits.get(0)),
            new Bank("PrivatBank", privatDeposits.get(1)),
            new Bank("PrivatBank", privatDeposits.get(2)),
            new Bank("PrivatBank", privatDeposits.get(3)),
            new Bank("PrivatBank", privatDeposits.get(4)) ));
    public static List<Deposit> monoDeposits = new ArrayList<>(List.of(
            new Deposit("Deposit Smart", 19, 30000, false, true,  0.5),
            new Deposit("Deposit Light", 20, 80000, true, true,  1),
            new Deposit("Deposit Human", 17, 10000, true, true,  1),
            new Contribution("Deposit Start", 21, 16000, true, true,  0.5, true) ));
    public static List<Bank> mono = new ArrayList<>(List.of(
            new Bank("MonoBank", monoDeposits.get(0)),
            new Bank("MonoBank", monoDeposits.get(1)),
            new Bank("MonoBank", monoDeposits.get(2)),
            new Bank("MonoBank", monoDeposits.get(3)) ));
    public static List<Deposit> alfaDeposits = new ArrayList<>(List.of(
            new Deposit("Deposit Faith", 15, 40000, false, true,  0.25),
            new Deposit("Deposit Heart", 21, 16000, false, true,  0.5),
            new Contribution("Deposit Force", 18, 11000, true, true,  1, true),
            new Contribution("Deposit Earth", 25, 20000, true, true,  0.25, true),
            new Contribution("Deposit Light", 20, 80000, true, true,  1, true) ));
    public static List<Bank> alfa = new ArrayList<>(List.of(
            new Bank("AlfaBank", alfaDeposits.get(0)),
            new Bank("AlfaBank", alfaDeposits.get(1)),
            new Bank("AlfaBank", alfaDeposits.get(2)),
            new Bank("AlfaBank", alfaDeposits.get(3)),
            new Bank("AlfaBank", alfaDeposits.get(4)) ));
    public static List<List> allBanks = new ArrayList<List>() {
        {
            add(privat);
            add(mono);
            add(alfa);
        }
    };
    public Bank(String name, Deposit deposit) {
        this.name = name;
        this.deposit = deposit;
    }
    public Bank() {}
    @Override
    public String toString() { return  name; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Deposit getDeposit() { return deposit; }
    public void setDeposit(Deposit deposit) { this.deposit = deposit; }
}