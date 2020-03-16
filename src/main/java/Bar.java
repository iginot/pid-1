package main.java;

/**
 * Purpose of this class to store information about the protein bar.
 */

public class Bar {

    private String name;
    private double fat;
    private double energy;
    private double kolhydrat;
    private double protein;
    private double fiber;
    private int reviewerCount;

    public Bar(String name, double fat, double energy, double kolhydrat, double protein, double fiber) {
        this.fat = fat;
        this.name = name;
        this.energy = energy;
        this.kolhydrat = kolhydrat;
        this.protein = protein;
        this.fiber = fiber;
        reviewerCount = 0;
    }

    public String getName(){
        String returnName = name + "\t\t" + energy  + "\t\t" + kolhydrat  + "\t\t" + protein  + "\t\t" + fiber + "\t\t" + fat;
        return returnName;
    }

    public Double getProtein()
    {
        return protein;
    }

    public Double getFat()
    {
        return fat;
    }

    public Double getFiber()
    {
        return fiber;
    }

}