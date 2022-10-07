package main.buttons;
import main.bank.Bank;
import java.io.IOException;
public class MainOptionsCommand implements Command {
    private final Bank theBank;
    public MainOptionsCommand(Bank bank) { this.theBank = bank; }
    @Override
    public void execute() throws IOException {
        System.out.println("\n-----Main options-----");
        System.out.println("\nPrint list of existed Banks - [1]");
        System.out.println("Create a Bank - [2]");
        System.out.println("Print list of Deposits - [3]");
        System.out.println("Sort Deposits by parameter - [4]");
        System.out.println("Create a Deposit - [5]");
        System.out.println("Delete a Deposit - [6]");
        System.out.println("Change a Deposit - [7]");
        System.out.println("Find a Deposit - [8]");
        System.out.println("Exit - [9]");
        System.out.print("\n>>>What would you like to do?  ");
    }
}