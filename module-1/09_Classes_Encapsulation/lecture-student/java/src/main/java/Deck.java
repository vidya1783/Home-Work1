import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

    //Declare private Members
    private int cardCount;
    private List<Card>listOfCards= new ArrayList<>();

    // Declare Public Members

    //Declare Accessors

    //Declare constructors
    public Deck(){
        //Default Constructor -allows for instantiation
        this (new int[]{},new int[]{});
    }
    public Deck(int[]cardRanks, int[]cardSuits){
        this(cardRanks,cardSuits,new Card[]{});

    }
    public Deck(int[]cardRanks, int[]cardSuits,Card []additionalCards){
        for(int suit:cardSuits){
            for (int rank:cardRanks){
                //make that card!
                listOfCards.add(new Card(rank,suit));
            }
        }
        for (Card extraCard:additionalCards)
            listOfCards.add(extraCard);

    }
    this.shuffle();}

    //Declare Private Methods

    //Declare public methods
    //TODO: Deal
    public Card dealOne(){
        if(listOfCards.size()!=0){
            return listOfCards.remove(0);
        }
        else {return null;
    }}
    public String reportDeck(){
    String result="";
    for (Card c : this.listOfCards){
        result+= c.toString()+ "\n";
        }
        {return result;}}
    //TODO:Shuffle
    public void shuffle(){
        Collections.shuffle(listOfCards);
    }

    // Declare default Object Method


}
