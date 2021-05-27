package com.techelevator;



public class SquareWall extends RectangleWall{

   private int sideLength;


    public int getSideLength(){
        return sideLength;
    }


    public SquareWall(String name, String color) {
        super(name, color);
    }

    public SquareWall(String name, String color, int length, int height) {
        super(name, color, length, height);
    }
    public SquareWall(String name, String color, int sideLength){
        super(name,color,sideLength,sideLength);
        this.sideLength=sideLength;
        this.sideLength=sideLength;
    }

    public String toString(){
        return getName() + " (" + sideLength +'x'+ sideLength+ ") "+ "square";
    }
}
