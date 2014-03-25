public class Run
{

    public double runt(int tpy, int lpy, int rpy)
    {        
        double ydistance = ((rpy + lpy)/2) - tpy;
        double a = -19.171428567;
        double b = 487.3571429;
        double realdistance = (ydistance - b)/a;
        return realdistance;     
    }
    public static double runt2(int tpy, int lpy, int rpy)
    {        
        double ydistance = ((rpy + lpy)/2) - tpy;
        return ydistance;
        //double a = 643.502484;
        //double b = .9259166448;
        //double realdistance =  Math.log(ydistance/a)/Math.log(b);
        //return realdistance;
        //double round = Round(realdistance,0);
        //return round;
    }

    public static double Round(double Rval, int Rpl) {
        double p = Math.pow(10,Rpl);
        Rval = Rval * p;
        double tmp = Math.round(Rval);
        return tmp/p;
    }
} 
    
