package main.deposits;
public class Contribution extends Deposit {
    private final boolean valuables;
    public Contribution(String name, int percent, int money, boolean takeMoneyBefore, boolean addMoney, double term, boolean valuables) {
        super(name, percent, money, takeMoneyBefore, addMoney, term);
        this.valuables = valuables;
    }
    @Override
    public String toString() {
        return "|" + super.getName() + "\t|Percent = " + super.getPercent() + "%\t|Money = " + super.getMoney() + " UAH\t|Term = " +
                super.getTerm() + " years\t|Profit [take money before] = " +
                profitMinus(super.getPercent(), super.getMoney(), super.isTakeMoneyBefore(), super.getTerm()) + "\t |Profit [add money] = " +
                profitPlus(super.getPercent(), super.getMoney(), super.isAddMoney()) + "\t|Profit = " +
                profit(super.getPercent(), super.getMoney()) + "\t|Valuables = " + valuables;
    }
}