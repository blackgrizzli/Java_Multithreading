package клонирование_без_Cloneable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Solution {
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    String name;
    int age;
    User user;
    public Solution(String name, int age, User user) {
        this.name = name;
        this.age = age;
        this.user = user;
    }
    public Solution(Solution solution) {
        this.age = solution.age;
        this.name = solution.name;
        //this.user = solution.user; //напишем если так, объект user не дублируются, а просто копируется ссылка
        this.user = new User(solution.user); // а так дублируется сам объект User

    }


    public static void main(String[] args) {
        Solution solution = new Solution("Dmitry", 30, new User("Andrey", 3));
        Solution cloneSolution = new Solution(solution);

        cloneSolution.setName("VASIA");  //изменили имя дубликата объекта
        cloneSolution.setAge(32);        //изменили возраст дубликата объекта

        System.out.println("solution.equals(cloneSolution) = " + solution.equals(cloneSolution));
        System.out.println();
        System.out.println("!!! Тут мы видем, что при изменение дублика не изменяется дублируемый объект !!!");
        System.out.println();
        System.out.println(solution.name + " =/ имя дублируемого объекта после изменения дубликата");
        System.out.println(cloneSolution.name + " =/ имя дибликата после изменения");

        System.out.println(solution.age+ " =/ возраст дублируемого объкта после изменения дубликата");
        System.out.println(cloneSolution.age+ " =/ возраст дубликата после изменения");

        System.out.println(cloneSolution.user.equals(solution.user) + " =/ cloneSolution.user.equals(solution.user)");

        System.out.println(cloneSolution.user.nameUser + " =/cloneSolution.user.nameUser");
        System.out.println(cloneSolution.user.ageUser + " =/cloneSolution.user.ageUser");

    }
}

class User {
    String nameUser;
    int ageUser;
public User (User user){
    this.nameUser = user.nameUser;
    this.ageUser = user.ageUser;
}

    public User(String nameUser, int ageUser) {
        this.nameUser = nameUser;
        this.ageUser = ageUser;
    }
}
