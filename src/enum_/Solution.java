package enum_;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            wheels = new ArrayList<>();
            String[] str = loadWheelNamesFromDB();
            Wheel[]whe = Wheel.values();
            if(str.length == 0) throw new RuntimeException();
            for (int i = 0; i < whe.length; i++) {
                if(whe[i].toString().equals(str[i]) && str.length == 4) {
                    wheels.add(Wheel.valueOf(str[i]));

                }else{
                    throw new RuntimeException();
                }
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.wheels.forEach(System.out::println);
    }
}


