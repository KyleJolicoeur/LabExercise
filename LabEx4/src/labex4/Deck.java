package labex4;
import java.util.Stack;
public class Deck 
{
       public static final int DECK_SIZE = 52;//initial max deck size
       public static int tarotDeckSize;
       Card[] arrayDeck;
   /*********************************************************************/
       public Deck()
       { //used for normal decks
          arrayDeck = new Card[DECK_SIZE];
          tarotDeckSize = DECK_SIZE;
          for(int i=0; i<13; i++)
            { //creates the Spades cards
                arrayDeck[i] = new Card(i,"Spades");
                arrayDeck[i].setId(i);
            }
            for(int i=0; i<13; i++)
            { //creates the Clubs cards
                arrayDeck[i + 13] = new Card(i,"Clubs");
                arrayDeck[i + 13].setId(i + 13);
            }
            for(int i=0; i<13; i++)
            { //creates the Hearts cards
                arrayDeck[i + 26] = new Card(i,"Hearts");
                arrayDeck[i + 26].setId(i + 26);
            }
            for(int i=0; i<13; i++)
            { //creates the Diamonds cards
                arrayDeck[i + 39] = new Card(i,"Diamonds");
                arrayDeck[i + 39].setId(i + 39);
            }
        }
       
    public Card getCardID(int i) {
        return arrayDeck[i];
    }

    public void setArrayDeck(Card[] arrayDeck) {
        this.arrayDeck = arrayDeck;
    }
       
    public Stack shuffleDeck()
       {
            Stack randDeck = new Stack(); //creates a shuffled deck
            for(int i = 0; i < 52; i++)
            {
                int randDeckPick;//random number generator for shuffling
                randDeckPick = ((int) (Math.random()*(51 - i)));
                randDeck.push(arrayDeck[randDeckPick]);
                arrayDeck[randDeckPick] = arrayDeck[51 - i];
            }
            return randDeck;
       }
    public void display()
    {
        for(int i = 0; i < arrayDeck.length; i++)
        {
            System.out.println(arrayDeck[i].getSuit() + " " + arrayDeck[i].getId()
            + " " + arrayDeck[i].checkFaceValue());
        }
    }
}