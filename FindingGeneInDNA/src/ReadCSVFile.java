import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.File;

public class ReadCSVFile {
    public void readFood(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord record : parser) {
            System.out.print(record.get("Name")+": ");
            System.out.println(record.get("Favorite Food"));
        }
    }
    public void listExporters(CSVParser parser, String exportOfInterest) {
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportOfInterest)) {
                System.out.println(record.get("Country"));
            }
        }
    }

    public String countryInfo(CSVParser parser, String country) {
        for (CSVRecord record : parser) {
            String export = record.get("Country");
            if (export.contains(country)) {
                return (country + ": " + record.get("Exports") + ": " + record.get("Value (dollars)"));
            }

        }
        return ("Not found");

    }

    public void listExportersTwoProducts(CSVParser parser, String exportitem1, String exportitem2) {
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportitem1) && export.contains(exportitem2)) {
                System.out.println(record.get("Country"));
            }
        }
    }

    public int numberOfExporters(CSVParser parser, String exportItem) {
        int number = 0;
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportItem)) {
                number ++;
            }
        }
        return number;
    }

    public void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            if (record.get("Value (dollars)").length() > amount.length()) {
                System.out.println(record.get("Country") + ":" + record.get("Value (dollars)"));
            }
        }
    }

    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord coldestSoFar = null;

        for (CSVRecord currentRow : parser) {
            coldestSoFar = getSmallestOfTwo(coldestSoFar, currentRow);
        }
        return coldestSoFar;
    }

    public CSVRecord hottestHourInFile(CSVParser parser) {
        CSVRecord largestSoFar = null;

        for (CSVRecord currentRow : parser) {
            largestSoFar = getLargestOfTwo(largestSoFar, currentRow);
        }

        return largestSoFar;
    }

    public CSVRecord hottestInManyDays() {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        // iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // use method to get largest in file.
            CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
            largestSoFar = getLargestOfTwo(largestSoFar, currentRow);
        }
        //The largestSoFar is the answer
        return largestSoFar;
    }

    private CSVRecord getLargestOfTwo(CSVRecord largestSoFar, CSVRecord currentRow) {
        if (largestSoFar == null) {
            largestSoFar = currentRow;
        }
        //Otherwise
        else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
            //Check if currentRow’s temperature > largestSoFar’s
            if (currentTemp > largestTemp) {
                //If so update largestSoFar to currentRow
                largestSoFar = currentRow;
            }
        }
        return largestSoFar;
    }

    private CSVRecord getSmallestOfTwo(CSVRecord smallestSoFar, CSVRecord currentRow) {
        if (smallestSoFar == null) {
            smallestSoFar = currentRow;
        }
        //Otherwise
        else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double largestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
            //Check if currentRow’s temperature > largestSoFar’s
            if (currentTemp < largestTemp) {
                //If so update largestSoFar to currentRow
                smallestSoFar = currentRow;
            }
        }
        return smallestSoFar;
    }
}
