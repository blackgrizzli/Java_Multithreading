

public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        Object one = o1.hashCode() > o2.hashCode() ? o1 : o2;
        Object two = o1.hashCode() > o2.hashCode() ? o2 : o1;
        if (one.toString().compareTo(two.toString()) != 0){
            solution.someMethodWithSynchronizedBlocks(one,two);
            return true;
        }else{
            solution.someMethodWithSynchronizedBlocks(two,one);
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}