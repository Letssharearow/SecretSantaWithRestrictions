import java.util.HashSet;

public class NumberList {
    Number root;
    int size;

    public NumberList(int size){
        this.size = size;

        Number[] temp = new Number[size];

        for (int i = 0; i < size; i++) {
            temp[i] = new Number(i, size, null);
        }
        
        Number prev = temp[temp.length - 1];
        for (int i = 0; i < size; i++) {
            prev.next = temp[i];
            prev = temp[i];
        }
        root = temp[0];
    }

    public void next(){
        root.next();
    }

    public void nextSet(){

        HashSet<Integer> set= new HashSet<>();
        
        while (set.size() != size) {
            set = new HashSet<>();
            root.next();
            Number temp = root;
            for (int i = 0; i < size; i++) {
                set.add(temp.value);
                temp = temp.next;
            }
        }

    }

    public int[] current(){
        int[] numbers = new int[size];
        Number temp = root;
        for (int i = 0; i < size; i++) {
            numbers[i] += temp.value;
            temp = temp.next;
        }
        return numbers;
    }

    @Override
    public String toString(){
        String st = "";
        Number temp = root;
        for (int i = 0; i < size; i++) {
            st += temp.value + " ";
            temp = temp.next;
        }
        return st;
    }

    public static int fac(int f){
        int output = 1;
        for (int i = 2; i <= f; i++) {
            output *= i;
        }
        return output;
    }

    public static void main(String[] args) {
        int size = 8;
        NumberList list = new NumberList(size);

        String st = "";
        int amount =  fac(size - 1);
        for (int index = 0; index < amount; index++) {
            st += list.toString() + "\n";
           list.nextSet();
        }
        System.out.println("fast geschafft"); 
        System.out.println(st);
    }
}
