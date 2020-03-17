package main.java;

/**
 * Purpose of this class is to start application and to keep it opened until the user decides to quit.
 * Application communicates via text interface.
 * User can type commands and application will process them or asks for additional input.
 */

public class Starter {

    private Database barDatabase;
    private Texts screenWriter;
    Keyboard commandKeyboard;

    public Starter()
    {
        barDatabase = new Database();
        screenWriter = new Texts();
        commandKeyboard= new Keyboard();
    }

    private void runtime() {

        boolean runtimeActive = true;

        screenWriter.welcomeScreen();

        while (runtimeActive) {
            String userInput = commandKeyboard.getInput();
            runtimeActive = processCommand(userInput);
            if(runtimeActive) {
                screenWriter.questionAfterCommand();
                screenWriter.menuScreen();
            } else {
                screenWriter.exitScreen();
            }

        }
    }

    private boolean processCommand(String inputFromUser) {

        double filteredValue;
        String valueFromUser;
        int reviewerCount;

        switch (inputFromUser) {

            case "1":
                barDatabase.allBarsShow();
                return true;
            case "2":
                barDatabase.sortByProtein();
                screenWriter.headerSortByProtein();
                barDatabase.allBarsShow();
                return true;
            case "3":
                barDatabase.sortByFat();
                screenWriter.headerSortByFat();
                barDatabase.allBarsShow();
                return true;
            case "4":
                screenWriter.writeFiberValue();
                valueFromUser = commandKeyboard.getInput();
                try {
                     filteredValue = Double.valueOf(valueFromUser);
                } catch (Exception e) {
                    screenWriter.wrongValueProvided();
                    return true;
                }
                barDatabase.filterByFiber(filteredValue);
                barDatabase.sortByFiber();
                screenWriter.headerFilterByFiber();
                barDatabase.filteredBarsShow();
                return true;
            case "5":
                screenWriter.writeProteinValue();
                valueFromUser = commandKeyboard.getInput();
                try {
                    filteredValue = Double.valueOf(valueFromUser);
                } catch (Exception e) {
                    screenWriter.wrongValueProvided();
                    return true;
                }
                screenWriter.writeReviewersCount();
                valueFromUser = commandKeyboard.getInput();
                try {
                    reviewerCount = Integer.valueOf(valueFromUser);
                } catch (Exception e) {
                    screenWriter.wrongValueProvided();
                    return true;
                }
                barDatabase.filterByProtein(filteredValue, reviewerCount);
                screenWriter.headerFilterByFiber();
                barDatabase.filteredBarsShow();
                return true;
            case "0":
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