public class Cat implements Action{
    private int runLength;
    private int jumpHeight;


    public Cat(int runLength, int jumpHeight) {
        this.runLength = runLength;
        this.jumpHeight = jumpHeight;
    }

    public int getRunLength() {
        return runLength;
    }

    public void setRunLength(int runLength) {
        this.runLength = runLength;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(int jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "runLength=" + runLength +
                ", jumpHeight=" + jumpHeight +
                '}';
    }

    @Override
    public int jump() {
        return jumpHeight;
    }

    @Override
    public int run() {
        return runLength;
    }


}
