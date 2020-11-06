package mainApp;

import presentation.UI;

public class Main {

    public static void main(String[] args) {

        boolean workMainApp = true;
        do{
            workMainApp = UI.Main();
        } while (workMainApp);
    }
}
