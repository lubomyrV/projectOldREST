package ua.laptop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Comparator;
import java.util.Date;

@Entity
public class Product implements Comparable<Product>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String laptopModel;
    private double price;
    private String producer;
    private String processor;
    private String typeProcessor;
    private String screenDiagonal;
    private String amountOfRAM;
    private String numberOfslotsForRAM;
    private String typeOfRAM;
    private String driveCapacity;
    private String chipset;
    private String graphicAdapter;
    private String networkAdapters;
    private String ioConnectorsAndPorts;
    private String battery;
    private String batteryFeatures;
    private String briefCharacteristics;
    private String image;
    private String date;

    public Product() {
    }

    public Product(String laptopModel, double price, String briefCharacteristics) {
        this.laptopModel = laptopModel;
        this.price = price;
        this.briefCharacteristics = briefCharacteristics;
    }

    public Product(String laptopModel, double price, String producer, String processor, String typeProcessor, String screenDiagonal, String amountOfRAM, String numberOfslotsForRAM, String typeOfRAM, String driveCapacity, String chipset, String graphicAdapter, String networkAdapters, String ioConnectorsAndPorts, String battery, String batteryFeatures, String briefCharacteristics, String image) {
        this.laptopModel = laptopModel;
        this.price = price;
        this.producer = producer;
        this.processor = processor;
        this.typeProcessor = typeProcessor;
        this.screenDiagonal = screenDiagonal;
        this.amountOfRAM = amountOfRAM;
        this.numberOfslotsForRAM = numberOfslotsForRAM;
        this.typeOfRAM = typeOfRAM;
        this.driveCapacity = driveCapacity;
        this.chipset = chipset;
        this.graphicAdapter = graphicAdapter;
        this.networkAdapters = networkAdapters;
        this.ioConnectorsAndPorts = ioConnectorsAndPorts;
        this.battery = battery;
        this.batteryFeatures = batteryFeatures;
        this.briefCharacteristics = briefCharacteristics;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLaptopModel() {
        return laptopModel;
    }

    public void setLaptopModel(String laptopModel) {
        this.laptopModel = laptopModel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getTypeProcessor() {
        return typeProcessor;
    }

    public void setTypeProcessor(String typeProcessor) {
        this.typeProcessor = typeProcessor;
    }

    public String getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(String screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }

    public String getAmountOfRAM() {
        return amountOfRAM;
    }

    public void setAmountOfRAM(String amountOfRAM) {
        this.amountOfRAM = amountOfRAM;
    }

    public String getNumberOfslotsForRAM() {
        return numberOfslotsForRAM;
    }

    public void setNumberOfslotsForRAM(String numberOfslotsForRAM) {
        this.numberOfslotsForRAM = numberOfslotsForRAM;
    }

    public String getTypeOfRAM() {
        return typeOfRAM;
    }

    public void setTypeOfRAM(String typeOfRAM) {
        this.typeOfRAM = typeOfRAM;
    }

    public String getDriveCapacity() {
        return driveCapacity;
    }

    public void setDriveCapacity(String driveCapacity) {
        this.driveCapacity = driveCapacity;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getGraphicAdapter() {
        return graphicAdapter;
    }

    public void setGraphicAdapter(String graphicAdapter) {
        this.graphicAdapter = graphicAdapter;
    }

    public String getNetworkAdapters() {
        return networkAdapters;
    }

    public void setNetworkAdapters(String networkAdapters) {
        this.networkAdapters = networkAdapters;
    }

    public String getIoConnectorsAndPorts() {
        return ioConnectorsAndPorts;
    }

    public void setIoConnectorsAndPorts(String ioConnectorsAndPorts) {
        this.ioConnectorsAndPorts = ioConnectorsAndPorts;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getBatteryFeatures() {
        return batteryFeatures;
    }

    public void setBatteryFeatures(String batteryFeatures) {
        this.batteryFeatures = batteryFeatures;
    }

    public String getBriefCharacteristics() {
        return briefCharacteristics;
    }

    public void setBriefCharacteristics(String briefCharacteristics) {
        this.briefCharacteristics = briefCharacteristics;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", laptopModel='" + laptopModel + '\'' +
                ", price=" + price +
                ", producer='" + producer + '\'' +
                ", processor='" + processor + '\'' +
                ", typeProcessor='" + typeProcessor + '\'' +
                ", screenDiagonal='" + screenDiagonal + '\'' +
                ", amountOfRAM='" + amountOfRAM + '\'' +
                ", numberOfslotsForRAM='" + numberOfslotsForRAM + '\'' +
                ", typeOfRAM='" + typeOfRAM + '\'' +
                ", driveCapacity='" + driveCapacity + '\'' +
                ", chipset='" + chipset + '\'' +
                ", graphicAdapter='" + graphicAdapter + '\'' +
                ", networkAdapters='" + networkAdapters + '\'' +
                ", ioConnectorsAndPorts='" + ioConnectorsAndPorts + '\'' +
                ", battery='" + battery + '\'' +
                ", batteryFeatures='" + batteryFeatures + '\'' +
                ", briefCharacteristics='" + briefCharacteristics + '\'' +
                ", image='" + image + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product product) {
        return Comparators.PRICE.compare(this, product);
    }

    public static class Comparators {

//        public static Comparator<Product> NAME = new Comparator<Product>() {
//            @Override
//            public int compare(Product o1, Product o2) {
//                return o1.name.compareTo(o2.name);
//            }
//        };
        public static Comparator<Product> PRICE = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        };
//        public static Comparator<Product> NAMEANDAGE = new Comparator<Product>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                int i = o1.name.compareTo(o2.name);
//                if (i == 0) {
//                    i = o1.age - o2.age;
//                }
//                return i;
//            }
//        };
    }
}
