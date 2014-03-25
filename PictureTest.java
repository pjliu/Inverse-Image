import java.util.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.Color;

public class PictureTest

{
   
   public static void main(String [] args)
   {
	   generateFile("c:\\test.txt"); 
   }
 
   private static void generateFile(String sFileName)
	{
	    File t = new File("a.jpg");
        try{
            BufferedImage img = ImageIO.read(t);
            FileWriter writer = new FileWriter(sFileName);
            for(int x = 0; x != 640; x++)
            {
                for(int y = 0; y != 480; y++)
                {
                     
                    Color c = new Color(img.getRGB(x,y));
                    int r=c.getRed();
                    int g=c.getGreen();
                    int b=c.getBlue();
                    int p = (r + g + b)/3; 
                    String o = x + ", " + y; 
                    if(p > 60){
                                           
                        writer.append(o + "\r\n");
                    }
                    //generate whatever data you want 
                    
                }
            }
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }

	}
}
