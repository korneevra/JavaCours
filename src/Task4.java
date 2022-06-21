public class Task4 {

    public static void hanooyB(char from, char buf, char to, int n){
        if(n == 1) System.out.println("from " + from + " to " + buf);
        else {
            hanooyB(from, to, buf, n - 1);
            System.out.println("from " + from + " to " + buf);
            hanooyB(to, buf, from, n - 1);
        }
    }

    public static void main(String[] args) {
        hanooyB('a', 'b', 'c', 3);
    }
}
