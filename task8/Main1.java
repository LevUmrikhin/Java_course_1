package ru.isys.trainings.task8;
import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        LinkList<String> random_link_list = new LinkList<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            random_link_list.add(UUID.randomUUID().toString());
        }

        LinkedList<String> random_linked_list = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            random_linked_list.add(UUID.randomUUID().toString());
        }
        System.out.println("Adding to beginning:");
        testAddToBeginning1(random_link_list);
        testAddToBeginning(random_linked_list);

        System.out.println("Adding to middle:");
        testAddToMiddle1(random_link_list);
        testAddToMiddle(random_linked_list);

        System.out.println("Adding to end:");
        testAddToEnd1(random_link_list);
        testAddToEnd(random_linked_list);

        System.out.println("Removing from beginning:");
        testRemoveFromBeginning1(random_link_list);
        testRemoveFromBeginning(random_linked_list);

        System.out.println("Removing from middle:");
        testRemoveFromMiddle1(random_link_list);
        testRemoveFromMiddle(random_linked_list);

        System.out.println("Removing from end:");
        testRemoveFromEnd1(random_link_list);
        testRemoveFromEnd(random_linked_list);

        System.out.println("Getting from beginning:");
        testGetFromBeginning1(random_link_list);
        testGetFromBeginning(random_linked_list);

        System.out.println("Getting from middle:");
        testGetFromMiddle1(random_link_list);
        testGetFromMiddle(random_linked_list);

        System.out.println("Getting from end:");
        testGetFromEnd1(random_link_list);
        testGetFromEnd(random_linked_list);

        System.out.println("External Iterator:");


        System.out.println("Internal Iterator:");
        testInternalIterator1(random_link_list);
        testInternalIterator(random_linked_list);
    }

    private static void testAddToBeginning( List<String> list) {
        //adding an element to the beginning
        double T1 = System.nanoTime();
        list.add(0, "1");
        double T2 = System.nanoTime();

        System.out.println("time for " + list.getClass().getSimpleName() + " ="
                + String.valueOf(T2 - T1));
    }
    private static void testAddToBeginning1( LinkList<String> list) {
        //adding an element to the beginning
        double T1 = System.nanoTime();
        list.add(0, "1");
        double T2 = System.nanoTime();

        System.out.println("time for " + list.getClass().getSimpleName() + " ="
                + String.valueOf(T2 - T1));
    }

    //adding an element to the middle
    private static void testAddToMiddle( List<String> list) {
        double T11 = System.nanoTime();
        list.add(5000, "1");
        double T21 = System.nanoTime();



        System.out.println("time for " + list.getClass().getSimpleName() + " ="
                + String.valueOf(T21 - T11));
    }
    private static void testAddToMiddle1( LinkList<String> list) {
        double T11 = System.nanoTime();
        list.add(5000, "1");
        double T21 = System.nanoTime();



        System.out.println("time for " + list.getClass().getSimpleName() + " ="
                + String.valueOf(T21 - T11));
    }

    //adding an element to the end
    private static void testAddToEnd( List<String> list) {
        double T1_1 = System.nanoTime();
        list.add(5000, "1");
        double T2_1 = System.nanoTime();


        System.out.println("time for " + list.getClass().getSimpleName() + " ="
                + String.valueOf(T2_1 - T1_1));
    }
    private static void testAddToEnd1( LinkList<String> list) {
        double T1_1 = System.nanoTime();
        list.add(5000, "1");
        double T2_1 = System.nanoTime();


        System.out.println("time for " + list.getClass().getSimpleName() + " ="
                + String.valueOf(T2_1 - T1_1));
    }


    private static void testRemoveFromBeginning( List<String> list) {
        //removing 1st element

        double T110 = System.nanoTime();
        list.remove(0);
        double T210 = System.nanoTime();


        System.out.println("time for " + list.getClass().getSimpleName() + " ="
                +  String.valueOf(T210 - T110));
    }
    private static void testRemoveFromBeginning1( LinkList<String> list) {
        //removing 1st element

        double T110 = System.nanoTime();
        list.remove(0);
        double T210 = System.nanoTime();


        System.out.println("time for " + list.getClass().getSimpleName() + " ="
                +  String.valueOf(T210 - T110));
    }

    //removing and element from the middle
    private static void testRemoveFromMiddle( List<String> list) {
        double T111 = System.nanoTime();
        list.remove(5000);
        double T211 = System.nanoTime();


        System.out.println("time for " + list.getClass().getSimpleName() + " ="
                + String.valueOf(T211 - T111));
    }
    private static void testRemoveFromMiddle1( LinkList<String> list) {
        double T111 = System.nanoTime();
        list.remove(5000);
        double T211 = System.nanoTime();


        System.out.println("time for " + list.getClass().getSimpleName() + " ="
                + String.valueOf(T211 - T111));
    }

    //removing an element from the end
    private static void testRemoveFromEnd( List<String> list) {
        double T112 = System.nanoTime();
        list.remove(list.size() - 1);
        double T212 = System.nanoTime();


        System.out.println("time for " + list.getClass().getSimpleName() + " ="
                + String.valueOf(T212 - T112));
    }
    private static void testRemoveFromEnd1( LinkList<String> list) {
        double T112 = System.nanoTime();
        list.remove(list.size() - 1);
        double T212 = System.nanoTime();


        System.out.println("time for " + list.getClass().getSimpleName() + " ="
                + String.valueOf(T212 - T112));
    }

    //get 1st element
    private static void testGetFromBeginning( List<String> list) {
        double T113 = System.nanoTime();
        list.get(0);
        double T213 = System.nanoTime();


        System.out.println("time for " + list.getClass().getSimpleName() + " ="
                + String.valueOf(T213 - T113));
    }
    private static void testGetFromBeginning1( LinkList<String> list) {
        double T113 = System.nanoTime();
        list.get(0);
        double T213 = System.nanoTime();


        System.out.println("time for " + list.getClass().getSimpleName() + " ="
                + String.valueOf(T213 - T113));
    }
    //get middle element
    private static void testGetFromMiddle( List<String> list) {
        double T114 = System.nanoTime();
        list.get(5000);
        double T214 = System.nanoTime();


        System.out.println("time for " + list.getClass().getSimpleName() + " ="
                + String.valueOf(T214 - T114));
    }
    private static void testGetFromMiddle1( LinkList<String> list) {
        double T114 = System.nanoTime();
        list.get(5000);
        double T214 = System.nanoTime();


        System.out.println("time for " + list.getClass().getSimpleName() + " ="
                + String.valueOf(T214 - T114));
    }

    //get end element
    private static void testGetFromEnd( List<String> list) {
        double T115 = System.nanoTime();
        list.get(list.size() - 1);
        double T215 = System.nanoTime();


        System.out.println("time for " + list.getClass().getSimpleName() + " ="
                + String.valueOf(T215 - T115));
    }
    private static void testGetFromEnd1( LinkList<String> list) {
        double T115 = System.nanoTime();
        list.get(list.size() - 1);
        double T215 = System.nanoTime();


        System.out.println("time for " + list.getClass().getSimpleName() + " ="
                + String.valueOf(T215 - T115));
    }




    //internal iterator
    private static void testInternalIterator( List<String> list) {
        double T8 = System.nanoTime();

        for (String string : list) {
            String s = "1";
        }
        double T9 = System.nanoTime();


        System.out.println("time for " + list.getClass().getSimpleName() + " ="
                + String.valueOf(T9- T8));
    }
    private static void testInternalIterator1( LinkList<String> list) {
        double T8 = System.nanoTime();

        for (Object string : list) {
            String s = "1";
        }
        double T9 = System.nanoTime();


        System.out.println("time for " + list.getClass().getSimpleName() + " ="
                + String.valueOf(T9- T8));
    }


}
