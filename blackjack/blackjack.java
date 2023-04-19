import java.util.*;

public class blackjack
{
  public static void main(String[]args)
  {
    
    System.out.println("Welcome to Blackjack!");
    
    //creating a fresh deck
    ArrayList <card> deckMain = new ArrayList<card>();
    
    
    
    
    Scanner pencil = new Scanner(System.in);
    
    System.out.println("What is your name?");
    String name = pencil.nextLine();
    
    player person = new player(name, 500);
    player comp = new player("computer", 500);
    
    
    
    int progress = 1;
    
    while (progress == 1)
    {

      //implement shuffle here
      for(int i = 1; i < 14; i++)
      {
        for(int j = 1; j < 5; j++)
        {
          deckMain.add( new card( i, j));
        }
      }
      deck d = new deck(deckMain);
      
      d.shuffle(deckMain);
      

      
      //person playing
      
      int personWin = 0;
      System.out.println("Your current banknote is " + person.getBanknote());
      System.out.println("The computer's current banknote is " + comp.getBanknote());
      
      System.out.println("How much do you want to bet");
      int bet = pencil.nextInt();
      pencil.nextLine();
      
      int deckSize = 51;
      
      int position1 = (int)(Math.random()*deckSize+1);
      card card1 = d.getCard().get(position1-1);
      d.getCard().remove(position1);
      deckSize = deckSize -1 ;
      int card1Value;
      
      
      int position2 = (int)(Math.random()*deckSize+1);
      card card2 = d.getCard().get(position2-1);
      d.getCard().remove(position2);
      deckSize = deckSize -1 ;
      int card2Value;
      
      int position3 = (int)(Math.random()*deckSize+1);
      card card3 = d.getCard().get(position3-1);
      d.getCard().remove(position3);
      deckSize = deckSize -1 ;
      int card3Value;
      
      int position4 = (int)(Math.random()*deckSize+1);
      card card4 = d.getCard().get(position4-1);
      d.getCard().remove(position4);
      deckSize = deckSize -1 ;
      int card4Value;
      
      
      System.out.println("The cards have been dealt. Your two cards drawn are: " + cardName(card1) + " and " + cardName(card2));

      
      if (card1.getName() == 1)
      {
        System.out.println("What value do you want your ace to have(can only choose 1 or 11)");
        card1Value = pencil.nextInt();
        pencil.nextLine();
      }
      
      else
      {
        card1Value = cardValue(card1);
      }
      
      if (card2.getName() == 1)
      {
        System.out.println("What value do you want your ace to have(can only choose 1 or 11)");
        card2Value = pencil.nextInt();
        pencil.nextLine();
      }
      
      else
      {
        card2Value = cardValue(card2);
      }
      
      //computer Ace
      if (card3.getName() == 1)
      {
        card3Value = 11;
      }
      else
      {
        card3Value = cardValue(card3);
      }
      
      
      if (card4.getName() == 1)
      {
        if (card3Value<=10)
        {
          card4Value = 11;
        }
        else
        {
          card4Value = 1;
        }
      }
      
      else
      {
        card4Value = cardValue(card4);
      }
      
      ArrayList <card> compDeck = new ArrayList<card>();
      compDeck.add(card3);
      compDeck.add(card4);
        
      
      int totalValue = card1Value + card2Value;
      int totalValueComp = card3Value + card4Value;
      
      System.out.println("Your total card value is " + totalValue);
      //shows card2 of computer
      
      System.out.println("The computer's first card is " + cardName(card3));      
      
      

      
      while (totalValueComp <=17)
      {
        int positionNext = (int)(Math.random()*deckSize+1);
        card cardNext = d.getCard().get(positionNext-1);
        d.getCard().remove(positionNext);
        deckSize = deckSize -1 ;
        int cardNextValue;
        
        compDeck.add(cardNext);
        
        if (cardNext.getName() == 1)
        {
          cardNextValue = 1;
        }
        
        else
        {
          cardNextValue = cardValue(cardNext);
        }
        
        totalValueComp = totalValueComp + cardNextValue;
      }
      
      
      
      
      
      System.out.println("Would you like to hit? 1-yes 2-no");
      int drawAgain = pencil.nextInt();
      pencil.nextLine();
      
      while(drawAgain == 1)
      {
        int positionNext = (int)(Math.random()*deckSize+1);
        card cardNext = d.getCard().get(positionNext-1);
        d.getCard().remove(positionNext);
        deckSize = deckSize -1 ;
        int cardNextValue;
        
        System.out.println("Your new card dealt is " + cardName(cardNext));
       
        if (cardNext.getName() == 1)
        {
          System.out.println("What value do you want your ace to have(can only choose 1 or 11)");
          cardNextValue = pencil.nextInt();
          pencil.nextLine();
        }
        
        else
        {
          cardNextValue = cardValue(cardNext);
        }
        
        totalValue = totalValue + cardNextValue;
        System.out.println("Your new total card value is " + totalValue);
        
        

        
        if(totalValue > 21)
        {
          System.out.println("You got over 21");
          drawAgain = 2;
          personWin = 2;
        }
        
        else
        {
          System.out.println("Would you like to hit again? 1-yes 2-no");
          drawAgain = pencil.nextInt();
          pencil.nextLine();
        }
       
        
      }
      
      
      if (totalValue>totalValueComp && totalValue <= 21)
      {
        personWin = 1;
      }
      
      if(totalValue == totalValueComp)
      {
        personWin = 3;
      }
      
      if(totalValue > 21 && totalValueComp > 21)
      {
        personWin = 3;
      }
      
      
      if (personWin == 1)
      {
        int a = person.getBanknote();
        int b = comp.getBanknote();
        person.setBanknote(a + bet);
        comp.setBanknote(b - bet);
        System.out.println("You win this round! The computer's total value was " + totalValueComp + ", and the cards were ");
        for (int i = 0; i < compDeck.size(); i++)
        {
          System.out.println(cardName(compDeck.get(i)));
        }

      }
      
      
      else if (personWin == 2)
      {
        int a = person.getBanknote();
        int b = comp.getBanknote();
        person.setBanknote(a - bet);
        comp.setBanknote(b + bet);
        System.out.println("You lost this round :(( The computer's total value was " + totalValueComp + ", and the cards were ");
        System.out.println("You win this round! The computer's total value was " + totalValueComp + ", and the cards were ");
        for (int i = 0; i < compDeck.size(); i++)
        {
          System.out.println(cardName(compDeck.get(i)));
        }
  

      }
      
      else if (personWin == 3)
      {
        System.out.println("This round is a draw");
        System.out.println("The computer's total value was " + totalValueComp);
        System.out.println("You lost this round :(( The computer's total value was " + totalValueComp + ", and the cards were ");
        System.out.println("You win this round! The computer's total value was " + totalValueComp + ", and the cards were ");
        for (int i = 0; i < compDeck.size(); i++)
        {
          System.out.println(cardName(compDeck.get(i)));
        }


      }
      
        
      System.out.println("The round is over. Would you like to deal again? 1-yes, 2-no ");
      int endGame = pencil.nextInt();
      pencil.nextLine();
      
      
      if (endGame == 2 || person.getBanknote() <= 0 || comp.getBanknote() <= 0)
      {
        progress = 2;
      }
      
        
    }
    
    //prints a random int between 1 <= x < 15 
    System.out.println((int)(Math.random()*14 + 1));
    
    //prints a random int between 1 <= x < 53 
    System.out.println((int)(Math.random()*52 + 1));
    
     
    
    
    
    
                       
    //14 differnet card
    //Different Cards and their values
    // 1-10 : just point value
    // J, Q, K = 10
    // A : 1 or 11 --> player's choice

    
  }
  
  public static String cardName(card c)
  {
    
    if(c.getName() == 1)
    {
      return "A";
    }
    
    if(c.getName() == 2)
    {
      return "2";
    }
    
    if(c.getName()== 3)
    {
      return "3";
    }
    
    if(c.getName() == 4)
    {
      return "4";
    }
    
    if(c.getName() == 5)
    {
      return "5";
    }
    
    if(c.getName() == 6)
    {
      return "6";
    }
    
    if(c.getName() == 7)
    {
      return "7";
    }
    
    if(c.getName() == 8)
    {
      return "8";
    }
    
    if(c.getName() == 9)
    {
      return "9";
    }
    
    if(c.getName() == 10)
    {
      return "10";
    }
    
    if(c.getName() == 11)
    {
      return "J";
    }
    
    if(c.getName() == 12)
    {
      return "Q";
    }
    
    else //(c.getName() == 13)
    {
      return "K";
    }
    
    
  }
  
  public static int cardValue(card c)
  {
    if(c.getName()>1 && c.getName()<11) 
    {
      return c.getName();
    }
    
    if(c.getName() > 9 && c.getName()<14)
    {
      return 10;
    }
    
    else
    {
      return 0;
    }
    
    
  }
  
 
}