public class MainProgram {

    //The main application for working card, decks, and games
    public static void main(String[]args){

        Card myCard = new Card(2,1);
        System.out.println(myCard.toString());
        myCard.flip();
        System.out.println(myCard.toString());



    }

}
