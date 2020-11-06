package presentation;

import java.util.Scanner;

public class FolderUI {

    private Scanner in = new Scanner(System.in);

    public FolderUI()
    {
        System.out.println("\n----Number System Menu----" +
                "\n-What do you want to do?" +
                "\n1)Translate to five num system;" +
                "\n2)Translate from five num system;" +
                "\n3)Quit." +
                "\n Your choice:");
        int i = in.nextInt();
        switch (i){

            default:
                System.out.println("----Wrong input!");
                break;
        }

    }
}
