package coe318.lab5;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class BlackjackGame {

  private CardPile deck;
  private CardPile houseCards;
  private CardPile yourCards;
  private boolean houseDone;
  private boolean playerDone;
  private UserInterface ui;

  public BlackjackGame(UserInterface ui) {
    this.ui = ui;
    ui.setGame(this);
    deck = new CardPile();
    for (int i = 2; i < 15; i++) {
      for (int j = 0; j < 4; j++) {
        deck.add(new Card(i, j, true));
      }
    }
    houseCards = new CardPile();
    yourCards = new CardPile();
    houseDone = false;
    playerDone = false;
  }

  public void start() {
    Card c;
    c = deck.removeRandom();
    c.setFaceUp(false);
    getHouseCards().add(c);
    getHouseCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    ui.display();
  }

  public void play() {
    while (!houseDone || !playerDone) {
      if (!houseDone) {
        if (score(getHouseCards()) <= 17) {
          getHouseCards().add(deck.removeRandom());
          ui.display();
        } else {
          houseDone = true;
        }
      }
      if (!playerDone) {
        if (ui.hitMe()) {
          getYourCards().add(deck.removeRandom());
          ui.display();
        } else {
          playerDone = true;
        }
      }
    }
  }

  public void end() {
    getHouseCards().getCards().get(0).setFaceUp(true);
    ui.gameOver();
  }

  /**
   * Determine the score of a pile of cards.
   *
   * @param p
   * @return the score
   */
  public int score(CardPile p) {
      
    //Get an ArrayList version of the CardPile that was passed in
    //so you can use ArrayList methods such as .size() in the for loop
    ArrayList<Card> list = p.getCards();
    
    int sum = 0;
    
    //Loop through the entire CardPile 
    for(int i = 0; i < list.size(); i++)
    {
        //If the current card is not a Jack, Queen, King, or Ace
        if(list.get(i).getRank() >= 2 && list.get(i).getRank() <= 10)
        {
            sum += list.get(i).getRank();
        }
        
        //else if it is
        else
        {
            switch(list.get(i).getRank())
            {
                case 11://If it's a Jack
                    sum += 10;
                    break;
                case 12://If it's a Queen
                    sum += 11;
                    break;
                case 13://If it's a King
                    sum += 12;
                    break;
                case 14://If it's a Ace
                    sum += 1;
                    break;
            }
        }
    }
    return sum;
  }

  /**
   * @return the houseCards
   */
  public CardPile getHouseCards() {
    return houseCards;
  }

  /**
   * @return the yourCards
   */
  public CardPile getYourCards() {
    return yourCards;
  }

  public static void main(String[] args) {
    BlackjackGame game = new BlackjackGame(new SimpleUI());
    game.start();
    game.play();
    game.end();
  }
}