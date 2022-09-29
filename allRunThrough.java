import java.util.List;

public class allRunThrough implements RunThroughAll{

    @Override
    public int[] getBest(int size, List<Ausnahme> ausnahmen) {
        
        NumberList list = new NumberList(size);

        int bestPoints = Integer.MAX_VALUE;
        int[] currentBest = null;
        int[] vergleichsReihenfolge;

        int loopAmount = NumberList.fac(size - 1);

        for(int i = 0 ; i < loopAmount; i++) { 
            int currentPoints = 0;
            vergleichsReihenfolge = list.current();

            for (Ausnahme ausnahme : ausnahmen) {
                currentPoints += Reihenfolge.vergleicheReihenfolge(vergleichsReihenfolge, ausnahme);
            }
            if(currentPoints < bestPoints){
                currentBest = Reihenfolge.copyArray(vergleichsReihenfolge);
                bestPoints = currentPoints;
            }   
            list.nextSet();        
        }
        System.out.println(" bestPointsA: " + bestPoints );
        return currentBest;
    }
    
}
