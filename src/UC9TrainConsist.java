// UC9 - Group Bogies by Type
import java.util.*;
import java.util.stream.Collectors;

public class UC9TrainConsist {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String toString() {
            return name + " (" + capacity + ")";
        }
    }

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println("   UC9 - Group Bogies by Type");
        System.out.println("=======================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));

        Map<String, List<Bogie>> grouped =
                bogies.stream().collect(Collectors.groupingBy(b -> b.name));

        for (Map.Entry<String, List<Bogie>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nUC9 operations completed successfully...");
    }
}