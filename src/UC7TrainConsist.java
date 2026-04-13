// UC8 - Streams
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UC8TrainConsist {

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
        System.out.println("   UC8 - Filter Passenger Bogies Using Streams");
        System.out.println("=======================================\n");

        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));

        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        System.out.println("Filtered Bogies (capacity > 60):");
        System.out.println(filtered);

        System.out.println("\nUC8 operations completed successfully...");
    }
}