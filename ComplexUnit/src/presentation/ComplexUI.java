package presentation;

import models.ComplexNumber;
import util.complex.ComplexMath;

import java.util.Scanner;

public class ComplexUI {
    // class for menu and actions with complex numbers

    private Scanner in = new Scanner(System.in);
    private ComplexNumber mainComplex;

    //constructor for complex number which is would be main/changing in result of actions
    public ComplexUI() {
        do {
            System.out.println("\n-Please, input complex number(z=a+bi) or expression which contains numbers, " +
                    "letter 'i' and signs '+' or '-'." +
                    "\n Your number:");
            mainComplex = new ComplexNumber(in.nextLine());
        }while(mainComplex.getImagine()==0 && mainComplex.getReal()==0);
        //ComplexUIMenu(); //running menu for complex number
    }

    //menu
    public void Menu() {
        boolean menuContinue = true;  // Variable for cycle to repeat menu
        do {
            System.out.println("\n----Complex Numbers Menu-----" +
                    "\n-What do you want to do?" +
                    "\n1)Update complex number;" +
                    "\n2)Add to complex number;" +
                    "\n3)Subtract from complex number;" +
                    "\n4)Multiply complex number;" +
                    "\n5)Divide complex number;" +
                    "\n6)Quit." +
                    "\n Your choice:");
            try {
                //Input choice
                int i = Integer.parseInt(in.nextLine());
                switch (i) {
                    case 1:
                        UpdateComplexUI();
                        break;
                    case 2:
                        AddToCM();
                        break;
                    case 3:
                        SubtractCM();
                        break;
                    case 4:
                        MultiplyCM();
                        break;
                    case 5:
                        DivideCM();
                        break;
                    case 6:
                        System.out.println("\n-----Back To Main Menu-----\n");
                        menuContinue = false;
                        break;
                    default:
                        System.out.println("\n----Wrong input!----\n");
                        break;
                }
            }
            catch(Exception e){
                System.out.println("\n----Wrong input!----\n");
            }
        }while(menuContinue);

    }

    //change value of main complex number (should be changed)
    private void UpdateComplexUI() {
        ComplexNumber cloneMC = mainComplex;
        do {
            System.out.println("\n-Please, input NEW complex number or expression which contains numbers, " +
                    "letter 'i' and signs '+' or '-'." +
                    "\n Your number:");
            mainComplex = new ComplexNumber(in.nextLine());
        }while((mainComplex.getImagine()==0 && mainComplex.getReal()==0) && mainComplex==cloneMC);
        System.out.println("\nComplex number changed! "+ mainComplex.toString());
    }

    //check expression for add, subtract methods
    private boolean CheckDoubleSimple(String str){
        if(str.matches("(-?\\d+(\\.\\d)?[-+]?)+")) {
            return true;
        }
        if(str.matches("(-?\\d+(\\.\\d)?i[-+]?)+")) {
            return true;
        }
            return false;
    }
    //add method input menu
    private void AddToCM(){
       do {
           try {
               System.out.println("\n-Please, input number or expression which contains numbers, " +
                       "letter 'i' and signs '+' or '-'." +
                       "\n Your number:");
               String s = in.nextLine();
               //checking which method of add should be
               if (CheckDoubleSimple(s)) {
                   //if it is a one number (with 'i' or not)
                   double number = 0;
                   if (s.contains("i")) {
                       //adding to imagine
                       s = s.replaceAll("i", "");
                       String[] nums = s.split("(\\+|(?=-))");
                       for (String num : nums) {
                           number += Double.parseDouble(num);
                       }
                       mainComplex = ComplexMath.Add(mainComplex, number);
                   }
                   else {
                       //adding to real
                       String[] nums = s.split("(\\+|(?=-))");
                       for (String num : nums) {
                           number += Double.parseDouble(num);
                       }
                       mainComplex = ComplexMath.Add(number, mainComplex);
                   }
                   System.out.println("\nComplex number changed! "+ mainComplex.toString());
                   break;
               }
               else if(s.matches("(-?\\d+(\\.\\d)?i?[-+]?)+")){
                   //if it is a complex number, adding new complex number to main
                   mainComplex = ComplexMath.Add(mainComplex, new ComplexNumber(s));
                   System.out.println("\nComplex number changed! "+ mainComplex.toString());
                   break;
               }
               else{  System.out.println("\n----Wrong input!----\n"); }
           }catch (Exception e) {
               System.out.println("\n----Wrong input!----\n");
           }

       }while(true);
    }
    //subtract method input menu
    private void SubtractCM(){
        do {
            try {
                System.out.println("\n-Please, input number or expression which contains numbers, " +
                        "letter 'i' and signs '+' or '-'." +
                        "\n Your number:");
                String s = in.nextLine();
                //checking which method of add should be
                if (CheckDoubleSimple(s)) {
                    //if it is a one number (with 'i' or not)
                    double number = 0;
                    if (s.contains("i")) {
                        //subtract from imagine
                        s = s.replaceAll("i", "");
                        String[] nums = s.split("(\\+|(?=-))");
                        for (String num : nums) {
                            number += Double.parseDouble(num);
                        }
                        mainComplex = ComplexMath.SubtractionImagine(mainComplex, number);
                    }
                    else {
                        //subtract from real
                        String[] nums = s.split("(\\+|(?=-))");
                        for (String num : nums) {
                            number += Double.parseDouble(num);
                        }
                        mainComplex = ComplexMath.SubtractionReal(mainComplex,number);
                    }
                    System.out.println("\nComplex number changed! z = "+ mainComplex.toString());
                    break;
                }
                else if(s.matches("(-?\\d+(\\.\\d)?i?[-+]?)+")){
                    //if it is a complex number, subtract new complex number from main
                    mainComplex = ComplexMath.Subtraction(mainComplex, new ComplexNumber(s));
                    System.out.println("\nComplex number changed! z = "+ mainComplex.toString());
                    break;
                }
                else{
                    System.out.println("\n----Wrong input!----\n");
                }
            }catch (Exception e) {
                System.out.println("\n----Wrong input!----\n");
            }

        }while(true);
    }

    //check expression for multiply, divide methods
    private boolean CheckDoubleHard(String str){
        if(str.matches("(-?[1-9]+(\\.\\d)?[-+]?)+|(-?\\d+(\\.\\d*[1-9]+)+[-+]?)+")) {
            return true;
        }
        return false;
    }
    //multiply method input menu
    private void MultiplyCM(){
        do {
            try {
                System.out.println("\n-Please, input number or expression which contains numbers, " +
                        "letter 'i' and signs '+' or '-'." +
                        "\n Your number:");
                String s = in.nextLine();
                //checking which method of add should be
                if (CheckDoubleHard(s)) {
                    //if it is a one number (with 'i' or not)
                    double number = 0;
                    if (s.contains("i")) {
                        //multiply to imagine
                        s = s.replaceAll("i", "");
                        String[] nums = s.split("(\\+|(?=-))");
                        for (String num : nums) {
                            number += Double.parseDouble(num);
                        }
                        mainComplex = ComplexMath.Multiply(mainComplex, number);
                        double buf = - mainComplex.getImagine();
                        mainComplex.setImagine(mainComplex.getImagine());
                        mainComplex.setReal(buf);
                    }
                    else {
                        //multiply to real
                        String[] nums = s.split("(\\+|(?=-))");
                        for (String num : nums) {
                            number += Double.parseDouble(num);
                        }
                        mainComplex = ComplexMath.Multiply(mainComplex,number);
                    }
                    System.out.println("\nComplex number changed! "+ mainComplex.toString());
                    break;
                }
                else if(s.matches("(-?[1-9]+(\\.\\d)?i?[-+]?)+|(-?\\d+(\\.\\d*[1-9]+)+i?[-+]?)+")){
                    //if it is a complex number, multiply new complex number to main
                    mainComplex = ComplexMath.Multiply(mainComplex, new  ComplexNumber(s));
                    System.out.println("\nComplex number changed! "+ mainComplex.toString());
                    break;
                }
                else{System.out.println("\n----Wrong input!----\n");}
            }catch (Exception e) {
                System.out.println("\n----Wrong input!----\n");
            }

        }while(true);
    }
    //divide method input menu
    private void DivideCM(){
        do {
            try {
                System.out.println("\n-Please, input number or expression which contains numbers, " +
                        "letter 'i' and signs '+' or '-'." +
                        "\n Your number:");
                String s = in.nextLine();
                //checking which method of add should be
                if (CheckDoubleHard(s)) {
                    //divide on real
                    double number = 0;
                    String[] nums = s.split("(\\+|(?=-))");
                    for (String num : nums) {
                        number += Double.parseDouble(num);
                    }
                    mainComplex = ComplexMath.Divide(mainComplex,number);
                    System.out.println("\nComplex number changed! z = "+ mainComplex.toString());
                    break;
                }
                else if(s.matches("(-?[1-9]+(\\.\\d)?i?[-+]?)+|(-?\\d+(\\.\\d*[1-9]+)+i?[-+]?)+")){
                    //if it is a complex number, divide new complex number on main
                    mainComplex = ComplexMath.Divide(mainComplex, new ComplexNumber(s));
                    System.out.println("\nComplex number changed! z = "+ mainComplex.toString());
                    break;
                }
                else{System.out.println("\n----Wrong input!----\n");}
            }catch (Exception e) {
                System.out.println("\n----Wrong input!----\n");
            }
        }while(true);
    }

}
