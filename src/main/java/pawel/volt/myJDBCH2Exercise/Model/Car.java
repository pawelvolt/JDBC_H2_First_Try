package pawel.volt.myJDBCH2Exercise.Model;

public class Car {
    private String model;
    private int year;
    private int milage; //in km
    private long price;

    public Car() {
    }

    public Car(String model, int year, int milage, long price) {
        this.model = model;
        this.year = year;
        this.milage = milage;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", milage=" + milage +
                ", price=" + price +
                '}';
    }
}
