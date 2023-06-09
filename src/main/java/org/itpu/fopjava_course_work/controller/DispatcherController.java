package org.itpu.fopjava_course_work.controller;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.itpu.fopjava_course_work.entity.Appliance;
import org.itpu.fopjava_course_work.service.ApplianceService;
import org.itpu.fopjava_course_work.util.TableView;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class DispatcherController {
    private final Map<String, AbstractController<?>> controllers;
    private final Map<String, String> parameterConverters;
    private final int lineCount = 168;
    private final String equalSign = "=";
    private final String dashSign = "-";

    public DispatcherController(ApplianceService applianceService, Map<String, String> parameterConverters) {
        controllers = new HashMap<>();
        this.parameterConverters = parameterConverters;
        controllers.put("airConditioner", new AirConditionerController(applianceService));
        controllers.put("blender", new BlenderController(applianceService));
        controllers.put("clothesSteamer", new ClothesSteamerController(applianceService));
        controllers.put("coffeeMaker", new CoffeeMakerController(applianceService));
        controllers.put("dishWasher", new DishwasherController(applianceService));
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
        System.out.println("Welcome to " + appName);
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
            System.out.println("3. Quit");
            System.out.println(dashSign.repeat(lineCount));
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> viewAllAppliances(scanner);
                    case 2 -> searchAppliances(scanner);
                    case 3 -> {
                        isRunning = false;
                        System.out.println("Exiting the application. Goodbye!");
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (NoSuchElementException e) {
                System.out.println("Invalid format of choice. Please use numbers & try again.");
                scanner.nextLine();
            } catch (Throwable t) {
                System.out.println("An error occurred. Please try again.");
                t.printStackTrace();
            }
            System.out.println();
        }

        scanner.close();
    }

    private void searchAppliances(Scanner scanner) {
        String header = " Search Appliances - Select filters ";
        String headerEqualSigns = equalSign.repeat((lineCount - header.length()) / 2);
        System.out.println(headerEqualSigns + header + headerEqualSigns);
        boolean isRunning = true;

        while (isRunning) {
            System.out.print("Enter the field name: ");
            String field = scanner.nextLine();
            System.out.print("Enter the search keyword: ");
            String keyword = scanner.nextLine();
            parameterConverters.put(field.trim(), keyword.trim());
            System.out.println("Do you want to add more filters: ");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Enter your choice: ");
            int needMoreFilters = scanner.nextInt();
            scanner.nextLine();

            if (needMoreFilters != 1) {
                isRunning = false;
            }
        }

        List<Appliance<?>> searchResults = controllers.values().stream().map(it -> it.findBy(parameterConverters)).flatMap(Collection::stream).collect(Collectors.toList());

        header = " Search Results ";
        headerEqualSigns = equalSign.repeat((lineCount - header.length()) / 2);
        System.out.println(headerEqualSigns + header + headerEqualSigns);

        if (searchResults.isEmpty()) {
            System.out.println("No appliances found matching the search filters: " + parameterConverters);
        } else {
            System.out.println("Filters: " + parameterConverters);
            printTable(searchResults);
        }
        parameterConverters.clear();
    }

    private void viewAllAppliances(Scanner scanner) {
        List<Appliance<?>> appliances = new ArrayList<>(controllers.values().stream().map(AbstractController::getAll).flatMap(Collection::stream).toList());
        boolean isRunning = true;

        while (isRunning) {
            String header = " List All Appliances Sort By ";
            String headerEqualSigns = equalSign.repeat((lineCount - header.length()) / 2);
            System.out.println(headerEqualSigns + header + headerEqualSigns);
            System.out.println("1. ID ASC");
            System.out.println("2. ID DESC");
            System.out.println("3. Model Name ASC");
            System.out.println("4. Model Name DESC");
            System.out.println("5. Brand ASC");
            System.out.println("6. Brand DESC");
            System.out.println("7. Type ASC");
            System.out.println("8. Type DESC");
            System.out.println("9. Price ASC");
            System.out.println("10. Price DESC");
            System.out.println("11. Color ASC");
            System.out.println("12. Color DESC");
            System.out.println("13. Quantity ASC");
            System.out.println("14. Quantity DESC");
            System.out.println(dashSign.repeat(lineCount));
            System.out.print("Enter your choice: ");
            int sortOption = scanner.nextInt();
            scanner.nextLine();

            switch (sortOption) {
                case 1 -> {
                    isRunning = false;
                    printAllAppliances(appliances, Comparator.comparing(Appliance::getId));
                }
                case 2 -> {
                    isRunning = false;
                    printAllAppliances(appliances, Comparator.comparing(Appliance::getId, Comparator.reverseOrder()));
                }
                case 3 -> {
                    isRunning = false;
                    printAllAppliances(appliances, Comparator.comparing(Appliance::getModelName));
                }
                case 4 -> {
                    isRunning = false;
                    printAllAppliances(appliances, Comparator.comparing(Appliance::getModelName, Comparator.reverseOrder()));
                }
                case 5 -> {
                    isRunning = false;
                    printAllAppliances(appliances, Comparator.comparing(Appliance::getBrand));
                }
                case 6 -> {
                    isRunning = false;
                    printAllAppliances(appliances, Comparator.comparing(Appliance::getBrand, Comparator.reverseOrder()));
                }
                case 7 -> {
                    isRunning = false;
                    printAllAppliances(appliances, Comparator.comparing(Appliance::getType));
                }
                case 8 -> {
                    isRunning = false;
                    printAllAppliances(appliances, Comparator.comparing(Appliance::getType, Comparator.reverseOrder()));
                }
                case 9 -> {
                    isRunning = false;
                    printAllAppliances(appliances, Comparator.comparing(Appliance::getPrice));
                }
                case 10 -> {
                    isRunning = false;
                    printAllAppliances(appliances, Comparator.comparing(Appliance::getPrice, Comparator.reverseOrder()));
                }
                case 11 -> {
                    isRunning = false;
                    printAllAppliances(appliances, Comparator.comparing(Appliance::getColor));
                }
                case 12 -> {
                    isRunning = false;
                    printAllAppliances(appliances, Comparator.comparing(Appliance::getColor, Comparator.reverseOrder()));
                }
                case 13 -> {
                    isRunning = false;
                    printAllAppliances(appliances, Comparator.comparing(Appliance::getQuantity));
                }
                case 14 -> {
                    isRunning = false;
                    printAllAppliances(appliances, Comparator.comparing(Appliance::getQuantity, Comparator.reverseOrder()));
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void printAllAppliances(List<Appliance<?>> appliances, Comparator<Appliance<?>> comparator) {
        String header = " List of Appliances ";
        String headerEqualSigns = equalSign.repeat((lineCount - header.length()) / 2);
        System.out.println(headerEqualSigns + header + headerEqualSigns);
        appliances.sort(comparator);

        printTable(appliances);
    }

    private void printTable(List<Appliance<?>> appliances) {
        System.out.println("Found: " + appliances.size() + " items");
        System.out.println();
        TableView.printTable(appliances);
    }
}
