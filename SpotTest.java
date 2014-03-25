import java.util.*;
import java.io.*;

public class SpotTest
{

    public static void writeToFile()
    {
        try{
            FileWriter writer = new FileWriter("c:\\sitting.txt");
            Pixel center = new Pixel(320, 240);
                                       
            //loop this line to write all the coordinates to the text file
            for(int i = 0; i <= 3600; i++)//loops throught the entire movie (
            {
                PixelAlgorithms pa = new PixelAlgorithms();
                ArrayList <Pixel> thres = null;
                thres = pa.gather("G:\\Face Tracking Experiment\\LED Lights\\Walking\\Walking" + " (" + i + ").jpg");//threshold algorithm called
                //System.out.println("(" + i + ").jpg");//print check
                ArrayList<ArrayList <Pixel>> groups = pa.group(thres);//grouping algorithm called
                if(groups.size() < 3)
                {
                    writer.append("No Point at : " + i + " \r\n"); 
                    System.out.println("No Point at : " + i + " \r\n");
                }
                //Pixel one = pa.findMidpoint(groups.get(0));//midpoint algorithm called thrice
                //Pixel two = pa.findMidpoint(groups.get(1));
                //Pixel three = pa.findMidpoint(groups.get(2));
                
                //int pixdis1 = pa.MDis(center, one);//distance algorithm called thrice
                //int pixdis2 = pa.MDis(center, two);
                //int pixdis3 = pa.MDis(center, three);
                
                //double actualdis = pa.run(pa.MDis(one, two));//actual distance approximation algorithm called
                //System.out.println("" + actualdis);
                //double theta1 = pa.calcViewAngle(actualdis * 55, pixdis1);//viewing angle calculation algorithm called thrice
                //double theta2 = pa.calcViewAngle(actualdis * 55, pixdis2);
                //double theta3 = pa.calcViewAngle(actualdis * 55, pixdis3);
                //writeputs the the data into the file
                //writer.append(""+'[' + one.getX() + ", " + one.getY() + ']' + '[' + two.getX() + ", " + two.getY() + ']' + '[' + three.getX() + ", " + three.getY() + ']' + " " + theta1 + " " + theta2 +  " " + theta3 + " " + actualdis + " \r\n");        
            }
            writer.flush();
            writer.close();
        }
        catch (IOException e) {//checks for run-time errors that might occur 
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
}
