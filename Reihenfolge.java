import java.util.List;

public class Reihenfolge {
    int[] reihenfolge;
    RunThroughAll iterator;

    public Reihenfolge(int size){
        this(size, new randomRunThrough());
    }

    public Reihenfolge(int size, RunThroughAll iterator){
        this.iterator = iterator;
        reihenfolge = new int[size];   
    }

    public void erstelleAlleReihenfolgen(List<Ausnahme> ausnahmen){
        reihenfolge = iterator.getBest(reihenfolge.length, ausnahmen);
    }

    public static int vergleicheReihenfolge(int[] reihenfolge, Ausnahme ausnahme){

        int[] ausnahmeReihenfolge = ausnahme.reihenfolge;
        int points = 0;
        int gewichtung = ausnahme.gewichtung;

        int prevAusnahme = ausnahmeReihenfolge[0];
        for (int i = 1; i < ausnahmeReihenfolge.length; i++) {        
            int currentAusnahme = ausnahmeReihenfolge[i];

            int prevReihenfolge = reihenfolge[reihenfolge.length -1];
            for (int j = 0; j < reihenfolge.length; j++) {
                int currentReihenfolge = reihenfolge[j];
                if(currentReihenfolge == currentAusnahme && prevReihenfolge == prevAusnahme){
                    points += gewichtung;
                }
                prevReihenfolge = currentReihenfolge;
            }
            prevAusnahme = currentAusnahme;
        }
        return points;
    }

    public static String printArray(int[] array){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i] + " ");
        }
        return result.toString();
    }
    
    public static int[] copyArray(int[] toCopy){
        int[] copy = new int[toCopy.length];
        for(int i = 0 ; i < copy.length; i++) { 
            copy[i] = toCopy[i];
        }
        return copy;
    }

    public static void main(String[] args) {
        Reihenfolge reihenfolge = new Reihenfolge(5);
    }
}
