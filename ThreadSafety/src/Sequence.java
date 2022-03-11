public class Sequence {

    private int value = 0;

    public synchronized int getNext() {
        value = value + 1;
        return value;
    }
}
