package com.techelevator.farm;

public class Tractor implements Singable, Rideable{
    private String name= "Big Green";
    private String sound= "Vroom Vroom";

    public Tractor(String name,String sound){
        this.name=name;
        this.sound=sound;
    }
    public String getSound(){
        return this.sound;
    }
    public String getName(){
        return this.name;
    }
}
