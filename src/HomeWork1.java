public class HomeWork1 {

    public static double powRecursion(double a, int b){
        if(b == 0) return 1;

        if(b < 0) {
            powRecursion(1/a, -b);
        }
        double res = powRecursion(a, b/2);

        return b % 2 == 0 ? res * res : res * res * a;
    }

    public static double powIter(double a, int n) {
        if (a == 0 || a == 1) return a;
        if (n == 0) return 1;

        if (n < 0) {
            n = -n;
            a = 1 / a;
        }

        double res = 1;
        while (n > 0) {
            if (n % 2 == 1)
                res = res * a;
            a = a * a;
            n = n / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 7;
//        System.out.println(powRecursion(a, b));
        System.out.println(powIter(a, b));
    }
}
