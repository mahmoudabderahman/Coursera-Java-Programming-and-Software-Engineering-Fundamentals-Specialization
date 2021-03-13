public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        testFindGene("AATGCGTAATATGGT");
        testFindGene("AATGCTAGGGTAATATGGT");
        testFindGene("ATCCTATGCTTCGGCTGCTCTAATATGGT");
        testFindGene("TAA");
        testFindGene("ATG");
        testFindGene("AAATGCCCTAACTAGATTAAGAAACC");
        testFindGene("ATGATCGCTAATGCTGCTTAAGCTATG");
        testFindGene("AATGCGTAATATGGTAATGCTAGGGTAATATGGTATCCTATGCTTCGGCTGCTCTAATATGGTTAAATGAAATGCCCTAACTAGATTAAGAAACC");
    }
    public static void testFindGene(String dna) {

        FindGene findGene = new FindGene();

        System.out.println("Found gene in the dna [" + dna + "] is " + findGene.findGene(dna));
    }


}
