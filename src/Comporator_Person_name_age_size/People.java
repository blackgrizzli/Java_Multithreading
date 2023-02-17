package Comporator_Person_name_age_size;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/

public class People {

    String name;
    int age;
    int size;

    public People(String name, int age, int size) {

        this.name = name;
        this.age = age;
        this.size = size;
    }
    @Override
    public String toString() {
        return String.format(" %s | %d | %d",name,age,size);
    }

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        @SafeVarargs
        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            for (Comparator<T> x : comparators) {
                int result = x.compare(o1, o2);
                if (result != 0) return result;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        ArrayList<People> people = new ArrayList<>();
        people.add(new People("Dima", 30, 60));
        people.add(new People("jein", 30, 21));
        people.add(new People("jein", 28, 20));
        people.add(new People("Andrey", 20, 10));
        people.add(new People("Dima", 30, 65));
        people.add(new People("Dima", 25, 60));
        people.add(new People("jein", 30, 20));



        Comparator[] comparators = new Comparator[3];
        comparators[0] = Comparator.comparing((People o) -> o.name);
        comparators[1] = Comparator.comparingInt((People o) -> o.age);
        comparators[2] = Comparator.comparingInt((People o) -> o.size);


        Collections.sort(people, new CustomizedComparator<>(comparators));
        for(var x : people){
            System.out.println(x);
        }
    }
}

