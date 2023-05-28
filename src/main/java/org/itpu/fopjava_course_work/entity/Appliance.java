package org.itpu.fopjava_course_work.entity;
import java.util.Objects;

@SuppressWarnings("unchecked")
public abstract class Appliance<SELF extends Appliance<SELF>> {
    protected int id;
    protected String name;
    protected String type;
    protected String brand;
    protected String modelName;
    protected String category;
    protected double price;
    protected double weight;
    protected double height;
    protected double width;
    protected double depth;
    protected int quantity;
    protected String color;
    private String voltage;

    public int getId() {
        return id;
    }

    public SELF setId(int id) {
        this.id = id;
        return (SELF) this;
    }

    public String getName() {
        return name;
    }

    public SELF setName(String name) {
        this.name = name;
        return (SELF) this;
    }

    public String getType() {
        return type;
    }

    public SELF setType(String type) {
        this.type = type;
        return (SELF) this;
    }

    public String getBrand() {
        return brand;
    }

    public SELF setBrand(String brand) {
        this.brand = brand;
        return (SELF) this;
    }

    public String getModelName() {
        return modelName;
    }

    public SELF setModelName(String modelName) {
        this.modelName = modelName;
        return (SELF) this;
    }

    public String getCategory() {
        return category;
    }

    public SELF setCategory(String category) {
        this.category = category;
        return (SELF) this;
    }

    public double getPrice() {
        return price;
    }

    public SELF setPrice(double price) {
        this.price = price;
        return (SELF) this;
    }

    public double getWeight() {
        return weight;
    }

    public SELF setWeight(double weight) {
        this.weight = weight;
        return (SELF) this;
    }
    public double getHeight() {
        return height;
    }

    public SELF setHeight(double height) {
        this.height = height;
        return (SELF) this;
    }
    public double getWidth() {
        return width;
    }

    public SELF setWidth(double width) {
        this.width = width;
        return (SELF) this;
    }
    public double getDepth() {
        return depth;
    }

    public SELF setDepth(double depth) {
        this.depth = depth;
        return (SELF) this;
    }
    public int getQuantity() {
        return quantity;
    }

    public SELF setQuantity(int quantity) {
        this.quantity = quantity;
        return (SELF) this;
    }

    public String getColor() {
        return color;
    }

    public SELF setColor(String color) {
        this.color = color;
        return (SELF) this;
    }

    public String getVoltage() {
        return voltage;
    }

    public SELF setVoltage(String voltage) {
        this.voltage = voltage;
        return (SELF) this;
    }

    @Override
    public String toString() {
        return "Appliance{" + commonFields() + '}';
    }

    protected String commonFields() {
        return "price=" + price + ", weight=" + weight;

    }

    @Override
    public int hashCode() {
        return Objects.hash(price, weight);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Appliance other = (Appliance) obj;
        return price == other.price && Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
    }

}