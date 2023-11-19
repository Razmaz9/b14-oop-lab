import src.Car;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    List<Integer> storage = new ArrayList<>();

    public void add(){
        storage.add(1);
        storage.add(2);
        storage.add(3);
        storage.add(4);
        storage.add(5);
        System.out.println(storage);
        storage.remove(storage.size()-1);
        System.out.println(storage);
    }
}


class Main {
    public static void main(String[] args) {
        Test mytest = new Test();
        mytest.add();


    }
}