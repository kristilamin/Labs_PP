package main.user;
public class AppUser {
    private int appuserid;
    private String login;
    private String password;
    private int depositid;
    public AppUser() {}
    public AppUser(int appuserid, String login, String password, int depositid) {
        this.appuserid = appuserid;
        this.login = login;
        this.password = password;
        this.depositid = depositid;
    }
    public AppUser(int appuserid, String login, int depositid) {
        this.appuserid = appuserid;
        this.login = login;
        this.depositid = depositid;
    }
    public int getAppuserid() {return appuserid;}
    public void setAppuserid(int appuserid) {this.appuserid = appuserid;}
    public String getLogin() {return login;}
    public void setLogin(String login) {this.login = login;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public int getDepositid() {return depositid;}
    public void setDepositid(int depositid) {this.depositid = depositid;}
    @Override
    public String toString() {
        return appuserid + ") User:  " + login + "  Deposit ID = " + depositid;
    }
}