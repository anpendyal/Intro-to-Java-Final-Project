//Project 2
//Anooshka Pendyal

//This project, using object oriented programming, models a simplified version of blackjack, a card game.

//A game proceeds as follows: A player is dealt two cards face up. 
//If the point total is exactly 21 the player wins immediately. 
//If the total is not 21, the dealer is dealt two cards, one face up and one face down. 
//A player then determines whether to ask the dealer for another card (called a “hit”) or to “stay” with his/her current hand. 
//A player may ask for several “hits.” When a player decides to “stay” the dealer begins to play. 
//If the dealer has 21 it immediately wins the game. 
//Otherwise, the dealer must take “hits” until the total points in its hand is 17 or over, at which point the dealer must “stay.” 
//If the dealer goes over 21 while taking “hits” the game is over and the player wins. 
//If the dealer’s points total exactly 21, the dealer wins immediately. 
//When the dealer and player have finished playing their hands, the one with the highest point total is the winner. 
//Play is repeated until the player decides to quit. 




import java.util.Scanner;

public class Project2
{
    public static void main (String [] args)
    {
        //whitespace
        System.out.println();
        System.out.println();

        //create Scanner object
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to BlackJack!"); 
        
        //create Card, Deck, and Person objects
        Card cardObj = new Card(); //temporary Card object to set the Ace value
        Deck Deck = new Deck();
        Person player = new Person();
        Person dealer = new Person();

        //initializes and sets some variables and populates Deck
        boolean playerNotGoneOver21Points = true;
        int playAgain = 1;
        Deck.populateDeck();

        //big while loop that allows user to replay game
        while (playAgain == 1)
        {
            //ask user what they would like to value the ace card
            cardObj.setAceValue();

            System.out.println();

            //initialize current player/dealer points
            int currentPlayerPointTotal = 0;
            int currentDealerPointTotal = 0;
    
            //generates and displays starting 2 cards for player
            System.out.println("2 cards are dealt to the player: ");
            Card playerCard1 = player.hit(Deck);
            Card playerCard2 = player.hit(Deck);
            System.out.println(playerCard1.getNumber() + " of " + playerCard1.getSuite());
            System.out.println(playerCard2.getNumber() + " of " + playerCard2.getSuite());
    
            //sets values for starting 2 cards for player
            playerCard1.setValue(playerCard1.getNumber());
            playerCard2.setValue(playerCard2.getNumber());
    
            //sets and displays current player point total
            currentPlayerPointTotal = playerCard1.getValue() + playerCard2.getValue();
            System.out.println("Player's current point total: " + currentPlayerPointTotal);
    
            System.out.println();
    
            //checks if starting 2 player cards are equal to 21 (automatic win), if not, continue to rest of program
            if (currentPlayerPointTotal == 21)
            {
                System.out.println("You won!");
                System.out.println("You reached exactly 21 points!");
            }
            else
            {
                //deal 2 cards to dealer, one is face down
                System.out.println("2 cards are dealt to the dealer. One is face up, the other is face down: ");
                Card dealerCard1 = dealer.hit(Deck);
                Card dealerCard2 = dealer.hit(Deck);
                System.out.println(dealerCard1.getNumber() + " of " + dealerCard1.getSuite());
                System.out.println("Card 2");
    
                //set value for 2 dealer cards
                dealerCard1.setValue(dealerCard1.getNumber());
                dealerCard2.setValue(dealerCard2.getNumber());
    
                //set current dealer point total
                currentDealerPointTotal = dealerCard1.getValue() + dealerCard2.getValue();
                System.out.println();
    
                if (currentDealerPointTotal == 21)
                {
                    System.out.println("Game Over!");
                    System.out.println("The Dealer reached exactly 21 points.");
                }
                else
                {
                    //asks user to hit (draw more cards) or stay
                    //loop continues until user specifies to stay, reaches exactly 21 points, or goes over 21 points
                    System.out.print("Would you like to stay or hit? Enter 0 for stay or 1 for hit: ");
                    int hitOrStay = input.nextInt();
                    while (hitOrStay == 1)
                    {
                        Card playerCardHit = player.hit(Deck);
                        System.out.println(playerCardHit.getNumber() + " of " + playerCardHit.getSuite());
                        playerCardHit.setValue(playerCardHit.getNumber());
                        currentPlayerPointTotal += playerCardHit.getValue();
                        System.out.println("Player's current point total: " + currentPlayerPointTotal);
                        if (currentPlayerPointTotal > 21)
                        {
                            System.out.println("Game Over!");
                            System.out.println("You went over 21 points.");
                            playerNotGoneOver21Points = false;
                            hitOrStay = 0;
                            break;
                        }
                        if (currentPlayerPointTotal == 21)
                        {
                            System.out.println("You won!");
                            System.out.println("You got exactly 21 points! ");
                            playerNotGoneOver21Points = false;
                            hitOrStay = 0;
                            break;
                        }
                        System.out.println();
                        System.out.print("Would you like to stay or hit? Enter 0 for stay or 1 for hit: ");
                        hitOrStay = input.nextInt();
                    }
                    //executed after user hits only if user has not reached 21 points or gone over
                    //dealer gets dealt cards until current dealer point total reaches 17 points
                    //if dealer point total goes over 21, player wins
                    if (playerNotGoneOver21Points)
                    {
                        while (currentDealerPointTotal < 17)
                        {
                            Card dealerCardHit = dealer.hit(Deck);
                            System.out.println(dealerCardHit.getNumber() + " of " +  dealerCardHit.getSuite());
                            dealerCardHit.setValue(dealerCardHit.getNumber());
                            System.out.println(dealerCardHit.getValue());
                            currentDealerPointTotal += dealerCardHit.getValue();
                            System.out.println("Dealer's current point total: " + currentDealerPointTotal);
                            System.out.println();
                            if (currentDealerPointTotal > 21)
                            {
                                System.out.println("You won!");
                                System.out.println("The Dealer went over 21 points.");
                                hitOrStay = 0;
                                break;
                            }
                            if (currentDealerPointTotal == 21)
                            {
                                System.out.println("Game Over!");
                                System.out.println("The Dealer reached exactly 21 points.");
                                hitOrStay = 0;
                                break;
                            }
                        }
                    }
                }
            }
    
            //is executed only if both player and dealer have not gone over 21 points/reached 21 points
            //determines winner by who has highest score
            if (currentPlayerPointTotal != 21 & currentDealerPointTotal != 21 & currentPlayerPointTotal < 21 & currentDealerPointTotal < 21)
            {
                System.out.println();
                if (currentDealerPointTotal > currentPlayerPointTotal)
                {
                    System.out.println("You lost! The Dealer had a higher point total than you.");
                }
                else
                {
                    System.out.println("You won! You had a higher point total than the Dealer.");
                }
                
                System.out.println("Dealer Point Total: " + currentDealerPointTotal);
                System.out.println("Player Point Total: " + currentPlayerPointTotal);
            }

            //reshuffles deck by resetting hasBeenPicked to false for all cards
            Deck.reshuffleDeck();
    
            System.out.println();

            //ends loop if user chooses not to play again (by selecting 0)
            System.out.println("Would you like to play again? Enter 1 for yes or 0 for no: ");
            playAgain = input.nextInt();

            System.out.println();
            System.out.println();

        }

        //program ends
        System.out.println("Thanks for playing Blackjack!");
    }
}