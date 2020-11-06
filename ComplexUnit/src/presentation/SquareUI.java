package presentation;

import models.equlation.Square;
import java.util.Scanner;

public class SquareUI {

    private Scanner in = new Scanner(System.in);

    public SquareUI(){
        System.out.println("\n-Input coefficients a,b,c for a*x^2 + b*x + c = 0");
        double a =0, b=0, c=0;
        do {
            try {
                System.out.println("\n-Please, input coefficient for x^2 (coefficient a) (from 4.9e-324 to 1.7e+308)" +
                        "\n Your number:");
                a = Double.parseDouble(in.nextLine());
                if (a != 0) {
                    System.out.println("\n-Please, input coefficient for x^1 (coefficient b) (from 4.9e-324 to 1.7e+308)" +
                            "\n Your number:");
                    b = Double.parseDouble(in.nextLine());
                    System.out.println("\n-Please, input coefficient for x^0 (coefficient c) (from 4.9e-324 to 1.7e+308)" +
                            "\n Your number:");
                    c = Double.parseDouble(in.nextLine());

                    String[] solution = Square.GetSolution(a, b, c);
                    for (int i =0; i<solution.length;i++) {
                        System.out.println("x="+solution[i]);
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("\n----Wrong input!----\n");
            }
        }while (true);
    }
}
