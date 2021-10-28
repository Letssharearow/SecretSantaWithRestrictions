import java.util.List;
import java.util.ArrayList;

public class Wichtel {
    String[] namen;
    int[] reihenfolge;
    List<Ausnahme> ausnahmen = new ArrayList<>();

    public Wichtel(String[] namen){
        this.namen = namen;
        reihenfolge = new int[namen.length];
    }

    public void addAusnahme(Ausnahme ausnahme){
        ausnahmen.add(ausnahme);
    }

    public void berechneReihenfolge(){
        
    }
}
