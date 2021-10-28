public class Wichteln{

String[] namen = {"Philipp", "Julian", "Viviane", "Siegfried", "Veronika", "Andreas", "Mama", "Papa"};
//                   0          1          2           3           4           5        6       7

//Jahre von alt zu neu                Jahr 1               Jahr 2              Jahr 3          Jahr 4              Jahr 5              Jahr 6 (2018)      Jahr 7 (2019)
int[][] reihenfolgenLetzterJahre = {{0,3,1,2,4,5,6,7}, {0,3,7,2,6,1,5,4}, {0,5,6,2,4,1,7,3}, {0,2,5,3,1,7,6,4}, {0,4,1,6,2,7,3,5}, {0,1,3,2,5,7,4,6}, {0,4,7,5,2,3,6,1}};

int abstandUtenObenRechts = 100;
int platzZwischenNamen = 220;
int[] reihenfolgeNamen = nehmeBesteReihenfolge(reihenfolgenLetzterJahre, 1000);

public void printReihenfolgeNamen(){
  for(int i = 0 ; i < reihenfolgeNamen.length; i++) { 
    System.out.println("hier: " + reihenfolgeNamen[i]);
  }
}
int[] zufaelligeReihenfolge(){   
  
  int[] benutzteStellen = {-1,-1,-1,-1,-1,-1,-1,-1};
  int zufaelligeStelle = (int) (Math.random() * 9);
  int stellenGeprueft;
  
  for(int i2 = 0 ; i2 < benutzteStellen.length  ; i2++) {         
    stellenGeprueft = -1;
    
    while(stellenGeprueft < 8){
        stellenGeprueft = 0;
        zufaelligeStelle = (int) (Math.random() * 9);
        
        for(int i = 0; i < benutzteStellen.length; i++){
          if(zufaelligeStelle != benutzteStellen[i]) {stellenGeprueft++;}          
        }
    }
     benutzteStellen[i2] = zufaelligeStelle;    
  }  
  return benutzteStellen;
}

/*
int[] positionenXY(int momentaneStelle){
  
  int[] positionen = new int[2];

    if(momentaneStelle < 4){
      positionen[0] = abstandUtenObenRechts + platzZwischenNamen * momentaneStelle;
      positionen[1] = abstandUtenObenRechts; 
    }
    else{
      positionen[0] = abstandUtenObenRechts + platzZwischenNamen * 3 - platzZwischenNamen * (momentaneStelle - 4);
      positionen[1] = SIZE_Y - abstandUtenObenRechts - TEXT_SIZE; 
    }      
    
  return positionen;
}*/

int[] nehmeBesteReihenfolge(int[][] vergleichsreihenfolgen, int anzahlZuTestenderReihenfolgen){
    int[][] alleReihenfolgen = new int[anzahlZuTestenderReihenfolgen][8];    
    int[] punkteDerReihenfolgen = new int[anzahlZuTestenderReihenfolgen];
    int stelleBesterReihenfolge = -1;
    int punkte;
    int eineStelleNachI = - 1;
    int eineStelleNachI3 = -1;
    
    for(int u = 0 ; u < anzahlZuTestenderReihenfolgen ; u++) { 
    alleReihenfolgen[u] = zufaelligeReihenfolge(); 
    punkte = 0;
      
      for(int i = 0 ; i <  alleReihenfolgen[u].length; i++) { 
        if(i < alleReihenfolgen[u].length - 1){eineStelleNachI = i + 1;}
        else{eineStelleNachI = 0;}
        
        for(int i2 = 1 ; i2 < vergleichsreihenfolgen.length + 1 ; i2++) { 
            for(int i3 = 0 ; i3 < vergleichsreihenfolgen[i2 - 1].length ; i3++) { 
                if(i3 < vergleichsreihenfolgen[i2 - 1].length - 1){eineStelleNachI3 = i3 + 1;}
                else{eineStelleNachI3 = 0;}
                // durch dass += u  werden die späteren Jahre höher bewertet. D.h. wenn ich letztes Jahr jemand hatte, ist es unwahrscheinlicher, ihn dieses Jahr zu haben als jemanden, den ich vor 3 Jahren hatte                
                if(alleReihenfolgen[u][i] == vergleichsreihenfolgen[i2 - 1][i3] && alleReihenfolgen[u][eineStelleNachI] == vergleichsreihenfolgen[i2 - 1][eineStelleNachI3]){
                  System.out.println("punkteVorher: " + punkte );
                  punkte += i2;  
                  System.out.println("punkteNachher: " + punkte );
                }
            }
        }
      }
      punkteDerReihenfolgen[u] = punkte;
      
    }
    stelleBesterReihenfolge = 0;
    for(int u = 0 ; u < anzahlZuTestenderReihenfolgen ; u++) { 
    //   Je mehr Punkte desto schlechter. Die stelle der Reihenfolge mit den wenigsten Punkten merkt sich stelleBesterReihenfolge  
      if(punkteDerReihenfolgen[u] < punkteDerReihenfolgen[stelleBesterReihenfolge]) stelleBesterReihenfolge = u;
      
    }    
    System.out.println("je kleiner diese Zahl, desto besser die gefundene Reihenfolge: " + punkteDerReihenfolgen[stelleBesterReihenfolge]); 
    System.out.println("0 = Philipp, 1 = Juli ... Nach alter sortiert: "); 
    for(int i = 0 ; i < alleReihenfolgen[stelleBesterReihenfolge].length ; i++) { 
       System.out.println(alleReihenfolgen[stelleBesterReihenfolge][i]);
    }
    return alleReihenfolgen[stelleBesterReihenfolge];
}

  public static void main (String[] args){

    Wichteln wichteln = new Wichteln();
    wichteln.printReihenfolgeNamen();
  }
}