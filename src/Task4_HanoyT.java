public class Task4_HanoyT {

//    +Написать программу, показывающую последовательность действий для игры “Ханойская башня”


    public static void hanoyT(char from, char buf, char to, int n){
        if(n == 1) System.out.println("from " + from + " to " + buf);
        else {
            hanoyT(from, to, buf, n - 1);
            System.out.println("from " + from + " to " + buf);
            hanoyT(to, buf, from, n - 1);
        }
    }

    public static void main(String[] args) {

        hanoyT('a', 'b', 'c', 3);
    }
}
