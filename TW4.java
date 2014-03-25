import java.util.*;
import java.io.*;

public class TW4
{     

    public void writeToFile(int speed, String export)
    {
        try{
            FileWriter writer = new FileWriter(export);

            writer.append("PROJECT;SEQUENCE;STEP;MOVEKIND;XPOS;YPOS;ZPOS;BASE;SHOULDER;SPEED;PAUSE" + "\r\n");
            //Pixel center = new Pixel(320, 240);

            //loop this line to write all the coordinates to the text file

            int theta = 90;
            double x = 0;
            double y = 0;
            double z = 0;
            double as = 0.92857142857142857142857142857143;

            boolean backwards = false;

            for(int i = 0; i < 5000; i++)//loops throught the entire movie (
            {   
                writer.append("TRACE7;0000001;" + (i+1) + ";2;" + x + ";" + y + ";" + z + ";" +theta + ";70;" + speed +";0" + "\r\n");        
                if(theta > -50 && !backwards)
                {
                    as = 0.92857142857142857142857142857143;
                    theta--;

                }
                else
                {
                    as = -0.92857142857142857142857142857143;
                    theta++;
                    backwards = true;

                    if(theta == 90)
                    {       
                        backwards = false;
                    }
                }
                x = as + x;
                y = as + y;
                z = as + z;
            }
            writer.flush();
            writer.close();
        }
        catch (IOException e) {//checks for run-time errors that might occur 
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
}
