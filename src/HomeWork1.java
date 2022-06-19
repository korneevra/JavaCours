import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HomeWork1 {

//        +Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму.
//        Пример 1: а = 3, b = 2, ответ: 9
//        Пример 2: а = 2, b = -2, ответ: 0.25
//        Пример 3: а = 3, b = 0, ответ: 1
//        Пример 4: а = 0, b = 0, ответ: не определено
//        Пример 5
//        входные данные находятся в файле input.txt в виде
//        b 3
//        a 10
//        Результат нужно сохранить в файле output.txt
//        1000

    // Три различных метода / алгоритма выполнеия
    static double pow(double a, int b){
        if (a == 0 || a == 1) return a;
        if (b == 0) return 1;
        if (b < 0) {
            a = 1 / a;
            b = -b;
        }
        double res = a;
        for (int i = 0; i < b - 1; i++) {
            res *= a;
        }
        return res;
    }

    public static double powRecursion(double a, int b){
        if (a == 0 || a == 1) return a;
        if (b == 0) return 1;

        if (b < 0) {
            b = -b;
            a = 1 / a;
        }
        double res = powRecursion(a, b/2);
        return b % 2 == 0 ? res * res : res * res * a;
    }

    public static String powIter(double a, int b) {
        if (a == 0 && b == 0) return "не определено";
        if (a == 0 || a == 1) return Double.toString(a);
        if (b == 0) return "1";

        if (b < 0) {
            b = -b;
            a = 1 / a;
        }
        double res = 1;
        while (b > 0) {
            if (b % 2 == 1) res = res * a;
            a = a * a;
            b = b / 2;
        }
        return Double.toString(res);
    }

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("input.txt");
        int c;
        String s = "";
        String[] arr;
        while ((c = fr.read()) != -1){
            s += (char) c;
        }
        s = s.replace("\r\n", " ");
        arr = s.split(" ");
        int b = Integer.parseInt(arr[1]);
        int a = Integer.parseInt(arr[3]);

        FileWriter fw = new FileWriter("output.txt", false);
        fw.write(powIter(a, b));
        fw.flush();

        // Проверка времени выполнеия каждого из трех методов
        long st = System.nanoTime();
        System.out.println(pow(a, b));
        long fn = System.nanoTime();
        System.out.println((fn - st)/1000 + "mkS");

        st = System.nanoTime();
        System.out.println(powRecursion(a, b));
        fn = System.nanoTime();
        System.out.println((fn - st)/1000 + "mkS");

        st = System.nanoTime();
        System.out.println(powIter(a, b));
        fn = System.nanoTime();
        System.out.println((fn - st)/1000 + "mkS");


    }
}
