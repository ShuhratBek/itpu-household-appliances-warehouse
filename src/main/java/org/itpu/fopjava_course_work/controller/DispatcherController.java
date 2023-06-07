package org.itpu.fopjava_course_work.controller;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.service.ApplianceService;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class DispatcherController {
    private final Map<String, ConcreteController<?>> controllers;
    private static final Collection<Appliance<?>> appliances = new ArrayList<>();
    private final Map<String, String> parameterConverters;
    private final int lineCount = 160;
    private final String equalSign = "=";
    private final String dashSign = "-";

    public DispatcherController(ApplianceService applianceService, Map<String, String> parameterConverters) {
        controllers = new HashMap<>();
        this.parameterConverters = parameterConverters;
        controllers.put("airConditioner", new AirConditionerController(applianceService));
        controllers.put("blender", new BlenderController(applianceService));
        controllers.put("clothesSteamer", new ClothesSteamerController(applianceService));
        controllers.put("coffeeMaker", new CoffeeMakerController(applianceService));
        controllers.put("dishWasher", new DishWasherController(applianceService));
        controllers.put("dryer", new DryerController(applianceService));
    }

    public void listen() throws IOException, XmlPullParserException {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = reader.read(new FileReader("pom.xml"));

        String appName = model.getName();
        String version = model.getVersion();
        String creationDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String developerName = model.getDevelopers().get(0).getName();
        String email = model.getDevelopers().get(0).getEmail();

        System.out.println(equalSign.repeat(lineCount));
        System.out.println("   Welcome to " + appName);
        System.out.println(equalSign.repeat(lineCount));
        System.out.println("Version: " + version);
        System.out.println("Created on: " + creationDate);
        System.out.println("Developer: " + developerName);
        System.out.println("Email: " + email);
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            String header = " Menu ";
            String headerEqualSigns = equalSign.repeat((lineCount - header.length()) / 2);
            System.out.println(headerEqualSigns + header + headerEqualSigns);
            System.out.println("1. List All Appliances");
            System.out.println("2. Search Appliances");
            System.out.println("3. Clear filters");
            System.out.println("4. Quit");
            System.out.println(dashSign.repeat(lineCount));
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> viewAllAppliances(scanner);
                case 2 -> searchAppliances(scanner);
                case 3 -> clearFilters();
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

    private void clearFilters() {
        parameterConverters.clear();
    }

    private void searchAppliances(Scanner scanner) {
        System.out.print("Enter the field name: ");
        String field = scanner.nextLine();
        System.out.println(dashSign.repeat(lineCount));
        System.out.print("Enter the search keyword: ");
        String keyword = scanner.nextLine();
        System.out.println(dashSign.repeat(lineCount));
        parameterConverters.put(field.trim(), keyword.trim());

        List<Appliance<?>> searchResults = controllers.values().stream().map(it -> it.find(parameterConverters)).flatMap(Collection::stream).collect(Collectors.toList());

        if (searchResults.isEmpty()) {
            System.out.println("No appliances found matching the search keyword.");
        } else {
            String header = " Search Results ";
            String headerEqualSigns = equalSign.repeat((lineCount - header.length()) / 2);
            System.out.println(headerEqualSigns + header + headerEqualSigns);
            System.out.println(dashSign.repeat(lineCount));
            System.out.printf("| %-6s | %-16s | %-20s | %-15s | %-7s | %-17s | %-8s | %-6s | %-6s | %-6s | %-6s | %-10s |\n",
                    "ID", "Model Name", "Brand", "Type", "Price", "Color", "Quantity", "Weight", "Height", "Width", "Depth", "Voltage");
            System.out.println(dashSign.repeat(lineCount));
            for (Appliance<?> appliance : searchResults) {
                System.out.printf("| %-6d | %-16s | %-20s | %-15s | %-7d | %-17s | %-8d | %-6s | %-6s | %-6s | %-6s | %-10s |\n",
                        appliance.getId(), appliance.getModelName(), appliance.getBrand(), appliance.getType(),
                        appliance.getPrice(), appliance.getColor(), appliance.getQuantity(), appliance.getWeight(),
                        appliance.getHeight(), appliance.getWidth(), appliance.getDepth(), appliance.getVoltage());
            }
            System.out.println(dashSign.repeat(lineCount));
        }
    }

    private void viewAllAppliances(Scanner scanner) {
        String[] applianceTypes = {"airConditioner", "blender", "clothesSteamer", "coffeeMaker", "dishWasher", "dryer"};

        for (String applianceType : applianceTypes) {
            ConcreteController<?> controller = controllers.get(applianceType);
            Collection<? extends Appliance<?>> applianceList = controller.findAll();
            appliances.addAll(applianceList);
        }

        boolean isRunning = true;

        while (isRunning) {
            String header = " All Appliances Sort By ";
            String headerEqualSigns = equalSign.repeat((lineCount - header.length()) / 2);
            System.out.println(headerEqualSigns + header + headerEqualSigns);
            System.out.println("1. ID ASC");
            System.out.println("2. ID DESC");
            System.out.println("3. Model Name ASC");
            System.out.println("4. Model Name DESC");
            System.out.println("5. Price ASC");
            System.out.println("6. Price DESC");
            System.out.println("7. Quantity ASC");
            System.out.println("8. Quantity DESC");
            System.out.println(dashSign.repeat(lineCount));
            System.out.print("Enter your choice: ");
            int sortOption = scanner.nextInt();
            scanner.nextLine();

            switch (sortOption) {
                case 1 -> {
                    isRunning = false;
                    // Sort by ID ASC
                    printAllAppliances(Comparator.comparing(Appliance::getId));
                }
                case 2 -> {
                    isRunning = false;
                    // Sort by ID DESC
                    printAllAppliances(Comparator.comparing(Appliance::getId, Comparator.reverseOrder()));
                }
                case 3 -> {
                    isRunning = false;
                    // Sort by Name ASC
                    printAllAppliances(Comparator.comparing(Appliance::getModelName));
                }
                case 4 -> {
                    isRunning = false;
                    // Sort by Name DESC
                    printAllAppliances(Comparator.comparing(Appliance::getModelName, Comparator.reverseOrder()));
                }
                case 5 -> {
                    isRunning = false;
                    // Sort by Price ASC
                    printAllAppliances(Comparator.comparing(Appliance::getPrice));
                }
                case 6 -> {
                    isRunning = false;
                    // Sort by Price DESC
                    printAllAppliances(Comparator.comparing(Appliance::getPrice, Comparator.reverseOrder()));
                }
                case 7 -> {
                    isRunning = false;
                    // Sort by Quantity ASC
                    printAllAppliances(Comparator.comparing(Appliance::getQuantity));
                }
                case 8 -> {
                    isRunning = false;
                    // Sort by Quantity DESC
                    printAllAppliances(Comparator.comparing(Appliance::getQuantity, Comparator.reverseOrder()));
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void printAllAppliances(Comparator<Appliance<?>> comparator) {
        ((List<Appliance<?>>) appliances).sort(comparator);
        String header = " List of Appliances ";
        String headerEqualSigns = equalSign.repeat((lineCount - header.length()) / 2);
        System.out.println(headerEqualSigns + header + headerEqualSigns);
        System.out.println(dashSign.repeat(lineCount));
        System.out.printf("| %-6s | %-16s | %-20s | %-15s | %-7s | %-17s | %-8s | %-6s | %-6s | %-6s | %-6s | %-10s |\n",
                "ID", "Model Name", "Brand", "Type", "Price", "Color", "Quantity", "Weight", "Height", "Width", "Depth", "Voltage");
        System.out.println(dashSign.repeat(lineCount));
        for (Appliance<?> appliance : appliances) {
            System.out.printf("| %-6d | %-16s | %-20s | %-15s | %-7d | %-17s | %-8d | %-6s | %-6s | %-6s | %-6s | %-10s |\n",
                    appliance.getId(), appliance.getModelName(), appliance.getBrand(), appliance.getType(),
                    appliance.getPrice(), appliance.getColor(), appliance.getQuantity(), appliance.getWeight(),
                    appliance.getHeight(), appliance.getWidth(), appliance.getDepth(), appliance.getVoltage());
        }
        System.out.println(dashSign.repeat(lineCount));

    }
}
