/**
 * Purpose of this class is to provide texts for text interface of the application.
 */

public class Texts {
    public void welcomeScreen()
    {
        System.out.println( "Welcome!\n" +
                            "1) Show the name of all bars.\n" +
                            "Sort bars based on highest protein content.\n" +
                            "Sort bars based on highest fat content.\n" +
                            "Filter bars and sort them from highest to lowest.\n" +
                            "Find all protein bars with more than\n" +
                            "0) Quit");
    }
    public void wrongMenuInput()
    {
        System.out.println("I don't understand. You can choose between options 1 and 4.");
    }
    public void exitScreen()
    {
        System.out.println("You have chosen to quit. Have a nice day.");
    }
    public void headerAllBarsShow()
    {
        System.out.println("List of all bars in the database are:");
    }
}