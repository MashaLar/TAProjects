package mainApp;

import presentation.UI;

public class Main {

    public static void main(String[] args) {
        // Variable for cycle to repeat the program
        boolean workMainApp = true;
        do{
            //Running class to display an action of main menu
            workMainApp = UI.MainApp();
        } while (workMainApp);
    }
}
