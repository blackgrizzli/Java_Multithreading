package Game_ipodrom;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    private List<Horse> horses;
    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
        List<Horse> list = new ArrayList<>();
        list.add(new Horse("жора", 3, 0));
        list.add(new Horse("жирный", 3, 0));
        list.add(new Horse("пират", 3, 0));
        Hippodrome.game = new Hippodrome(list);
        game.run();
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            game.move();
            game.print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse x : horses) {
            x.move();
        }
    }

    public void print() {
        for (Horse x : horses) {
            x.print();
        }
        for(int i = 0; i <10;i++){
            System.out.println();
        }
    }
//    public Horse getWinner(){
//
//    }
    public void printWinner(){

    }
}
