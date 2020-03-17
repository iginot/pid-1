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
 * It also provides methods to create it and access it.
 */

public class Database{

    private List<Bar> database;
    private List<Bar> filteredDatabase;
    private Texts screenWriter;

    public Database() {
        database = new ArrayList<Bar>();
        filteredDatabase = new ArrayList<Bar>();
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

    public void filteredBarsShow(){
        screenWriter.headerAllBarsShow();
        for (Bar bar : filteredDatabase)
        {
            System.out.println(bar.getName());
        }
    }

    public void sortByProtein(){
        Comparator<Bar> compareByProtein = (Bar b1, Bar o2) ->
                b1.getProtein().compareTo( o2.getProtein() );
        Collections.sort(database, compareByProtein.reversed());
    }

    public void sortByFat(){
        Comparator<Bar> compareByFat = (Bar b1, Bar o2) ->
                b1.getFat().compareTo( o2.getFat() );
        Collections.sort(database, compareByFat.reversed());
    }

    public void sortByFiber(){
        Comparator<Bar> compareByFiber = (Bar b1, Bar o2) ->
                b1.getFiber().compareTo( o2.getFiber() );
        Collections.sort(filteredDatabase, compareByFiber.reversed());
    }

    public void filterByFiber(double filteredValue){
        filteredDatabase = database.stream()
                .filter(p -> p.getFiber() < filteredValue).collect(Collectors.toList());
    }

    public void filterByProtein(double proteinContent, int reviewerCount) {
        filteredDatabase = database.stream()
                .filter(p -> p.getProtein() > proteinContent && p.getReviewerCount() == reviewerCount).collect(Collectors.toList());
    }

    public void readFile()
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("../bars.xml"));

            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();

            NodeList children = root.getElementsByTagName("bar");

            for (int counter = 0; counter < children.getLength(); counter ++) {

                NodeList grandGrandChildren = null;
                int iterator = 0;
                int reviewerCount = 0;

                Element eJElement = (Element) children.item(counter);

                NodeList grandchildren = children.item(counter).getChildNodes();
                while(!grandchildren.item(iterator).getNodeName().equals("review") && iterator < grandchildren.getLength())
                {
                    iterator++;
                }
                if (grandchildren.item(iterator).getNodeName().equals("review")){
                    grandGrandChildren = grandchildren.item(iterator).getChildNodes();
                }

                for (int count = 0; count < grandGrandChildren.getLength(); count++){
                    if(grandGrandChildren.item(count).getNodeName().equals("reviewer")){
                        reviewerCount++;
                    }
                }

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

                Bar newBar = new Bar(name, fatDouble, energyDouble, kolhydratDouble, proteinDouble, fiberDouble, reviewerCount);
                database.add(newBar);
            }
        } catch(Exception e)
        {
            screenWriter.XMLloadFailed();
        }
    }
}