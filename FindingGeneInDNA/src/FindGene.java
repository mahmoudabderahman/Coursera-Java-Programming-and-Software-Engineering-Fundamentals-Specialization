import java.util.ArrayList;
import java.util.List;

public class FindGene {

    /**
     * A method to check if a dna has a valid gene
     * @param dna String represents the DNA string.
     * @return The gene if it's found or "gene not found", if there is not
     */
    /**
    public String findGene(String dna)
    {
        String result = "";

        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) { // no ATG
        return "Gene not found";
        }

        int endIndex = dna.indexOf("TAA", startIndex + 3);
        if (endIndex == -1) { // no TAA
        }

        if ((endIndex - startIndex) % 3 == 0)
        {
            result = dna.substring(startIndex, endIndex + 3);
        }
        else
        {
            return "Gene not found";
        }
        return result;
    }
    */
    /**
     * A method to check if a dna has a valid gene
     * @param dna String represents the DNA string.
     * @return The gene if it's found or "gene not found", if there is not
     */
    public String findGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1)
        {
            return "Gene not found!";
        }
        else
        {
            int taaIndex = findStopCodon(dna, startIndex, "TAA");
            int tagIndex = findStopCodon(dna, startIndex, "TAG");
            int tgaIndex = findStopCodon(dna, startIndex, "TGA");
            int minIndex = Math.min(Math.min(taaIndex, tagIndex) , tgaIndex);
            if (minIndex == dna.length())
            {
                return "Gene not found!";
            }
            return dna.substring(startIndex, minIndex + 3);
        }

    }

    public int findStopCodon(String str, int startIndex, String codon) {
        int currIndex  = str.indexOf(codon, startIndex + 3);
        while(currIndex != -1) {
            if ((currIndex - startIndex) % 3 == 0){
                return  currIndex;
                //startIndex = start;
            }
            else {
                currIndex = str.indexOf(codon, currIndex + 1);
            }
        }
        return str.length();
    }
}
