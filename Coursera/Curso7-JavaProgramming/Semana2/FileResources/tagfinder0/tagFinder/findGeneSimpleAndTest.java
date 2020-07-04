public class findGeneSimpleAndTest {

    public String findGeneSimple (String dna) {
        //Start codon is  "ATG"
        //Stop codon is "TAA"

        String result = "";
        int startIndex = dna.indexOf("ATG");
        int stopIndex = dna.indexOf("TAA", startIndex + 3);

        if (startIndex == -1) {
            return "There's no ATG";
        }

        if (stopIndex == -1) {
            return "There's no TAA";
        }

        result = dna.substring(startIndex, stopIndex + 3);

        return result;
    }

    public void testFindGeneSimple() {
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene + "\n");

        dna = "AATGCGTAGGATAGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene + "\n");

    }
}

