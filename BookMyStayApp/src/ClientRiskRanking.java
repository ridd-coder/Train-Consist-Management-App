import java.util.*;

public class ClientRiskRanking {

    // -------- Client Class --------
    static class Client {
        String name;
        int riskScore;
        double accountBalance;

        public Client(String name, int riskScore, double accountBalance) {
            this.name = name;
            this.riskScore = riskScore;
            this.accountBalance = accountBalance;
        }

        @Override
        public String toString() {
            return name + ":" + riskScore;
        }
    }

    // -------- Bubble Sort (Ascending Risk Score) --------
    public static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    // swap
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break; // optimized
        }

        System.out.println("Bubble Sort Swaps: " + swaps);
    }

    // -------- Insertion Sort (Descending Risk + Balance) --------
    public static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && compare(arr[j], key) < 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Compare for DESC riskScore, then DESC balance
    private static int compare(Client c1, Client c2) {
        if (c1.riskScore != c2.riskScore) {
            return Integer.compare(c1.riskScore, c2.riskScore);
        }
        return Double.compare(c1.accountBalance, c2.accountBalance);
    }

    // -------- Top N High Risk Clients --------
    public static void printTopRisk(Client[] arr, int topN) {
        System.out.print("Top " + topN + " risks: ");
        for (int i = 0; i < Math.min(topN, arr.length); i++) {
            System.out.print(arr[i].name + "(" + arr[i].riskScore + ") ");
        }
        System.out.println();
    }

    // -------- Main --------
    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 2000),
                new Client("clientB", 50, 3000)
        };

        // Bubble Sort (Ascending)
        Client[] bubbleArr = clients.clone();
        bubbleSort(bubbleArr);
        System.out.println("Bubble (asc): " + Arrays.toString(bubbleArr));

        // Insertion Sort (Descending)
        Client[] insertionArr = clients.clone();
        insertionSort(insertionArr);
        System.out.println("Insertion (desc): " + Arrays.toString(insertionArr));

        // Top risks
        printTopRisk(insertionArr, 3);
    }
}