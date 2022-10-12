package main.deposit;
import static main.Main.in;
public class Deposit {
    private String name;
    private int percent;
    private int money;
    private boolean takeMoneyBefore;
    private boolean addMoney;
    private double term;
    private String BankName;
    public Deposit(String name, int percent, int money, boolean takeMoneyBefore, boolean addMoney, double term, String BankName) {
        this.name = name;
        this.percent = percent;
        this.money = money;
        this.takeMoneyBefore = takeMoneyBefore;
        this.addMoney = addMoney;
        this.term = term;
        this.BankName = BankName;
    }
    public Deposit() {
        System.out.print("\nEnter name of Bank: ");
        this.BankName = in.nextLine();
        System.out.print("Enter name of Deposit: ");
        this.name = in.nextLine();
        System.out.print("Enter percent: ");
        this.percent = Integer.parseInt(in.nextLine());
        System.out.print("Enter money: ");
        this.money = Integer.parseInt(in.nextLine());
        System.out.print("Enter [true or false] to take money before the term: ");
        this.takeMoneyBefore = Boolean.parseBoolean(in.nextLine());
        System.out.print("Enter [true or false] to add money before the term: ");
        this.addMoney = Boolean.parseBoolean(in.nextLine());
        System.out.print("Enter term: ");
        this.term = Double.parseDouble(in.nextLine());
        System.out.println();
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getPercent() { return percent; }
    public void setPercent(int percent) { this.percent = percent; }
    public int getMoney() { return money; }
    public void setMoney(int money) { this.money = money; }
    public boolean isTakeMoneyBefore() { return takeMoneyBefore; }
    public void setTakeMoneyBefore(boolean takeMoneyBefore) { this.takeMoneyBefore = takeMoneyBefore; }
    public boolean isAddMoney() { return addMoney; }
    public void setAddMoney(boolean addMoney) { this.addMoney = addMoney; }
    public double getTerm() { return term; }
    public void setTerm(double term) { this.term = term; }
    public String getBankName() { return BankName; }
    public void setBankName(String bankName) { BankName = bankName; }
    public int profit(int percent, int money) {
        int realProfit = (money * percent)/100;
        return realProfit + money;
    }
    public int profitMinus(int percent, int money, boolean takeMoneyBefore, double term) {
        if(takeMoneyBefore){
            int realProfit = (int)(money * (percent/3*term))/100;
            if(realProfit < 0)
                realProfit = 0;
            return realProfit + money;
        }
        return profit(percent, money);
    }
    public int profitPlus(int percent, int money, boolean addMoney) {
        if(addMoney){
            int realProfit = (int)((money + (Math.random()*5000)) * percent)/100;
            if(realProfit < 0)
                realProfit = 0;
            return realProfit + money;
        }
        return profit(percent, money);
    }
    @Override
    public String toString() {
        return "|" + BankName + "\t|" + name + "\t|Percent = " + percent + "%\t|Money = " + money + " UAH\t|Term = " + term + " years\t|Profit [take money before] = " +
                profitMinus(percent,  money, takeMoneyBefore, term) + "\t |Profit [add money] = " + profitPlus(percent, money, addMoney) +
                "\t|Profit = " + profit(percent, money);
    }
}