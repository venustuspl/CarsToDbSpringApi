package pl.venustus.CarsToDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CarDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addCar(Car car) {

        String sql = "INSERT INTO Car VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{
                car.getCarId(),
                car.getMark(),
                car.getModel(),
                car.getColor()
        });
    }


    @EventListener(ApplicationReadyEvent.class)
    public void dbInit() {
        System.out.println("---------------sfas--------------------");
        addCar(new Car(1, "fiat", "p", "c"));
        addCar(new Car(2, "opel", "p", "c"));
        addCar(new Car(3, "vw", "p", "c"));
        addCar(new Car(4, "audi", "p", "c"));
        //  String sql = "INSERT INTO Car VALUES(1,'Merc','x','c');";

        jdbcTemplate.update("commit;");
    }


}
