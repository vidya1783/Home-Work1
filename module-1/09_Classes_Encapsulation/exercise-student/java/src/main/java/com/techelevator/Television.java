package com.techelevator;

public class Television {
    private boolean isOn=false;
    private int currentChannel=3;
    private int currentVolume=2;



    public boolean isOn(){return isOn;}
    public int getCurrentChannel(){return currentChannel; }
    public int getCurrentVolume(){return currentVolume;}
     //constructor
    //Method

    public void turnOff(){this.isOn=false;}
    public void turnOn(){this.isOn=true;this.currentChannel=3;this.currentVolume=2;}
    public void changeChannel(int newChannel){if (this.isOn==true&&newChannel>=3&&newChannel<=18) this.currentChannel=newChannel;}
    public void channelUp(){
        if (this.isOn==true&&currentChannel>=3&&currentChannel<18) this.currentChannel++;
        else if(this.isOn==true&&currentChannel==18)this.currentChannel=3;
    }
    public void channelDown(){
        if (this.isOn==true&&currentChannel>3&&currentChannel<=18) this.currentChannel--;
        else if(this.isOn==true&&currentChannel==3)this.currentChannel=18;


    }
    public void raiseVolume(){
        if (this.isOn==true&&currentVolume<10)this.currentVolume++;

    }
    public void lowerVolume(){
        if (this.isOn==true&&currentVolume>0)this.currentVolume--;
    }


}
