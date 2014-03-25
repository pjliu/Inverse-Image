import java.util.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.Color;

public class PixelAlgorithms
{
    private ArrayList<ArrayList <Pixel>> all;
    
    public PixelAlgorithms()
    {
        all = new ArrayList<ArrayList <Pixel>> ();
    }
    public ArrayList <Pixel> gather(String picname)
    {
        //this method gathers all the pixels in the picture file that are have an average RGB value over 60 and put them into a file 
        ArrayList <Pixel> thres = new ArrayList <Pixel> ();//this will hold all the pixels above the 60 RGB average value
        try{
            BufferedImage img = ImageIO.read(new File(picname));//reads the picture
            for(int x = 0; x != 640; x++)//loops to read all pixels
            {
                for(int y = 0; y != 480; y++)
                {

                    Color c = new Color(img.getRGB(x,y));
                    int r=c.getRed();
                    int g=c.getGreen();
                    int b=c.getBlue();
                    int p = (r + g + b)/3; //averages the RGB value
                    if(p > 30){//determines if the pixel is above or below the threshold
                        thres.add(new Pixel(x,y));//the pixel is added if the pixel's RGB values are above the threshold level
                    }                 
                }
            }
        }
        catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }        
        return thres;
    }
    
    private boolean check(Pixel one, Pixel two)
    {
        //this method checks to see if a pixel "one" is within 30 pixels of "two"
        double dis = Math.sqrt((one.getX() - two.getX())*(one.getX()-two.getX()) + (one.getY()-two.getY())*(one.getY()-two.getY()));
        if(dis < 30.1)
            return true;
        else
            return false;
    }
    
    public ArrayList<ArrayList <Pixel>> group(ArrayList <Pixel> thres)
    {
        //this method groups all light pixels that are adjacent to one another. it puts each group in a seperate arraylist and then all the arraylists into another arraylist
        if(thres.size() == 0)
        {
            return null;
        }
        Pixel base = thres.get(0);//gets the first point and is set as the base point
        ArrayList <Pixel> primary = new ArrayList <Pixel>();//collects points for group 1
        ArrayList <Pixel> secondary = new ArrayList <Pixel> ();//collects points not in group 1

        for(int i = 1; i < thres.size(); i++)//loops until all points in light grouping 1 are grouped together
        {
            if(check(base, thres.get(i)))//if the point is within a than 30 pixel radius of the base point, it will be added to group 1
            {
                primary.add(thres.get(i));
            }
            else//if the pixel radius is greater than 30, the then the pixel will be added to the "not in group 1" list
            {
                secondary.add(thres.get(i));
            }
        }
        all.add(primary);//adds the light grouping list to the overall list
        group(secondary);//recurses, this time, using the secondary list to find the next grouping and so on until all the points have been grouped.

        return all;        
    }

    


    public Pixel findMidpoint(ArrayList <Pixel> group)
    {
        //this method finds the midpoint of a light grouping
        int xt = 0;
        int yt = 0;
        for(int i = 0; i < group.size(); i++)
        {
            xt = xt + group.get(i).getX();//adds all the x values together
            yt = yt + group.get(i).getY();//adds all the y values together            
        }

        return new Pixel(xt/group.size(), yt/group.size());//this will give us a estimated center point of the light grouping
    }
    public int MDis(Pixel one, Pixel two)
    {
        //this method returns the distance from one pixel to the next.
        return (int) Math.sqrt((one.getX() - two.getX())*(one.getX()-two.getX()) + (one.getY()-two.getY())*(one.getY()-two.getY()));
    }



    public static double run(int A)
    {   
        //this method approximates the actual distance between the person's face and the camera lens.
        double a = 743.12;
        double b = -0.065;
        double realdistance =  Math.log(A/a)/b;
        double round = Round(realdistance,1);
        return round;
    }
    private static double Round(double Rval, int Rpl) 
    {
        //this method rounds everything to a certain number of places.
        double p = Math.pow(10,Rpl);
        Rval = Rval * p;
        double tmp = Math.round(Rval);
        return tmp/p;
    }

    public double calcViewAngle(double distance, int pixelDistance)
    {
        //this method calculates the certain angles
        return Math.toDegrees(Math.atan(pixelDistance/distance));
    }

}
