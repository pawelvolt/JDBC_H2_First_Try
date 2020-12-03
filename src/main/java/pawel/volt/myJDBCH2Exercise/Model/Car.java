package pawel.volt.myJDBCH2Exercise.Model;

public class Car {
   // private int carId;
    private String model;
    private int year;
    private int mileage; //in km
    private long price;

    public Car() {
    }

    public Car( String model, int year, int mileage, long price) {
        //this.carId = carId;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
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
        return mileage;
    }

    public void setMilage(int mileage) {
        this.mileage = mileage;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

 /*   public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }
*/
    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", price=" + price +
                '}';
    }
}
