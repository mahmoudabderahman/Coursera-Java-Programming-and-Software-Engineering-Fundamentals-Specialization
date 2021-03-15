import edu.duke.FileResource;

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
        Part1 part1 = new Part1();
        FileResource fileResource = new FileResource("brca1line.fa");
        String geneAsString = fileResource.asString();
        part1.testProcessGenes(geneAsString);

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
