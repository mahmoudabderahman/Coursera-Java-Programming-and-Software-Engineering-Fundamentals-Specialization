import edu.duke.URLResource;

public class AssignmentOfStrings {
    public void findYouTubeURLs(String url) {
        URLResource urlResource = new URLResource(url);
        for(String line : urlResource.lines()) {
            line = line.toLowerCase();
            if (line.contains("href") && line.contains("youtube"))
            System.out.println(line);
        }
    }

    public void getAllHrefsOfURL(String url) {
        URLResource urlResource = new URLResource(url);
        String webContent = urlResource.asString();
        int start = webContent.indexOf("href=", 0);
        while (true) {
            if (start != -1) {
                String href = webContent.substring(start + 5, webContent.indexOf("\"", start));
                System.out.println(href);
                start = webContent.indexOf("\"", start) + 1;
            }
            else {
                break;
            }
        }

    }

    public String mystery(String dna) {
        // dna = TTATTA
        int pos = dna.indexOf("T"); // find the first occurrence of T
        int count = 0;
        int startPos = 0;
        String newDna = "";
        if (pos == -1) { // if there is no T found, return the dna String as it is
            return dna;
        }
        while (count < 3) { // loop till reaching the count of 3
            count += 1; // 1 2
            newDna = newDna + dna.substring(startPos,pos); // T T
            startPos = pos+1; // 1 2
            pos = dna.indexOf("T", startPos); // 1
            if (pos == -1) {
                break;
            }
        }
        newDna = newDna + dna.substring(startPos);
        return newDna;
    }

    public void findGenesInURL(String url) {
        Part1 part1 = new Part1();
        URLResource urlResource = new URLResource(url);
        String webContent = urlResource.asString();
        part1.testProcessGenes(webContent);
    }
}
