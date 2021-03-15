import edu.duke.StorageResource;

import java.util.ArrayList;

public class Part1 {
    /**
     * A method to check if a dna has a valid gene
     * @param dna String represents the DNA string.
     * @return The gene if it's found or "gene not found", if there is not
     */
    public String findGene(String dna, int where) {
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1)
        {
            return "";
        }
        else
        {
            int taaIndex = findStopCodon(dna, startIndex, "TAA");
            int tagIndex = findStopCodon(dna, startIndex, "TAG");
            int tgaIndex = findStopCodon(dna, startIndex, "TGA");
            int minIndex;
            if(taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
                minIndex = tgaIndex;
            }
            else {
                minIndex = taaIndex;
            }
            if(minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {
                minIndex = tagIndex;
            }
            if (minIndex == -1)
            {
                return "";
            }
            return dna.substring(startIndex, minIndex + 3);
        }

    }

    /**
     * Find the index of the first occurred gene, based on the codon passed.
     * @param str String represents the dna String
     * @param startIndex int represents the point, at which the search starts
     * @param codon String represents the codon
     * @return index of the found codon, if it meets the criteria
     */
    public int findStopCodon(String str, int startIndex, String codon) {
        int currIndex  = str.indexOf(codon, startIndex + 3);
        while(currIndex != -1) {
            if ((currIndex - startIndex) % 3 == 0){
                return  currIndex;
            }
            else {
                currIndex = str.indexOf(codon, currIndex + 1);
            }
        }
        return -1;
    }

    /**
     * Find all the possible genes in a String.
     * @param dna String represents the dna String.
     * @return An arraylist of all found genes.
     */
    public String findMultipleGenes(String dna){
        ArrayList<String> genes = new ArrayList<String>();
        int startIndex = 0;

        while (startIndex <= dna.length()) {
            startIndex = dna.indexOf("ATG", startIndex);
            if (startIndex == -1)
            {
                return genes.toString();
                //return "Gene not found!";
            }
            else{
                int taaIndex = findStopCodon(dna, startIndex, "TAA");
                int tagIndex = findStopCodon(dna, startIndex, "TAG");
                int tgaIndex = findStopCodon(dna, startIndex, "TGA");
                int minIndex;
                if(taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
                    minIndex = tgaIndex;
                }
                else {
                    minIndex = taaIndex;
                }
                if(minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {
                    minIndex = tagIndex;
                }
                if (minIndex == -1)
                {
                    genes.add("");
                }
                genes.add(dna.substring(startIndex, minIndex + 3));
                startIndex = minIndex + 3;
            }

        }
        return genes.toString();
    }

    public void findMultipleGenesInstructorImplementation(String dna) {
        int startIndex = 0;

        while (true) {
            String currentGene = findGene(dna, startIndex);
            if (currentGene.equals("")) {
                break;
            }
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
    }

    public StorageResource getAllGenes(String dna) {
        dna = dna.toUpperCase();
        System.out.println(dna);
        StorageResource geneList = new StorageResource();
        int startIndex = 0;

        while (true) {
            String currentGene = findGene(dna, startIndex);

            if (currentGene.isEmpty()) {
                break;
            }

            geneList.add(currentGene);

            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return geneList;
    }

    public void testOn(String dna) {
        System.out.println("Testing getAllGenes on " + dna);
        StorageResource genes = getAllGenes(dna);
        for (String g: genes.data()) {
            System.out.println(g);
        }
    }

    public float cgRatio(String dna) {
        dna = dna.toUpperCase();
        int numberOfCs = 0;
        int numberOfGs = 0;
        for(int i = 0; i < dna.length(); i++) {
            char c = dna.charAt(i);
            if (c == 'C') {
                numberOfCs++;
            }
            else if (c == 'G') {
                numberOfGs++;
            }
        }
        return ((float) numberOfCs) /  numberOfGs;
    }


    public int countCTG(String dna) {
        int ctgS = 0;
        int start = 0;

        while (true) {
            int ctgFound = dna.indexOf("CTG", start);
            if (ctgFound != -1) {
                ctgS++;
                start = ctgFound + 3;
            }
            else{
                break;
            }
        }
        return ctgS;
    }


    public void processGenes(StorageResource sr) {
        int moreThanNine = 0;
        int ratioMoreThanZeroCommaThirtyFive = 0;
        String longestGene = "";
        int maxLongestGene = 0;

        for(String storageResource : sr.data()) {
            System.out.println(storageResource);
            storageResource = storageResource.toUpperCase();
            if (storageResource.length() > 60) {
                System.out.println("Gene more than 9 chars: " + storageResource);
                moreThanNine++;
            }
            if(cgRatio(storageResource) > 0.35) {
                System.out.println("Gene's CG ratio more than 0.35: " + storageResource);
                ratioMoreThanZeroCommaThirtyFive++;
            }
            //String gene = findGene(storageResource, 0);

            if (storageResource.length() > maxLongestGene) {
                maxLongestGene = storageResource.length();
                longestGene = storageResource;
            }
            System.out.println("-----------------------------------------------------------------------");
        }
        System.out.println("More than nine characters: " + moreThanNine);
        System.out.println("More than 0.35 ratio: " + ratioMoreThanZeroCommaThirtyFive);
        System.out.println("Longest gene: " + maxLongestGene);


    }
    public void testProcessGenes(String dna) {
        StorageResource sr = getAllGenes(dna);
        System.out.println("Number of genes: " + sr.size());
        //testOn(dna);
        //sr.add(dna);
        processGenes(sr);
        System.out.println();
    }
}
