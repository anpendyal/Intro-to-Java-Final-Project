//used for the player and the dealer

public class Person
{
    //attribute used to keep track of points in game
    private int totalPoints;

    //constructor
    public Person()
    {
        totalPoints = 0;
    }

    //setter for total points
    public void setTotalPoints(int newValue)
    {
        totalPoints = newValue;
    }

    public int getTotalPoints()
    {
        return totalPoints;
    }

    //hit method picks a card from the deck
    public Card hit(Deck Deck)
    {
        return Deck.pickCard();
    }
}