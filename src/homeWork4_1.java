import java.util.*;

public class homeWork4_1 {

    // 10 * Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения.
    //Вычислить запись если это возможно

    public static boolean isOperator(String o) {
        return o.equals("+") || o.equals("-") || o.equals("*") || o.equals("/") || o.equals("(")
                || o.equals(")") || o.equals("^") ;
    }

    public static boolean isLowerRank(String op1, String op2) {
        switch (op1) {
            case "*":
            case "/":
                return op2.equals("^") || op2.equals("(") ||
                        (op2.equals("*") || op2.equals("/"));
            case "^":
                return op2.equals("(");
            case "(":
                return false;
            default:
                return true;
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        String s = "x^y/(5*z)+10";
        List<String> list = new ArrayList<>(Arrays.asList(s.split("")));

        for (String i: list) {
            if (isOperator(i)) {
                if (stack.isEmpty() || "(".equals(stack.peek())) {
                    stack.push(i);
                } else if (i.equals(")")) {
                    while (!"(".equals(stack.peek())) {
                        queue.add(stack.pop());
                    }
                    stack.pop();
                } else if (!isLowerRank(i, stack.peek())) {
                    stack.push(i);
                } else if (isLowerRank(i, stack.peek())) {
                    while (!stack.isEmpty() && isLowerRank(i, stack.peek()) && !"(".equals(stack.peek())) {
                        queue.add(stack.pop());
                    }
                    stack.push(i);
                } else if (i.equals("(")) {
                    stack.push(i);
                }
            } else {
                queue.add(i);
            }
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        System.out.println(s);
        queue.forEach(System.out::print);
    }
}
