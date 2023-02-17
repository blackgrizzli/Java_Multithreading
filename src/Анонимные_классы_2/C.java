package Анонимные_классы_2;

public class C implements JustAnInterface{
    public C() {
        System.out.print("C");
        B localB = B;
    }
}
