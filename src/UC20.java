import java.util.*;

public class UC20 {

    public static void main(String[] args) {

        List<String> bogieIds = new ArrayList<>();
        String searchId = "BG309";

        if (bogieIds.isEmpty()) {
            throw new IllegalStateException("No bogies available for search");
        }

        boolean found = false;

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Bogie found: " + searchId);
        } else {
            System.out.println("Bogie not found: " + searchId);
        }
    }
}