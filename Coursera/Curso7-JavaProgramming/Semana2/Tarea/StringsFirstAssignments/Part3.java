/**
 * @author David Ospina Osorio
 */
public class Part3 {
    public boolean twoOccurrences(String stringA, String stringB) {
        int occurrence = stringB.indexOf(stringA);
        int numOccurrences = 0;

        while ((occurrence != -1) && (stringB.length() > stringA.length()) && (numOccurrences < 2)){
            System.out.println(stringB);
            numOccurrences = numOccurrences + 1;
            stringB = stringB.substring(occurrence + stringA.length(), stringB.length());
            System.out.println(numOccurrences);
        }

        if (numOccurrences == 2) {
            return true;
        }

        else {
            return false;
        }
    }

    public String lastPart(String stringA, String stringB) {
        int occurrence = stringB.indexOf(stringA); 

        if (occurrence != -1) {
            return stringB.substring(occurrence + stringA.length(), stringB.length());
        }

        else {
            return stringB;
        }
    }

    public void test() {
        String stringA = "atg";
        String stringB = "ctgtatgta";
        boolean numOccurrences;

        numOccurrences = twoOccurrences(stringA, stringB);
        System.out.println(numOccurrences);       
    }

    public void test2() {
        String stringA = "";
        String stringB = "";
        String lastPart = "";

        stringA = "an";
        stringB = "banana";
        lastPart = lastPart(stringA, stringB);
        System.out.println(lastPart);

        stringA = "atg";
        stringB = "ctgtatgta";
        lastPart = lastPart(stringA, stringB);
        System.out.println(lastPart);

        stringA = "zoo";
        stringB = "forest";
        lastPart = lastPart(stringA, stringB);
        System.out.println(lastPart);
    }
}
