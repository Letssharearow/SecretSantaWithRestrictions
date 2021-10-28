
import java.util.ArrayList;
import java.util.List;


public class randomRunThrough implements RunThroughAll{

    
    @Override
    public int[] getBest(int size, List<Ausnahme> ausnahmen) {
        return getBest(size, ausnahmen, 100000);
    }

    
    public int[] getBest(int size, List<Ausnahme> ausnahmen, int loopAmount) {
        int bestPoints = Integer.MAX_VALUE;
        int[] currentBest = null;
        int[] vergleichsReihenfolge = getRandom(size);

        for(int i = 0 ; i < loopAmount; i++) { 
            int currentPoints = 0;
            vergleichsReihenfolge = getRandom(size);

            for (Ausnahme ausnahme : ausnahmen) {
                currentPoints += Reihenfolge.vergleicheReihenfolge(vergleichsReihenfolge, ausnahme);
            }
            if(currentPoints < bestPoints){
                currentBest = Reihenfolge.copyArray(vergleichsReihenfolge);
                bestPoints = currentPoints;
            }                 
        }
        System.out.println(" bestPoints: " + bestPoints );
        return currentBest;
    }

    public int[] getRandom(int size){

        int[] reihenfolge = new int[size];
        ArrayList<Integer> liste = new ArrayList<>();
        for(int i = 0 ; i < size; i++) {
            liste.add(i);
        } 
        for (int i = 0; i < size; i++) {
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
        ausnahmen.add(new Ausnahme(new int[]{0,3,1,2,4,5,6,7,1}));
        ausnahmen.add(new Ausnahme(new int[]{0,3,7,2,6,1,5,4},2));
        ausnahmen.add(new Ausnahme(new int[]{0,5,6,2,4,1,7,3},3));
        ausnahmen.add(new Ausnahme(new int[]{0,2,5,3,1,7,6,4},4));
        ausnahmen.add(new Ausnahme(new int[]{0,4,1,6,2,7,3,5},5));
        ausnahmen.add(new Ausnahme(new int[]{0,1,3,2,5,7,4,6},6));
        ausnahmen.add(new Ausnahme(new int[]{0,4,7,5,2,3,6,1},7));
        System.out.println(Reihenfolge.printArray(test.getBest(reihenfolge.length, ausnahmen, 1000000)));

        
    }
    
}
