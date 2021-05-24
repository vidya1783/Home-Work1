package com.techelevator;

public class FruitTree {

    //Instance variables -->private members
    private String typeOfFruit;
    private int  piecesOfFruitLeft;

    //Accessors
    public String getTypeOfFruit(){return typeOfFruit;}
    public int getPiecesOfFruitLeft(){return piecesOfFruitLeft;}

    public FruitTree (String typeOfFruit, int startingpiecesOfFruit){
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft=startingpiecesOfFruit;
    }
    public boolean pickFruit(int numberOfPiecesToRemove ){
        if (piecesOfFruitLeft>=numberOfPiecesToRemove){
            piecesOfFruitLeft -= numberOfPiecesToRemove;
            return true;}

        else {return false;}


    }

}
