public class Treadmill implements Obstacle{
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Treadmill{" +
                "length=" + length +
                '}';
    }

    @Override
    public int returnValue() {
        return length;
    }
}
