package innerClass_hard;

import java.math.BigDecimal;

/*
Наследование от внутреннего класса
*/

import java.util.List;

/*
Реализация интерфейса используя локальный класс
*/

public class Solution {
    public static void main(String[] args) {
        List<Pet> pet = Util.getPets();
        List<Sayable> pets = Util.convertPetToSayable(pet);
        Util.printDialog(pets);
    }
}

