/**
 * @author David Ospina Osorio
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        String geneString = "";
        String dna2 = dna.toUpperCase();
        int beginCodon  = dna2.indexOf(startCodon);
        int endCodon    = dna2.indexOf(stopCodon);
        int lengthCodon = 0;

        if (beginCodon == -1) {
            return "Sorry there's no a Start Codon (ATG)";
        }

        if (endCodon == -1) {
            return "Sorry there's no a End Codon (TAA)";
        }

        if (beginCodon > endCodon) {
            return "Sorry there's no gene strand";
        }

        else {
            geneString =  dna.substring(beginCodon, endCodon + 3);
            lengthCodon = geneString.length();

            if (lengthCodon % 3 == 0) {
                if(dna != dna2){
                    return geneString.toLowerCase();
                }

                else{
                    return geneString;
                }
            }

            else {
                return "Sorry there's no gene strand";
            }
        }
    }

    public void testSimpleGene() {
        String dna = "";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        String gene = "";

        dna = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("DNA strand is: " + dna);
        gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene is: " + gene + "\n");

        /*dna = "gatgctataat";
        System.out.println("DNA strand is: " + dna);
        gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene is: " + gene + "\n");

        dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is: " + dna);
        gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene is: " + gene + "\n");

        dna = "TGCGTAATATGGT";
        System.out.println("DNA strand is: " + dna);
        gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene is: " + gene + "\n");

        dna = "AATGCGTATATGGT";
        System.out.println("DNA strand is: " + dna);
        gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene is: " + gene + "\n");

        dna = "AAGCGAATATT";
        System.out.println("DNA strand is: " + dna);
        gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene is: " + gene + "\n");*/
    }
}
