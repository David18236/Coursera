/**
 * @author David Ospina Osorio
 */
public class Part1 {
    public String findSimpleGene(String dna) {
        String geneString = "";
        int startCodon  = dna.indexOf("ATG");
        int endCodon    = dna.indexOf("TAA");
        int lengthCodon = 0;

        if (startCodon == -1) {
            return "Sorry there's no a Start Codon (ATG)";
        }

        if (endCodon == -1) {
            return "Sorry there's no a End Codon (TAA)";
        }

        if (startCodon > endCodon) {
            return "Sorry there's no gene strand";
        }

        else {
            geneString =  dna.substring(startCodon, endCodon + 3);
            lengthCodon = geneString.length();

            if (lengthCodon % 3 == 0) {
                return geneString;
            }

            else {
                return "Sorry there's no gene strand";
            }
        }
    }

    public void testSimpleGene() {
        String dna = "AATGCGCTAATATGGT";
        System.out.println("DNA strand is: " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is: " + gene + "\n");

        dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is: " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is: " + gene + "\n");

        dna = "TGCGTAATATGGT";
        System.out.println("DNA strand is: " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is: " + gene + "\n");

        dna = "AATGCGTATATGGT";
        System.out.println("DNA strand is: " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is: " + gene + "\n");

        dna = "AAGCGAATATT";
        System.out.println("DNA strand is: " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is: " + gene + "\n");
    }
}
