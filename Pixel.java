//basic class to represent a pixel
//contains two variables x and y

public class Pixel
{
public int x;
public int y;

    public Pixel(int X, int Y)
    {
        // initialise instance variables
        x = X;
        y = Y;
    }

    public int getY()
    {
        return x;
    }
    
    public int getX()
    {
        return y;
    }
    public String toString()
    {
    return "[" + x + ", " + y + "]";    
    }
}
