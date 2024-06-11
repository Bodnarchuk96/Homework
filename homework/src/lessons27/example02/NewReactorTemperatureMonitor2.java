package lessons27.example02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewReactorTemperatureMonitor2 {

    private static final int LAST_TEN_MEASUREMENTS = 10;
    private static final int LAST_HUNDRED_MEASUREMENTS = 100;
    private static final double TEMPERATURE_RISE_THRESHOLD = 1.1;
    private static final double PREVIOUS_TEMPERATURE_THRESHOLD = 1.2;

    public static void main(String[] args) {
        List<Double> temperatures = new ArrayList<>();
        Double previousTemperature = null;

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                double currentTemperature = getInputTemperature(scanner);
                if (currentTemperature == Double.MIN_VALUE) break;

                temperatures.add(currentTemperature);

                printAllTimeAverage(temperatures);

                checkAndPrintTemperatureDifference(currentTemperature, previousTemperature, temperatures);

                if (temperatures.size() >= LAST_TEN_MEASUREMENTS) {
                    printLastTenAverage(temperatures);
                }

                if (temperatures.size() >= LAST_HUNDRED_MEASUREMENTS && temperatures.size() % LAST_HUNDRED_MEASUREMENTS == 0) {
                    printLastHundredAverage(temperatures);
                }

                previousTemperature = currentTemperature;
            }
        } catch (Exception e) {
            System.out.println("An error has occurred: " + e.getMessage());
        }
    }


    private static double getInputTemperature(Scanner scanner) {
        System.out.print("Enter reactor temperature (or enter 'exit' to exit): ");
        String input = scanner.next();

        if (input.equalsIgnoreCase("exit")) {
            return Double.MIN_VALUE;
        }

        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format. Please enter a numeric temperature value.");
            return Double.MIN_VALUE;
        }
    }


    private static double calculateAverage(List<Double> tempList) {
        return tempList.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }


    private static void printAllTimeAverage(List<Double> temperatures) {
        double averageTemperature = calculateAverage(temperatures);
        System.out.println("Average temperature for all time: " + averageTemperature);
    }


    private static void checkAndPrintTemperatureDifference(double currentTemperature, Double previousTemperature, List<Double> temperatures) {
        if (previousTemperature != null) {
            double difference = currentTemperature - previousTemperature;
            System.out.println("Difference from previous temperature: " + difference);

            double averageTemperature = calculateAverage(temperatures);
            if (currentTemperature > averageTemperature * TEMPERATURE_RISE_THRESHOLD &&
                    currentTemperature > previousTemperature * PREVIOUS_TEMPERATURE_THRESHOLD) {
                System.out.println("Alarm, temperature rise");
            }
        }
    }


    private static void printLastTenAverage(List<Double> temperatures) {
        double lastTenAverage = calculateAverage(temperatures.subList(temperatures.size() - LAST_TEN_MEASUREMENTS, temperatures.size()));
        System.out.println("Average temperature for the last 10 measurements: " + lastTenAverage);
    }


    private static void printLastHundredAverage(List<Double> temperatures) {
        double lastHundredAverage = calculateAverage(temperatures.subList(temperatures.size() - LAST_HUNDRED_MEASUREMENTS, temperatures.size()));
        System.out.println("Average temperature for the last 100 measurements: " + lastHundredAverage);
    }
}