
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class randomRunThrough implements RunThroughAll{

    
    @Override
    public int[] getBest(int[] reihenfolge, List<Ausnahme> ausnahmen) {
        return getBest(reihenfolge, ausnahmen, reihenfolge.length * reihenfolge.length * (ausnahmen.size() + 1) * (ausnahmen.size() + 1));
    }

    
    public int[] getBest(int[] reihenfolge, List<Ausnahme> ausnahmen, int loopAmount) {
        int bestPoints = Integer.MAX_VALUE;
        int[] currentBest = null;
        int[] vergleichsReihenfolge = getRandom(reihenfolge);

        for(int i = 0 ; i < loopAmount; i++) { 
            int currentPoints = 0;
            vergleichsReihenfolge = getRandom(reihenfolge);

            for (Ausnahme ausnahme : ausnahmen) {
                currentPoints += vergleicheReihenfolge(reihenfolge, ausnahme);
            }
            if(currentPoints < bestPoints){
                currentBest = copyArray(vergleichsReihenfolge);
                bestPoints = currentPoints;
            }                 
        }
        System.out.println(" bestPoints: " + bestPoints );
        return currentBest;
    }

    public int[] copyArray(int[] toCopy){
        int[] copy = new int[toCopy.length];
        for(int i = 0 ; i < copy.length; i++) { 
            copy[i] = toCopy[i];
        }
        return copy;
    }

    public int vergleicheReihenfolge(int[] reihenfolge, Ausnahme ausnahme){

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

    public int[] getRandom(int[] reihenfolge){

        List<Integer> liste = Arrays.stream(reihenfolge).boxed().collect(Collectors.toList());
        for (int i = 0; i < reihenfolge.length; i++) {
            int random = (int) (Math.random() * liste.size());
            reihenfolge[i] = liste.get(random);
            liste.remove(random);
        }
        return reihenfolge;
    }

    public static void main(String[] args) {
        randomRunThrough test = new randomRunThrough();
        int[] reihenfolge = new int[]{0,1,2,3,4,5,6,7};
        List<Ausnahme> ausnahmen = new ArrayList<>();
        ausnahmen.add(new Ausnahme(new int[]{0,3,1,2,4,5,6,7}));
        ausnahmen.add(new Ausnahme(new int[]{0,3,7,2,6,1,5,4},2));
        ausnahmen.add(new Ausnahme(new int[]{0,5,6,2,4,1,7,3},3));
        ausnahmen.add(new Ausnahme(new int[]{0,2,5,3,1,7,6,4},4));
        ausnahmen.add(new Ausnahme(new int[]{0,4,1,6,2,7,3,5},5));
        ausnahmen.add(new Ausnahme(new int[]{0,1,3,2,5,7,4,6},6));
        ausnahmen.add(new Ausnahme(new int[]{0,4,7,5,2,3,6,1},7));
        System.out.println(Reihenfolge.printArray(test.getBest(reihenfolge, ausnahmen, 100000)));

        
    }
    
}
