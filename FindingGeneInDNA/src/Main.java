import edu.duke.FileResource;
import edu.duke.URLResource;

public class Main {
    public static void main(String[] args) {

        /**
        System.out.println("Hello World!");
        testFindGene("AATGCGTTAGTAAAATATGGT");
        testFindGene("AATGCGTAATATGGT");
        testFindGene("AATGCTAGGGTAATATGGT");
        testFindGene("ATCCTATGCTTCGGCTGCTCTAATATGGT");
        testFindGene("TAA");
        testFindGene("ATG");
        testFindGene("AAATGCCCTAACTAGATTAAGAAACC");
        testFindGene("ATGATCGCTAATGCTGCTTAAGCTATG");
        testFindGene("AATGCGTAATATGGTAATGCTAGGGTAATATGGTATCCTATGCTTCGGCTGCTCTAATATGGTTAAATGAAATGCCCTAACTAGATTAAGAAACC");
        System.out.println("----------------------------------------------------------------------------");
        testMultipleGenes("AATGCGTAATATGGTAATGCTAGGGTAATATGGTATCCTATGCTTCGGCTGCTCTAATATGGTTAAATGAAATGCCCTAACTAGATTAAGAAACC");
        testMultipleGenes("ATGCCCTAAATGCCCTGAATGCCCTAG");StringsThirdAssignments
        **/
        /**
        FindGene findGene = new FindGene();
        findGene.testOn("AATGCGTAATATGGTAATGCTAGGGTAATATGGTATCCTATGCTTCGGCTGCTCTAATATGGTTAAATGAAATGCCCTAACTAGATTAAGAAACC");
        System.out.println("\n\n");
        findGene.testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        System.out.println("\n\n");
        findGene.testOn("");
        System.out.println("\n\n");
        findGene.testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
         **/
        // Practical quiz solution
        //Part1 part1 = new Part1();
        //FileResource fileResource = new FileResource("brca1line.fa");
        //String geneAsString = fileResource.asString();
        //part1.testProcessGenes(geneAsString);
        ///////////////////////////////////////////////////////
        AssignmentOfStrings assignmentOfStrings = new AssignmentOfStrings();
        //assignmentOfStrings.findYouTubeURLs("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        //System.out.println(assignmentOfStrings.mystery("TTTTTTTATTTA"));
        //assignmentOfStrings.getAllHrefsOfURL("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        Part1 part1 = new Part1();
        //assignmentOfStrings.findGenesInURL("https://users.cs.duke.edu/~rodger/GRch38dnapart.fa");
        URLResource urlResource = new URLResource("https://users.cs.duke.edu/~rodger/GRch38dnapart.fa");
        String dna = urlResource.asString();
        System.out.println(part1.countCTG(dna));
        System.out.println(part1.cgRatio(dna));
    }
    public static void testFindGene(String dna) {

        FindGene findGene = new FindGene();

        System.out.println("Found gene in the dna [" + dna + "] is " + findGene.findGene(dna, 0));
    }
    public static void testMultipleGenes(String dna) {

        FindGene findGene = new FindGene();

        System.out.println("Found gene in the dna [" + dna + "] is " + findGene.findMultipleGenes(dna));
        //findGene.findMultipleGenesInstructorImplementation("AATGCGTAATATGGTAATGCTAGGGTAATATGGTATCCTATGCTTCGGCTGCTCTAATATGGTTAAATGAAATGCCCTAACTAGATTAAGAAACC");
        //findGene.findMultipleGenesInstructorImplementation("ATGCCCTAAATGCCCTGAATGCCCTAG");

    }


}
