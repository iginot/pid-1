package main.java;

/**
 * Purpose of this class is to provide texts for text interface of the application.
 */

public class Texts {
    public void welcomeScreen()
    {
        System.out.println( "Welcome!\n" +
                            "1) Show the name of all bars.\n" +
                            "2) Sort bars based on highest protein content.\n" +
                            "3) Sort bars based on highest fat content.\n" +
                            "4) Filter bars and sort them from highest to lowest.\n" +
                            "Find all protein bars with more than\n" +
                            "0) Quit");
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
                            "name\t\tenergy\t\tkolhydrat\tprotein\t\tfiber\t\tfat");
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
}