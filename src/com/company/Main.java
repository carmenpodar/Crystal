package com.company;

public class Main {

    public static void main(String[] args) {
        int i = 0;
        increment(i);
        System.out.println("After increment:" + i);

        IntContainer container = new IntContainer();
        System.out.println("Container i:" + container.i);

        increment(container);
        System.out.println("After increment Container i:" + container.i);

        IntContainer container1 = new IntContainer();
        System.out.println(container1);
        System.out.println("Container i:" + container1.i);

        changeRefAndIncrement(container1);
        System.out.println("After increment Container i:" + container1.i);
        System.out.println("Container:" + container1);

    }

    public static void increment(int i) {
        i = i + 1;
        System.out.println("In increment:" + i);
    }

    public static void increment(IntContainer container) {
        container.i++;
        System.out.println("In increment:" + container.i);
    }

    public static void changeRefAndIncrement(IntContainer container) {
        System.out.println("Container:" + container);
        container = new IntContainer();
        System.out.println("Container:" + container);
        container.i += 3;
        System.out.println("In increment:" + container.i);
    }

}
