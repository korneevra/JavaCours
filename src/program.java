import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class program {

    //Задана натуральная степень k. Сформировать случайным образом список коэффициентов
    // (значения от 0 до 100) многочлена многочлен степени k.
    //*Пример: k=2 => 2*x² + 4*x + 5 = 0 или x² + 5 = 0 или 10*x² = 0
    static String polynomialCr(int k){
        int[] arr = new int[k + 1];
        for (int i = 0; i < k + 1; i++) {
            arr[i] = new Random().nextInt(0, 10);
        }
        System.out.println(Arrays.toString(arr));
        String ss = "";
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] == 0) continue;
            ss += arr[i] + "*x^" + (k - i);
            if (i < k - 2)
                ss += " + ";
        }
        if (arr[k -1] != 0)
            ss += " + " + arr[k - 1] + "*x";
        if (arr[k] != 0)
            ss += " + " + arr[k];
        ss += " = 0";
        return ss;
    }
    static int enterK(){
        System.out.print("Enter k: ");
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    static double pow(double a, double b){
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


    //Даны два файла, в каждом из которых находится запись многочлена.
    // Сформировать файл содержащий сумму многочленов.

    public static void main(String[] args) throws IOException {


//        String pn1 = polynomialCr(enterK());
//        String pn2 = polynomialCr(enterK());
//        System.out.println(pn1 + '\n' + pn2);
//        FileWriter fw1 = new FileWriter("file1.txt", false);
//        FileWriter fw2 = new FileWriter("file2.txt", false);
//        fw1.write(pn1);
//        fw2.write(pn2);
//        fw1.flush();
//        fw2.flush();
//        FileReader fr1 = new FileReader("file1.txt");
//        FileReader fr2 = new FileReader("file2.txt");
//        int c;
//        String ss = "";
//        while ((c = fr1.read()) != -1) {
//            ss += (char) c;
//        }
//        String[] arr = ss.split(" \\+ ");
//        for (String i: arr) {
//            System.out.println(i);
//        }
//        System.out.println();


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
          FileReader fr = new FileReader("input.txt");
          int c;
          String s = "";
          String[] arr;
          ArrayList ls = new ArrayList();
          while ((c = fr.read()) != -1){
//              System.out.println(c);
              s += (char) c;
          }
          arr = s.split(" ");
        System.out.println(Arrays.toString(arr));
//        System.out.println(s);


          System.out.println(pow(0, 0));
    }
}
