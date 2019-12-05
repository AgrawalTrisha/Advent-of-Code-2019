import java.util.ArrayList;

public class Day3_Path {
    private ArrayList<Day3_Coordinate> coordinates;

    public Day3_Path(String instructs) {
        coordinates = new ArrayList<>();
        String[] instructions = instructs.split(",");
        int currentX = 0;
        int currentY = 0;
        for(String instruction : instructions) {
            int steps = Integer.parseInt(instruction.substring(1));
            switch (instruction.charAt(0)) {
                case 'U':
                    for(int i = 0; i < steps; i++, currentY++) {
                        coordinates.add(new Day3_Coordinate(currentX, currentY));
                    }
                    break;
                case 'D':
                    for(int i = 0; i < steps; i++, currentY--) {
                        coordinates.add(new Day3_Coordinate(currentX, currentY));
                    }
                    break;
                case 'L':
                    for(int i = 0; i < steps; i++, currentX--) {
                        coordinates.add(new Day3_Coordinate(currentX, currentY));
                    }
                    break;
                case 'R':
                    for(int i = 0; i < steps; i++, currentX++) {
                        coordinates.add(new Day3_Coordinate(currentX, currentY));
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public ArrayList<Day3_Coordinate> getIntersections(Day3_Path p) {
        ArrayList<Day3_Coordinate> intersections = new ArrayList<>();
        for(int i = 1; i < coordinates.size(); i++) {
            for(int j = 1; j < p.coordinates.size(); j++) {
                if(coordinates.get(i).equals(p.coordinates.get(j))) {
                    intersections.add(coordinates.get(i));
                }
            }
        }
        return intersections;
    }

    public void print() {
        for(int i = 0; i < coordinates.size(); i++) {
            System.out.println(coordinates.get(i).toString());
        }
    }
}
