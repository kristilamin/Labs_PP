package main.deposits;
public class Contribution extends Deposit {
    private final boolean valuables;
    public Contribution(String name, int percent, int money, boolean takeMoneyBefore, boolean addMoney, double term, boolean valuables) {
        super(name, percent, money, takeMoneyBefore, addMoney, term);
        this.valuables = valuables;
    }
    @Override
    public String toString(){
        return super.toString() + "\t|Valuables = " + valuables;
    }
}