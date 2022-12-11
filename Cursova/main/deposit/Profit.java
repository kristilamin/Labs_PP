package main.deposit;
public class Profit {
    private int profitid;
    private int depositid;
    private int realprofit;
    private int takemoneybeforeprofit;
    private int addmoneyprofit;
    public Profit(int profitid, int depositid, int realprofit, int takemoneybeforeprofit, int addmoneyprofit) {
        this.profitid = profitid;
        this.depositid = depositid;
        this.realprofit = realprofit;
        this.takemoneybeforeprofit = takemoneybeforeprofit;
        this.addmoneyprofit = addmoneyprofit;
    }
    public int getProfitid() {return profitid;}
    public void setProfitid(int profitid) {this.profitid = profitid;}
    public int getDepositid() {return depositid;}
    public void setDepositid(int depositid) {this.depositid = depositid;}
    public int getRealprofit() {return realprofit;}
    public void setRealprofit(int realprofit) {this.realprofit = realprofit;}
    public int getTakemoneybeforeprofit() {return takemoneybeforeprofit;}
    public void setTakemoneybeforeprofit(int takemoneybeforeprofit) {this.takemoneybeforeprofit = takemoneybeforeprofit;}
    public int getAddmoneyprofit() {return addmoneyprofit;}
    public void setAddmoneyprofit(int addmoneyprofit) {this.addmoneyprofit = addmoneyprofit;}
    @Override
    public String toString() {
        return profitid + ") Profit = " + realprofit + "   Profit [take money before] = " + takemoneybeforeprofit +
                "    Profit [add money] = " + addmoneyprofit;
    }
}