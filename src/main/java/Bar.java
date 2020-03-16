/**
 * Purpose of this class to store information about the protein bar.
 */

public class Bar {

    private String name;
    private int energy;
    private int kolhydrat;
    private int protein;
    private int fiber;
    private int reviewerCount;

    public Bar(String name, int energy, int kolhydrat, int protein, int fiber, int reviewerCount) {
        this.name = name;
        this.energy = energy;
        this.kolhydrat = kolhydrat;
        this.protein = protein;
        this.fiber = fiber;
        this.reviewerCount = reviewerCount;
    }

    public String getName(){
        return name;
    }
}