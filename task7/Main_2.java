package ru.isys.trainings.task7;
import java.util.*;

public class Main_2 {
    public static void main(String[] args) {
        List<String> random_array_list = new ArrayList<>(1000000);
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            random_array_list.add(UUID.randomUUID().toString());
        }
        LinkedList<String> random_linked_list = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            random_linked_list.add(UUID.randomUUID().toString());
        }
        System.out.println("Adding to beginning:");
        testAddToBeginning(random_array_list);
        testAddToBeginning(random_linked_list);

        System.out.println("Adding to middle:");
        testAddToMiddle(random_array_list);
        testAddToMiddle(random_linked_list);

        System.out.println("Adding to end:");
        testAddToEnd(random_array_list);
        testAddToEnd(random_linked_list);

        System.out.println("Removing from beginning:");
        testRemoveFromBeginning(random_array_list);
        testRemoveFromBeginning(random_linked_list);

        System.out.println("Removing from middle:");
        testRemoveFromMiddle(random_array_list);
        testRemoveFromMiddle(random_linked_list);

        System.out.println("Removing from end:");
        testRemoveFromEnd(random_array_list);
        testRemoveFromEnd(random_linked_list);

        System.out.println("Getting from beginning:");
        testGetFromBeginning(random_array_list);
        testGetFromBeginning(random_linked_list);

        System.out.println("Getting from middle:");
        testGetFromMiddle(random_array_list);
        testGetFromMiddle(random_linked_list);

        System.out.println("Getting from end:");
        testGetFromEnd(random_array_list);
        testGetFromEnd(random_linked_list);

        System.out.println("External Iterator:");
        testExternalIterator(random_array_list);
        testExternalIterator(random_linked_list);

        System.out.println("Internal Iterator:");
        testInternalIterator(random_array_list);
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

        //adding an element to the middle
        private static void testAddToMiddle( List<String> list) {
            double T11 = System.nanoTime();
            list.add(500000, "1");
            double T21 = System.nanoTime();



            System.out.println("time for " + list.getClass().getSimpleName() + " ="
                    + String.valueOf(T21 - T11));
        }

        //adding an element to the end
        private static void testAddToEnd( List<String> list) {
            double T1_1 = System.nanoTime();
            list.add(500000, "1");
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

        //removing and element from the middle
        private static void testRemoveFromMiddle( List<String> list) {
            double T111 = System.nanoTime();
            list.remove(500000);
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

        //get 1st element
        private static void testGetFromBeginning( List<String> list) {
            double T113 = System.nanoTime();
            list.get(0);
            double T213 = System.nanoTime();


            System.out.println("time for " + list.getClass().getSimpleName() + " ="
                    + String.valueOf(T213 - T113));
        }
        //get middle element
        private static void testGetFromMiddle( List<String> list) {
            double T114 = System.nanoTime();
            list.get(500000);
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

        //external iterator
        private static void testExternalIterator( List<String> list) {
            double T5 = System.nanoTime();
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String string = iterator.next();
            }
            double T6 = System.nanoTime();


            System.out.println("time for " + list.getClass().getSimpleName() + " ="
                    + String.valueOf(T6 - T5));
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


}
