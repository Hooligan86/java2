import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FruitBox<T> {
    private List<T> fruitList = new ArrayList<>();

    public double getWeight(){
        double result = 0;
        for (T fruit : fruitList) {
            result += ((Fruit)fruit).getWeight();
        }
        return result;
    }

    public boolean compare(FruitBox box){
        return this.getWeight() == box.getWeight();
    }

    public void addFruit(T fruit){
        if(fruitList.isEmpty()){
            fruitList.add(fruit);
            return;
        }
        if(fruitList.get(0).getClass() == fruit.getClass()){
            fruitList.add(fruit);
        }else{
            System.out.println("You can add only the same fruits");
        }
    }

    public void aaa(FruitBox fruitBox){
        if(fruitBox.fruitList.get(0).getClass() == fruitList.get(0).getClass()){
            fruitList.addAll(fruitBox.fruitList);
            fruitBox.fruitList.clear();
        }else{
            System.out.println("You can add only the same fruits");
        }
    }


}
