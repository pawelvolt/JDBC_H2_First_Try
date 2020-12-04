package pawel.volt.myJDBCH2Exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pawel.volt.myJDBCH2Exercise.Model.Car;
import pawel.volt.myJDBCH2Exercise.dao.DAO;
import pawel.volt.myJDBCH2Exercise.dao.MyJDBCDAO;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class MyJdbch2ExerciseApplication {
    private static DAO<Car> dao;


    public MyJdbch2ExerciseApplication(DAO<Car> dao) {
        MyJdbch2ExerciseApplication.dao = dao;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyJdbch2ExerciseApplication.class, args);

        System.out.println("\nAdding a new car------------------------------------\n");
        Car car = new Car("Mazda", 2019, 2, 200000);
        dao.create(car);


        System.out.println("\nAll cars: ------------------------------------------\n");
        List<Car> cars = dao.list();
        cars.forEach(System.out::println);

        System.out.println("\nGeting a car with id = 3--------------------------- \n");
        Optional<Car> car2 = dao.get(3);
        System.out.println(car2);

        System.out.println("\nDELETING car with id  = 3--------------------------- \n");
        dao.delete(3);


        System.out.println("\nAll cars: ------------------------------------------\n");
        List<Car> cars3 = dao.list();
        cars3.forEach(System.out::println);

       /* System.out.println("\nGet list of cars sorted by price descending ---------\n");
        System.out.println(dao.toString());
        List<Car> listDesc = dao.*/
    }

}
