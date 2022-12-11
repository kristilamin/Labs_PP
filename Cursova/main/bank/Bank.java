package main.bank;
public class Bank {
    private int bankid;
    private String bankname;
    public Bank() {}
    public Bank(int bankid, String bankname) {
        this.bankid = bankid;
        this.bankname = bankname;
    }
    public int getBankid() {return bankid;}
    public void setBankid(int bankid) {this.bankid = bankid;}
    public String getBankname() {return bankname;}
    public void setBankname(String bankname) {this.bankname = bankname;}
    @Override
    public String toString() { return bankid + ") " + bankname; }
}