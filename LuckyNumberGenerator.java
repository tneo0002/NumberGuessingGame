/**
 * Class LuckyNumberGenerator will generate numbers with a prescribed limit and return the generated random number 
 * to the caller of the method.
 * @author (Tze Loon Neoh)
 * @version (26 Aug 2021)
 */
public class LuckyNumberGenerator
{
    private int x;

    /**
     * Constructor for objects of class LuckyNumberGenerator
     */
    public LuckyNumberGenerator()
    {
        x = 0;
    }

    public int generateNumber(int upperLimit)
    {
        return 1 + (int)(Math.random() * upperLimit);
    }
}