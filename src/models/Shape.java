package models;

import java.util.ArrayList;

public class Shape {
    ArrayList<Point> points = new ArrayList<>();

    // container of Points
    public Shape(){
        this.points = new ArrayList<>();
    }

    // adds point to the container
    public void addPoint(Point point) {
        points.add(point);
    }

    // calculate perimeter
    public double calculatePerimeter(){
        double per = 0;
        int size = points.size();
        for (int i = 0; i < size - 1; i++) {
            per += points.get(i).distanceTo(points.get(i + 1));
        }
        per += points.get(size - 1).distanceTo(points.get(0));
        return per;
    }

    // get average side
    public double getAverageSide() {
        int size = points.size();
        if (size == 0) {
            return 0;
        }
        return calculatePerimeter() / size;
    }

    // get the longest side
    public double getLongestSide() {
        double longestSide = 0, currentSide;
        for (int i = 0; i < points.size(); i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get((i + 1) % points.size());

            currentSide = currentPoint.distanceTo(nextPoint);
            if (currentSide > longestSide) {
                longestSide = currentSide;
            }
        }
        return longestSide;
    }
}
