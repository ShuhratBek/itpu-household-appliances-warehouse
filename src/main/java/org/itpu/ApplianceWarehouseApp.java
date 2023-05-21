package org.itpu;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ApplianceWarehouseApp {
    private static final List<Appliance> appliances = new ArrayList<>();

    public static void main(String[] args) throws IOException, XmlPullParserException {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = reader.read(new FileReader("pom.xml"));

        String appName = model.getName();
        String version = model.getVersion();
        String creationDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String developerName = model.getDevelopers().get(0).getName();
        String email = model.getDevelopers().get(0).getEmail();

        System.out.println("===================================================");
        System.out.println("   Welcome to " + appName);
        System.out.println("===================================================");
        System.out.println("Version: " + version);
        System.out.println("Created on: " + creationDate);
        System.out.println("Developer: " + developerName);
        System.out.println("Email: " + email);
        System.out.println();

        // Load data from CSV file
        loadDataFromCSV();

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("================ Menu ================");
            System.out.println("1. List All Appliances");
            System.out.println("2. Search Appliances");
            System.out.println("3. View Appliance Details");
            System.out.println("4. Quit");
            System.out.println("======================================");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> listAppliances();
                case 2 -> searchAppliances(scanner);
                case 3 -> viewApplianceDetails(scanner);
                case 4 -> {
                    isRunning = false;
                    System.out.println("Exiting the application. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void listAppliances() {
        System.out.println("=== List of Appliances ===");
        System.out.printf("%-5s %-20s %-25s %-10s %-8s\n", "ID", "Name", "Category", "Price", "Quantity");

        for (Appliance appliance : appliances) {
            System.out.printf("%-5d %-20s %-25s $%-9.2f %-8d\n", appliance.getId(), appliance.getName(),
                    appliance.getCategory(), appliance.getPrice(), appliance.getQuantity());
        }
    }

    private static void searchAppliances(Scanner scanner) {
        System.out.print("Enter the search keyword: ");
        String keyword = scanner.nextLine();

        List<Appliance> searchResults = new ArrayList<>();

        for (Appliance appliance : appliances) {
            if (appliance.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    appliance.getCategory().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(appliance);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("No appliances found matching the search keyword.");
        } else {
            System.out.println("=== Search Results ===");
            System.out.printf("%-5s %-20s %-25s %-10s %-8s\n", "ID", "Name", "Category", "Price", "Quantity");

            for (Appliance appliance : searchResults) {
                System.out.printf("%-5d %-20s %-25s $%-9.2f %-8d\n", appliance.getId(), appliance.getName(),
                        appliance.getCategory(), appliance.getPrice(), appliance.getQuantity());
            }
        }
    }

    private static void viewApplianceDetails(Scanner scanner) {
        System.out.print("Enter the Appliance ID: ");
        int id = scanner.nextInt();

        boolean found = false;

        for (Appliance appliance : appliances) {
            if (appliance.getId() == id) {
                System.out.println("=== Appliance Details ===");
                System.out.println("ID: " + appliance.getId());
                System.out.println("Name: " + appliance.getName());
                System.out.println("Category: " + appliance.getCategory());
                System.out.println("Price: $" + appliance.getPrice());
                System.out.println("Quantity: " + appliance.getQuantity());

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Appliance not found with ID: " + id);
        }
    }

    private static void loadDataFromCSV() {
        String line;
        String csvSplitBy = ",";
        boolean isFirstLine = true;

        try (InputStream inputStream = ApplianceWarehouseApp.class.getClassLoader().getResourceAsStream("appliances.csv")) {
            assert inputStream != null;
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                while ((line = br.readLine()) != null) {
                    if (isFirstLine) {
                        isFirstLine = false;
                        continue; // Skip the header line
                    }

                    String[] data = line.split(csvSplitBy);

                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String category = data[2];
                    double price = Double.parseDouble(data[3]);
                    int quantity = Integer.parseInt(data[4]);

                    Appliance appliance = new Appliance(id, name, category, price, quantity);
                    appliances.add(appliance);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}