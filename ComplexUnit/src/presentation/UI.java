package presentation;

import java.util.Scanner;

public class UI {

    public static boolean Main() {
        Scanner in = new Scanner(System.in);
        System.out.println("\n-----Main menu-----" +
                "\n-What do you want to do?" +
                "\n1)Translate to five number system system;" +
                "\n2)Work with complex numbers;" +
                "\n3)Find solution for square equalation;" +
                "\n4)Quit." +
                "\n Your choice:");
        int i = in.nextInt();
        switch (i){
            case 1:
                new FolderUI();
                return true;
            case 2:
                new ComplexUI();
                return true;
            case 3:
                new SquareUI();
                return true;
            case 4:
                System.out.println("----Good luck!----");
                return false;
            default:
                System.out.println("----Wrong input!----");
                return true;
        }
    }
}
