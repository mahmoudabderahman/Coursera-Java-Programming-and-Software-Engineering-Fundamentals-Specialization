public class FindGene {
    public String findGene(String dna)
    {
        String result = "";
        int startIndex = dna.indexOf("ATG");
        int endIndex = dna.indexOf("TAA", startIndex + 3);
        result = dna.substring(startIndex, endIndex + 3);
        return result;
    }

}
