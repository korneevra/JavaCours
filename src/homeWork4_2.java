import java.util.*;

public class homeWork4_2 {

//        12 Написать программу, определяющую правильность расстановки скобок в выражении.
//        Пример 1: a+(d*3) - истина
//        Пример 2: [a+(1*3) - ложь
//        Пример 3: [6+(3*3)] - истина
//        Пример 4: {a}[+]{(d*3)} - истина
//        Пример 5: <{a}+{(d*3)}> - истина
//        Пример 6: {a+]}{(d*3)} - ложь

    public static void main(String[] args) {
        String[] ss =   {"a+(d*3)",
                        "[a+(1*3)",
                        "[6+(3*3)]",
                        "{a}[+]{(d*3)}",
                        "<{a}+{(d*3)}>",
                        "{a+]}{(d*3)}",};
        String[] br = {"(", ")", "{", "}", "[", "]", "<", ">"};
        for (String i: ss) {
            List<String> list = new ArrayList<>(Arrays.asList(i.split("")));
            Map<String, String> map = new HashMap<>();
            map.put(")", "(");
            map.put("]", "[");
            map.put("}", "{");
            map.put(">", "<");
            Stack<String> stack = new Stack<>();
            list.retainAll(Arrays.asList(br));
            for (String o: list) {
                if (map.containsValue(o)) {
                    stack.push(o);
                } else {
                    if (stack.contains(map.get(o)))
                        stack.remove(map.get(o));
                    else {
                        break;
                    }
                }
            }
            if (stack.isEmpty()) System.out.println(i + " - True");
            else System.out.println(i + " - false");
        }
    }
}
