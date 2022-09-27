package main.bank;
import main.deposits.Contribution;
import main.deposits.Deposit;
import java.util.*;
public class Bank {
    private String name;
    private Deposit deposit;
    public static ArrayList<Deposit> privatDeposits = new ArrayList<>(List.of(
            new Deposit("Deposit Yours", 15, 50000, true, true,  0.25),
            new Deposit("Deposit Good", 25, 20000, true, true,  0.25),
            new Deposit("Deposit Slava", 17, 10000, false, true,  1),
            new Contribution("Deposit Free", 15, 40000, false, true,  0.25, true),
            new Contribution("Deposit Plus", 18, 11000, true, true,  1, true) ));
    public static ArrayList<Bank> privat = new ArrayList<>(List.of(
        new Bank("PrivatBank", privatDeposits.get(0)),
        new Bank("PrivatBank", privatDeposits.get(1)),
        new Bank("PrivatBank", privatDeposits.get(2)),
        new Bank("PrivatBank", privatDeposits.get(3)),
        new Bank("PrivatBank", privatDeposits.get(4)) ));
    public static ArrayList<Deposit> monoDeposits = new ArrayList<>(List.of(
            new Deposit("Deposit Smart", 19, 30000, false, true,  0.5),
            new Deposit("Deposit Light", 20, 80000, true, true,  1),
            new Deposit("Deposit Human", 17, 10000, true, true,  1),
            new Contribution("Deposit Start", 21, 16000, true, true,  0.5, true) ));
    public static ArrayList<Bank> mono = new ArrayList<>(List.of(
        new Bank("MonoBank", monoDeposits.get(0)),
        new Bank("MonoBank", monoDeposits.get(1)),
        new Bank("MonoBank", monoDeposits.get(2)),
        new Bank("MonoBank", monoDeposits.get(3)) ));
    public static ArrayList<Deposit> alfaDeposits = new ArrayList<>(List.of(
            new Deposit("Deposit Faith", 15, 40000, false, true,  0.25),
            new Deposit("Deposit Heart", 21, 16000, false, true,  0.5),
            new Contribution("Deposit Force", 18, 11000, true, true,  1, true),
            new Contribution("Deposit Earth", 25, 20000, true, true,  0.25, true),
            new Contribution("Deposit Light", 20, 80000, true, true,  1, true) ));
    public static ArrayList<Bank> alfa = new ArrayList<>(List.of(
        new Bank("AlfaBank", alfaDeposits.get(0)),
        new Bank("AlfaBank", alfaDeposits.get(1)),
        new Bank("AlfaBank", alfaDeposits.get(2)),
        new Bank("AlfaBank", alfaDeposits.get(3)),
        new Bank("AlfaBank", alfaDeposits.get(4)) ));
    public static ArrayList<ArrayList> allBanks = new ArrayList<ArrayList>() {
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
    public void mainOptions(){
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
    public void listOfBanks(){
        System.out.println("\n-----List of Banks-----\n");
        System.out.println(allBanks.get(0).get(0));
        System.out.println(allBanks.get(1).get(0));
        System.out.println(allBanks.get(2).get(0));
        if(allBanks.size() > 3)
            System.out.println(allBanks.get(3).get(0));
        if(allBanks.size() > 4)
            System.out.println(allBanks.get(4).get(0));
    }
    public void listOfDeposits(){
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter number of Bank: ");
        int num = in.nextInt();
        System.out.println();
        if(num == 1)
            privatDeposits.forEach(System.out::println);
        if(num == 2)
            monoDeposits.forEach(System.out::println);
        if(num == 3)
            alfaDeposits.forEach(System.out::println);
    }
    public void sortByParameter(){
        Scanner in = new Scanner(System.in);
        System.out.print("Sort Deposits by percent [1] or by money [2]: ");
        int choose = in.nextInt();
        System.out.print("Enter number of Bank: ");
        int num = in.nextInt();
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
    public void createDeposit(){
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter number of Bank to add there a Deposit: ");
        int num = in.nextInt();
        if(num == 1){
            Deposit obj = new Deposit();
            privatDeposits.add(obj);
            privatDeposits.forEach(System.out::println);
        }if(num == 2){
            Deposit obj = new Deposit();
            monoDeposits.add(obj);
            monoDeposits.forEach(System.out::println);
        }if(num == 3){
            Deposit obj = new Deposit();
            alfaDeposits.add(obj);
            alfaDeposits.forEach(System.out::println);
        }
    }
    public void deleteDeposit(){
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter number of Bank to delete from there a Deposit: ");
        int num = in.nextInt();
        System.out.print("Enter number of Deposit: ");
        int numOfDeposit = in.nextInt();
        System.out.println();
        if(num == 1){
            privatDeposits.remove(numOfDeposit-1);
            privatDeposits.forEach(System.out::println);
        }if(num == 2){
            monoDeposits.remove(numOfDeposit-1);
            monoDeposits.forEach(System.out::println);
        }if(num == 3){
            alfaDeposits.remove(numOfDeposit-1);
            alfaDeposits.forEach(System.out::println);
        }
    }
    public void changeDeposit(){
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter number of Bank to change its Deposit: ");
        int num = in.nextInt();
        System.out.print("Enter number of Deposit: ");
        int numOfDeposit = in.nextInt();
        if(num == 1){
            privatDeposits.set(numOfDeposit-1, new Deposit());
            privatDeposits.forEach(System.out::println);
        }if(num == 2){
            monoDeposits.set(numOfDeposit-1, new Deposit());
            monoDeposits.forEach(System.out::println);
        }if(num == 3){
            alfaDeposits.set(numOfDeposit-1, new Deposit());
            alfaDeposits.forEach(System.out::println);
        }
    }
    public void createBank(){
        Scanner forInt = new Scanner(System.in);
        Scanner forLine = new Scanner(System.in);
        ArrayList<Bank> newBank = new ArrayList<>();
        ArrayList<Bank> newBank2 = new ArrayList<>();
        int chose = 1, repeat = 0;
        System.out.print("\nEnter name of Bank: ");
        String nameOfBank = forLine.nextLine();
        getMoreDeposits(forInt, newBank, repeat, nameOfBank);
        allBanks.add(newBank);
        System.out.print("\n>>>One more Bank? [1 - yes, 0 - no]: ");
        chose = forInt.nextInt();
        if(chose == 1){
            System.out.print("\nEnter name of Bank: ");
            String nameOfBank2 = forLine.nextLine();
            getMoreDeposits(forInt, newBank2, repeat, nameOfBank2);
            allBanks.add(newBank2);
        }
    }
    private void getMoreDeposits(Scanner forInt, ArrayList<Bank> newBank, int repeat, String nameOfBank) {
        int chose;
        enteringDepositData(newBank, nameOfBank, repeat);
        while (true){
            System.out.print("\n>>>Add one more Deposit? [1 - yes, 0 - no]: ");
            chose = forInt.nextInt();
            if(chose == 0)
                break;
            repeat++;
            enteringDepositData(newBank, nameOfBank, repeat);
        }
    }
    private void enteringDepositData(ArrayList<Bank> newBank, String nameOfBank, int repeat) {
        Bank bank = new Bank(nameOfBank, new Deposit());
        newBank.add(bank);
        for(int i = 0; i <= repeat; i++)
            System.out.println(newBank.get(i).deposit);
    }
    public void findDeposit(){
        Scanner forInt = new Scanner(System.in);
        Scanner forLine = new Scanner(System.in);
        System.out.print("\nFind Deposit by name [1] or by percent [2]: ");
        int check = forInt.nextInt();
        if(check == 1){
            System.out.print("Enter name of Deposit to find: ");
            String nameDeposit = forLine.nextLine();
            for (Deposit privatDeposit : privatDeposits) {
                if (Objects.equals(privatDeposit.getName(), nameDeposit))
                    System.out.println("\nPrivatBank\n" + privatDeposit);
            }
            for (Deposit monoDeposit : monoDeposits) {
                if (Objects.equals(monoDeposit.getName(), nameDeposit))
                    System.out.println("\nMonoBank\n" + monoDeposit);
            }
            for (Deposit alfaDeposit : alfaDeposits) {
                if (Objects.equals(alfaDeposit.getName(), nameDeposit))
                    System.out.println("\nAlfaBank\n" + alfaDeposit);
            }
        }if(check == 2){
            System.out.print("Enter percent of Deposit to find: ");
            int percentDeposit = forInt.nextInt();
            for (Deposit privatDeposit : privatDeposits) {
                if (Objects.equals(privatDeposit.getPercent(), percentDeposit))
                    System.out.println("\nPrivatBank\n" + privatDeposit);
            }
            for (Deposit monoDeposit : monoDeposits) {
                if (Objects.equals(monoDeposit.getPercent(), percentDeposit))
                    System.out.println("\nMonoBank\n" + monoDeposit);
            }
            for (Deposit alfaDeposit : alfaDeposits) {
                if (Objects.equals(alfaDeposit.getPercent(), percentDeposit))
                    System.out.println("\nAlfaBank\n" + alfaDeposit);
            }
        }
    }
}