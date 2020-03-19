package by.bsuir.weather;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(value = "by.bsuir.weather")
@PropertySource("classpath:database.properties")
public class SpringConfig {

    @Autowired
    private Environment env;

    @Bean
    public HikariDataSource getDataSource(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setJdbcUrl(env.getProperty("database.url"));
        config.setUsername(env.getProperty("database.user"));
        config.setPassword(env.getProperty("database.password"));
        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(HikariDataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}

