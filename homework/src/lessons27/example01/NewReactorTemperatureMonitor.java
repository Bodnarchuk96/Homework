package lessons27.example01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewReactorTemperatureMonitor {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Double> temperatures = new ArrayList<>();


    private static final int LAST_TEN_MEASUREMENTS = 10;
    private static final int LAST_HUNDRED_MEASUREMENTS = 100;
    private static final double TEMPERATURE_RISE_THRESHOLD = 1.1;
    private static final double PREVIOUS_TEMPERATURE_THRESHOLD = 1.2;

    private static Double previousTemperature = null;

    public static void main(String[] args) {
        while (true) {
            double currentTemperature = getInputTemperature();
            if (currentTemperature == Double.MIN_VALUE) continue;
            temperatures.add(currentTemperature);

            printAllTimeAverage();

            checkAndPrintTemperatureDifference(currentTemperature);

            if (temperatures.size() >= LAST_TEN_MEASUREMENTS) {
                printLastTenAverage();
            }

            if (temperatures.size() >= LAST_HUNDRED_MEASUREMENTS && temperatures.size() % LAST_HUNDRED_MEASUREMENTS == 0) {
                printLastHundredAverage();
            }

            previousTemperature = currentTemperature;
        }
    }


    private static double getInputTemperature() {
        System.out.print("Enter reactor temperature: ");
        try {
            return scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid temperature.");
            scanner.next();
            return Double.MIN_VALUE;
        }
    }


    private static double calculateAverage(List<Double> tempList) {
        return tempList.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }


    private static void printAllTimeAverage() {
        double averageTemperature = calculateAverage(temperatures);
        System.out.println("Average temperature for all time: " + averageTemperature);
    }


    private static void checkAndPrintTemperatureDifference(double currentTemperature) {
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


    private static void printLastTenAverage() {
        double lastTenAverage = calculateAverage(temperatures.subList(temperatures.size() - LAST_TEN_MEASUREMENTS, temperatures.size()));
        System.out.println("Average temperature for the last 10 measurements: " + lastTenAverage);
    }


    private static void printLastHundredAverage() {
        double lastHundredAverage = calculateAverage(temperatures.subList(temperatures.size() - LAST_HUNDRED_MEASUREMENTS, temperatures.size()));
        System.out.println("Average temperature for the last 100 measurements: " + lastHundredAverage);
    }
}