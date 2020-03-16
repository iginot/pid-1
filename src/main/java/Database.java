package main.java;

import java.util.ArrayList;
import java.io.File;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.util.Comparator;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.List;

/**
 * Purpose of this class is to host a database of protein bars.
 */

public class Database{

    private ArrayList<Bar> database;
    private Texts screenWriter;

    public Database() {
        database = new ArrayList<Bar>();
        screenWriter = new Texts();
        readFile();
    }

    public void allBarsShow(){
        screenWriter.headerAllBarsShow();
        for (Bar bar : database)
        {
            System.out.println(bar.getName());
        }
    }

    public void compareByProtein(){
        Comparator<Bar> compareByProtein = (Bar b1, Bar o2) ->
                b1.getProtein().compareTo( o2.getProtein() );
        Collections.sort(database, compareByProtein.reversed());
    }

    public void compareByFat(){
        Comparator<Bar> compareByFat = (Bar b1, Bar o2) ->
                b1.getFat().compareTo( o2.getFat() );
        Collections.sort(database, compareByFat.reversed());
    }

    public void filterByFiber(){
        Comparator<Bar> compareByFiber = (Bar b1, Bar o2) ->
                b1.getFiber().compareTo( o2.getFiber() );
        Collections.sort(database, compareByFiber.reversed());
    }

    public void readFile()
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("/Users/igortruchlik/PID-exercises/E1/pid-exercise-1/bars.xml"));

            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();

            NodeList children = root.getElementsByTagName("bar");

            for (int counter = 0; counter < 6; counter ++) {

                //children.getLength()
                Element eJElement = (Element) children.item(counter);

                String name = eJElement.getAttribute("SN");
                String fat = eJElement.getElementsByTagName("fett").item(0).getTextContent();
                String energy = eJElement.getElementsByTagName("energy").item(0).getTextContent();
                String kolhydrat = eJElement.getElementsByTagName("kolhydrat").item(0).getTextContent();
                String protein = eJElement.getElementsByTagName("protein").item(0).getTextContent();
                String fiber = eJElement.getElementsByTagName("fiber").item(0).getTextContent();

                Double fatDouble = Double.valueOf(fat);
                Double energyDouble = Double.valueOf(energy);
                Double kolhydratDouble = Double.valueOf(kolhydrat);
                Double proteinDouble = Double.valueOf(protein);
                Double fiberDouble = Double.valueOf(fiber);

                Bar newBar = new Bar(name, fatDouble, energyDouble, kolhydratDouble, proteinDouble, fiberDouble);
                database.add(newBar);

            }
        } catch(Exception e)
        {}

    }

}
