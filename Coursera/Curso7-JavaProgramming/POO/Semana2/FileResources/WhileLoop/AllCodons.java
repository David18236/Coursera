public class AllCodons {
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon) {
        int currIndex = dnaStr.indexOf(stopCodon, startIndex + 3);

        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            if(diff % 3 == 0) {
                return currIndex;
            }

            else {
                currIndex = dnaStr.indexOf(stopCodon, currIndex + 1);
            }
        }

        return dnaStr.length();
    }

    public String findGen(String dna) {

    }
}
