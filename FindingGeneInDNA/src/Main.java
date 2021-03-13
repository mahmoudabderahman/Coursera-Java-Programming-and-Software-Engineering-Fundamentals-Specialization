public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        testFindGeneSimple("AATGCGTAATATGGT");
        testFindGeneSimple("AATGCTAGGGTAATATGGT");
        testFindGeneSimple("ATCCTATGCTTCGGCTGCTCTAATATGGT");
        testFindGeneSimple("TAA");
    }
    public static void testFindGeneSimple(String dna) {

        FindGene findGene = new FindGene();

        System.out.println("Found gene in the dna [" + dna + "] is " + findGene.findGene(dna));
    }
}
