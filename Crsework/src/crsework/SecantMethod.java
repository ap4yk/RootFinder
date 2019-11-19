package crsework;
/**
 *
 * @author Arunas
 */
public class SecantMethod {

    public SecantMethod() {
    
    }
   
    public String findRoots(double range,double xInput, double decimal){
        double xold1 = 0.0, xold2 = 0.5;
        double xnew, fxold1, fxold2, diff;
        int iteration = 0;
        String interval="";
        do
            {
            iteration = iteration + 1;
            fxold1 = xold1 - Math.cos(xold1);
            fxold2 = xold2 - Math.cos(xold2);
            xnew = xold1 - (fxold1 * (xold1 - xold2)) / (fxold1 - fxold2);
            System.out.println("Approx for iteration"+iteration +" is "+xnew);
            interval=interval+"Approx for iteration"+iteration +" is "+xnew+"\n";
            diff = Math.abs(xnew - xold1);
            xold2 = xold1;
            xold1 = xnew;
            }
        while(diff > decimal);
            System.out.println("root to six decimal places is "+xnew);
            interval=interval+"root to six decimal places is "+xnew+"\n";
            return interval;
    }
    
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    