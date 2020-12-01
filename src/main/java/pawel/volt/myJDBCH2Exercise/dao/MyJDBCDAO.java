package pawel.volt.myJDBCH2Exercise.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pawel.volt.myJDBCH2Exercise.Model.Car;

import java.util.List;
import java.util.Optional;


@Component
public class MyJDBCDAO implements DAO<Car>{

    private static final Logger log = LoggerFactory.getLogger(MyJDBCDAO.class);
    private JdbcTemplate jdbcTemplate;

    public MyJDBCDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Car> list() {
        return null;
    }

    @Override
    public void create() {

    }

    @Override
    public Optional<Car> get(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Car car, int id) {

    }

    @Override
    public void delete(int id) {

    }
}
