package com.techelevator.farm;

public class Tractor implements Singable {

    private String name;
    private String sound;

    public Tractor() {
        name = "Big Green";
        sound = "vroom!";
    }

    public String getName() {
        return name;
    }

    public String getSound() {
        return sound;
    }
}