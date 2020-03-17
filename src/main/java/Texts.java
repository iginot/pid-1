package main.java;

/**
 * Purpose of this class is to provide texts for text interface of the application.
 */

public class Texts {
    public void welcomeScreen()
    {
        System.out.println( "Welcome!\n" +
                "Our application provides the most comprehensive list of bars.\n" +
                "To see them, just follow the instructions in the menu.\n");
        menuScreen();
    }

    public void menuScreen()
    {
        System.out.println("1) Show the name of all bars.\n" +
                "2) Sort all bars based on highest protein content.\n" +
                "3) Sort all bars based on highest fat content.\n" +
                "4) Filter bars by maximal amount of fiber and sort them from highest to lowest.\n" +
                "5) Show bars that contain at least provided amount of protein and precise number of reviews.\n" +
                "0) Quit");
    }

    public void questionAfterCommand(){
        System.out.println("\nAre you ready for more fun?");
    }

    public void wrongMenuInput()
    {
        System.out.println("I don't understand. You can choose between options 1, 2, 3, 4 and 0.");
    }
    public void exitScreen()
    {
        System.out.println("You have chosen to quit. Have a nice day.");
    }
    public void headerAllBarsShow()
    {
        System.out.println("list of all bars in the database contains:\n" +
                            "name\t\tenergy\t\tkolhydrat\tprotein\t\tfiber\t\tfat\t\tcount of reviewers");
    }
    public void headerSortByProtein(){
        System.out.println("When sorting by highest protein content,");
    }
    public void headerSortByFat(){
        System.out.println("When sorting by highest fat content,");
    }
    public void headerFilterByFiber(){
        System.out.println("When sorting by highest fiber content,");
    }
    public void writeFilterValue(){
        System.out.println("Write value to filter the result:");
    }
    public void writeFiberValue(){
        System.out.println("Write me what is your fiber limit:");
    }
    public void writeProteinValue(){
        System.out.println("Write me what is your requirement for protein:");
    }
    public void writeReviewersCount(){
        System.out.println("How many reviewers do you want to have?");
    }
    public void wrongValueProvided(){
        System.out.println("You need to provide a valid number.");
    }
    public void XMLloadFailed()
    {
        System.out.println("XML document loading was unsuccessful.");
    }
}