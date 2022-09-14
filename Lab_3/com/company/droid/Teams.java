package com.company.droid;
public class Teams {
    public static BaseDroid[] droids = { new BaseDroid("Droid 1",50,15,2,5,"-blaster-",27),
                                   new BaseDroid("Droid 2",50,30,2,10,"-lightsaber-",12),
                                   new BaseDroid("Droid 3",50,23,2,5,"-shokesaber-",32),
                                   new BaseDroid("Droid 4",50,10,10,10,"-shoker-",32),
                                   new BaseDroid("Droid 5",50,17,5,5,"-lightgun-",35),
                                   new BaseDroid("Droid 6",50,20,15,5,"-miniblaster-",42),
                                   new BaseDroid("Droid 7",50,14,0,10,"-double-blaster-",37)};
    public void showFighters(){
        System.out.println("\n-----List of fighters-----\n");
        for (int i = 0; i < droids.length; i++){
            System.out.println(i+1 + ". " + droids[i].toString());
        }
        System.out.println();
    }
}
