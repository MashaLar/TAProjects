package presentation;

import models.complex.*;


import java.util.Scanner;

public class ComplexUI {

    private Scanner in = new Scanner(System.in);
    private ComplexNumber mainComplex;

    public ComplexUI() {
        do {
            System.out.println("\n-Please, input complex number(z=a+bi) or expression which contains numbers, " +
                    "letter 'i' and signs '+' or '-'." +
                    "\n Your number:");
            mainComplex = new ComplexNumber(in.nextLine());
        }while(mainComplex.getImagine()==0 && mainComplex.getReal()==0);
        ComplexUIMenu();
    }

    private void ComplexUIMenu()
    {
        boolean menuContinue = true;
        do {
            System.out.println("\n----Complex Numbers Menu-----" +
                    "\n-What do you want to do?" +
                    "\n1)Update complex number;" +
                    "\n2)Add to complex number;" +
                    "\n3)Subtract from complex number;" +
                    "\n4)Multiply complex number;" +
                    "\n5)Devide complex number;" +
                    "\n6)Quit." +
                    "\n Your choice:");
            try {
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
                        DevideCM();
                        break;
                    case 6:
                        System.out.println("\n-----Good luck!-----\n");
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

    private void UpdateComplexUI() {
        ComplexNumber cloneMC = mainComplex;
        do {
            System.out.println("\n-Please, input NEW complex number or expression which contains numbers, " +
                    "letter 'i' and signs '+' or '-'." +
                    "\n Your number:");
            mainComplex = new ComplexNumber(in.nextLine());
        }while((mainComplex.getImagine()==0 && mainComplex.getReal()==0) && mainComplex!=cloneMC);
    }

    private boolean CheckDoubleEx(String str){
        if(str.matches("(-?\\d+(\\.\\d)?[-+]?)*")) {
            return true;
        }
        if(str.matches("(-?\\d+(\\.\\d)?i[-+]?)*")) {
            return true;
        }
            return false;
    }

    private void AddToCM(){
       do {
           try {
               System.out.println("\n-Please, input number or expression which contains numbers, " +
                       "letter 'i' and signs '+' or '-'." +
                       "\n Your number:");
               String s = in.nextLine();
               if (CheckDoubleEx(s)) {
                   double number = 0;
                   if (s.contains("i")) {
                       s = s.replaceAll("i", "");
                       String nums[] = s.split("(\\+|(?=-))");
                       for (String num : nums) {
                           number += Double.parseDouble(num);
                       }
                       mainComplex = ComplexMath.Add(mainComplex, number);
                   } else {
                       String nums[] = s.split("(\\+|(?=-))");
                       for (String num : nums) {
                           number += Double.parseDouble(num);
                       }
                       mainComplex = ComplexMath.Add(number, mainComplex);
                   }
                   System.out.println("\nComplex number changed! z = "+ mainComplex.toString());
                   break;
               }
               else {
                   mainComplex = ComplexMath.Add(mainComplex, new ComplexNumber(s));
                   System.out.println("\nComplex number changed! z = "+ mainComplex.toString());
                   break;
               }

           }catch (Exception e) {
               System.out.println("\n----Wrong input!----\n");
           }

       }while(true);
    }

    private void SubtractCM(){
        do {
            try {
                System.out.println("\n-Please, input number or expression which contains numbers, " +
                        "letter 'i' and signs '+' or '-'." +
                        "\n Your number:");
                String s = in.nextLine();
                if (CheckDoubleEx(s)) {
                    double number = 0;
                    if (s.contains("i")) {
                        s = s.replaceAll("i", "");
                        String nums[] = s.split("(\\+|(?=-))");
                        for (String num : nums) {
                            number += Double.parseDouble(num);
                        }
                        mainComplex = ComplexMath.SubtractionImagine(mainComplex, number);
                    } else {
                        String nums[] = s.split("(\\+|(?=-))");
                        for (String num : nums) {
                            number += Double.parseDouble(num);
                        }
                        mainComplex = ComplexMath.SubtractionReal(mainComplex,number);
                    }
                    System.out.println("\nComplex number changed! z = "+ mainComplex.toString());
                    break;
                } else {
                    mainComplex = ComplexMath.Subtraction(mainComplex, new ComplexNumber(s));
                    System.out.println("\nComplex number changed! z = "+ mainComplex.toString());
                    break;
                }
            }catch (Exception e) {
                System.out.println("\n----Wrong input!----\n");
            }

        }while(true);
    }

    private void MultiplyCM(){
        do {
            try {
                System.out.println("\n-Please, input number or expression which contains numbers, " +
                        "letter 'i' and signs '+' or '-'." +
                        "\n Your number:");
                String s = in.nextLine();
                if (CheckDoubleEx(s)) {
                    double number = 0;
                    if (s.contains("i")) {
                        s = s.replaceAll("i", "");
                        String nums[] = s.split("(\\+|(?=-))");
                        for (String num : nums) {
                            number += Double.parseDouble(num);
                        }
                        mainComplex = ComplexMath.Multiply(mainComplex, number);
                        double buf = - mainComplex.getImagine();
                        mainComplex.setImagine(mainComplex.getImagine());
                        mainComplex.setReal(buf);
                    } else {
                        String nums[] = s.split("(\\+|(?=-))");
                        for (String num : nums) {
                            number += Double.parseDouble(num);
                        }
                        mainComplex = ComplexMath.Multiply(mainComplex,number);
                    }
                    System.out.println("\nComplex number changed! z = "+ mainComplex.toString());
                    break;
                } else {
                    mainComplex = ComplexMath.Multiply(mainComplex, new ComplexNumber(s));
                    System.out.println("\nComplex number changed! z = "+ mainComplex.toString());
                    break;
                }
            }catch (Exception e) {
                System.out.println("\n----Wrong input!----\n");
            }

        }while(true);
    }

    private boolean CheckDoubleForDevideMethod(String str){
        if(str.matches("(-?\\d+(\\.\\d)?[-+]?)*")) {
            return true;
        }
        return false;
    }

    private void DevideCM(){
        do {
            try {
                System.out.println("\n-Please, input number or expression which contains numbers, " +
                        "letter 'i' and signs '+' or '-'." +
                        "\n Your number:");
                String s = in.nextLine();
                if (CheckDoubleForDevideMethod(s)) {
                    double number = 0;
                    String nums[] = s.split("(\\+|(?=-))");
                    for (String num : nums) {
                        number += Double.parseDouble(num);
                    }
                    mainComplex = ComplexMath.Devide(mainComplex,number);
                    System.out.println("\nComplex number changed! z = "+ mainComplex.toString());
                    break;
                } else {
                    mainComplex = ComplexMath.Devide(mainComplex, new ComplexNumber(s));
                    System.out.println("\nComplex number changed! z = "+ mainComplex.toString());
                    break;
                }
            }catch (Exception e) {
                System.out.println("\n----Wrong input!----\n");
            }

        }while(true);
    }



}
