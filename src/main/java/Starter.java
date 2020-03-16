package main.java;

/**
 * Purpose of this class is to start application and keep it opened while the user needs it.
 */

public class Starter {

    private Database barDatabase;
    private Texts screenWriter;

    public Starter()
    {
        barDatabase = new Database();
        screenWriter = new Texts();
    }

    private void runtime() {

        boolean runtimeActive = true;
        Keyboard commandKeyboard = new Keyboard();

        screenWriter.welcomeScreen();

        while (runtimeActive) {
            String userInput = commandKeyboard.getInput();
            runtimeActive = processCommand(userInput);
        }
    }

    private boolean processCommand(String inputFromUser) {
        switch (inputFromUser) {
            case "1":
                barDatabase.allBarsShow();
                return true;
            case "2":
                barDatabase.compareByProtein();
                screenWriter.headerSortByProtein();
                barDatabase.allBarsShow();
                return true;
            case "3":
                barDatabase.compareByFat();
                screenWriter.headerSortByFat();
                barDatabase.allBarsShow();
                return true;
            case "4":
                barDatabase.filterByFiber();
                screenWriter.headerFilterByFiber();
                barDatabase.allBarsShow();
                return true;
            case "0":
                screenWriter.exitScreen();
                return false;
            default:
                screenWriter.wrongMenuInput();
                return true;
        }
    }

    public static void main(String[] args) {
        Starter barApplication = new Starter();
        barApplication.runtime();
    }
}