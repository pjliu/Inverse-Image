
public class Runner
{
    public static void run()
    {
        for(int i = 1; i <=100; i++)
        {
            String export = "C:\\Export Scripts2\\test" + i + ".csv";
            TW4 a = new TW4();
            a.writeToFile(i,export);
        }
        
    }
}
