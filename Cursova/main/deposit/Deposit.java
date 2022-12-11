package main.deposit;
public class Deposit {
    private int depositid;
    private String depositname;
    private int percent;
    private int money;
    private int term;
    private int bankid;
    public Deposit() {}
    public Deposit(int depositid, String depositname, int percent, int money, int term, int bankid) {
        this.depositid = depositid;
        this.depositname = depositname;
        this.percent = percent;
        this.money = money;
        this.term = term;
        this.bankid = bankid;
    }
    public int getDepositid() { return depositid; }
    public void setDepositid(int depositid) { this.depositid = depositid; }
    public String getDepositname() { return depositname; }
    public void setDepositname(String depositname) {this.depositname = depositname;}
    public int getPercent() {return percent;}
    public void setPercent(int percent) {this.percent = percent;}
    public int getMoney() {return money;}
    public void setMoney(int money) {this.money = money;}
    public int getTerm() {return term;}
    public void setTerm(int term) {this.term = term;}
    public int getBankid() {return bankid;}
    public void setBankid(int bankid) {this.bankid = bankid;}
    @Override
    public String toString() {
        return  depositid + ")   " + depositname + "    Percent = " + percent + "%    Money = " + money + " UAH    Term = " +
                term + " month    Bank ID = " + bankid;
    }
}