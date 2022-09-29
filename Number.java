public class Number {
    int value;
    int max;

    Number next;

    public Number(int value, int max, Number next){
        this.value = value;
        this.max = max;
        this.next = next;
    }

    public void next(){
        value++;
        if(value == max){
            value = 0;
            next.next();
        }
    }
}
