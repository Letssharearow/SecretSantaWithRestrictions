public class Ausnahme {
    public int[] reihenfolge;
    public int gewichtung;

    public Ausnahme(int[] reihenfolge, int gewichtung){
        if(reihenfolge.length <= 1){
            throw new RuntimeException("need more values");
        }
        this.reihenfolge = reihenfolge;
        this.gewichtung = gewichtung;
    }

    
    public Ausnahme(int[] reihenfolge){
        this.reihenfolge = reihenfolge;
        this.gewichtung = 1;
    }
}
