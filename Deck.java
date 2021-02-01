//used to create a deck full of card objects

import java.util.Random;

public class Deck
{
    public Card[] Deck = new Card[52]; //creates Deck array full of 52 Card objects
    public String[] suiteOrder = {"Clubs","Spades","Hearts","Diamonds"}; //suite array that will be used to create the deck
    public String[] numberOrder = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"}; //number array that will be used to create the deck
    public static int pickedCardsCounter = 0; //attribute that keeps track of how many cards have been picked

    //populate deck method
    public void populateDeck()
    {
        int i = 0;
        //uses two loops to create 52 cards
        for (int j = 0; j < 4; j++)
        {
            for (int q = 0; q < 13; q++)
            {
                Card temp_card = new Card();
                temp_card.setSuite(suiteOrder[j]);
                temp_card.setNumber(numberOrder[q]);
                Deck[i] = temp_card;
                i++;
            }
        }
    }

    //getter method
    public Card[] getDeck()
    {
        return Deck;
    }

    //getter method for length
    public int getLength()
    {
        return Deck.length;
    }

    //picks a random number and matches it to card, makes sure the card won't be picked twice
    public Card pickCard()
    {
        Random rand = new Random();
        int randomNum = rand.nextInt(52);
  
        while (Deck[randomNum].getHasBeenPicked())
        {
            randomNum = rand.nextInt(52);
        }

        Deck[randomNum].setHasBeenPicked(true);
        pickedCardsCounter++;
        return Deck[randomNum]; 
    }

    //resets all hasBeenPicked
    public void reshuffleDeck()
    {
        for (int r = 0; r < 52; r++)
        {
            Deck[r].setHasBeenPicked(false);
        }
    }
}