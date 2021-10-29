import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Wichtel {
    String[] namen;
    Reihenfolge reihenfolge;
    List<Ausnahme> ausnahmen = new ArrayList<>();

    public Wichtel(String[] namen){
        this.namen = namen;
        reihenfolge = new Reihenfolge(namen.length);
    }

    public void addAusnahme(Ausnahme ausnahme){
        ausnahmen.add(ausnahme);
    }

    public void berechneReihenfolge(){
        reihenfolge.erstelleAlleReihenfolgen(ausnahmen);
    }

    public void erstelleWichtelpartnerDateien() throws IOException{
		
        int[] besteReihenfolge = reihenfolge.reihenfolge;
        int giftProvider = besteReihenfolge[besteReihenfolge.length - 1];

        for (int i = 0; i < namen.length; i++) {
            int giftReceiver = besteReihenfolge[i];
            System.out.println(" giftProvider: " + giftProvider + " giftReceiver: " + giftReceiver);
            String fileName = "Wichtelpartner von " + namen[giftProvider] + ".txt";
            File wichtelPartner = new File(fileName);

		    try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));)
            {   
                writer.write(namen[giftReceiver]);
            }
            giftProvider = giftReceiver;
		}	
		
    }

    public static void main(String[] args) {
        Wichtel wichtel = new Wichtel(new String[]{"Philipp", "Julian", "Viviane", "Siegfried", "Veronika", "Andreas", "Mama", "Papa"});        
        wichtel.addAusnahme(new Ausnahme(new int[]{0,3,1,2,4,5,6,7,0},0));
        wichtel.addAusnahme(new Ausnahme(new int[]{0,3,7,2,6,1,5,4,0},1));
        wichtel.addAusnahme(new Ausnahme(new int[]{0,5,6,2,4,1,7,3,0},2));
        wichtel.addAusnahme(new Ausnahme(new int[]{0,2,5,3,1,7,6,4,0},3));
        wichtel.addAusnahme(new Ausnahme(new int[]{0,4,1,6,2,7,3,5,0},4));
        wichtel.addAusnahme(new Ausnahme(new int[]{0,1,3,2,5,7,4,6,0},5));
        wichtel.addAusnahme(new Ausnahme(new int[]{0,4,7,5,2,3,6,1,0},6));

        wichtel.berechneReihenfolge();
        System.out.println(Reihenfolge.printArray(wichtel.reihenfolge.reihenfolge));
        
        try {
            wichtel.erstelleWichtelpartnerDateien();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //new int[]{5,0,7,1,2,6,3,4}
    }
}
