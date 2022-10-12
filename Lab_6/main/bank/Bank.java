package main.bank;
import main.deposit.Deposit;
import main.deposit.Contribution;
import java.util.*;
public class Bank {
    private String name;
    private static List<Deposit> allDeposits = new ArrayList<>(List.of(
            new Deposit("Yours", 15, 50000, true, true, 0.5, "PrivatBank"),
            new Deposit("Good", 25, 20000, true, true, 0.6, "PrivatBank"),
            new Deposit("Slava", 17, 10000, false, true, 1, "PrivatBank"),
            new Contribution("Free", 15, 40000, false, true,  2,"PrivatBank", true),
            new Contribution("Plus", 18, 11000, true, true,  1.5,"PrivatBank", true),
            new Deposit("Smart", 19, 30000, false, true, 0.5, "MonoBank"),
            new Deposit("Light", 20, 80000, true, true, 1, "MonoBank"),
            new Deposit("Human", 17, 12000, true, true, 1.5, "MonoBank"),
            new Contribution("Start", 21, 16000, true, true, 0.5, "MonoBank",true),
            new Deposit("Faith", 16, 42000, false, true, 0.2, "AlfaBank"),
            new Deposit("Heart", 22, 16000, false, true, 0.5, "AlfaBank"),
            new Contribution("Force", 18, 13000, true, true,  1, "AlfaBank", true),
            new Contribution("Earth", 26, 21000, true, true,  0.5, "AlfaBank", true),
            new Contribution("Light", 20, 80000, true, true,  1.5, "AlfaBank", true) ));
    private static List<Bank> allBanks = new ArrayList<>(List.of(
            new Bank("PrivatBank"),
            new Bank("MonoBank"),
            new Bank("AlfaBank") ));

    public Bank() {}
    public Bank(String name) { this.name = name; }
    @Override
    public String toString() { return name; }
    public static List<Bank> getAllBanks() { return allBanks; }
    public static void setAllBanks(List<Bank> allBanks) { Bank.allBanks = allBanks; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public static List<Deposit> getAllDeposits() { return allDeposits; }
    public static void setAllDeposits(List<Deposit> allDeposits) { Bank.allDeposits = allDeposits; }
}