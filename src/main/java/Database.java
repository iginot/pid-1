import java.util.ArrayList;

/**
 * Purpose of this class is to host a database of protein bars.
 */

public class Database {

    private ArrayList<Bar> database;

    public Database() {
        database = new ArrayList<Bar>();
        database.add(new Bar("Test", 10, 20, 30, 40, 2));
        database.add(new Bar("Second Test", 100, 200, 300, 400, 1));
    }

    public void allBarsShow(){
        for (Bar bar : database)
        {
            System.out.println(bar.getName());
        }
    }

}
