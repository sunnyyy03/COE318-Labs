package coe318.lab5;

public class Card implements Comparable {
  //Symbolic constants

  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;

  private int thisRank;
  private int thisSuit;
  private boolean thisFace;
  
  
  /**
   * Construct a card of the given rank, suit and whether it is faceup or
   * facedown. The rank is an integer from 2 to 14. Numbered cards (2 to 10)
   * have a rank equal to their number. Jack, Queen, King and Ace have the ranks
   * 11, 12, 13, and 14 respectively. The suit is an integer from 0 to 3 for
   * Clubs, Diamonds, Hearts and Spades respectively.
   *
   * @param rank
   * @param suit
   * @param faceUp
   */
  public Card(int rank, int suit, boolean faceUp) {
    thisRank=rank;
    thisSuit=suit;
    thisFace=faceUp;
  }

  /**
   * @return the faceUp
   */
  public boolean isFaceUp() {
    return thisFace; 
  }

  /**
   * @param faceUp the faceUp to set
   */
  public void setFaceUp(boolean faceUp) {
    thisFace=faceUp;
  }

  /**
   * @return the rank
   */
  public int getRank() {
    return thisRank;
  }

  /**
   * @return the suit
   */
  public int getSuit() {
    return thisSuit;
  }

  @Override
  public boolean equals(Object ob) {
    if (!(ob instanceof Card)) {
      return false;
    }
    Card c = (Card) ob;
    return thisRank==c.getRank() && thisSuit==c.getSuit();
  }

  @Override
  public int hashCode() {//DO NOT MODIFY
    int hash = 7;
    hash = 31 * hash + this.getRank();
    hash = 31 * hash + this.getSuit();
    return hash;
  }

  @Override
  public int compareTo(Object obj) {//DO NOT MODIFY
    return compareTo((Card) obj);
  }

  public int compareTo(Card c) {
    if(thisRank==c.getRank())
    {
        return thisSuit;
    }
    return thisRank-c.getRank();
  }

  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
  public String getRankString() {
    if(thisRank>=2 && thisRank<=10)
    {
        return Integer.toString(thisRank);
    }
    
    String rankString = 
    switch (thisRank) 
    {
      case 11 -> "Jack";
      case 12 -> "Queen";
      case 13 -> "King";
      case 14 -> "Ace";
      default -> "N/A";
   };
    
    return rankString;
  }

  /**
   * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
   *
   * @return the suit String
   */
  public String getSuitString() {
    String suit = 
    switch(thisSuit)
    {
        case 0 -> "Clubs";
        case 1 -> "Diamonds";
        case 2 -> "Hearts";
        case 3 -> "Spades";
        default -> "N/A";
    };
          
    return suit; //FIX THIS
  }

  /**
   * Return "?" if the card is facedown; otherwise, the rank and suit of the
   * card.
   *
   * @return the String representation
   */
  @Override
  public String toString() {
    if(thisFace)
    {
        String s = getRankString() + " of  " + getSuitString();
        return s;
    }
    else
    {
        return "?";
    }
  }

  public static void main(String[] args) {
    //Create 5 of clubs
    Card club5 = new Card(5, 0, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    System.out.println("club5 compareTo spadeAce: "
            + club5.compareTo(spadeAce));
    System.out.println("club5 compareTo club5: "
            + club5.compareTo(club5));
    System.out.println("club5 equals spadeAce: "
            + club5.equals(spadeAce));
    System.out.println("club5 equals club5: "
            + club5.equals(club5));
  }
}
