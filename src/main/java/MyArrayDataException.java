public class MyArrayDataException extends Exception{
    public MyArrayDataException(int row, int col) {
        super("In arr[" + row + "][" + col + "] not a number");
    }
}
