import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        var map = new HashMap<String, Integer>();
        map.put("Иван", 23);
        map.put("Василий", 30);
        map.put("Петр", 34);
        map.put("Максим", 41);
        map.put("Андрей", 34);
        map.put("Александр", 15);
        map.put("Ирина", 16);
        map.put("Наталья", 12);
        map.put("Дарья", 16);
        map.put("Анастасия", 46);
        BiPredicate<String, Integer> condition = (name, age) -> name.startsWith("И") && age < 30;
        map.entrySet().stream()
                .filter((entry) -> condition.test(entry.getKey(), entry.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }

    public  static void task2() {
        var map = new HashMap<String, Integer>();
        map.put("Иван", 23);
        map.put("Василий", 30);
        map.put("Петр", 34);
        map.put("Максим", 41);
        map.put("Андрей", 34);
        map.put("Александр", 15);
        map.put("Ирина", 16);
        map.put("Наталья", 12);
        map.put("Дарья", 16);
        map.put("Анастасия", 46);
        Function<Map.Entry<String, Integer>, User> userSupplier = entry -> new User(entry.getKey(), entry.getValue());
        List<User> users = map.entrySet().stream().map(userSupplier).collect(Collectors.toList());
        users.forEach(System.out::println);
    }

    public static void task3() {
        var map = new LinkedHashMap<String, Integer>();
        map.put("Иван", 23);
        map.put("Василий", 30);
        map.put("Петр", 34);
        map.put("Максим", 41);
        map.put("Андрей", 34);
        map.put("Александр", 15);
        map.put("Ирина", 16);
        map.put("Наталья", 12);
        map.put("Дарья", 16);
        map.put("Анастасия", 46);
        var list = new ArrayList<>(List.of(5, 4, 5, 3, 4, 5, 4, 4, 5, 5));
        BiFunction<Map.Entry<String, Integer>, Integer, Map.Entry<String, Integer>> convert =
                (entry, mark) -> { list.remove(0); return new AbstractMap.SimpleEntry<>(entry.getKey(), mark); };
        map.entrySet().stream()
                .map(entry -> convert.apply(entry, list.get(0)))
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
        
    }
}
