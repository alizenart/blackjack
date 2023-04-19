public class player
{
  private String name;
  private int banknote;
  
  public player( String n, int b)
  {
    name = n;
    banknote = b;
  }
  
  //getters
  public String getName()
  {
    return name;
  }
  
  public int getBanknote()
  {
    return banknote;
  }
  
  //setters
  public void setName( String n)
  {
    name = n;
  }
  
  public void setBanknote( int b)
  {
    banknote = b;
  }
  
  
}