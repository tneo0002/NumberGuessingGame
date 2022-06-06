import java.util.*;

/**
 * The Player class implements a player who plays the number
 * guessing game. The player object stores and updates information
 * about the player himself such as name, total credits, number of 
 * games won and lost, and amounts of credit won and lost. It also
 * returns its information when its accessors are called.
 * 
 * @author (Tze Loon Neoh)
 * @version (26 Aug 2021)
 */
public class Player
{
    private String name;
    private int credits;
    private int wins;
    private int losses;
    private int winnings;
    private int losings;
    
    public Player()
    {
        name = "";
        credits = 0;
        wins = 0;
        losses = 0;
        winnings = 0;
        losings = 0;
    }
        
    public void displayStatistics()
    {
        int winPercent = 0;
        if (wins + losses == 0)
            winPercent = 0;            
        else
            winPercent = 100 * wins / (wins + losses);
        System.out.println("\nPlayer " + name + " has " + wins + " win(s) and " + 
                            losses + " loss(es) ==> Winning Percentage = " +
                            winPercent + "%.");
        System.out.println("Total Credit: $" + credits);
        System.out.println("Total Amount Won: $" + winnings);
        System.out.println("Total Amount Lost: $" + losings + "\n");
    }
    
    public int getCredit()
    {
        return credits;
    }
    
    public int getCreditLost()
    {
        return losings;
    }
        
    public int getCreditWon()
    {
        return winnings;
    }
        
    public int getLoss()
    {
        return losses;
    }
    
    public String getName()
    {
        return name;
    }

    public int getWin()
    {
        return wins;
    }
    
    public void loseCredit(int loss)
    {
        credits = credits - loss;
    }
    
    public void resetPlayerToDefault()
    {
        name = "";
        credits = 0;
        wins = 0;
        losses = 0;
        winnings = 0;
        losings = 0;
    }
    
    public void setName ()
    {
        Scanner console = new Scanner(System.in);
        String newPlayerName = console.nextLine();
        name = newPlayerName;
    }    
    
    public void setCredit(int newCredit)
    {
        credits = credits + newCredit;
    }
    
    public void setLosings(int creditLost)
    {
        losings += creditLost;
    }
    
    public void setWinnings(int creditWon)
    {
        winnings += creditWon;
    }
        
    public void setLoss(int increment)
    {
        losses += increment;
    }
        
    public void setWin(int increment)
    {
        wins += increment;
    }
}
