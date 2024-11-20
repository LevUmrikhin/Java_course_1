
import ru.isys.trainings.task8.LinkList;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
    LinkList list = new LinkList();

    list.add("5");
    list.add("3");
    list.add("6");
    list.add("4");
    list.add(3,"4");
    list.set(2,"5");
    list.remove(5);
    list.get(1);
    Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        list.forEach(System.out::println);



        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list.isEmpty());
    list.clear();
    System.out.println(list.isEmpty());


    }
}