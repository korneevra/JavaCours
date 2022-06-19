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



    }
}
