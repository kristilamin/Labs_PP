package com.company.droid;
public class Teams {
    private final BaseDroid droid_1 = new BaseDroid("Droid 1",50,15,2,5,"-blaster-",27);
    private final BaseDroid droid_2 = new BaseDroid("Droid 2",50,30,2,10,"-lightsaber-",12);
    private final BaseDroid droid_3 = new BaseDroid("Droid 3",50,23,2,5,"-shokesaber-",32);
    private final BaseDroid droid_4 = new BaseDroid("Droid 4",50,10,10,10,"-shoker-",32);
    private final BaseDroid droid_5  = new BaseDroid("Droid 5",50,17,5,5,"-lightgun-",35);
    private final BaseDroid droid_6 = new BaseDroid("Droid 6",50,20,15,5,"-miniblaster-",42);
    private final BaseDroid droid_7 = new BaseDroid("Droid 7",50,14,0,10,"-double-blaster-",37);
    public void showFighters(){
        System.out.println("\n-----List of fighters-----\n");
        System.out.println("1. " + droid_1.getName());
        System.out.println("2. " + droid_2.getName());
        System.out.println("3. " + droid_3.getName());
        System.out.println("4. " + droid_4.getName());
        System.out.println("5. " + droid_5.getName());
        System.out.println("6. " + droid_6.getName());
        System.out.println("7. " + droid_7.getName() + "\n");
    }
    public BaseDroid getdroid_1() { return droid_1; }
    public BaseDroid getdroid_2() { return droid_2; }
    public BaseDroid getdroid_3() { return droid_3; }
    public BaseDroid getdroid_4() { return droid_4; }
    public BaseDroid getdroid_5() { return droid_5; }
    public BaseDroid getdroid_6() { return droid_6; }
    public BaseDroid getdroid_7() { return droid_7; }
}