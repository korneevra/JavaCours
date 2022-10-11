import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HW5 {

        public static void main(String[] args) throws ParseException {

            // 1. Доработать код перевода арабских чисел в римские
            LinkedHashMap<Integer, String> hm = new LinkedHashMap<>();
            hm.put(1000, "M");
            hm.put(900, "CM");
            hm.put(500, "D");
            hm.put(400, "CD");
            hm.put(100, "C");
            hm.put(90, "XC");
            hm.put(50, "L");
            hm.put(40, "XL");
            hm.put(10, "X");
            hm.put(9, "IX");
            hm.put(5, "V");
            hm.put(4, "IV");
            hm.put(1, "I");

            StringBuilder sb = new StringBuilder();
            int n = 888;
            for (int i: hm.keySet()) {
                if(n >= i) {
                    while (n >= i) {
                        sb.append(hm.get(i));
                        n -= i;
                    }
                }
            }
            System.out.println(sb);
            System.out.println("---------------------");

            // Список сотрудников некой фирмы хранится в виде, например, такой HashMap
            //HashMap<Integer, ArrayList<String>> persons = new HashMap<>();
            //где ключ - серия и номер паспорта сотрудника, а в списке хранятся его параметры
            //1) Написать метод, возвращающий всех однофамильцев (или тёзок)
            //2) Написать метод, возвращающий сотрудников, старше (младше) определенного возраста
            //
            //Note: Усложнение: хранить дату рождения в виде String определенного формата (например, DD-MM-YYYY),
            // при вычислении преобразовывать в "датовый" тип и вычислять возраст.
            //Упрощение: хранить "готовый" возраст

            HashMap<String, List<String>> persons = new HashMap<>();
            persons.put("8910187466", Arrays.asList("Ivanov", "Ivan", "Ivanovich", "24-02-1977"));
            persons.put("8920456987", Arrays.asList("Petrov", "Ivan", "Sergeevich", "04-17-1987"));
            persons.put("8915863254", Arrays.asList("Ivanov", "Stas", "Vladimirovich", "31-03-1994"));
            persons.put("8921589647", Arrays.asList("Zdunov", "Pavel", "Sergeevich", "05-03-2005"));
            persons.put("8987452136", Arrays.asList("Sukin", "Ivan", "Romanovich", "21-12-1999"));
            System.out.println(namesake(persons, 1));
            System.out.println(ageFind(persons, 30,"-"));
        }
        public static Map<String, List<String>> namesake(HashMap<String, List<String>> pers, int k){
            Map<String, List<String>> res = new HashMap<>();
            String s;
            for (var i: pers.entrySet()) {
                s = i.getValue().get(k);
                for (var j: pers.entrySet()) {
                    if(i.equals(j)) continue;
                    if(j.getValue().get(k).equals(s)){
                        res.putIfAbsent(i.getKey(), i.getValue());
                        res.putIfAbsent(j.getKey(), j.getValue());
                    }
                }
            }
            return res;
        }

        public static Map<String, List<String>> ageFind(HashMap<String, List<String>> pers, int age, String dir) throws ParseException {
            Map<String, List<String>> res = new HashMap<>();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            for (var i: pers.entrySet()) {
                Date date = formatter.parse(i.getValue().get(3));
                Date nowDate = new Date();
                switch (dir) {
                    case "+" -> {
                        if(nowDate.getYear() - date.getYear() >= age) res.put(i.getKey(), i.getValue());
                    }
                    case "-" -> {
                        if(nowDate.getYear() - date.getYear() < age) res.put(i.getKey(), i.getValue());
                    }
                }
            }
            return res;
        }

}

