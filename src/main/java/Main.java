import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // item 1 and 2
//        Integer[] list = {1, 2, 3, 4, 5};
//        String[] list2 = {"1", "2", "3", "4", "5"};
//        swap(list, 1, 2);
//        swap(list2, 1, 2);

        FruitBox fruitBox1 = new FruitBox();
        FruitBox fruitBox2 = new FruitBox();
        Apple apple = new Apple();
        Orange orange = new Orange();

        fruitBox1.addFruit(apple);
        fruitBox1.addFruit(apple);
        fruitBox1.addFruit(apple);
        fruitBox2.addFruit(apple);
        fruitBox2.addFruit(apple);
        fruitBox2.addFruit(orange);
        System.out.println(fruitBox1.getWeight());

        fruitBox1.aaa(fruitBox2);

        System.out.println(fruitBox1.getWeight());
        System.out.println(fruitBox2.getWeight());

    }

    public static <T> void swap(T[] list, int fromPosition, int toPosition) {
        T temp = list[toPosition];
        list[toPosition] = list[fromPosition];
        list[fromPosition] = temp;
    }

    public static <T> List<T> arrayToArraylist(T[] list){
        List<T> newList = new ArrayList<>();
        Collections.addAll(newList, list);
        return newList;
    }



}
