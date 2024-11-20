package ru.isys.trainings.task7;
import java.util.Comparator;
public class TriangleComparator implements Comparator<triangle> {
    @Override public int compare(triangle a, triangle b)
    {
        return Double.compare(a.getArea(), b.getArea());
    }
}
