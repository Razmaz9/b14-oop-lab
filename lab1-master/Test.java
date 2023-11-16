public class Test {
    public String[] directions = {"N", "E", "S", "W"};
    public int direction = 3;
    public void turnLeft() {
        direction = (direction + 1) % 4;
        System.out.println(directions[direction]);
    }
}
class Main {
    public static void main(String[] args) {
        Test mytest = new Test();
        mytest.turnLeft();
    }
}