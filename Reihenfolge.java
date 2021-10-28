public class Reihenfolge {
    int[] reihenfolge;


    public Reihenfolge(int size){
        reihenfolge = new int[size];   
        erstelleAlleReihenfolgen();  
    }

    public void erstelleAlleReihenfolgen(){
        for (int i = 0; i < reihenfolge.length; i++) {
            reihenfolge[i] = i;
        }
    }

    public void switchLast(){
        int temp = reihenfolge[reihenfolge.length -1];
        reihenfolge[reihenfolge.length - 1] = reihenfolge[reihenfolge.length -2];
        reihenfolge[reihenfolge.length -2] = temp;
    }

    public void switchI(int i){
        int temp = reihenfolge[i];
        reihenfolge[i] = reihenfolge[i-1];
        reihenfolge[i-1] = temp;
    }

    public void runThroughAll(){

        for (int i = 1; i <  reihenfolge.length; i++) {
            System.out.println(printArray(reihenfolge));
            switchLast();
            if(i%2 == 0){
                switchI(reihenfolge.length-2);
            }
        }
    }

    public static String printArray(int[] array){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i] + " ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Reihenfolge reihenfolge = new Reihenfolge(5);
        reihenfolge.runThroughAll();
    }
}
