package labex4;

import java.util.Stack;

public class TarotDeck extends Deck
{
    int deckSize;
    Stack tarotStack;
    
    public TarotDeck()
    {
        deckSize = 56; 
        
        
        arrayDeck = new Card[deckSize];
          for(int i=0; i<13; i++)
            { //creates the Spades cards
                arrayDeck[i] = new Card(i,"Swords");
                arrayDeck[i].setId(i);
            }
        arrayDeck[13] = new Card(14,"Swords");
        arrayDeck[13].setId(13);
            for(int i=0; i<13; i++)
            { //creates the Clubs cards
                arrayDeck[i + 14] = new Card(i,"Wands");
                arrayDeck[i + 14].setId(i + 14);
            }
        arrayDeck[27] = new Card(14, "Wands");
        arrayDeck[27].setId(27);
            for(int i=0; i<13; i++)
            { //creates the Hearts cards
                arrayDeck[i + 28] = new Card(i,"Coins");
                arrayDeck[i + 28].setId(i + 28);
            }
        arrayDeck[41] = new Card(14, "Coins");
        arrayDeck[41].setId(41);
            for(int i=0; i<13; i++)
            { //creates the Diamonds cards
                arrayDeck[i + 42] = new Card(i,"Cups");
                arrayDeck[i + 42].setId(i + 42);
            }
        arrayDeck[55] = new Card(14, "Cups");
        arrayDeck[55].setId(55);
    }
    public Stack getStack()
    {
       
        Stack randDeck = new Stack(); //creates a shuffled deck
        for(int i = 0; i < 52; i++)
        {
            int randDeckPick;//random number generator for shuffling
            randDeckPick = ((int) (Math.random()*(55 - i)));
            randDeck.push(arrayDeck[randDeckPick]);
            arrayDeck[randDeckPick] = arrayDeck[55 - i];
        }
        return randDeck;
       
    }
}
