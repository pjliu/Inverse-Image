import java.util.*;
import java.io.*;

public class TraceWriter2
{

    public static void writeToFile()
    {
        try{
            FileWriter writer = new FileWriter("c:\\FaceTrace.csv");
            writer.append("PROJECT;SEQUENCE;STEP;MOVEKIND;BASE;SHOULDER;LIFT;SPEED;PAUSE" + "\r\n");
            Pixel center = new Pixel(320, 240);
                                       
            //loop this line to write all the coordinates to the text file
            for(int i = 0; i < 2159; i++)//loops throught the entire movie (
            {
                PixelAlgorithms pa = new PixelAlgorithms();
                ArrayList <Pixel> thres = null;
                thres = pa.gather("C:\\Documents and Settings\\nilesh\\My Documents\\Movie\\M" + " (" + i + ").jpg");//threshold algorithm called
                System.out.println("C:\\Documents and Settings\\nilesh\\My Documents\\Movie\\M" + " (" + i + ").jpg");//print check
                ArrayList<ArrayList <Pixel>> groups = pa.group(thres);//grouping algorithm called
                Pixel one = pa.findMidpoint(groups.get(0));//midpoint algorithm called thrice
                Pixel two = pa.findMidpoint(groups.get(1));
                Pixel three = pa.findMidpoint(groups.get(2));
                
                int pixdis1 = pa.MDis(center, one);//distance algorithm called thrice
                int pixdis2 = pa.MDis(center, two);
                int pixdis3 = pa.MDis(center, three);
                
                double actualdis = pa.run(pa.MDis(one, two));//actual distance approximation algorithm called
                //System.out.println("" + actualdis);
                double theta1 = pa.calcViewAngle(actualdis * 55, pixdis1);//viewing angle calculation algorithm called thrice
                double theta2 = pa.calcViewAngle(actualdis * 55, pixdis2);
                double theta3 = pa.calcViewAngle(actualdis * 55, pixdis3);
                //writeputs the the data into the file
                writer.append("FaceTrace;000001;" + (i+1) + ";2;" + ((theta1 + 76.86247436452)*2  - 89.86247436452) + ";" + ((theta2 - 37.733649736579437)*2 + 18.933649736579437) + ";1;30;10" + "\r\n");        
            }
            writer.flush();
            writer.close();
        }
        catch (IOException e) {//checks for run-time errors that might occur 
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }
}
