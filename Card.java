//creates card objects with suites and numbers

import java.util.Scanner;

public class Card
{
    private String suite; //can be clubs, spades, hearts, or diamonds
    private String number; //can be a number or a Jack, Queen, King, or Ace
    private int value; //will set the point value of the card
    private static int aceValue; //sets value of ace, decided by user
    private boolean hasBeenPicked; //makes sure card hasn't been picked so there are no doubles

    //constructor
    public Card()
    {
        suite = "";
        number = "";
        value = 0;
        aceValue = 1;
        hasBeenPicked = false;
    }

    //getter methods
    public String getSuite()
    {
        return suite;
    }

    public String getNumber()
    {
        return number;
    }

    public int getValue()
    {
        return value;
    }

    public int getAceValue()
    {
        return aceValue;
    }

    public boolean getHasBeenPicked()
    {
        return hasBeenPicked;
    }


    //setter methods
    public void setSuite (String input)
    {
        suite = input;
    }

    public void setNumber(String input)
    {
        number = input;
    }

    //this setter method uses switch cases to assign an integer value to the card based on its string number
    public void setValue(String number)
    {
        switch (number)
        {
            case "2":
                value = 2;
                break;
            case "3":
                value = 3;
                break;
            case "4":
                value = 4;
                break;
            case "5":
                value = 5;
                break;
            case "6":
                value = 6;
                break;
            case "7":
                value = 7;
                break;
            case "8":
                value = 8;
                break;
            case "9":
                value = 9;
                break;
            case "10":
                value = 10;
                break;
            case "Jack":
                value = 10;
                break;
            case "Queen":
                value = 10;
                break;
            case "King":
                value = 10;
                break;
            case "Ace":
                value = aceValue;
                break;
        }
    }

    //sets the value of ace cards based on user's choice
    public void setAceValue()
    {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Do you want the value of the Ace cards to be 1 or 11? ");
        aceValue = scanner.nextInt();  // Read user input
    }

    //setter for hasbeenpicked attribute, makes sure that cards aren't picked twice
    public void setHasBeenPicked(Boolean picked)
    {
        if (picked == true)
        {
            hasBeenPicked = true;
        }
        else
        {
            hasBeenPicked = false;
        }
    }
}