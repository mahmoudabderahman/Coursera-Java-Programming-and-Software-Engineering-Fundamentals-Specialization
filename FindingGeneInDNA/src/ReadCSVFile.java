import edu.duke.*;
import org.apache.commons.csv.*;

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

    }
}
