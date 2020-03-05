package pl.venustus.CarsToDB;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/task_crud?serverTimezone=Europe/Warsaw&SSL=False");
        dataSourceBuilder.username("nazwa_uzytkownika");
        dataSourceBuilder.password("twoje_haslo");
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        return dataSourceBuilder.build();
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

}
