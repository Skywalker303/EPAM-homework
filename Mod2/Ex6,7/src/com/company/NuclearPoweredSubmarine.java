package com.company;

public class NuclearPoweredSubmarine implements Swimable {
    String compartments;
    String superstructure;
    String nuclearWeapon;

    /**
     * @author Bogous A.
     * @return output
     */
    @Override
    public void swim() {
       System.out.println("swim across the ocean");
    }

    public class EngineForNuclearPoweredSubmarine {
        String steamGenerator;
        String steamTurbinePlant;
    }

}