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
    /**
    public String coldestHourInFile(CSVParser parser) {
        CSVRecord records = parser.getRecords();
        int max =
        for (CSVRecord record : parser) {

        }
    }
     */
    public CSVRecord hottestHourInFile(CSVParser parser) {
        CSVRecord largestSoFar = null;

        for (CSVRecord currentRow : parser) {
            if (largestSoFar == null) {
                largestSoFar = currentRow;
            }
            else
            {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));

                if (currentTemp > largestTemp) {
                    largestSoFar = currentRow;
                }
            }
        }

        return largestSoFar;
    }

    public CSVRecord hottestInManyDays() {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
            if (largestSoFar == null) {
                largestSoFar = currentRow;
            }
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));

                if (currentTemp > largestTemp) {
                    largestSoFar = currentRow;
                }
            }
        }
        return largestSoFar;
    }
}
