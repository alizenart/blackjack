import java.util.*;
public class deck
{
  private ArrayList <card> cards;
  
  
  public deck( ArrayList<card> c)
  {
    cards = c;
  }
  
  public ArrayList<card> getCard()
  {
    return cards;
  }
  
  public void setCard( ArrayList<card> c)
  {
    cards = c;
  }
  
  

  
  public ArrayList<card> shuffle( ArrayList<card> c )
  {
    
    for( int i = 1; i < 1000000; i++)
    {
      //a is postion
      int a = (int)(Math.random()*51);

      card x = c.get(a);

      c.set(0,x); // 30,22,11
    }
    
    return c;
    
  }
}