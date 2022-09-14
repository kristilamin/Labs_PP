package com.company.droid;
public class BaseDroid {
    private String name;
    private int health;
    private int damage;
    private int heal;
    private int armor;
    private String weapon;
    private int accuracy;
    public BaseDroid(String name, int health, int damage, int heal, int armor, String weapon, int accuracy) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.heal = heal;
        this.armor = armor;
        this.weapon = weapon;
        this.accuracy = accuracy;
    }
    @Override
    public String toString() {
        return name + "\t\tDamage = " + damage + "\t\tHeal = " + heal +
                "\t\tArmor = " + armor + "\t\tAccuracy = " + accuracy + "\t\tHealth = " + health + "\t\tWeapon = " + weapon;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }
    public int getDamage() { return damage; }
    public void setDamage(int damage) { this.damage = damage; }
    public int getHeal() { return heal; }
    public void setHeal(int heal) { this.heal = heal;}
    public int getArmor() { return armor; }
    public void setArmor(int armor) { this.armor = armor; }
    public String getWeapon() { return weapon; }
    public void setWeapon(String weapon) { this.weapon = weapon; }
    public int getAccuracy() { return accuracy; }
    public void setAccuracy(int accuracy) { this.accuracy = accuracy; }
    public boolean isAlive() { return this.health > 0; }
    public int getHit(int damage,int armor,int heal,int accuracy) {
        int chance = (int) (Math.random()*30);
        if(chance < accuracy) {
            int actualDamage = (damage - armor) + heal;
            this.health -= actualDamage;
            if(health < 0)
                health = 0;
            return actualDamage;
        }
        return 0;
    }
}
