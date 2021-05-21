//we forgot to declare the package when creating the project.....but it should be here ascom.techelevator.cards
public class Card {

    //Define the attributes of a card...card properties(Mind Encapsulation)

    private int rank;
    private int suit;
    private boolean faceDown = true;

    //Define the public accessors
    public int getRank(){
        return this.rank;
    }
    public int getSuit(){
        return this.suit;
    }
    public boolean isFaceDown(){
        return this.faceDown;
    }
    //Create a constructor so that I can instantiate a card

    public Card(int cardRank, int cardSuit){
        this.rank = cardRank;
        this.suit = cardSuit;
    }

    //Define the things that a a card can do....car methods ..it's behaviors
    public void flip(){
        this.faceDown = !this.faceDown;
    }
    //TODO: Finish the method to return the friendly name - such as Two of Diamonds
    public String cardDisplay(){
        if(this.faceDown) {
        return "Bicycle";}
        else{ return "Friendly Names of: " + this.rank + ":"+this.suit;

        }
    }

    //Default object methods
    public String toString(){
        return this.getRank()+ "of" +this.getSuit()+ "it is"+ ((this.faceDown)?"faceDown":"faceUp");}


}
