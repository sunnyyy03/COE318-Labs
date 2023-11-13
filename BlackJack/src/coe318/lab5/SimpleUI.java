package coe318.lab5;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        ArrayList<Card> houseCards = game.getHouseCards().getCards();
        ArrayList<Card> yourCards = game.getYourCards().getCards();
        
        //Print out the house's cards
        System.out.println("\nHouse's Cards");
        for(int i = 0; i < houseCards.size(); i++)
        {
            System.out.println(houseCards.get(i));
        }
        
        //Print out your cards
        System.out.println("\nYour Cards");
        for(int i = 0; i < yourCards.size(); i++)
        {
            System.out.println(yourCards.get(i));
        }
    }

  @Override
    public boolean hitMe() {
        System.out.println("Want a card?(y/n)");//Prompt the user
        String response = user.nextLine();//Store the response
        return "y".equals(response);//Check if the response is a yes
    }

  @Override
    public void gameOver() {
        System.out.println("\nGAME OVER");
        
        //Wait for a second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        //Use the ArrayList versions of the cards so that you can use the ArrayList methods
        ArrayList<Card> houseCards = game.getHouseCards().getCards();
        ArrayList<Card> yourCards = game.getYourCards().getCards();
        
        //Your and the house's scores
        int houseScore = game.score(game.getHouseCards());
        int yourScore = game.score(game.getYourCards());


        //Print out the house's cards
        System.out.println("\nHouse's Cards");
        for(int i = 0; i < houseCards.size(); i++)
        {
            System.out.println(houseCards.get(i));
        }

        //Print out your cards
        System.out.println("\nYour Cards");
        for(int i = 0; i < yourCards.size(); i++)
        {
            System.out.println(yourCards.get(i));
        }
        
        //Now print out everything related to the score
        System.out.println("\nHouse's Score " + houseScore);
        System.out.println("Your Score " + yourScore + "\n");
        
        //Determine if you lost or won
        if(yourScore > 21)
        {
            System.out.println("YOU LOSE");
        }
        else if(yourScore==houseScore)
        {
            System.out.println("YOU LOSE");
        }
        else if(houseScore > 21)
        {
            System.out.println("YOU WIN");
        }
        else if(houseScore <= 21 && yourScore <= 21) 
        {
            if(yourScore > houseScore)
            {
                System.out.println("YOU WIN");
            }
        }
    }

}