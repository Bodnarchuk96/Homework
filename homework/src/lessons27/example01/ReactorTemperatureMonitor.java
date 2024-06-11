package lessons27.example01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReactorTemperatureMonitor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> temperatures = new ArrayList<>();
        Double previousTemperature = null;

        while (true) {
            System.out.print("Enter reactor temperature: ");
            double currentTemperature = scanner.nextDouble();
            temperatures.add(currentTemperature);


            double sum = 0;
            for (double temp : temperatures) {
                sum += temp;
            }
            double averageTemperature = sum / temperatures.size();
            System.out.println("Average temperature for all time: " + averageTemperature);


            if (previousTemperature != null) {
                double difference = currentTemperature - previousTemperature;
                System.out.println("Difference from previous temperature: " + difference);


                if (currentTemperature > averageTemperature * 1.1 && currentTemperature > previousTemperature * 1.2) {
                    System.out.println("Alarm, temperature rise");
                }
            }


            if (temperatures.size() >= 10) {
                double lastTenSum = 0;
                for (int i = temperatures.size() - 10; i < temperatures.size(); i++) {
                    lastTenSum += temperatures.get(i);
                }
                double lastTenAverage = lastTenSum / 10;
                System.out.println("Average temperature for the last 10 measurements: " + lastTenAverage);
            }


            if (temperatures.size() >= 100 && temperatures.size() % 100 == 0) {
                double hundredSum = 0;
                for (int i = temperatures.size() - 100; i < temperatures.size(); i++) {
                    hundredSum += temperatures.get(i);
                }
                double hundredAverage = hundredSum / 100;
                System.out.println("Average temperature for the last 100 measurements: " + hundredAverage);
            }


            previousTemperature = currentTemperature;
        }
    }
}