package org.itpu.fopjava_course_work;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.itpu.fopjava_course_work.entity.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ApplianceWarehouseApp {
    private static final List<Appliance<?>> appliances = new ArrayList<>();
    private static final String AIR_CONDITIONERS_CSV = "air-conditioners.csv";
    private static final String BLENDERS_CSV = "blenders.csv";
    private static final String CLOTHES_STEAMERS_CSV = "clothes-steamers.csv";
    private static final String COFFEE_MAKERS_CSV = "coffee-makers.csv";
    private static final String DISHWASHERS_CSV = "dishwashers.csv";
    private static final String DRYERS_CSV = "dryers.csv";
    private static final String ELECTRIC_KETTLES_CSV = "electric-kettles.csv";
    private static final String ELECTRIC_TOOTHBRUSHES_CSV = "electric-toothbrushes.csv";
    private static final String FANS_CSV = "fans.csv";
    private static final String GAMING_CONSOLES_CSV = "gaming-consoles.csv";
    private static final String HAIR_DRYERS_CSV = "hair-dryers.csv";
    private static final String HEATERS_CSV = "heaters.csv";
    private static final String IRONS_CSV = "irons.csv";
    private static final String MICROWAVES_CSV = "microwaves.csv";
    private static final String OVENS_CSV = "ovens.csv";
    private static final String REFRIGERATORS_CSV = "refrigerators.csv";
    private static final String ROBOTIC_VACUUMS_CSV = "robotic-vacuums.csv";
    private static final String SOUND_SYSTEMS_CSV = "sound-systems.csv";
    private static final String STEAM_CLEANERS_CSV = "steam-cleaners.csv";
    private static final String TELEVISIONS_CSV = "televisions.csv";
    private static final String TOASTERS_CSV = "toasters.csv";
    private static final String VACUUM_CLEANERS_CSV = "vacuum-cleaners.csv";
    private static final String WASHING_MACHINES_CSV = "washing-machines.csv";
    private static final String WATER_PURIFIERS_CSV = "water-purifiers.csv";

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
        List<String[]> airConditionerData = readCsvData(AIR_CONDITIONERS_CSV);
        for (String[] data : airConditionerData) {
            AirConditioner airConditioner = new AirConditioner()
                    .setId(Integer.parseInt(data[0]))
                    .setName(data[1])
                    .setType(data[2])
                    .setBrand(data[3])
                    .setModelName(data[4])
                    .setCategory(data[5])
                    .setPrice(Double.parseDouble(data[6]))
                    .setQuantity(Integer.parseInt(data[7]))
                    .setCoolingCapacity(Integer.parseInt(data[8]))
                    .setHeatingCapacity(Integer.parseInt(data[9]))
                    .setPowerConsumption(Integer.parseInt(data[10]))
                    .setNoiseLevel(Integer.parseInt(data[11]))
                    .setEnergyEfficiencyRating(data[12])
                    .setColor(data[13])
                    .setWeight(Double.parseDouble(data[14]))
                    .setHeight(Double.parseDouble(data[15]))
                    .setWidth(Double.parseDouble(data[16]))
                    .setDepth(Double.parseDouble(data[17]))
                    .setVoltage(data[18]);
            appliances.add(airConditioner);
        }

        List<String[]> blenderData = readCsvData(BLENDERS_CSV);
        for (String[] data : blenderData) {
            Blender blender = new Blender()
                    .setId(Integer.parseInt(data[0]))
                    .setName(data[1])
                    .setType(data[2])
                    .setBrand(data[3])
                    .setModelName(data[4])
                    .setCategory(data[5])
                    .setPrice(Double.parseDouble(data[6]))
                    .setQuantity(Integer.parseInt(data[7]))
                    .setPowerConsumption(Integer.parseInt(data[8]))
                    .setSpeedSettings(Integer.parseInt(data[9]))
                    .setCapacity(Double.parseDouble(data[10]))
                    .setColor(data[11])
                    .setWeight(Double.parseDouble(data[12]))
                    .setHeight(Double.parseDouble(data[13]))
                    .setWidth(Double.parseDouble(data[14]))
                    .setDepth(Double.parseDouble(data[15]))
                    .setVoltage(data[16]);
            appliances.add(blender);
        }

        List<String[]> clothesSteamerData = readCsvData(CLOTHES_STEAMERS_CSV);
        for (String[] data : clothesSteamerData) {
            ClothesSteamer clothesSteamer = new ClothesSteamer()
                    .setId(Integer.parseInt(data[0]))
                    .setName(data[1])
                    .setType(data[2])
                    .setBrand(data[3])
                    .setModelName(data[4])
                    .setCategory(data[5])
                    .setPrice(Double.parseDouble(data[6]))
                    .setQuantity(Integer.parseInt(data[7]))
                    .setPowerConsumption(Integer.parseInt(data[8]))
                    .setWaterTankCapacity(Double.parseDouble(data[9]))
                    .setSteamTime(Integer.parseInt(data[10]))
                    .setColor(data[11])
                    .setWeight(Double.parseDouble(data[12]))
                    .setHeight(Double.parseDouble(data[13]))
                    .setWidth(Double.parseDouble(data[14]))
                    .setDepth(Double.parseDouble(data[15]))
                    .setVoltage(data[16]);
            appliances.add(clothesSteamer);
        }

        List<String[]> coffeeMakerData = readCsvData(COFFEE_MAKERS_CSV);
        for (String[] data : coffeeMakerData) {
            CoffeeMaker coffeeMaker = new CoffeeMaker()
                    .setId(Integer.parseInt(data[0]))
                    .setName(data[1])
                    .setType(data[2])
                    .setBrand(data[3])
                    .setModelName(data[4])
                    .setCategory(data[5])
                    .setPrice(Double.parseDouble(data[6]))
                    .setQuantity(Integer.parseInt(data[7]))
                    .setCapacity(Integer.parseInt(data[8]))
                    .setPowerConsumption(Integer.parseInt(data[9]))
                    .setColor(data[10])
                    .setWeight(Double.parseDouble(data[11]))
                    .setHeight(Double.parseDouble(data[12]))
                    .setWidth(Double.parseDouble(data[13]))
                    .setDepth(Double.parseDouble(data[14]))
                    .setVoltage(data[15]);
            appliances.add(coffeeMaker);
        }

        List<String[]> dishwasherData = readCsvData(DISHWASHERS_CSV);
        for (String[] data : dishwasherData) {
            Dishwasher dishwasher = new Dishwasher()
                    .setId(Integer.parseInt(data[0]))
                    .setName(data[1])
                    .setType(data[2])
                    .setBrand(data[3])
                    .setModelName(data[4])
                    .setCategory(data[5])
                    .setPrice(Double.parseDouble(data[6]))
                    .setQuantity(Integer.parseInt(data[7]))
                    .setPlaceSettings(Integer.parseInt(data[8]))
                    .setEnergyEfficiencyRating(data[9])
                    .setWashingPrograms(Integer.parseInt(data[10]))
                    .setColor(data[11])
                    .setWeight(Double.parseDouble(data[12]))
                    .setHeight(Double.parseDouble(data[13]))
                    .setWidth(Double.parseDouble(data[14]))
                    .setDepth(Double.parseDouble(data[15]))
                    .setVoltage(data[16]);
            appliances.add(dishwasher);
        }

        List<String[]> dryersData = readCsvData(DRYERS_CSV);
        for (String[] data : dryersData) {
            Dryer dryer = new Dryer()
                    .setId(Integer.parseInt(data[0]))
                    .setName(data[1])
                    .setType(data[2])
                    .setBrand(data[3])
                    .setModelName(data[4])
                    .setCategory(data[5])
                    .setPrice(Double.parseDouble(data[6]))
                    .setQuantity(Integer.parseInt(data[7]))
                    .setCapacity(Double.parseDouble(data[8]))
                    .setPowerConsumption(Integer.parseInt(data[9]))
                    .setBoilTime(Double.parseDouble(data[10]))
                    .setMaterial(data[11])
                    .setColor(data[12])
                    .setWeight(Double.parseDouble(data[13]))
                    .setHeight(Double.parseDouble(data[14]))
                    .setWidth(Double.parseDouble(data[15]))
                    .setDepth(Double.parseDouble(data[16]))
                    .setVoltage(data[17]);
            appliances.add(dryer);
        }

        List<String[]> electricKettlesData = readCsvData(ELECTRIC_KETTLES_CSV);
        for (String[] data : electricKettlesData) {
            ElectricKettle electricKettle = new ElectricKettle()
                    .setId(Integer.parseInt(data[0]))
                    .setName(data[1])
                    .setType(data[2])
                    .setBrand(data[3])
                    .setModelName(data[4])
                    .setCategory(data[5])
                    .setPrice(Double.parseDouble(data[6]))
                    .setQuantity(Integer.parseInt(data[7]))
                    .setMaterial(data[8])
                    .setCapacity(Double.parseDouble(data[9]))
                    .setColor(data[10])
                    .setVoltage(data[11])
                    .setPowerConsumption(Integer.parseInt(data[12]))
                    .setWeight(Double.parseDouble(data[13]))
                    .setHeight(Double.parseDouble(data[14]))
                    .setWidth(Double.parseDouble(data[15]))
                    .setDepth(Double.parseDouble(data[16]));
            appliances.add(electricKettle);
        }
    }
    private static List<String[]> readCsvData(String csvFile) {
        List<String[]> data = new ArrayList<>();
        boolean isFirstLine = true;

        InputStream inputStream = ApplianceWarehouseApp.class.getClassLoader().getResourceAsStream(csvFile);
        if (inputStream != null) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (isFirstLine) {
                        isFirstLine = false;
                        continue; // Skip the header line
                    }
                    String[] values = line.split(",");
                    data.add(values);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("CSV file not found: " + csvFile);
        }

        return data;
    }
}