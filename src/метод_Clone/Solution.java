package метод_Clone;

public class Solution {
    public static void main(String[] args) throws CloneNotSupportedException {
        myClone mc = new myClone();    // первый обьект.
        myClone2 mc2 = new myClone2(); // второй объект.
        mc.mcl = mc2;                  // присвоили ссылку полю "mc1" у первого объекта.
        System.out.println(mc2.j);

        myClone mc1 = mc.clone();      // клонировали первый объект вместе

        mc1.i = 1;
        System.out.println(mc.i);
        System.out.println(mc1.i);

        mc.mcl.j = 2;
        System.out.println(mc2.j);

    }
}

class myClone implements Cloneable {
    int i = 0;
    myClone2 mcl;
    @Override
    protected myClone clone() throws CloneNotSupportedException {
        myClone myCloneName =  (myClone) super.clone();
        myCloneName.mcl = mcl.clone();
        return myCloneName;
    }
}

class myClone2 implements Cloneable {
    int j = 0;

    @Override
    protected myClone2 clone() throws CloneNotSupportedException {
        return (myClone2) super.clone();
    }
}
