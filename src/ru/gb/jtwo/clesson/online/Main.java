package ru.gb.jtwo.clesson.online;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("January", 1);
        map.put("February", 2);
        map.put("March", 3);
        map.put("April", 4);
        map.put("May", 5);

        map.put("January", 10);

        System.out.println(map);

        for (String key : map.keySet()) {
            System.out.printf("key=%s, val=%d\n", key, map.get(key));
        }

        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iter = set.iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            System.out.printf("key=%s, val=%d", entry.getKey(), entry.getValue());
        }

    }

    private static void setExample() {
        Box b0 = new Box(1, 1);
        Box b1 = new Box(2, 2);
        Box b2 = new Box(3, 3);
        Box b3 = new Box(4, 4);
        Box b4 = new Box(1, 1);

        TreeSet<String> set = new TreeSet<>();
        set.add("January");
        set.add("February");
        set.add("March");
        set.add("April");

        set.add("January");

        System.out.println(set);

        TreeSet<Box> set1 = new TreeSet<>();
        set1.addAll(Arrays.asList(b0, b1, b2, b3));
        System.out.println(set1);
    }

    private static void listSample(Box b0, Box b1, Box b2, Box b3, Box b4) {
        LinkedList<Box> list1 = new LinkedList<>();
        list1.addAll(Arrays.asList(b0, b1, b2, b3));
//        System.out.println(list1);
        System.out.println(list1.contains(b4));

        System.out.println(Integer.toHexString(b0.hashCode()));
        System.out.println(Integer.toHexString(b4.hashCode()));
    }

    private static void listExample() {
        //        ArrayList<String> list = new ArrayList<>();
//        list.add("Hello");
//        list.add("World");
//        list.add(0, "Fix");
//        System.out.println(list.get(0));
//        System.out.println(list.contains(new String("Hello")));
//        System.out.println(list.indexOf("World"));
//        list.set(1, "Wow");
//        System.out.println(list);
    }

    private static void cyclesExample(ArrayList<Box> list1) {
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }
        System.out.println();

        Iterator<Box> iter = list1.iterator();
        while (iter.hasNext()) {
            Box b = iter.next();
            System.out.print(b + " ");
        }
        System.out.println();

        for (Box b : list1) {
            System.out.print(b + " ");
        }
    }

    private static void wrappers() {
        String s = "HelloWorld";
        String s0 = new String("Hello");
        int i = 10;
        i++;
        Integer i0 = 10;
        Integer i1 = new Integer(11);
        i0++;
        System.out.println(i0++);
    }
}
