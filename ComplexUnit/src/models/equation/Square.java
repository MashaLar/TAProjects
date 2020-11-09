package models.equation;

import models.complex.ComplexNumber;

public class Square {
    // Class for finding solutions of square equation

    // Finding discriminant
    public static double Discriminant(double a, double b, double c){
        return Math.pow(b,2)-4*a*c;
    }

    // Check sign of discriminant
    private static String DiscriminantCheck(double D, double twoA, double b){
        String Solution = "";
        double root = 1/2; //variable for root from number in Math.pow method
        if(D > 0){
            //if discriminant more than zero, then we have two real number solutions
            Solution += "" + ((-b+Math.pow(D,root))/twoA);
            Solution += "_" + ((-b-Math.pow(D,root))/twoA);
        }
        if(D == 0){
            //if discriminant equal zero, we have only one solution
            Solution += "" + ((-b)/twoA);
        }
        if(D < 0){
            //if discriminant less than zero, we have two complex solutions
            Solution += new ComplexNumber(-b/twoA,Math.pow(D,root)/twoA).toString();
            Solution +="_"+ new ComplexNumber(-b/twoA,-(Math.pow(D,root)/twoA)).toString();
        }
        return Solution;
    }

    // Finding Solutions
    public static String[] GetSolution(double a, double b, double c){
        double D = Discriminant(a,b,c); // Finding discriminant
        //Finding solutions and make array of solution string variables
        String[] Solution = DiscriminantCheck(D,2*a,b).split("_");
        return Solution;
    }

}
