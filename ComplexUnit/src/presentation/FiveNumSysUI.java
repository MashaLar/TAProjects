package presentation;

import util.fivenumsys.NumSysTranslate;

import java.util.Scanner;

public class FiveNumSysUI {
    // class for menu and actions with 5 num system

    private Scanner in = new Scanner(System.in);

    //menu for work with 5 num system
    public void Menu() {
        boolean menuContinue = true; // Variable for cycle to repeat menu
        do {
        System.out.println("\n----Number System Menu----" +
                "\n-What do you want to do?" +
                "\n1)Translate to five num system;" +
                "\n2)Translate from five num system;" +
                "\n3)Quit." +
                "\n Your choice:");
            try {
                //Input choice
                int i = Integer.parseInt(in.nextLine());
                switch (i) {
                    case 1:
                        ToFive();
                        break;
                    case 2:
                        FromFive();
                        break;
                    case 3:
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

    //translate to 5
    private void ToFive(){
        do {
            try {
                System.out.println("\n-Please, input system number (2-37) of your number to translate." +
                        "\n Your system number:");
                //Inputting system
                int systemNum = Integer.parseInt(in.nextLine());
                System.out.println("\n-Please, input number (contains numbers " +
                        "or letters)." +
                        "\n Your number:");
                //Inputting number
                String s = in.nextLine();

                //If an integer number
                if(s.matches("[a-zA-Z0-9]+")&& systemNum<=36 && systemNum>=2){
                    System.out.println("Result: "+NumSysTranslate.ToAnyNumSysInt(s, systemNum,5));
                    break;
                }
                //If a fractional number
                else if(s.matches("[a-zA-Z0-9]+\\.[a-zA-Z0-9]+")&& systemNum<=36 && systemNum>=2) {
                    System.out.println("Result: "+NumSysTranslate.ToAnyNumSysFract(s,systemNum,4,5));
                    break;
                }
                else {
                    System.out.println("\n----Wrong input!----\n");
                }
            }catch (Exception e) {
                System.out.println("\n----Wrong input!----\n");
            }

        }while(true);
    }

    //translate from 5
    private void FromFive(){
        do {
            try {
                System.out.println("\n-Please, input number (contains numbers " +
                        "or letters)." +
                        "\n Your number:");
                //Inputting number in 5 number system
                String s = in.nextLine();
                System.out.println("\n-Please, input system number(2-37) of wanted result." +
                        "\n Your system number:");
                //Outputting system
                int systemNum = Integer.parseInt(in.nextLine());

                //If an integer number
                if(s.matches("[a-zA-Z0-9]+")&& systemNum<=37 && systemNum>=2){
                    System.out.println("Result: "+NumSysTranslate.ToAnyNumSysInt(s,5, systemNum));
                    break;
                }
                //If a fractional number
                else if(s.matches("[a-zA-Z0-9]+\\.[a-zA-Z0-9]+")&& systemNum<=37 && systemNum>=2) {
                    System.out.println("Result: "+NumSysTranslate.ToAnyNumSysFract(s,5,4,systemNum));
                    break;
                }
                else {
                    System.out.println("\n----Wrong input!----\n");
                }
            }catch (Exception e) {
                System.out.println("\n----Wrong input!----\n");
            }

        }while(true);
    }
}
