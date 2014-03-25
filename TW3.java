import java.util.*;
import java.io.*;

public class TW3
{

    public static void writeToFile(int speed, String export)
    {
        try{
            FileWriter writer = new FileWriter(export);
            writer.append("PROJECT;SEQUENCE;STEP;MOVEKIND;XPOS;YPOS;ZPOS;BASE;SHOULDER;LIFT;SPEED;PAUSE" + "\r\n");
            //Pixel center = new Pixel(320, 240);
                                       
            //loop this line to write all the coordinates to the text file
            for(int i = 0; i < 30; i++)//loops throught the entire movie (
            {
                double theta2 = 0;
                int lift = 0;
                int x = 0;
                int y = 0;
                int z = 0;
                if(i%2 == 0){
                    theta2 = 90;
                    lift = 0;
                    x = 0;
                    y = 0;
                    z = 0;
                }
                else{
                    theta2 = -50;
                    lift = 0;
                    x = 10;
                    y = 10;
                    z = 10;
                }
                
                writer.append("TRACE7;000001;" + (i+1) + ";2;" + x + ";" + y + ";" + z + ";90;"  + theta2 + ";"+ lift + ";" + speed +";0" + "\r\n");        
            }
            writer.flush();
            writer.close();
        }
        catch (IOException e) {//checks for run-time errors that might occur 
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
}
