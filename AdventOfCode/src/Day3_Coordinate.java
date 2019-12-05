import java.util.ArrayList;

public class Day3_Coordinate {
    private int x;
    private int y;
    public static Day3_Coordinate ORIGIN = new Day3_Coordinate(0,0);

    public Day3_Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Day3_Coordinate c) {
        if(this.x == c.x && this.y == c.y)
            return true;
        return false;
    }

    public int distance(Day3_Coordinate c) {
        return Math.abs(x - c.x) + Math.abs(y - c.y);
    }

    public static int shortestToOrigin(ArrayList<Day3_Coordinate> intersections) {
        int minimum = intersections.get(0).distance(Day3_Coordinate.ORIGIN);
        for(int i = 0; i < intersections.size(); i++) {
            if(intersections.get(i).distance(Day3_Coordinate.ORIGIN) < minimum)
                minimum = intersections.get(i).distance(Day3_Coordinate.ORIGIN);
        }
        return minimum;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
