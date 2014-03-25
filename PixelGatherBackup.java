import java.util.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.Color;

public class PixelGatherBackup

{
   
   //public static void main(String [] args)
   //{
   //    generateFile("c:\\test.txt"); 
   //}
 
   public ArrayList <Pixel> generateFile(String picname)
	{
	    File t = new File(picname);
	    ArrayList <Pixel> thres = new ArrayList <Pixel> ();
        try{
            BufferedImage img = ImageIO.read(t);
            //FileWriter writer = new FileWriter(sFileName);
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
                        thres.add(new Pixel(x,y));                   
                        //writer.append(o + "\r\n");
                    }
                    //generate whatever data you want                     
                }
            }
            //writer.flush();
            //writer.close();
        }
        catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
        
        return thres;

	}
}

