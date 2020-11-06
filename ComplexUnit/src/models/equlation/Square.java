package models.equlation;

import models.complex.ComplexNumber;

public class Square {

    public static double Discriminant(double a, double b, double c){
        return Math.pow(b,2)-4*a*c;
    }

    private static String DiscriminantCheck(double D, double twoA, double b){
        String Solution = "";
        double root = 1/2;
        if(D > 0){
            Solution += "" + ((-b+Math.pow(D,root))/twoA);
            Solution += "|" + ((-b-Math.pow(D,root))/twoA);
        }
        if(D == 0){
            Solution += "" + ((-b)/twoA);
        }
        if(D < 0){
            Solution += new ComplexNumber(-b/twoA,Math.pow(D,root)/twoA).toString();
            Solution +="|"+ new ComplexNumber(-b/twoA,-(Math.pow(D,root)/twoA)).toString();
        }
        return Solution;
    }

    public static String[] GetSolution(double a, double b, double c){
        double D = Discriminant(a,b,c);

        String Solution[] = DiscriminantCheck(D,2*a,b).split(".*\\|.*");
        return Solution;
    }


}
