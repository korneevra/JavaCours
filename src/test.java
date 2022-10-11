import java.util.*;

public class test {

    public static void main(String[] args) {
        Worker w1 = new Worker();
        w1.id = 1;
        w1.salary = 1000;
        w1.firstName = "Name1";
        w1.lastName = "Surname1";

        Worker w2 = new Worker();
        w2.id = 2;
        w2.salary = 2000;
        w2.firstName = "Name2";
        w2.lastName = "Surname2";

        Worker w3 = new Worker();
        w3.id = 3;
        w3.salary = 3000;
        w3.firstName = "Name3";
        w3.lastName = "Surname3";

        Worker w4 = new Worker();
        w4.id = 1;
        w4.salary = 1000;
        w4.firstName = "Name1";
        w4.lastName = "Surname1";

        HashSet<Worker> workers = new HashSet<>(Arrays.asList(w1, w2, w3));
   //     System.out.println(workers);
        System.out.println(w1.toString());
        System.out.println(w1 == w4);
        System.out.println(w1.equals(w4));
        System.out.println(workers.contains(w4));



    }
}
