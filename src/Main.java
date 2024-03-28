import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 5, 2, 4, 8, 3, 9);

        // Lambda
        numbers.forEach(e -> System.out.println(e + 1));

        // Method References
        numbers.forEach(System.out::println);

        // Stream API
        System.out.println(numbers.stream().sorted(Integer::compareTo).collect(Collectors.toList()));
        System.out.println(numbers.stream().filter(e -> Math.floorMod(e, 2) == 0).collect(Collectors.toList()));

        // Default Methods
        Fruit orange = new Orange();
        orange.description(orange.getName());
        Fruit banana = new Banana();
        banana.description(banana.getName());

        // Option class
        System.out.println(Optional.empty().orElse("Other Not null"));

        //New Date Time API
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentTime);
    }

    public interface Fruit {
        default void description(String name) {
            System.out.printf("%s is fruit!%n", name);
        }

        String getName();
    }

    public static class Orange implements Fruit {
        @Override
        public String getName() {
            return "Orange";
        }
    }

    public static class Banana implements Fruit {
        @Override
        public String getName() {
            return "Banana";
        }
    }
}
