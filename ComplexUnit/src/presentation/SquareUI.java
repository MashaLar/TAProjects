package presentation;

import util.equation.Square;
import java.util.Scanner;

public class SquareUI {
    // class for finding solutions of square equation

    private Scanner in = new Scanner(System.in);

    //menu for finding solutions of square equation
    public void Menu(){
        System.out.println("\n-Input coefficients a,b,c for a*x^2 + b*x + c = 0");
        double a =0, b=0, c=0;
        do {
            try {
                System.out.println("\n-Please, input coefficient for x^2 (coefficient a) (from 4.9e-324 to 1.7e+308)" +
                        "\n Your number:");
                a = Double.parseDouble(in.nextLine());
                if (a != 0) {
                    //if it really square equation(coefficient before x^2 should be not 0)
                    System.out.println("\n-Please, input coefficient for x^1 (coefficient b) (from 4.9e-324 to 1.7e+308)" +
                            "\n Your number:");
                    b = Double.parseDouble(in.nextLine());
                    System.out.println("\n-Please, input coefficient for x^0 (coefficient c) (from 4.9e-324 to 1.7e+308)" +
                            "\n Your number:");
                    c = Double.parseDouble(in.nextLine());

                    //find solution
                    String[] solution = Square.GetSolution(a, b, c);
                    for (int i =0; i<solution.length;i++) {
                        System.out.println(solution[i]); //show solutions
                    }
                    break;
                }
                else {
                    System.out.println("\n----Coefficient before x^2 should`t equal 0!----\n");
                }
            } catch (Exception e) {
                System.out.println("\n----Wrong input!----\n");
            }
        }while (true);
    }

}
