package com.techelevator;

public class Elevator {
  private int currentFloor=1;
  private int numberOfFloors;
  private boolean doorOpen;


  public int getCurrentFloor(){return currentFloor;}
  public int getNumberOfFloors(){ return numberOfFloors;}
  public boolean isDoorOpen(){return doorOpen;}




  public Elevator(int numberOfFloors){
    this.numberOfFloors=numberOfFloors; }

    public void openDoor(){if (!doorOpen) this.doorOpen=true;}
    public void closeDoor(){if (doorOpen)this.doorOpen=false;}
    public void goUp(int desiredFloor){if(!doorOpen&&desiredFloor<=numberOfFloors&&desiredFloor>currentFloor)
      this.currentFloor=desiredFloor;
             }
    public void goDown(int desiredFloor){if(!doorOpen&&desiredFloor>0&& desiredFloor<currentFloor)
      this.currentFloor=desiredFloor;}


}
