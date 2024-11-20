
import ru.isys.trainings.task7.TriangleComparator;
import ru.isys.trainings.task7.rectangle;
import ru.isys.trainings.task7.rightTriangle;
import ru.isys.trainings.task7.triangle;
import java.util.TreeMap;

import java.util.*;
public class Application {
    public static void main(String[] args) {
        //prints sorted list of rectangles
        List<rectangle> list_r = new ArrayList<>(3);
        list_r.add(new rectangle("a", 10, 10));
        list_r.add(new rectangle("b", 12, 9));
        list_r.add(new rectangle("c", 13, 8));
        sort(list_r);
        System.out.println(list_r);

        //prints sorted list of triangles by perimeter
        List<rightTriangle> list_t = new ArrayList<>(3);
        list_t.add(new rightTriangle("a", 10, 10));
        list_t.add(new rightTriangle("b", 12, 9));
        list_t.add(new rightTriangle("c", 13, 8));
        sort(list_t);
        System.out.println(list_t);

        //prints sorted list of triangles by area
        TriangleComparator Tcomp = new TriangleComparator();
        Collections.sort(list_t, Tcomp);
        System.out.println(list_t);

        //Tree map for rectangle
        TreeMap<rectangle, Integer> treeMap = new TreeMap<>();
        treeMap.put(list_r.get(0), 1);
        treeMap.put(list_r.get(1), 2);
        treeMap.put(list_r.get(2), 3);
        for (rectangle key : treeMap.keySet()) {
            System.out.println(key + ": " + treeMap.get(key));
        }
    }

    public static <T extends Comparable<? super T>> void sort(List < T > list) {
        Collections.sort(list);
    }
}