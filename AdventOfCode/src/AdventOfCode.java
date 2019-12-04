public class AdventOfCode {
    //Day 1
    // Problem 1
    public static int d1p1(int mass) {
        int fuel = mass / 3 - 2;
        return fuel;
    }

    //Problem 2
    public static int d1p2(int mass) {
        int fuel = mass / 3 - 2;
        int sum = 0;
        while(fuel > 0) {
            sum += fuel;
            fuel = fuel / 3 - 2;
        }
        return sum;
    }
}