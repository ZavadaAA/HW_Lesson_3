package Lesson_3_HW;

import java.util.ArrayList;
import java.util.Arrays;

public class FruitBox<T extends Fruit> {

    ArrayList<T> fruitBox = new ArrayList<>();

    public FruitBox(T... fruit) {
        fruitBox = new ArrayList<>(Arrays.asList(fruit));
    }

    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>(new Apple(), new Apple(), new Apple(), new Apple());
        FruitBox<Orange> orangeBox = new FruitBox<>(new Orange(), new Orange(), new Orange());
        System.out.println("Вес коробки с яблоками составляет " + appleBox.getWeight());
        System.out.println("Вес коробки с апельсинами составляет " + orangeBox.getWeight());
        System.out.println(appleBox.compare(orangeBox));
        System.out.println(orangeBox.getFruitBox());
        System.out.println("Вес коробки с апельсинами составляет " + orangeBox.getWeight());
    }

    public ArrayList<T> getFruitBox() {
        return fruitBox;
    }

    public void addFruit(T fruit) {
        fruitBox.add(fruit);
        System.out.println("Мы добавили еще один фрукт!");
    }

    public float getWeight() {
        float totalWeight = 0.0f;
        for (int i = 0; i < fruitBox.size(); i++) {
            totalWeight += fruitBox.get(i).getWeight();
        }
        return totalWeight;
    }

    public boolean compare(FruitBox<? extends Fruit> box) {
        return Math.abs(getWeight() - box.getWeight()) == 0.0f;
    }

    public void replaceFruits(FruitBox<T> anotherBox) {
        anotherBox.fruitBox.addAll(this.fruitBox);
        this.fruitBox.clear();
    }
}