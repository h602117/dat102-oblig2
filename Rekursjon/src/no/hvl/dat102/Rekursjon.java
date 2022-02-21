package no.hvl.dat102;

public class Rekursjon {

    // a)
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }

        return n + sum(n - 1);
    }

    // b)
    public static int aSubn(int n) {
        if (n == 0) {
            return 2;
        }
        if (n == 1) {
            return 5;
        }

        return 5 * (aSubn(n - 1)) - 6 * (aSubn(n - 2)) + 2;
    }

    // c)
    public static int fn(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fn(n - 2) + fn(n - 1);
    }

    // d)
    public static int fnUtenRekursjon(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int prev1 = 0;
        int prev2 = 1;

        for (int i = 2; i <= n; i++) {
            int tmp = prev1 + prev2;
            prev1 = prev2;
            prev2 = tmp;
        }

        return prev2;
    }

    public static void main(String[] args) {

        System.out.println("a)\nS(100) = " + sum(100) + "\n");

        System.out.println("b)");
        for (int i = 0; i <= 10; i++) {
            System.out.println(aSubn(i));
        }
        System.out.println();

        System.out.println("c)");
        for (int i = 0; i <= 10; i++) {
            System.out.println(fn(i));
        }
        System.out.println();

        System.out.println("d)\n" + fnUtenRekursjon(10));
    }
}
