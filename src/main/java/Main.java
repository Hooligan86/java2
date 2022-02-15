import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[][]{{"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "s"},
                {"1", "2", "3", "4"},
        };

        try {
            System.out.println(sumArray(arr));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static int sumArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (arr.length == 4 && arr[0].length == 4 && arr[1].length == 4 && arr[2].length == 4 && arr[3].length == 4) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    try {
                        sum += Integer.parseInt(arr[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j);
                    }
                }
            }
        } else {
            throw new MyArraySizeException();
        }
        return sum;
    }
}
