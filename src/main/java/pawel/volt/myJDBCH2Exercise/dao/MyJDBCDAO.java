package pawel.volt.myJDBCH2Exercise.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pawel.volt.myJDBCH2Exercise.Model.Car;

import java.util.List;
import java.util.Optional;


@Component
public class MyJDBCDAO implements DAO<Car> {

    RowMapper<Car> carRowMapper = (rs, rowNum) -> {
        Car car = new Car();
        //car.setCarId(rs.getInt("car_id"));
        car.setModel(rs.getString("model"));
        car.setYear(rs.getInt("year"));
        car.setMilage(rs.getInt("mileage"));
        car.setPrice(rs.getInt("price"));
        return car;
    };

    private static final Logger log = LoggerFactory.getLogger(MyJDBCDAO.class);
    private JdbcTemplate jdbcTemplate;

    public MyJDBCDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Car> list() {
        String sql = "SELECT car_id, model, mileage, year, price FROM carStorage;";
        return jdbcTemplate.query(sql, carRowMapper);
    }

    @Override
    public void create(Car car) {
        String sql = "INSERT INTO carStorage(model, year, mileage, price)" +
                "  VALUES(?,?,?,?); ";
        int insert = jdbcTemplate.update(sql, car.getModel(), car.getYear(), car.getMilage(), car.getPrice());
        if (insert == 1) {
            log.info("New car added to car Storage: " + car.getModel() + " from " + car.getYear());
        }
    }

    @Override
    public Optional<Car> get(int id) {
        String sql = "SELECT * FROM carStorage WHERE car_id = ?";
        Car car = null;
        try {
            car = jdbcTemplate.queryForObject(sql, new Object[]{id}, carRowMapper);
        } catch (DataAccessException e) {
            log.info("Car with id = " + id + " not found");
        }
        return Optional.ofNullable(car);
    }

    @Override
    public void update(Car car, int id) {
        String sql = "UPDATE carStorage set model=? , year=? , mileage=? , price=? WHERE car_id = ?";
        int update = jdbcTemplate.update(sql, car.getModel(), car.getYear(), car.getMilage(), car.getPrice(), id);
        if (update == 1) {
            log.info("Car with id: " + id + " updated");
        }
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM carStorage WHERE car_id = ?", id);
    }


    public List<Car> listCarsByPrice() {
        String sql = "SELECT * FROM carStorage ORDER BY price DESC";
        return jdbcTemplate.query(sql, carRowMapper);

    }
}
