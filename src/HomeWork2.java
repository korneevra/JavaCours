import java.util.Arrays;
import java.util.Scanner;

public class HomeWork2 {

    // Написать программу вычисления n-ого треугольного числа
    static int triangleNum(int n){
        return n * (n + 1) /2;
    }

    // Написать программу, показывающую последовательность действий для игры “Ханойская башня”
    public static void hanoyT(char from, char buf, char to, int n){
        if(n == 1) System.out.println("from " + from + " to " + buf);
        else {
            hanoyT(from, to, buf, n - 1);
            System.out.println("from " + from + " to " + buf);
            hanoyT(to, buf, from, n - 1);
        }
    }
    // Задано уравнение вида q + w = e, q, w, e >= 0.
    // Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
    // Требуется восстановить выражение до верного равенства.
    // Предложить хотя бы одно решение или сообщить, что его нет.
    static String recoverExp(String[] arr){
        int q, w, e;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                q = Integer.parseInt(arr[0].replace("?", Integer.toString(i)));
                w = Integer.parseInt(arr[2].replace("?", Integer.toString(j)));
                e = Integer.parseInt(arr[4]);
                if((q + w) == e) return q + " + " + w + " = " + e;
            }
        }
        return "No solution";
    }

    public static void main(String[] args) {
        // Написать программу вычисления n-ого треугольного числа
        for (int i = 0; i < 15; i++) {
            System.out.print(triangleNum(i) + ", ");
        }
        System.out.println();
        System.out.println("---------------------------------------");


        // Написать программу, показывающую последовательность действий для игры “Ханойская башня”
        hanoyT('a', 'b', 'c', 3);
        System.out.println("---------------------------------------");


        // Задано уравнение вида q + w = e, q, w, e >= 0.
        // Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
        // Требуется восстановить выражение до верного равенства.
        // Предложить хотя бы одно решение или сообщить, что его нет.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an expression of the form q + w = e: ");
        String[] arr = scanner.nextLine().split(" ");
        System.out.println(recoverExp(arr));
    }
}
